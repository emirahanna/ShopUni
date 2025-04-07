import java.sql.*;

/**
 * This program demonstrates how to use UCanAccess JDBC driver to read/write
 * a Microsoft Access database.
 * @author www.codejava.net
 *
 */
public class playground {

    public static void main(String[] args) {

        String databaseURL = "jdbc:ucanaccess://e://Java";

        try (Connection connection = DriverManager.getConnection(databaseURL)) {


            String sql = "SELECT * FROM ProductList";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("ID");
                String title = result.getString("title");
                String description = result.getString("description");

                System.out.println(id + ", " + title + ", " + description);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
