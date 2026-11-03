package com.betacom.veicoliJPA.dto.input;

import com.betacom.veicoliJPA.dto.input.ValidationGroup.Create;
import com.betacom.veicoliJPA.dto.input.ValidationGroup.Update;
import com.betacom.veicoliJPA.models.Alimentazione;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class VeicoloReq {

	// serve solo in aggiornamento: l'id dice quale veicolo modificare
		@NotNull(groups = Update.class, message = "veicolo.id.obbligatorio")
		private Integer id;
		
		@NotBlank(groups = Create.class, message = "veicolo.marca.obbligatoria")
		private String marca;

		@NotBlank(groups = Create.class, message = "veicolo.modello.obbligatorio")
		private String modello;

		@Min(value = 1900, message = "veicolo.anno.nonvalido")
		@Max(value = 2100, message = "veicolo.anno.nonvalido")
		private Integer anno;
		
		@NotNull(groups = Create.class, message = "veicolo.alim.obbligatoria")
		private Alimentazione alimentazione;

		@NotNull(groups = Create.class, message = "veicolo.categoria.obbligatoria")
		private Integer categoriaId;
}
