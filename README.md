# ShopUni

We are four Penn State students who intend to create a comprehensive storefront application that will allow college-aged customers to sell and purchase products independently. This is our attempt of modelling a complex system, consisting of multiple subsystems and organized using the Model, View, Controller (MVC) architecture.


M03-A05 One Implemented Use Case: 

| User ID | Name              | % Efforts in Assignment | Brief of Efforts in the Task Contribution                                                                                                                                                                                                                                                                                                      |
|---------|-------------------|-------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| nvl5303 | Nicole Leon       | %                       | Design Pattern for Individual Assignment was individual product pages, and helped create Login GUI.                                                                                                                                                                                                                                            |
| ezy5092 | Emira Hanna Yahya | %                       | Implemented ProductList (products, users, and cart items) database, connected product catalog and product page to data base, established project structure using Maven, started catalog and page GUI and fixed some spacing issues, implemented cart GUI, and dynamic cart view, and reorganized modules and recent impl to fit MVC structure. |
| hmf5339 | Haley Fitzgerald  | %                       | Started connecting database to product page GUI, initial add to cart button/view product details button functionality, fixed some UI challenges initially in the product listing form, helped create Login GUI, connected login gui to functionality for authentication.                                                                       |
| hlt5125 | Heaven Thomas     | %                       | Checked over design code                                                                                                                                                                                                                                                                                                                       |

M03-A04 Implemented Design Patterns:

| User ID | Name              | Design Pattern Implemented           | Classes / Interfaces implementing the Design Pattern                                                                                                                                                                                                                                                                                                                                                                                                                           |
|---------|-------------------|--------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| nvl5303 | Nicole Leon       | Product page and observer            | Established observer. Interfaces for observer implemented: CartObserver, and made changes to UserAccount. Product Page  also implemented.                                                                                                                                                                                                                                                                                                                                      |
| ezy5092 | Emira Hanna Yahya | Singleton & Breadcrumbs              | Implemented singleton inside <code>CartManager</code> where a single Cart Manager Instance manages all the carts across the application. <br/> <br/>Breadcrumbs is implemented in <code>ProductListingView</code> and <code>CartContentsView</code>. This is mainly as these are the only views that have been implemented for this application, and can benefit from the breadcrumbs UI pattern.                                                                              |
| hmf5339 | Haley Fitzgerald  | Carousel and chain of responsibility | Classes implemented for chain of responsibility: OrderHandler paymentHandler, shippingHandler, validationHandler. Made changes in OrderController and Order. Classes implemented for carousel: FeaturedProductsView, FeaturedProductsForm, and FeaturedProductsController. Added getFeaturedProducts() method in product catalog.                                                                                                                                              |
| hlt5125 | Heaven Thomas     | Facade and Wizard                    | Implemented PaymentFacade.java class: It holds the Facade Pattern. It acts as a single entry point to process, refund, save, and update payments. Internally delegates work to model (Payment, SavedPayment) and view (PaymentView) components. Implemented wizard ui code in payment managment with classes in the view such as WizardFrame, Step1Panel, Step2Panel, Step3Panel which handles all the steps users would have to take to finish their payment checkout process |

USE CASES
1. View Product Details
2. Add Product to Cart
3. Track Order
4. Purchase Order
5. Authenticate Account

Log In Credentials
username: buyer
password: pwd