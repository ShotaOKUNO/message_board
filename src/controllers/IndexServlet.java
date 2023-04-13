package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import models.Message;
import utils.DBUtil;
import javax.servlet.RequestDispatcher;

import java.util.List;
import javax.persistence.EntityManager;
import models.Message;
import utils.DBUtil;

import javax.servlet.RequestDispatcher;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public IndexServlet() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        List<Message> messages = em.createNamedQuery("getAllMessages", Message.class).getResultList();

        em.close();

        request.setAttribute("messages", messages);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/messages/index.jsp");
        rd.forward(request, response);
    }

}