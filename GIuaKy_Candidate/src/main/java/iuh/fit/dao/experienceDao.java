package iuh.fit.dao;

import iuh.fit.enums.Roles;
import iuh.fit.models.Experience;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class experienceDao {
    EntityManager em;
    EntityTransaction et;

    public experienceDao() {
        em = Persistence.createEntityManagerFactory("MariaBD").createEntityManager();
        et = em.getTransaction();
    }

    public List<Experience> getAllExpByCanId(Long canId) {
        return em.createQuery("SELECT e FROM Experience e WHERE e.candidate.id = :canId", Experience.class)
                .setParameter("canId", canId)
                .getResultList();
    }
}
