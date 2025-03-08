package UserManagement.view;

import javax.swing.*;
import java.awt.*;

/**
 *  Will hold the graphical display information for each product detail so users can interact with and
 *  view individual product listings
 */

public class ProductDetailsView extends JFrame {
    public ProductDetailsView() throws HeadlessException {
    }
    public void ShowProductDetails() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter the product name");
        String productName = scnr.nextLine();
        System.out.println("Enter the product price");
        double price = scnr.nextDouble();
        System.out.println("Enter the product description");
        String productDescription = scnr.nextLine();
        System.out.println("Enter the product's category");
        String category = scnr.nextLine();
        System.out.println("Enter the product image URL");
        String productImageURL = scnr.nextLine();
    }
}
