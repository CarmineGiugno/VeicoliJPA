package com.betacom.veicoliJPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.veicoliJPA.models.Messaggi;
import com.betacom.veicoliJPA.models.MessaggiID;

@Repository
public interface IMessaggiRepository extends JpaRepository<Messaggi, MessaggiID> {

}
