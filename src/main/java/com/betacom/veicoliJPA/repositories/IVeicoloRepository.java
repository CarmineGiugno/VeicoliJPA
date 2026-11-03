package com.betacom.veicoliJPA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betacom.veicoliJPA.models.Alimentazione;
import com.betacom.veicoliJPA.models.Categoria;
import com.betacom.veicoliJPA.models.Veicolo;

@Repository
public interface IVeicoloRepository extends JpaRepository<Veicolo, Integer> {

	Boolean existsByTarga(String targa);

	List<Veicolo> findByMarcaIgnoreCase(String marca);

	List<Veicolo> findByAlimentazione(Alimentazione alimentazione);

	List<Veicolo> findByCategoriaDescrizioneIgnoreCase(String descrizione);
	
	Boolean existsByCategoria(Categoria categoria);
	
	List<Veicolo> filter(
			@Param("marca") String marca,
			@Param("alimentazione") Alimentazione alimentazione,
			@Param("categoria") String categoria,
			@Param("annoMin") Integer annoMin,
			@Param("annoMax") Integer annoMax,
			@Param("tipo") String tipo,
			@Param("targa") String targa,
			@Param("porte") Integer porte,
			@Param("marce") Integer marce,
			@Param("tipoForcella") String tipoForcella);
}