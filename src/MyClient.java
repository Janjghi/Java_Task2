import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ArrayUtils {

    private ArrayUtils() {}

    public static int[] readIntegersFromFile(String fileName) throws InvalidNumberException, FileNotFoundException {
        int[] array = new int[10];
        int index = 0;
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int number = Integer.parseInt(line);
                if (number < 0) {
                    throw new InvalidNumberException("Negative number found in file");
                }
                array[index] = number;
                index++;
            }
            scanner.close();
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Invalid number format in file");
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        }
        return array;
    }

    public static int sumArray(int[] array) throws InvalidNumberException {
        int sum = 0;
        try {
            for (int i = 0; i < array.length; i++) {
                sum = Math.addExact(sum, array[i]);
            }
        } catch (ArithmeticException e) {
            throw new InvalidNumberException("Integer overflow when summing array");
        }
        return sum;
    }
}
