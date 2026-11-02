package com.betacom.veicoliJPA.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoriaReq {

	private Integer id;   // usato in update

	@NotBlank(message = "categoria.descr.obbligatoria")
	private String descrizione;
}
