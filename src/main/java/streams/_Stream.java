package streams;

import model.Person;

import java.util.List;
import java.util.stream.Collectors;

import static model.Gender.*;

public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Geovanny", MALE),
                new Person("Yohana", FEMALE),
                new Person("Deila", FEMALE),
                new Person("Teddy", OTHER),
                new Person("Claudia", FEMALE)
        );

        people.stream()
                .map(person -> person.getGender())
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }
}

