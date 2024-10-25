package iuh.fit.giuaKy_xe.dao;

import iuh.fit.giuaKy_xe.models.Loaixe;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

import java.util.List;

@Stateless
public class QuanLyLoaiXeDao {
    EntityManager em;
    EntityTransaction et;

    public QuanLyLoaiXeDao() {
        em = Persistence.createEntityManagerFactory("MariaBD").createEntityManager();
        et = em.getTransaction();
    }

    @Transactional
    public List<Loaixe> getAllLoaiXe() {
        return em.createQuery("SELECT lx FROM Loaixe lx", Loaixe.class).getResultList();
    }
}
