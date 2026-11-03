package com.betacom.veicoliJPA.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.veicoliJPA.dto.input.BiciReq;
import com.betacom.veicoliJPA.dto.input.MacchinaReq;
import com.betacom.veicoliJPA.dto.input.MotoReq;
import com.betacom.veicoliJPA.dto.input.VeicoloReq;
import com.betacom.veicoliJPA.dto.output.VeicoloDTO;
import com.betacom.veicoliJPA.exceptions.VeicoloException;
import com.betacom.veicoliJPA.mapper.VeicoloMap;
import com.betacom.veicoliJPA.models.Bici;
import com.betacom.veicoliJPA.models.Categoria;
import com.betacom.veicoliJPA.models.Macchina;
import com.betacom.veicoliJPA.models.Moto;
import com.betacom.veicoliJPA.models.Veicolo;
import com.betacom.veicoliJPA.repositories.ICategoriaRepository;
import com.betacom.veicoliJPA.repositories.IVeicoloRepository;
import com.betacom.veicoliJPA.services.interfaces.IVeicoloServices;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VeicoloImpl implements IVeicoloServices{

	@Autowired
	private IVeicoloRepository veicoloR;

	@Autowired
	private ICategoriaRepository categoriaR;
	
	@Override
	@Transactional
	public VeicoloDTO createMacchina(MacchinaReq req) throws VeicoloException {
		Macchina m = new Macchina();
		applyCommonFields(m, req);
		m.setRuote(4);
		m.setTarga(req.getTarga());
		m.setPorte(req.getPorte());
		veicoloR.save(m);
		log.debug("Creata macchina id {}", m.getId());
		return VeicoloMap.mapToDTO(m);
	}
	
	@Override
	@Transactional
	public VeicoloDTO createMoto(MotoReq req) throws VeicoloException {
		Moto mo = new Moto();
		applyCommonFields(mo, req);
		mo.setRuote(2);
		mo.setTarga(req.getTarga());
		mo.setTipoForcella(req.getTipoForcella());
		veicoloR.save(mo);
		log.debug("Creata moto id {}", mo.getId());
		return VeicoloMap.mapToDTO(mo);
	}
	
	@Override
	@Transactional
	public VeicoloDTO createBici(BiciReq req) throws VeicoloException {
		Bici bi = new Bici();
		applyCommonFields(bi, req);
		bi.setRuote(2);
		bi.setMarce(req.getMarce());
		bi.setFreno(req.getFreno());
		bi.setPieghevole(req.getPieghevole());
		veicoloR.save(bi);
		log.debug("Creata bici id {}", bi.getId());
		return VeicoloMap.mapToDTO(bi);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) throws VeicoloException {
		Veicolo v = veicoloR.findById(id)
				.orElseThrow(() -> new VeicoloException("veicolo.non.trovato"));
		veicoloR.delete(v);
		log.debug("Eliminato veicolo id {}", id);
	}
	
	@Override
	public VeicoloDTO getById(Integer id) throws VeicoloException {
		Veicolo v = veicoloR.findById(id)
				.orElseThrow(() -> new VeicoloException("veicolo.non.trovato"));
		return VeicoloMap.mapToDTO(v);
	}
	
	@Override
	public List<VeicoloDTO> listAll() {
		return veicoloR.findAll().stream()
				.map(VeicoloMap::mapToDTO)
				.toList();
	}
	
	/** Campi comuni a tutti i tipi: risolve categoria e targa duplicata una volta sola. */
	private void applyCommonFields(Veicolo v, VeicoloReq req) throws VeicoloException {
		// targa duplicata: controllo applicativo per un messaggio chiaro (il vincolo UNIQUE resta la rete di sicurezza)
		String targa = (req instanceof MacchinaReq mr) ? mr.getTarga()
				: (req instanceof MotoReq mor) ? mor.getTarga() : null;
		if (targa != null && veicoloR.existsByTarga(targa)) {
			throw new VeicoloException("veicolo.targa.duplicata");
		}

		// risolve l'id categoria in entità gestita
		Categoria categoria = categoriaR.findById(req.getCategoriaId())
				.orElseThrow(() -> new VeicoloException("categoria.non.trovata"));

		v.setMarca(req.getMarca());
		v.setModello(req.getModello());
		v.setAnno(req.getAnno());
		v.setAlimentazione(req.getAlimentazione());
		v.setCategoria(categoria);
	}
	
	
}
