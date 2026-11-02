package com.betacom.veicoliJPA.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.betacom.veicoliJPA.dto.output.ResponseDTO;
import com.betacom.veicoliJPA.exceptions.VeicoloException;
import com.betacom.veicoliJPA.services.interfaces.IMessaggioServices;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionManager {

	private final IMessaggioServices msgS;

	// eccezioni di business: il messaggio è un CODE da tradurre
	@ExceptionHandler(VeicoloException.class)
	public ResponseEntity<ResponseDTO> handleVeicolo(VeicoloException e) {
		return ResponseEntity.badRequest()
				.body(ResponseDTO.builder().rc(false).msg(msgS.get(e.getMessage())).build());
	}

	// errori di validazione: anche i message dei @Pattern/@NotBlank diventano code da tradurre
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleValidation(MethodArgumentNotValidException e) {
		String code = e.getBindingResult().getFieldErrors().stream()
				.findFirst()
				.map(FieldError::getDefaultMessage)
				.orElse("validazione.errore");
		return ResponseEntity.badRequest()
				.body(ResponseDTO.builder().rc(false).msg(msgS.get(code)).build());
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleJsonNonValido(HttpMessageNotReadableException e) {
		return ResponseEntity.badRequest()
				.body(ResponseDTO.builder().rc(false).msg(msgS.get("json.non.valido")).build());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> handleGenerico(Exception e) {
		return ResponseEntity.badRequest()
				.body(ResponseDTO.builder().rc(false).msg(msgS.get("errore.generico")).build());
	}
}
