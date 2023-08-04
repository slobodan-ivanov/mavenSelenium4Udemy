package JavaStreams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavaStreamWithTasks {

    @Test
    public void regular() {
        List<String> names = new ArrayList<String>();
        names.add("Alphabet");
        names.add("Don");
        names.add("Adhkya");
        names.add("Adam");
        names.add("Banana");

        int count = 0;
        for (int i=0; i< names.size(); i++) {
            String name = names.get(i);
            if (name.startsWith("A")) {
                count++;
            }
        }
        System.out.println("count: " + count);
    }

    @Test
    public void streamFilter() {

        ArrayList<String> names = new ArrayList<>();
        names.add("Alphabet");
        names.add("Don");
        names.add("Adhkya");
        names.add("Adam");
        names.add("Banana");

        // Stream scans parallel
        // 1. Count names which starts with letter A
        Long count = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(count);
        // 2nd way
        Long count2 = Stream.of("Alphabet", "Don", "Adhkya", "Adam", "Banana").filter(s -> s.startsWith("A")).count();
        System.out.println(count2);
        // Print names which size iz more than 4.
        names.stream().filter(s -> s.length()>4).forEach(s -> System.out.println(s));
        // 2nd way limit to 0
        names.stream().filter(s -> s.length()>4).limit(1).forEach(s -> System.out.println(s));
    }

    @Test
    public void streamMap() {
        // Print strings which ends with a and uppercase them
        Stream.of("Alphabet", "Don", "Adhkya", "Adam", "Banana").filter(s -> s.endsWith("a")).
                map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
        // Print strings which starts with a and uppercase them, sot them
        List<String> names = Arrays.asList("Alphabet", "Don", "Adhkya", "Adam", "Banana");
        names.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).
                forEach(s -> System.out.println(s));

        // Concat stream and return boolean if match with some word
        Stream<String> newStream =  Stream.concat(names.stream(), names.stream());
//        newStream.sorted().forEach(s -> System.out.println(s));
        boolean flag = newStream.anyMatch(s -> s.equals("Adam"));
        assertTrue(flag);
    }

    @Test
    public void streamCollect() {
        // list
        // new list
        // new list some operations
        // Print second element which ends with a and uppercase
        List<String> newList = Stream.of("Alphabet", "Don", "Adhkya", "Adam", "Banana").filter(s -> s.endsWith("a")).
                map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(newList.get(0));

        List<Integer> numbers = Arrays.asList(1,5,3,1,2,4,5,8,9,10);
        // print unique number from this array
        // sort the array

//        numbers.stream().distinct().forEach(s -> System.out.println(s));
        List<Integer> sortedNumbers = numbers.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(sortedNumbers.get((2)));
    }

}

