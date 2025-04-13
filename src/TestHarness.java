import edu.psu.ist.productmanagement.controller.ProductListingController;
import edu.psu.ist.usermanagement.controller.LogInController;

import java.sql.*;

public class TestHarness {
    public static void main(String[] args) {
        //testUserDBConnection();
        testFullFlow();
        //testProductListing();
    }

    public static void testProductListing()
    {
        //am tired of entering the credentials again and again
        new ProductListingController();
    }


    public static void testFullFlow() {
        LogInController logInController = new LogInController();
    }

    public static void testUserDBConnection() {
        String databaseURL = "jdbc:ucanaccess://src/ProductList.accdb";

        try (Connection connection = DriverManager.getConnection(databaseURL)) {


            String sql = "SELECT * FROM user_database";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("ID");
                String username = result.getString("username");
                String password = result.getString("password");

                System.out.println(id + ", " + username + ", " + password);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}  
