package com.betacom.veicoliJPA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.veicoliJPA.models.Alimentazione;
import com.betacom.veicoliJPA.models.Veicolo;

@Repository
public interface IVeicoloRepository extends JpaRepository<Veicolo, Integer> {

	Boolean existsByTarga(String targa);

	List<Veicolo> findByMarcaIgnoreCase(String marca);

	List<Veicolo> findByAlimentazione(Alimentazione alimentazione);

	List<Veicolo> findByCategoriaDescrizioneIgnoreCase(String descrizione);
}