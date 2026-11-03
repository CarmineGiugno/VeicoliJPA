package com.betacom.veicoliJPA.dto.input;

import com.betacom.veicoliJPA.models.Alimentazione;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeicoloSearchReq {
	private String marca;
	private Alimentazione alimentazione;
	private String categoria;
	private Integer annoMin;
	private Integer annoMax;
	private String targa;
	private Integer porte;
	private Integer marce;
	private String tipoForcella;
	private String tipoVeicolo;
}
