import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            int[] array = ArrayUtils.readIntegersFromFile("numbers.txt");
            int sum = ArrayUtils.sumArray(array);
            System.out.println("Sum of array elements: " + sum);
        } catch (InvalidNumberException | FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}