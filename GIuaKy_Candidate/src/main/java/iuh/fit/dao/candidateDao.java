package iuh.fit.dao;

import iuh.fit.enums.Roles;
import iuh.fit.models.Candidate;
import iuh.fit.models.Experience;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Stateless
public class candidateDao {
    EntityManager em;

    public candidateDao() {
        em = Persistence.createEntityManagerFactory("MariaBD").createEntityManager();
    }


    @Transactional
    public List<Candidate> getALlCandidate() {
        return em.createQuery("SELECT c FROM Candidate c", Candidate.class).getResultList();
    }

    @Transactional
    public Optional<Candidate> getCandidateById(Long id) {
        return Optional.ofNullable(em.find(Candidate.class, id));
    }

    @Transactional
    public List<Candidate> getCandidateByRole(Byte role) {
        Roles roleEnum = Roles.values()[role];
        return em.createQuery("SELECT c FROM Candidate c JOIN c.experiences e WHERE e.role = :role", Candidate.class)
                .setParameter("role", roleEnum)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Transactional
    public List<Candidate> findAllUseEmail() {
        return em.createQuery("SELECT c FROM Candidate c WHERE c.email IS NOT NULL AND c.email <> '' AND c.email LIKE '%@gmail%'", Candidate.class)
                .getResultStream()
                .collect(Collectors.toList());
    }

}
