package JavaStreams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
}
