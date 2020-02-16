package org.example.servlet;

import lombok.SneakyThrows;
import org.example.dao.DepartmentsDao;
import org.example.model.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/departments")
public class DepartmentsServlet extends HttpServlet {
    private DepartmentsDao departmentsDao = new DepartmentsDao();
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        String action = Optional.ofNullable(req.getParameter("action"))
                .orElse("");

        switch (action) {
            case "remove":
                departmentsDao.delete(Integer.valueOf(req.getParameter("id")));
                resp.sendRedirect("/departments");
                break;
            case "edit":
            case "add":
                req.getRequestDispatcher("addEditDepartment.jsp").forward(req, resp);
                break;
            default:
                req.setAttribute("departments", departmentsDao.findAll());
                req.getRequestDispatcher("departments.jsp").forward(req, resp);
        }
    }
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        String id = req.getParameter("id");
        String name = req.getParameter("name");

        if (id == null || id.isEmpty()) {
            departmentsDao.save(new Department(name));
        } else {
            departmentsDao.update(new Department(Integer.parseInt(id), name));
        }

        resp.sendRedirect("/departments");
    }

}
