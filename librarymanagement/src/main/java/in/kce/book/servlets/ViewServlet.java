package in.kce.book.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import in.kce.book.bean.BookBean;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        BookBean b = (BookBean) req.getSession().getAttribute("book");

        out.println("<html><body>");
        out.println("<h2>Book Details</h2>");
        out.println("ISBN: " + b.getISBN() + "<br>");
        out.println("Title: " + b.getBookName() + "<br>");
        out.println("Author: " + b.getAuthor().getAuthorName() + "<br>");
        out.println("Contact: " + b.getAuthor().getContactNo() + "<br>");
        out.println("Cost: " + b.getCost());
        out.println("</body></html>");
    }
}
