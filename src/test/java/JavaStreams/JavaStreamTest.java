package JavaStreams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

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
        names.stream().filter(s -> s.length() > 4).forEach(System.out::println);
        System.out.println("---------------");

        // Limit by 1 element
        System.out.println("Print names which length is > 4");
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(System.out::println);
        System.out.println("---------------");
    }

}
