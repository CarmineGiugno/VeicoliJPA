package com.betacom.veicoliJPA.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@DiscriminatorValue("bici")
public class Bici extends Veicolo {

	private Integer marce;

	private String freno;

	private Boolean pieghevole;
}