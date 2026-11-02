package com.betacom.veicoliJPA.dto.input;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class BiciReq extends VeicoloReq{
	@Positive(message = "Il numero di marce deve essere positivo")
	private Integer marce;

	private String freno;

	private Boolean pieghevole;
}
