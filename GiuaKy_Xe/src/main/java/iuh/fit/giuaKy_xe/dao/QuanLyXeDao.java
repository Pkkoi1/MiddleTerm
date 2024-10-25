package iuh.fit.giuaKy_xe.dao;


import iuh.fit.giuaKy_xe.models.Xe;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Stateless
public class QuanLyXeDao {
    EntityManager em;
    EntityTransaction et;

    public QuanLyXeDao() {
        em = Persistence.createEntityManagerFactory("MariaBD").createEntityManager();
        et = em.getTransaction();
    }

    @Transactional
    public Set<Xe> getAllXe() {
        return em.createQuery("SELECT x FROM Xe x", Xe.class)
                .getResultStream()
                .collect(Collectors.toSet());
    }

    @Transactional
    public Set<Xe> getListByType(int type) {
        return em.createQuery("SELECT x FROM Xe x WHERE x.maLoai.id = :type", Xe.class)
                .setParameter("type", type)
                .getResultStream()
                .collect(Collectors.toSet());
    }

    @Transactional
    public Xe addXe(Xe xe) {
        try {
            et.begin();
            em.persist(xe);
            et.commit();
            return xe;
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        }
        return null;
    }
}
