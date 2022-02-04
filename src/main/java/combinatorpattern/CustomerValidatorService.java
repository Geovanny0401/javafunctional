package combinatorpattern;

import model.Customer2;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean isEmailValid(String email){
        return email.contains("@");
    }

    private boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("+57");
    }

    private boolean isAdult(LocalDate dob){
        return Period.between(dob,LocalDate.now()).getYears() > 16;
    }

    public boolean isValid(Customer2 customer)
    {
        return isEmailValid(customer.getEmail()) &&
                isPhoneNumberValid(customer.getPhoneNumber()) &&
                isAdult(customer.getDob());
    }
}
