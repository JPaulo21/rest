package webservice.model;


import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JsonbTransient
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCliente")
	private Pessoa p;
	
	@Column(unique=true)
	private String cep;
	
	@Column
	private String rua;
	
	@Column
	private int numero;
	
	@Column
	private String bairro;
	
	@Column
	private String cidade;
	
	@Column
	private String estado;

	@Override
	public String toString() {
		return "Endereco [ cep=" + cep + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", estado=" + estado + "]";
	}
	
	
}
