package com.betacom.veicoliJPA.dto.input;

import com.betacom.veicoliJPA.dto.input.ValidationGroup.Create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class MacchinaReq extends VeicoloReq{

	@Positive(message = "Il numero di porte deve essere positivo")
	private Integer porte;
	
	@NotBlank(groups = Create.class, message = "La targa è obbligatoria")
	@Pattern(regexp = "^[A-Z]{2}[0-9]{3}[A-Z]{2}$", message = "Targa auto non valida (atteso AA000AA)")
	private String targa;
}
