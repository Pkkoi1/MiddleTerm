package iuh.fit.dao;

import iuh.fit.enums.Roles;
import iuh.fit.models.Candidate;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class CandidateDao {
    EntityManager em;

    public CandidateDao() {
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
        Roles roles = Roles.values()[role];
        return em.createQuery("SELECT c FROM Candidate c JOIN c.experiences e WHERE e.role = :role", Candidate.class)
                .setParameter("role", roles)
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
