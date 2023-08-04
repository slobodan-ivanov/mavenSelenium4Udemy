package JavaStreams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavaStreamTest {

    @Test
    public void countWithFor() {

        // count numbers of elements starting with letter a
        ArrayList<String> names = new ArrayList<>();
        names.add("Abuhar");
        names.add("Boban");
        names.add("Mixa");
        names.add("Adam");
        names.add("Vanja");

        int nNamesWithA = 0;
        for (String name: names) {
            if (name.startsWith("A")) {
                nNamesWithA++;
            }
        }
        System.out.println("nNamesWithA: " +nNamesWithA);
    }

    @Test
    public void streamFilter() {
        // count numbers of elements starting with letter a
        ArrayList<String> names = new ArrayList<>();
        names.add("Abuhar");
        names.add("Boban");
        names.add("Mixa");
        names.add("Adam");
        names.add("Vanja");

        long nNamesWithA = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println("nNamesWithA: " +nNamesWithA);
        System.out.println("---------------");

        //2nd way
        Stream.of("Alphabet", "Don", "Adhkya", "Adam", "Banana"); // Creating collection (stream)
        Stream.of("Alphabet", "Don", "Adhkya", "Adam", "Banana").filter(
                s -> s.startsWith("A")).count(); // Nothing happens

        System.out.println("Print names which length is > 4");
        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
        System.out.println("---------------");

        // Limit by 1 element
        System.out.println("Print names which length is > 4");
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
        System.out.println("---------------");
    }

    @Test
    public void streamMapConcatMatch() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Abuhar");
        names.add("Boban");
        names.add("Vanja");
        names.add("Adam");
        names.add("Mixa");

        names.stream().filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        // print names starts with A and sort and uppercase
        names.stream().filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).sorted().forEach(s -> System.out.println(s));

        // Concat stream and return boolean if match with some word
        Stream<String> newStream = Stream.concat(names.stream(), names.stream());
        boolean anyMatch = newStream.anyMatch(s -> s.equals("Adam"));
        assertTrue(anyMatch);
    }

}
