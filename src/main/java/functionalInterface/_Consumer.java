package functionalInterface;

import model.Customer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {

        //Normal Java Function
        Customer customer=new Customer("Yohana","99999");
        greetCustomer(customer);
        greetCustomerV2(customer, false);

        //Consumer Functional interface
        greetCustomerConsumer.accept(customer);
        greetCustomerConsumerV2.accept(customer,false);
    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.getCustomerName() +
                    ", thanks for registering phone number " +
                    (showPhoneNumber ? customer.getCustomerPhoneNumber() : "*******"));

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.getCustomerName() +
                    ", thanks for registering phone number " +
                    customer.getCustomerPhoneNumber());

    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.getCustomerName() +
                ", thanks for registering phone number" +
                (customer.getCustomerPhoneNumber()));
    }

    static void greetCustomerV2(Customer customer, boolean showPhoneNumber){
        System.out.println("Hello " + customer.getCustomerName() +
                ", thanks for registering phone number " +
                (showPhoneNumber ? customer.getCustomerPhoneNumber() : "*******"));
    }
}
