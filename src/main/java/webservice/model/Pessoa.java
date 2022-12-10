package webservice.model;

import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class Pessoa{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	
	@Column(unique=true)
	private String cpf;
	
	@JsonbTransient
	@OneToMany(mappedBy="p", cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.EAGER)
	private List<Endereco> enderecos;
	

	
}

