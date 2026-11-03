package com.betacom.veicoliJPA.dto.input;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class BiciReq extends VeicoloReq{
	
	@Min(value = 1, message = "bici.marce.nonvalide")
	@Max(value = 30, message = "bici.marce.nonvalide")
	private Integer marce;

	private String freno;

	private Boolean pieghevole;
}
