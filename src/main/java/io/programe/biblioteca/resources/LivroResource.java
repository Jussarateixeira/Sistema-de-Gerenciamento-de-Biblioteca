
package io.programe.biblioteca.resources;

import dao.LivroDAO;
import domain.Livro;
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
public class LivroResource {

    @EJB
    private LivroDAO livroDAO;

    @POST
    @Path("/cadastrarLivros")
    public Response cadastrarLivros() {
        List<Livro> livros = new ArrayList<>();  
        livros.add(new Livro(null, "Um Estudo em Vermelho", "Arthur Conan Doyle", 1888));
        livros.add(new Livro(null, "A Revolução dos Bichos", "George Orwell", 1945));
        livros.add(new Livro(null, "Dom Casmurro", "Machado de Assis", 1899));

        livros.forEach(livroDAO::salvar);

        return Response.status(Response.Status.CREATED)
                .entity("Livros cadastrados com sucesso!")
                .build();
    }

}
