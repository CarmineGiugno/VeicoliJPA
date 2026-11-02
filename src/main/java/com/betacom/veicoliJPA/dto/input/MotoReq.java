package com.betacom.veicoliJPA.dto.input;

import com.betacom.veicoliJPA.dto.input.ValidationGroup.Create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class MotoReq extends VeicoloReq{

	private String tipoForcella;

	@NotBlank(groups = Create.class, message = "La targa è obbligatoria")
	@Pattern(regexp = "^[A-Z]{2}[0-9]{5}$", message = "veicolo.targa.moto.formato")
	private String targa;
}
