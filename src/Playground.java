import java.sql.*;

/**
 * This program demonstrates how to use UCanAccess JDBC driver to read/write
 * a Microsoft Access database.
 * @author www.codejava.net
 *
 */
public class Playground {

    public static void main(String[] args) {

        String databaseURL = "jdbc:ucanaccess://src/ProductList.accdb";

        try (Connection connection = DriverManager.getConnection(databaseURL)) {


            String sql = "SELECT * FROM sample_products";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                //int id = result.getInt("ID");
                String title = result.getString("title");
                String description = result.getString("description");

                System.out.println(title + ", " + description);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
