package com.betacom.veicoliJPA.dto.output;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
public class ResponseDTO {
	private Boolean rc;       // esito: true = ok, false = errore
	private String msg;       // messaggio per il client
}
