import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FiveLetterWordFilter {

    public static void main (String args[]) throws IOException {
        System.out.println("Moo");

        try (Stream<String> stream = Files.lines(Paths.get("words.txt"));
             PrintWriter writer = new PrintWriter(new FileWriter(("words5.txt")))) {

            stream.filter(it -> it.length() == 5)
                    .filter(it -> Character.isLowerCase(it.charAt(0)))
                    .forEach(writer::println);
        }
    }
}
