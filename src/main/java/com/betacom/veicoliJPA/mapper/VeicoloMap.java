package com.betacom.veicoliJPA.mapper;

import com.betacom.veicoliJPA.dto.output.VeicoloDTO;
import com.betacom.veicoliJPA.dto.output.VeicoloDTO.VeicoloDTOBuilder;
import com.betacom.veicoliJPA.models.Bici;
import com.betacom.veicoliJPA.models.Macchina;
import com.betacom.veicoliJPA.models.Moto;
import com.betacom.veicoliJPA.models.Veicolo;

public class VeicoloMap {

	// privato: è una classe di sole utility statiche, non va istanziata
	private VeicoloMap() {}
	
	public static VeicoloDTO mapToDTO(Veicolo v) {
		VeicoloDTOBuilder<?, ?> b = VeicoloDTO.builder()
				.id(v.getId())
				.marca(v.getMarca())
				.modello(v.getModello())
				.anno(v.getAnno())
				.ruote(v.getRuote())
				.targa(v.getTarga())
				.alimentazione(v.getAlimentazione() != null ? v.getAlimentazione().name() : null)
				.categoria(v.getCategoria() != null ? v.getCategoria().getDescrizione() : null);

		// campi e tipo specifici del sottotipo concreto
		if (v instanceof Macchina m) {
			b.tipo("macchina").porte(m.getPorte());
		} else if (v instanceof Moto mo) {
			b.tipo("moto").tipoForcella(mo.getTipoForcella());
		} else if (v instanceof Bici bi) {
			b.tipo("bici").marce(bi.getMarce()).freno(bi.getFreno()).pieghevole(bi.getPieghevole());
		}

		return b.build();
	}
}
