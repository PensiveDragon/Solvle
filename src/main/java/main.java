import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {

    public static void main(String[] args) throws IOException {

        System.out.println("Moo");

        // Read and sort the raw words list into 5 letter word lists
        // Remove capitalised words

        // Chris - 70k, Matthew 50k

        // Extended goal - find a better dictionary to use (some valid words appear missing so far)
        // Extended goal - create a rudimentary interface between world and Solvle (Screen capture processing?)
        // Extended info - find list of how commonly used words

        // .filter(it -> !it.contains("f"))
        // .filter(it -> it.contains("r"))
        // .filter(it -> it.charAt(0) != 'r')
        // .filter(it -> it.charAt(2) == 'a')


        try (Stream<String> stream = Files.lines(Paths.get("words.txt"))) {

            List<String> filteredResults = stream.filter(it -> it.length() == 5)
                    .filter(it -> Character.isLowerCase(it.charAt(0)))
                    .collect(Collectors.toList());

            filteredResults.forEach(System.out::println);
            System.out.println(filteredResults.size());
            System.out.println();


            filteredResults = filteredResults.stream()
                    .filter(it -> it.charAt(1) == 'h')   /* Correct letter, correct place*/

                    .filter(it -> it.contains("i"))      /* Correct letter */
                    .filter(it -> it.charAt(4) != 'k')   /* Letter in wrong place */

                    .filter(it -> !it.contains("b"))     /* Wrong letter */

                    .collect(Collectors.toList());

            filteredResults.forEach(System.out::println);
            System.out.println(filteredResults.size());
            System.out.println();
        }
    }
}
