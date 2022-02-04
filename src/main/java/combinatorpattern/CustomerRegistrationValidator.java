package combinatorpattern;

import model.Customer2;
import model.ValidationResult;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static model.ValidationResult.PHONE_NUMBER_NOT_VALID;
import static model.ValidationResult.SUCCESS;

public interface CustomerRegistrationValidator
        extends Function<Customer2, ValidationResult> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer2 -> {
            System.out.println("running email validation");
            return customer2.getEmail().contains("@") ?
                    SUCCESS : ValidationResult.EMAIL_NOT_VALID;
        };
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer2 -> customer2.getPhoneNumber().startsWith("+57") ?
                SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAdult() {
        return customer2 -> Period.between(customer2.getDob(), LocalDate.now()).getYears()> 16 ?
                SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }
}
