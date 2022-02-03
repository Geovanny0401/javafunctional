package Imperative;

import model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static model.Gender.FEMALE;
import static model.Gender.MALE;

public class Main {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Geovanny", MALE),
                new Person("Yohana", FEMALE),
                new Person("Deila", FEMALE),
                new Person("Teddy", MALE),
                new Person("Claudia", FEMALE)
        );

        System.out.println("// Imperative approach");

        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (FEMALE.equals(person.getGender())) {
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }

        System.out.println("// Declarative approach");
        List<Person> females2 = people.stream()
                .filter(person -> MALE.equals(person.getGender()))
                .collect(Collectors.toList());
        females2.forEach(System.out::println);
    }
}
