import edu.psu.ist.cartmanagement.controller.CartController;
import edu.psu.ist.productmanagement.controller.ProductListingController;
import edu.psu.ist.usermanagement.controller.LogInController;

import java.sql.*;

public class TestHarness {
    public static void main(String[] args) {
        testFullFlow();
        //attemptPaymentBeforeLogin();
    }

    public static void attemptPaymentBeforeLogin(){
        CartController c = new CartController();
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

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //ex: SELECT * FROM users_database WHERE ID =1


}  
