
package io.programe.biblioteca.resources;

import dao.LeitorDAO;
import domain.Leitor;
import jakarta.ejb.EJB;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jussara Teixeira
 */
@Path("/biblioteca")
public class LeitorResource {
    
    @EJB
    private LeitorDAO leitorDAO;
    
    @POST
    @Path("/cadastrarLeitores")
    public Response cadastrarLeitores() {
        List<Leitor> leitores = new ArrayList<>();
        leitores.add(new Leitor(null, "João Silva", "joao.silva@email.com"));
        leitores.add(new Leitor(null, "Maria Helena", "maria.helena@email.com"));

        leitores.forEach(leitorDAO::salvar);

        return Response.status(Response.Status.CREATED)
                       .entity("Leitores cadastrados com sucesso!")
                       .build();
    }
    
}
