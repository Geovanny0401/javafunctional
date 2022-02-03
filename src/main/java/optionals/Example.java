package optionals;

import java.util.Optional;

public class Example {

    public static void main(String[] args) {

        Optional.ofNullable("geovanny@gmail.com")
                .ifPresentOrElse(email -> System.out.println("Sengin email to: " +email ),
                        ()-> System.out.println("Cannot send email"));
    }
}
