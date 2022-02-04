package combinatorpattern;

import model.Customer2;
import model.ValidationResult;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {
        Customer2 customer = new Customer2(
                "Geovanny",
                "geovanny@gmail.com",
                "+57123456789",
                LocalDate.of(2000,1,1)
        );

       // System.out.println(new CustomerValidatorService().isValid(customer));

        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
