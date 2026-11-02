package com.betacom.veicoliJPA.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Entità padre della gerarchia.
 * SINGLE_TABLE: una sola tabella "veicolo" per tutti i sottotipi,
 * distinti dalla colonna discriminatore "tipo_veicolo".
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "veicolo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_veicolo", discriminatorType = DiscriminatorType.STRING)
public class Veicolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50, nullable = false)
	private String marca;

	@Column(length = 50, nullable = false)
	private String modello;

	private Integer anno;

	private Integer ruote;

	// targa sul padre: colonna unica condivisa (auto/moto la valorizzano, bici la lascia NULL)
	@Column(length = 10)
	private String targa;

	// enum salvato come testo ("DIESEL"), non come indice numerico
	@Enumerated(EnumType.STRING)
	@Column(name = "alimentazione", length = 20)
	private Alimentazione alimentazione;

	// ManyToOne verso la lookup: molti veicoli -> una categoria. Crea la FK categoria_id.
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
}