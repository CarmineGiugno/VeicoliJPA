package com.betacom.veicoliJPA.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.betacom.veicoliJPA.models.Messaggi;
import com.betacom.veicoliJPA.models.MessaggiID;
import com.betacom.veicoliJPA.repositories.IMessaggiRepository;
import com.betacom.veicoliJPA.services.interfaces.IMessaggioServices;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MessaggioImpl implements IMessaggioServices {

	private final IMessaggiRepository msgR;

	@Value("${lang}")
	private String lang;

	@Override
	public String get(String code) {
		Optional<Messaggi> m = msgR.findById(new MessaggiID(lang, code));
		return m.isEmpty() ? code : m.get().getMessaggio();
	}
}
