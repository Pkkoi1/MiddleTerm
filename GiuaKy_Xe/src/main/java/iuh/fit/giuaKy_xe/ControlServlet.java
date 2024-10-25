package iuh.fit.giuaKy_xe;

import java.io.*;

import iuh.fit.giuaKy_xe.dao.QuanLyLoaiXeDao;
import iuh.fit.giuaKy_xe.dao.QuanLyXeDao;
import iuh.fit.giuaKy_xe.models.Loaixe;
import iuh.fit.giuaKy_xe.models.Xe;
import jakarta.ejb.EJB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ControlServlet", value = "/controller")
public class ControlServlet extends HttpServlet {
    private String message;

    @EJB
    QuanLyLoaiXeDao loaiXeDao;

    @EJB
    QuanLyXeDao xeDao;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            loaiXeDao = new QuanLyLoaiXeDao();
            xeDao = new QuanLyXeDao();
            Object obj = request.getParameter("action");
            if (obj != null) {
                String action = obj.toString();
                switch (action) {
                    case "showTypeVehicle":
                        request.setAttribute("listTypeVehicle", loaiXeDao.getAllLoaiXe());
                        request.getRequestDispatcher("loaixe.jsp").forward(request, response);
                        break;
                    case "showVehicles":
                        request.setAttribute("listVehicle", xeDao.getAllXe());
                        request.getRequestDispatcher("xe.jsp").forward(request, response);
                        break;
                    case "addVehicle":
                        request.setAttribute("listTypeVehicle", loaiXeDao.getAllLoaiXe());
                        request.getRequestDispatcher("ThemMoiXe.jsp").forward(request, response);
                        break;
                    case "showVehicleByType":
                        Integer maLoai = Integer.parseInt(request.getParameter("id"));
                        request.setAttribute("listVehicle", xeDao.getListByType(maLoai));
                        request.getRequestDispatcher("xe.jsp").forward(request, response);
                        break;
                    default:
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Object obj = request.getParameter("action");
            if (obj != null) {
                String action = obj.toString();
                switch (action) {
                    case "addNewVehicle":
                        String tenXe = request.getParameter("tenXe");
                        Double gia = Double.parseDouble(request.getParameter("gia"));
                        Integer namSx = Integer.parseInt(request.getParameter("namSx"));
                        Integer maLoai = Integer.parseInt(request.getParameter("maLoai"));

                        Loaixe loaixe = new Loaixe();
                        loaixe.setId(maLoai);
                        Xe xe = new Xe(tenXe, gia, namSx, loaixe);
                        xeDao.addXe(xe);
                        request.setAttribute("listVehicle", xeDao.getAllXe());
                        request.getRequestDispatcher("xe.jsp").forward(request, response);
                        break;
                    default:
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}