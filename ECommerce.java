package workshop7;


/**
 * import java ArrayList
 */
import java.util.ArrayList;
/**
 * The product class represents a product in the e-commerce system.
 * it contains product details like ID, name, price, and stock quantity.
 */
class Product{
	String productId;
	String name;
	double price;
	int stockQuantity;
	/**
	 * Constructor to create a product object
	 * @param productId Unique identifier for the product
	 * @param name Name of the product
	 * @param price Price of the product
	 * @param stockQuantity Available stock quantity
	 */
	public Product(String productId, String name, double price, int stockQuantity) {
		this.productId=productId;
		this.name=name;
		this.price=price;
		this.stockQuantity=stockQuantity;
	}
	/**
	 * Displays the details of the product.
	 * displays product name, price, and stock quantity
	 */
	public void getDetails() {
		System.out.println("Product: "+name+" Price: "+price+"Stock: "+stockQuantity);
	}
	/**
	 * checks if the requested quantity is available in stock
	 * @param quantity The quantity to check availability for 
	 * @return true if the quantity is available, false if not available
	 */
	public boolean checkAvailability(int quantity) {
		return quantity <= stockQuantity;
	}
}
/**
 * The shoppingCart class represents a shopping cart in the e-commerce system.
 * It manages cart items and calculates total price
 */
class ShoppingCart{		
	ArrayList<Product> cartItems;
	double totalPrice;
	/**
	 * Default constructor for ShoppingCart
	 * Initialize empty cart with zero total price
	 */
	public ShoppingCart() {
		cartItems = new ArrayList<>();
		totalPrice =0.0;
		
	}
	/**
	 * Adds a product to the shopping cart with specified quantity
	 * @param product The product to add
	 * @param quantity The quantity to add
	 */
	public void addProduct(Product product, int quantity) {
		if(product.checkAvailability(quantity)) {
			for(int i = 0; i<quantity; i++) {
				cartItems.add(product);
			}
			System.out.println(quantity+" x "+product.name+" added to cart ");
		}else {
			System.out.println("Not enough stock for "+product.name);
		}
	}
	/**
	 * removes a product from the shopping cart
	 * @param product The product to remove
	 */
	public void removeProduct(Product product) {
		if(cartItems.remove(product)) {
			System.out.println(product.name+" removed from cart");
		}else {
			System.out.println("Product not found in cart");
		}
	}
	/**
	 * Calculates the total price of all the items in the cart
	 * @return the total price
	 */
	public double calculateTotalPrice() {
		totalPrice = 0;
		for(Product item : cartItems) {
			totalPrice += item.price;
		}
		return totalPrice;
	}
	/**
	 * Displays all items currently in the shopping cart.
	 * Displays each item's name and price
	 */
	public void viewCartItems() {
		if(cartItems.isEmpty()) {
			System.out.println("Cart is empty");
		}else {
			for (Product item:cartItems) {
				System.out.println("- "+item.name+": "+item.price);
			}
		}
	}

}
/**
 * THe customer class represents a customer in the e-commerce system.
 * Customers can register, login, view products, add to cart, and checkout
 */
class Customer{
	String customerId;
	String name;
	String email;
	String password;
	ShoppingCart cart;
	ArrayList<Product> products;
	/**
	 * Constructor to create a Customer object 
	 * @param customerId Unique identifier for the customer
	 * @param name Name of the customer
	 * @param email Email of the customer
	 * @param password Password for the customer account
	 * @param cart  Shopping cart for the customer
	 */
	public Customer(String customerId, String name, String email, String password, ShoppingCart cart) {
		this.customerId=customerId;
		this.name=name;
		this.email=email;
		this.password=password;
		this.cart=cart;
		this.products = new ArrayList<>();
		
	}
	/**
	 * Register the customer in the system
	 * prints a success message
	 */
	public void register() {
		System.out.println(name+" registered successfully");
	}
	/**
	 * Attempts to log into the customer with provided credentials
	 * @param email The email address to login with
	 * @param password THe password to login with
	 * @return true if login is successful, false if unsuccessful
	 */
	public boolean login(String email, String password) {
        if (this.email.equals(email) && this.password.equals(password)) {
            System.out.println("Login successful! Welcome " + name);
            return true;
        }
        System.out.println("Login failed!");
        return false;
	}
	/**
	 * Displays all available products to the customer
	 */
	public void viewProducts() {
        for (Product product : products) {
            product.getDetails();
        }
    }
    /**
     * Adds a product to the customer's shopping cart
     * @param product The product to add
     * @param quantity The quantity to add
     */
    public void addToCart(Product product, int quantity) {
        cart.addProduct(product, quantity);
    }
    /**
     * Completes the purchase process
     * Displays cart contents and clears the cart.
     */
    public void checkout() {
        cart.viewCartItems();
        System.out.println("Thank you for your purchase, " + name);
        cart = new ShoppingCart();
    }
}
/**
 * The E-commerceSystem class demonstrates the functionality of the e-commerce shopping cart system with a main method
 */
public class ECommerce {
	/**
	 * Main method that runs the e-commerce system.
	 * Creates products, shopping cart, customer and demonstrates all functionality
	 * @param args Command line arguments
	 */
    public static void main(String[] args) {
        Product laptop = new Product("P001", "Laptop", 999.99, 10);
        Product phone = new Product("P002", "Smartphone", 699.99, 20);
        Product headphone = new Product("P003", "Headphones", 199.99, 15);
        
        ShoppingCart cart = new ShoppingCart();
        Customer customer = new Customer("C001", "Mark Zuckerberg", "mark@email.com", "password1234", cart);
        
        customer.register();
        
        customer.login("mark@email.com", "password1234");
        
        customer.products.add(laptop);
        customer.products.add(phone);
        customer.products.add(headphone);
        
        customer.viewProducts();
        
        customer.addToCart(laptop, 1);
        customer.addToCart(phone, 2);
        customer.addToCart(headphone, 1);
        
        customer.cart.viewCartItems();
        
        customer.cart.removeProduct(phone);
        customer.cart.viewCartItems();
        
        customer.checkout();
    }
}