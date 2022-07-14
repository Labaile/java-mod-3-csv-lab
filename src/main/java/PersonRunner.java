import java.io.FileWriter;
import java.io.IOException;

public class PersonRunner {

    public static void main(String[] args) throws IOException {
        Person testPerson = new Person("Sherita", "Taylor", 1990, 12, 19);
        System.out.println(testPerson);
        String personCSV = testPerson.formatAsCSV();
        writeToFile("person.csv", personCSV);
    }

    static void writeToFile(String fileName, String text) throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.write(text);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (fileWriter != null)
                fileWriter.close();
        }
    }
}
