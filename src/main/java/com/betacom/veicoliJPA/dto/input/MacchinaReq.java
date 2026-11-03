package com.betacom.veicoliJPA.dto.input;

import com.betacom.veicoliJPA.dto.input.ValidationGroup.Create;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class MacchinaReq extends VeicoloReq{

	@Min(value = 2, message = "macchina.porte.nonvalide")
	@Max(value = 5, message = "macchina.porte.nonvalide")
	private Integer porte;
	
	@NotBlank(groups = Create.class, message = "veicolo.targa.obbligatoria")
	@Pattern(regexp = "^[A-Z]{2}[0-9]{3}[A-Z]{2}$", message = "veicolo.targa.auto.formato")
	private String targa;
}
