package dao;

import util.DBConnection;
import java.sql.*;

public class IssueDAO {

    public void issueBook(int bookId, int memberId) {
        String issueSQL = "INSERT INTO issued_books (book_id, member_id, issue_date) VALUES (?, ?, CURDATE())";
        String updateStock = "UPDATE books SET quantity = quantity - 1 WHERE book_id = ? AND quantity > 0";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            PreparedStatement ps1 = con.prepareStatement(updateStock);
            ps1.setInt(1, bookId);
            int updated = ps1.executeUpdate();

            if (updated == 0) {
                System.out.println("Book not available");
                con.rollback();
                return;
            }

            PreparedStatement ps2 = con.prepareStatement(issueSQL);
            ps2.setInt(1, bookId);
            ps2.setInt(2, memberId);
            ps2.executeUpdate();

            con.commit();
            System.out.println("Book issued successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}