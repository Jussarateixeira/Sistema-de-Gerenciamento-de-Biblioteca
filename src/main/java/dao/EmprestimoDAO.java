package dao;

import domain.Emprestimo;
import domain.Leitor;
import domain.Livro;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EmprestimoDAO {

    @PersistenceContext
    EntityManager entityManager;

    public void salvar(Emprestimo emprestimo) {
        entityManager.persist(emprestimo);
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        return entityManager.createQuery("SELECT e FROM Emprestimo e WHERE e.dataDevolucao IS NULL", Emprestimo.class)
                .getResultList();
    }

    public Emprestimo buscarPorLivroELeitor(Livro livro, Leitor leitor) {
        String jpql = "SELECT e FROM Emprestimo e WHERE e.livro = :livro AND e.leitor = :leitor AND e.dataDevolucao IS NULL";
        return entityManager.createQuery(jpql, Emprestimo.class)
                .setParameter("livro", livro)
                .setParameter("leitor", leitor)
                .getSingleResult();
    }

    public void atualizar(Emprestimo emprestimo) {
        entityManager.merge(emprestimo);  // O merge já cuida da persistência
    }
}
