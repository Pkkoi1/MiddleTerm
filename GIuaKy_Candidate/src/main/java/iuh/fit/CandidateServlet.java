package iuh.fit;

import java.io.*;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import iuh.fit.dao.CandidateDao;
import iuh.fit.dao.ExperienceDao;

@WebServlet(name = "helloServlet", value = "/controller")
public class CandidateServlet extends HttpServlet {

    @EJB
    private CandidateDao candidateDao;

    @EJB
    private ExperienceDao experienceDao;

    RequestDispatcher dispatcher;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Object obj = request.getParameter("action");
            if (obj != null) {
                String action = obj.toString();
                switch (action) {
                    case "showCandidates":
                        request.setAttribute("listCandidate", candidateDao.getALlCandidate());
                        request.getRequestDispatcher("candidates.jsp").forward(request, response);
                        break;
                    case "showDetail":
                        long id_candidate = Long.parseLong(request.getParameter("id"));
                        request.setAttribute("candidate", candidateDao.getCandidateById(id_candidate).get());
                        request.setAttribute("listExperience", experienceDao.getAllExpByCanId(id_candidate));
                        request.getRequestDispatcher("candidate_details.jsp").forward(request, response);
                        break;
                    case "report1":
                        request.getRequestDispatcher("report1.jsp").forward(request, response);
                        break;
                    case "viewRoles":
                        String roleParam = request.getParameter("role");
                        if ("ALL".equals(roleParam)) {
                            request.setAttribute("listCandidate", candidateDao.getALlCandidate());
                        } else {
                            Byte role = Byte.parseByte(roleParam);
                            if (candidateDao.getCandidateByRole(role).size() != 0 || role == 0) {
                                request.setAttribute("listCandidate", candidateDao.getCandidateByRole(role));

                            } else {
                                request.getRequestDispatcher("report1.jsp").forward(request, response);
                            }
                        }
                        request.getRequestDispatcher("report1.jsp").forward(request, response);
                        break;
                    case "report2":
                        request.setAttribute("listCandidate", candidateDao.findAllUseEmail());
                        request.getRequestDispatcher("report2.jsp").forward(request, response);
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}