package com.betacom.veicoliJPA.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.veicoliJPA.dto.input.CategoriaReq;
import com.betacom.veicoliJPA.dto.output.CategoriaDTO;
import com.betacom.veicoliJPA.exceptions.VeicoloException;
import com.betacom.veicoliJPA.mapper.CategoriaMap;
import com.betacom.veicoliJPA.models.Categoria;
import com.betacom.veicoliJPA.repositories.ICategoriaRepository;
import com.betacom.veicoliJPA.repositories.IVeicoloRepository;
import com.betacom.veicoliJPA.services.interfaces.ICategoriaServices;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoriaImpl implements ICategoriaServices {
	
	private final ICategoriaRepository categoriaR;
	private final IVeicoloRepository veicoloR;
	

	@Override
	@Transactional
	public CategoriaDTO create(CategoriaReq req) throws VeicoloException {
		if (categoriaR.existsByDescrizione(req.getDescrizione())) {
			throw new VeicoloException("categoria.gia.presente");
		}
		Categoria c = new Categoria();
		c.setDescrizione(req.getDescrizione());
		categoriaR.save(c);
		return CategoriaMap.mapToDTO(c);
	}

	@Override
	public List<CategoriaDTO> listAll() {
		return categoriaR.findAll().stream()
				.map(CategoriaMap::mapToDTO)
				.toList();
	}

	@Override
	@Transactional
	public void delete(Integer id) throws VeicoloException {
		Categoria c = categoriaR.findById(id)
				.orElseThrow(() -> new VeicoloException("categoria.non.trovata"));
		if (veicoloR.existsByCategoria(c)) {
			throw new VeicoloException("categoria.in.uso");
		}
		categoriaR.delete(c);
	}

}
