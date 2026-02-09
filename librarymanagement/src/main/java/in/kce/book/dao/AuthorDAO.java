package in.kce.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.kce.book.bean.AuthorBean;
import in.kce.book.util.DButil;

public class AuthorDAO {

    public AuthorBean getAuthor(String name) {
        try {
            Connection con = DButil.getDBConnection();
            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM Author_Tbl WHERE Author_name=?");
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AuthorBean a = new AuthorBean();
                a.setAuthorCode(rs.getInt(1));
                a.setAuthorName(rs.getString(2));
                a.setContactNo(rs.getLong(3));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
