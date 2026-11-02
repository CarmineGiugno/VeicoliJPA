package com.betacom.veicoliJPA.mapper;

import com.betacom.veicoliJPA.dto.output.CategoriaDTO;
import com.betacom.veicoliJPA.models.Categoria;

public class CategoriaMap {
	private CategoriaMap() {}

	public static CategoriaDTO mapToDTO(Categoria c) {
		return CategoriaDTO.builder()
				.id(c.getId())
				.descrizione(c.getDescrizione())
				.build();
	}
}
