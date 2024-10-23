package fit.edu.de1.dao;


import fit.edu.de1.models.LoaiThuoc;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Stateless
public class QuanLyLoaiThuocDao {
    private EntityManager em;
    private EntityTransaction et;

    public QuanLyLoaiThuocDao() {
        em = Persistence.createEntityManagerFactory("MariaBD").createEntityManager();
        et = em.getTransaction();
    }

    public void close() {
        em.close();
    }

    public List<LoaiThuoc> getAllLoaiThuoc() {
        String query = "SELECT lt FROM LoaiThuoc lt order by lt.tenLoai desc";
        return em.createQuery(query, LoaiThuoc.class)
                .getResultStream()
                .collect(Collectors.toList());
    }

    public Optional<LoaiThuoc> getLoaiThuocById(String maLoai) {
        return Optional.ofNullable(em.find(LoaiThuoc.class, maLoai));
    }

}
