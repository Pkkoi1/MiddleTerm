package fit.edu.de1.dao;


import fit.edu.de1.models.LoaiThuoc;
import fit.edu.de1.models.Thuoc;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Stateless
public class QuanLyThuocDao {
    private EntityManager em;
    private EntityTransaction et;

    public QuanLyThuocDao() {
        em = Persistence.createEntityManagerFactory("MariaBD").createEntityManager();
        et = em.getTransaction();
    }

    public List<Thuoc> getAll() {
        return em.createQuery("SELECT t FROM Thuoc t", Thuoc.class)
                .getResultStream()
                .collect(Collectors.toList());
    }

    public void close() {
        em.close();
    }

    public List<Thuoc> getDSThuocByLoaiThuoc(String loaiThuoc) {
        return em.createQuery("SELECT t FROM Thuoc t WHERE t.maLoai.maLoai = :loaiThuoc", Thuoc.class)
                .setParameter("loaiThuoc", loaiThuoc)
                .getResultStream()
                .collect(Collectors.toList());
    }

    public Thuoc addThuoc(Thuoc thuoc) {
        try {
            et.begin();
            em.persist(thuoc);
            et.commit();
            return thuoc;
        } catch (Exception e) {
            et.rollback();
            return null;
        }
    }

}
