# ShopUni

We are four Penn State students who intend to create a comprehensive storefront application that will allow college-aged
customers to sell and purchase products independently. This is our attempt of modelling a complex system, consisting of
multiple subsystems and organized using the Model, View, Controller (MVC) architecture.

## M04-A03 Two Implemented Use Cases with Clean, Refactored Code:

### Use Cases

1. View Product Details ✅
2. Add Product to Cart ✅
3. Track Order
4. Purchase Order ✅
5. Authenticate Account ✅

### User Credentials for Log In

    username: buyer
    password: pwd

### Context:

The use cases we implemented are sequential (Adding a product to the cart, and purchasing a product) and both relate to
a single user, the customer. Hence, we have an extra navigation menu for the assignment, and included a small link
underneath the buttons to experience the app as we intended

### Additional Details

Note: we have yet to find images for all 50 of our sample products. Please do not be confused if you see the same
product image. That is intentional, and will be fixed by the presentation

| User ID | Name              | % Efforts in Assignment | Brief of Efforts in the Task Contribution                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
|---------|-------------------|-------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| nvl5303 | Nicole Leon       | %2                      | Cleaned up code                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| ezy5092 | Emira Hanna Yahya | % 65                    | 1. Created nav menu for selecting between use cases<br/>2. Implemented actual images on product pages (Still uses a placeholder for now)<br/>3. Cart persistence between sessions<br/>4. Made it so that new payments, orders and deliveries were written to the database<br/>5. Implemented incremented ID generation for payment, order and shipping<br/>6.Ensure buttons create <code>Payment</code> and <code>Order</code> instances<br/>7. Input validation for login and payment<br/>8. Implemented code refactors (remove lazy classes, long param lists, unused imports, unused getters that will not be used in the future) and suggestions (Authentication now reads from the userDB, hint text disappears when you click on the text field, prices are on catalog, and more pronounced on the product page etc.) |
| hmf5339 | Haley Fitzgerald  | % 33                    | 1. Implemented ability to clear cart completely and delete products one by one from cart.<br/>2.Made it so when you click buy now in cart it directs user to payment wizard.<br/>3. Implemented UI for Step 1, Step 2, and step 3 of Payment Wizard.<br/>4. Cleaned up large class                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| hlt5125 | Heaven Thomas     | %0                      |

