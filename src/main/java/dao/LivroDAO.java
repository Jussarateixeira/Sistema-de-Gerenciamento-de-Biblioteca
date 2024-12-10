package dao;

import domain.Livro;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class LivroDAO {

    @PersistenceContext
    EntityManager entityManager;

    public void salvar(Livro livro) {
        entityManager.persist(livro);
    }

    public void atualizar(Livro livro) {
        entityManager.merge(livro);  // O merge é suficiente para garantir a atualização
    }

    public Livro buscarPorId(Long id) {
        return entityManager.find(Livro.class, id);
    }
}
