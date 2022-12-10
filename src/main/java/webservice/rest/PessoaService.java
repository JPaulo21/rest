package webservice.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import webservice.dao.PessoaDAO;
import webservice.model.Pessoa;

/**
 * Root resource (exposed at "pessoa" path)
 */
@Path("pessoa")
public class PessoaService {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	
        return "Got it!";
    }
    
	@GET
	@Path("/pessoas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> pessoas() {
		
		List<Pessoa> pessoas = new PessoaDAO().SelectPessoas();
		
		return pessoas;
		
	}
	
	@GET
	@Path("/encontrar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa pessoaPorId(@PathParam("id") int id) {
		
		Pessoa p = new PessoaDAO().SelectPessoaId(id); 
		System.out.println(p);
		
		return p;
	}
	
//	@GET
//	@Path("/pessoaj")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Pessoa pessoaJ() {
//
//		Endereco e = new Endereco(3, "34534-345", "Rua 82", 423, "Maranguape I", "Paulista", "PE");
//
//		List<Endereco> es = new ArrayList<Endereco>();
//
//		es.add(e);
//
//		Pessoa p = new Pessoa(5, "João", "704.234.534-23", es);
//
//		System.out.println(p);
//
//		return p;
//	}
}
