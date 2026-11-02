package com.betacom.veicoliJPA.models;



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

	@Enumerated(EnumType.STRING)
	@Column(name = "alimentazione", length = 20)
	private Alimentazione alimentazione;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
}