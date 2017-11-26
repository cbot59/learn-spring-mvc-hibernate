package it.aldi.web.springhibernate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet implementation class TestServlet */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String user = "springstudent";
    String pass = "springstudent";
    String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
    String driver = "com.mysql.jdbc.Driver";

    PrintWriter out = response.getWriter();
    response.setContentType("text/plain");

    try (Connection connection = DriverManager.getConnection(jdbcUrl, user, pass)) {
      Class.forName(driver);

      out.println("Connected to database.");
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
