package in.kce.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.kce.book.bean.AuthorBean;
import in.kce.book.bean.BookBean;
import in.kce.book.util.DButil;

public class BookDAO {

    public int createBook(BookBean book) {
        try {
            Connection con = DButil.getDBConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Book_Tbl VALUES (?,?,?,?,?)"
            );

            ps.setString(1, book.getISBN());
            ps.setString(2, book.getBookName());
            ps.setString(3, String.valueOf(book.getBookType()));
            ps.setInt(4, book.getAuthor().getAuthorCode());
            ps.setFloat(5, book.getCost());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public BookBean fetchBook(String isbn) {
        try {
            Connection con = DButil.getDBConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT b.ISBN,b.Book_title,b.Book_type,b.Book_cost," +
                "a.Author_code,a.Author_name,a.contact_no " +
                "FROM Book_Tbl b JOIN Author_Tbl a " +
                "ON b.Author_code=a.Author_code WHERE b.ISBN=?"
            );
            ps.setString(1, isbn);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                BookBean b = new BookBean();
                b.setISBN(rs.getString(1));
                b.setBookName(rs.getString(2));
                b.setBookType(rs.getString(3).charAt(0));
                b.setCost(rs.getFloat(4));

                AuthorBean a = new AuthorBean();
                a.setAuthorCode(rs.getInt(5));
                a.setAuthorName(rs.getString(6));
                a.setContactNo(rs.getLong(7));

                b.setAuthor(a);
                return b;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
