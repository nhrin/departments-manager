package org.example.servlet;

import lombok.SneakyThrows;
import org.example.dao.EmployeesDao;
import org.example.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Optional;

import static java.lang.String.format;

@WebServlet("/employees")
public class EmployeesServlet extends HttpServlet {
    private EmployeesDao employeesDao = new EmployeesDao();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = Optional.ofNullable(req.getParameter("action"))
                .orElse("");

        switch (action) {
            case "remove":
                employeesDao.delete(Integer.parseInt(req.getParameter("id")));
                resp.sendRedirect("/employees?departmentId=" + Integer.parseInt(req.getParameter("departmentId")));
                break;
            case "add":
            case "edit":
                req.getRequestDispatcher("addEditEmployee.jsp").forward(req, resp);
                break;
            default:
                req.setAttribute("employees", employeesDao.findAll(Integer.parseInt(req.getParameter("departmentId"))));
                req.getRequestDispatcher("employees.jsp").forward(req, resp);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String departmentId = req.getParameter("departmentId");
        String birthday = format(req.getParameter("birthday"));

        if (id == null || id.isEmpty()) {
            employeesDao.save(new Employee(name, email, Integer.parseInt(departmentId), birthday));
        } else {
            employeesDao.update(new Employee(Integer.parseInt(id), name, email, Integer.parseInt(departmentId), birthday));
        }

        resp.sendRedirect("/employees?departmentId=" + departmentId);
    }
}
