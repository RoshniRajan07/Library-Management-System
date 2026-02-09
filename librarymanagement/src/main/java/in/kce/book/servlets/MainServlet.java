package in.kce.book.servlets;

import java.io.IOException;

import in.kce.book.bean.BookBean;
import in.kce.book.dao.AuthorDAO;
import in.kce.book.service.Administrator;
import in.kce.book.service.Administrator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operation");

        if (operation.equals("AddBook")) {

            String isbn = request.getParameter("isbn");
            String bookName = request.getParameter("bookName");
            char bookType = request.getParameter("bookType").charAt(0);
            String authorName = request.getParameter("authorName");
            float cost = Float.parseFloat(request.getParameter("cost"));

            BookBean book = new BookBean();
            book.setISBN(isbn);
            book.setBookName(bookName);
            book.setBookType(bookType);
            book.setCost(cost);
            book.setAuthor(new AuthorDAO().getAuthor(authorName));
            System.out.println(book);
            String result = new Administrator().addBook(book);

            if (result.equals("SUCCESS"))
                response.sendRedirect("Menu.html");
            else if (result.equals("INVALID"))
                response.sendRedirect("Invalid.html");
            else
                response.sendRedirect("Failure.html");

        } else if (operation.equals("Search")) {

            String isbn = request.getParameter("isbn");
            BookBean book = new Administrator().viewBook(isbn);

            if (book == null) {
                response.sendRedirect("Invalid.html");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("book", book);
                RequestDispatcher rd = request.getRequestDispatcher("ViewServlet");
                rd.forward(request, response);
            }
        }
    }
}
