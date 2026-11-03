package com.betacom.veicoliJPA.dto.output;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class VeicoloDTO extends ResponseDTO{

	private Integer id;
	private String tipo;          // dal discriminatore: macchina / moto / bici
	private String marca;
	private String modello;
	private Integer anno;
	private Integer ruote;
	private String targa;
	private String alimentazione; // enum reso come stringa
	private String categoria;     // descrizione della categoria, non l'oggetto

	// campi specifici: valorizzati solo per il tipo pertinente, altrimenti null
	private Integer porte;
	private String tipoForcella;
	private Integer marce;
	private String freno;
	private Boolean pieghevole;
	private String tipoVeicolo;
}
