import java.util.ArrayList;
import java.util.List;

// Product class
class Product {
    private String name;
    private double unitPrice;

    public Product(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}

// LineItem class
class LineItem {
    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotal() {
        return product.getUnitPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}

// Invoice class
class Invoice {
    private String title;
    private String customerAddress;
    private List<LineItem> lineItems;

    public Invoice(String title, String customerAddress) {
        this.title = title;
        this.customerAddress = customerAddress;
        this.lineItems = new ArrayList<>();
    }

    public void addLineItem(LineItem item) {
        lineItems.add(item);
    }

    public double getTotalAmountDue() {
        double total = 0;
        for (LineItem item : lineItems) {
            total += item.getTotal();
        }
        return total;
    }

    public String getTitle() {
        return title;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create products
        Product product1 = new Product("Toaster", 29.95);
        Product product2 = new Product("Hair Dryer", 24.95);
        Product product3 = new Product("Car Vacuum", 19.99);
        // Create line items
        LineItem lineItem1 = new LineItem(product1, 3);
        LineItem lineItem2 = new LineItem(product2, 1);
        LineItem lineItem3 = new LineItem(product3, 2);
        // Create invoice
        Invoice invoice = new Invoice("Invoice Title", "Customer Address");
        invoice.addLineItem(lineItem1);
        invoice.addLineItem(lineItem2);
        invoice.addLineItem(lineItem3);

        // Print invoice details
        System.out.println("Invoice");
        System.out.println("Sam's Small Appliances \n 100 Main Street \n Anytown, CA 98765");
        System.out.println("-----------------------");

        for (LineItem item : invoice.getLineItems()) {
            System.out.println("Product: " + item.getProduct().getName());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("Total: $" + item.getTotal());

        }

        System.out.println("Total Amount Due: $" + invoice.getTotalAmountDue());
    }
}
