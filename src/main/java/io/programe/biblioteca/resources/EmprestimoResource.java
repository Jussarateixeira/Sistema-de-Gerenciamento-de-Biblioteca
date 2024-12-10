package io.programe.biblioteca.resources;

import dao.EmprestimoDAO;
import dao.LeitorDAO;
import dao.LivroDAO;
import domain.Emprestimo;
import domain.Leitor;
import domain.Livro;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Jussara Teixeira
 */

@Path("/biblioteca")
public class EmprestimoResource {

    @EJB
    private EmprestimoDAO emprestimoDAO;

    @EJB
    private LivroDAO livroDAO;

    @EJB
    private LeitorDAO leitorDAO;

    @POST
    @Path("/cadastrarEmprestimos")
    public Response cadastrarEmprestimos() {
        List<Emprestimo> emprestimos = new ArrayList<>();

        Livro livro1 = livroDAO.buscarPorId(1L);
        Livro livro2 = livroDAO.buscarPorId(2L);
        Leitor leitor1 = leitorDAO.buscarPorId(1L);
        Leitor leitor2 = leitorDAO.buscarPorId(2L);

        if (livro1 != null && leitor1 != null && livro1.getDisponivel()) {
            Emprestimo emprestimo1 = criarEmprestimo(livro1, leitor1);
            if (emprestimo1 != null) {
                emprestimos.add(emprestimo1);
            } else {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Erro ao criar o empréstimo para o livro 1.")
                        .build();
            }
        }

        if (livro2 != null && leitor2 != null && livro2.getDisponivel()) {
            Emprestimo emprestimo2 = criarEmprestimo(livro2, leitor2);
            if (emprestimo2 != null) {
                emprestimos.add(emprestimo2);
            } else {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Erro ao criar o empréstimo para o livro 2.")
                        .build();
            }
        }

        for (Emprestimo emprestimo : emprestimos) {
            emprestimoDAO.salvar(emprestimo);
        }

        return Response.status(Response.Status.CREATED)
                .entity("Empréstimos registrados com sucesso!")
                .build();
    }

    private Emprestimo criarEmprestimo(Livro livro, Leitor leitor) {
        if (livro == null || leitor == null) {
            return null; // Evita a criação do empréstimo se algum dos objetos estiver nulo
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);
        emprestimo.setLeitor(leitor);
        emprestimo.setDataEmprestimo(new Date());

        // Adicionando 10 dias à data de empréstimo para definir a data de devolução
        Date dataDevolucao = new Date();
        dataDevolucao.setTime(dataDevolucao.getTime() + (10L * 24L * 60L * 60L * 1000L)); // 10 dias em milissegundos
        emprestimo.setDataDevolucao(dataDevolucao);

        livro.setDisponivel(false);
        livroDAO.atualizar(livro);

        return emprestimo;
    }
}
