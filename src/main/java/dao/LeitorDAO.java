package dao;

import domain.Leitor;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class LeitorDAO {

    @PersistenceContext
    EntityManager entityManager;

    public void salvar(Leitor leitor) {
        entityManager.persist(leitor);
    }

    public Leitor buscarPorId(Long id) {
        return entityManager.find(Leitor.class, id);
    }
}
