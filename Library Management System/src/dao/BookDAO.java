package dao;

import util.DBConnection;
import java.sql.*;

public class BookDAO {

    public void addBook(String title, String author, int quantity) {
        String sql = "INSERT INTO books (title, author, quantity) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, quantity);
            ps.executeUpdate();
            System.out.println("Book added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewBooks() {
        String sql = "SELECT * FROM books";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("book_id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("author") + " | Qty: " +
                                rs.getInt("quantity")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}