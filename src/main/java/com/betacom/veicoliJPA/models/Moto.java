package com.betacom.veicoliJPA.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@DiscriminatorValue("moto")
public class Moto extends Veicolo {

	@Column(name = "tipo_forcella", length = 30)
	private String tipoForcella;
}

