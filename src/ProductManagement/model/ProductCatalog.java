package ProductManagement.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductCatalog {
    private ArrayList<Product> products;
    private int productPerPage = 3;

    public ProductCatalog() {
        this.products = new ArrayList<>();
        loadSampleProducts(); // sample data, actual shop should be reading from a database
    }

    private void loadSampleProducts() {
        products.add(new Product("Scarab Cut Out Top in Dusk", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance. Featuring a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. ", "20342391331", "imageID", "sellerID", new Date(), "Tops", new Pricing(40) ));
        products.add(new Product("Jeane Cut Out Long Sleeve Top", "Effortlessly chic, this draped front top is crafted from a MicroModal blend offering a soft, luxurious feel with a hint of stretch. With a slim fit and high neckline, it features gathered detailing across the front creating a flattering, asymmetrical silhouette. Pair with skirts or tailored trousers for a sophisticated take.", "20342391331", "imageID", "sellerID", new Date(), "Tops", new Pricing(40) ));
        products.add(new Product("Penn State Hoodie", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance. Featuring a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. ", "20342391331", "imageID", "sellerID", new Date(), "Tops", new Pricing(40) ));
        products.add(new Product("Happy Valley Sweater", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance. Featuring a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. ", "20342391331", "imageID", "sellerID", new Date(), "Tops", new Pricing(40) ));
        products.add(new Product("Something something product", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance. Featuring a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. ", "20342391331", "imageID", "sellerID", new Date(), "Tops", new Pricing(40) ));
        products.add(new Product("Scarab Cut Out Top in Dusk", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance. Featuring a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. ", "20342391331", "imageID", "sellerID", new Date(), "Tops", new Pricing(40) ));
    }

    /**
     * This basically returns the products in the list that will be displayed on a certain page
     * @param page
     * @return
     */
    public ArrayList<Product> getProductsOnPage(int page) {
        int start = (page - 1) * productPerPage;
        int end = Math.min(start + productPerPage, products.size());

        if (start >= products.size()) return new ArrayList<>(); // No more products

        return new ArrayList<>(products.subList(start, end));
    }

    public int getTotalPages() {
        return products.size() / productPerPage;
    }
}
