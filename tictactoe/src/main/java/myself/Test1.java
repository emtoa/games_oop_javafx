package myself;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {
        Integer[][] matrix = new Integer[2][2];

        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[1][0] = 3;
        matrix[1][1] = 4;

        /*
        System.out.println(Stream.of(matrix)
                .flatMap(m -> Arrays.stream(m))
                .map(integer -> integer.byteValue())
        );
        */

        Stream.of(matrix)
                .flatMap(m -> Arrays.stream(m))
                .map(integer -> integer.byteValue())
                .forEach(e -> System.out.println(e.toString()));
               // .anyMatch(a -> a.equals(0)));
    }
}
