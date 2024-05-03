package customer;

public class Main {
    public static void main(String[] args) {
        // Creating a new customer
        Customer customer = new Customer("John Doe", "john@example.com", "123 Main St");

        // Displaying customer information
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Customer Email: " + customer.getEmail());
        System.out.println("Customer Address: " + customer.getAddress());

        // Updating customer information
        customer.setName("Jane Smith");
        customer.setEmail("jane@example.com");
        customer.setAddress("456 Elm St");

        // Displaying updated customer information
        System.out.println("\nUpdated Customer Information:");
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Customer Email: " + customer.getEmail());
        System.out.println("Customer Address: " + customer.getAddress());
    }
}
