package in.kce.book.service;

import in.kce.book.bean.BookBean;
import in.kce.book.dao.BookDAO;

public class Administrator {

    public String addBook(BookBean book) {
        if (book == null ||
            book.getISBN() == null ||
            book.getBookName() == null ||
            book.getAuthor() == null ||
            (book.getBookType() != 'G' && book.getBookType() != 'T') ||
            book.getCost() <= 0) {

            return "INVALID";
        }

        int result = new BookDAO().createBook(book);
        return (result > 0) ? "SUCCESS" : "FAILURE";
    }

    public BookBean viewBook(String isbn) {
        return new BookDAO().fetchBook(isbn);
    }
}
