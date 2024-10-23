package fit.edu.de1;

import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import fit.edu.de1.dao.QuanLyLoaiThuocDao;
import fit.edu.de1.dao.QuanLyThuocDao;
import fit.edu.de1.models.LoaiThuoc;
import fit.edu.de1.models.Thuoc;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "QuanLyThuocServlet", value = "/controller")
public class QuanLyThuocServlet extends HttpServlet {

    @EJB
    private QuanLyLoaiThuocDao quanLyLoaiThuocDao;

    @EJB
    private QuanLyThuocDao thuocDao;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            Object obj = request.getParameter("action");
            if (obj != null) {
                String action = obj.toString();
                switch (action) {
                    case "showThuoc":
                        request.setAttribute("loaiThuocList", quanLyLoaiThuocDao.getAllLoaiThuoc());
                        request.setAttribute("listThuoc", thuocDao.getAll());
                        RequestDispatcher dispatcherThuoc = request.getRequestDispatcher("danhSachThuoc.jsp");
                        dispatcherThuoc.forward(request, response);
                        break;
                    case "showLoaiThuoc":
                        request.setAttribute("loaiThuocList", quanLyLoaiThuocDao.getAllLoaiThuoc());
                        RequestDispatcher dispatcher = request.getRequestDispatcher("danhSachLoaiThuoc.jsp");
                        dispatcher.forward(request, response);
                        break;
                    case "getDSThuocByLoaiThuoc":
                        String tenLoai = request.getParameter("tenLoai");
                        if (tenLoai != null) {
                            if (tenLoai.equalsIgnoreCase("all")) {
                                request.setAttribute("listThuoc", thuocDao.getAll());
                                request.setAttribute("loaiThuocList", quanLyLoaiThuocDao.getAllLoaiThuoc());
                            } else {
                                request.setAttribute("listThuoc", thuocDao.getDSThuocByLoaiThuoc(tenLoai));
                                request.setAttribute("loaiThuocList", quanLyLoaiThuocDao.getAllLoaiThuoc());
                            }

                            request.getRequestDispatcher("danhSachThuoc.jsp").forward(request, response);
                        } else {
                            response.sendRedirect("index.jsp");
                        }
                        break;
                    case "showThemThuoc":
                        request.setAttribute("loaiThuocList", quanLyLoaiThuocDao.getAllLoaiThuoc());
                        request.getRequestDispatcher("themThuocMoi.jsp").forward(request, response);
                        break;
                    default:
                        response.sendRedirect("index.jsp");
                        break;
                }
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            Object obj = request.getParameter("action");
            if (obj != null) {
                String action = obj.toString();
                switch (action) {
                    case "addThuoc":

                        String tenThuoc = request.getParameter("tenThuoc");
                        String maLoai = request.getParameter("maLoai");
                        Double donGia = Double.valueOf(request.getParameter("donGia"));
                        Integer namSX = Integer.valueOf(request.getParameter("namSX"));
                        LoaiThuoc loaiThuoc = quanLyLoaiThuocDao.getLoaiThuocById(maLoai).get();
                        Thuoc thuoc = new Thuoc(UUID.randomUUID().toString(), donGia, namSX, tenThuoc, loaiThuoc);

                        if (thuocDao.addThuoc(thuoc) != null) {
                            request.setAttribute("message", "Thêm thuốc thành công");
                            request.setAttribute("loaiThuocList", quanLyLoaiThuocDao.getAllLoaiThuoc());
                            request.setAttribute("listThuoc", thuocDao.getAll());
                            RequestDispatcher dispatcherThuoc = request.getRequestDispatcher("danhSachThuoc.jsp");
                            dispatcherThuoc.forward(request, response);
                        } else {
                            request.setAttribute("message", "Thêm thuốc thất bại");
                        }

                        break;
                    default:
                        response.sendRedirect("index.jsp");
                        break;
                }
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    public void destroy() {
    }
}