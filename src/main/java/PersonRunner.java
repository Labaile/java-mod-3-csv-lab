import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersonRunner {

    public static void main(String[] args) throws IOException {
       // So we can initialize an instance of Person and print its value to the console with the following code:
       Person testPerson = new Person("Sherita", "Taylor", 1990, 12, 19);
//        System.out.println(testPerson);
//
//        //creates a string object and writes it, to a csv file
     System.out.println("This is when we write to file");
      String personCSV = testPerson.formatAsCSV();
      writeToFile("person.csv", personCSV);


        //create a string object and read from csv file
        String readFromFilePersonCSV = readFromFile("person.csv", false);
        Person readFromFileTestPerson = new Person(readFromFilePersonCSV);
        System.out.println("This was read from a csv file:\n" + readFromFileTestPerson);
        //String getLastName = readFromFileTestPerson.getLastName();
        //System.out.println(getLastName);

    }

    static String readFromFile(String fileName, boolean addNewLine) throws IOException {
        String returnString = new String();
        Scanner fileReader = null;
        try {
            File myFile = new File(fileName);
            fileReader = new Scanner(myFile);
            while (fileReader.hasNextLine()) {
                returnString += fileReader.nextLine();
                if (addNewLine)
                    returnString += "\n";
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (fileReader != null)
                fileReader.close();
        }

        return returnString;
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
