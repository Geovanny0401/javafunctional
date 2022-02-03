package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        System.out.println("Without predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("0700000000"));
        System.out.println(isPhoneNumberValid("09009877300"));

        System.out.println("With predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0700000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09009877300"));

        System.out.println(
                "Is phone number valid and contains number 2 = " +
                        isPhoneNumberValidPredicate.and(containsNumber2).test("09009877200")
        );

        System.out.println(
                "Is phone number valid and contains number 2 = " +
                        isPhoneNumberValidPredicate.or(containsNumber2).test("07000000002")
        );
    }

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length()==11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length()==11;

    static Predicate<String> containsNumber2 = phoneNumber ->
            phoneNumber.contains("2");
}
