package com.betacom.veicoliJPA.dto.input;

import com.betacom.veicoliJPA.dto.input.ValidationGroup.Create;
import com.betacom.veicoliJPA.dto.input.ValidationGroup.Update;
import com.betacom.veicoliJPA.models.Alimentazione;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class VeicoloReq {

	// serve solo in aggiornamento: l'id dice quale veicolo modificare
		@NotNull(groups = Update.class, message = "L'id è obbligatorio per l'aggiornamento")
		private Integer id;
		
		@NotBlank(groups = Create.class, message = "La marca è obbligatoria")
		private String marca;

		@NotBlank(groups = Create.class, message = "Il modello è obbligatorio")
		private String modello;

		@Min(value = 1888, groups = Create.class, message = "veicolo.anno.nonvalido")
		private Integer anno;

		@Positive(groups = Create.class, message = "Le ruote devono essere un numero positivo")
		private Integer ruote;
		
		@NotNull(groups = Create.class, message = "L'alimentazione è obbligatoria")
		private Alimentazione alimentazione;

		@NotNull(groups = Create.class, message = "La categoria è obbligatoria")
		private Integer categoriaId;
}
