import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileOperations {
    public static void main(String[] args) throws FileNotFoundException {
     //System.out.println(sumUsingScanner("inputFile.txt"));
     //System.out.println(sumUsingBufferedReaderAndFileReader("inputFile.txt"));
        sumUsingStream("inputFile.txt");
    }

    private static int sumUsingScanner(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int sum = 0;
        while(scanner.hasNextInt())
        {
            sum+=scanner.nextInt();
        }
        return sum;
    }

    private static int sumUsingBufferedReaderAndFileReader(String fileName) throws FileNotFoundException {
        File file  = new File(fileName);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String string;
        Integer sumOfNumbers = 0;
        try{
            while ((string = bufferedReader.readLine())  != null){
                 sumOfNumbers+= Integer.parseInt(string);
            }
        }catch (IOException exception){

        }
        return sumOfNumbers;
    }

    private static void sumUsingStream(String fileName){
        Path filePath = Paths.get(fileName);
        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(System.out::println);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}