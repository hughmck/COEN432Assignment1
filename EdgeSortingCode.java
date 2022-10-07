import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class EdgeSortingCode {

    public EdgeSortingCode() throws FileNotFoundException {
    }

    public static void mutate(){

    }

    public static void crossover(){

    }

    public static void initializingArray() throws FileNotFoundException {
        int totalRow = 8;
        int totalColumn = 8;
        int[][] edgeMatchingArray = new int[totalRow][totalColumn];
        File file = new File("Ass1Input.txt");
        Scanner scanner = new Scanner(file);


        for (int row = 0; scanner.hasNextLine() && row < totalRow; row++) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int i = 0; i < totalColumn && i < chars.length; i++) {
                edgeMatchingArray[row][i] = chars[i];
            }
        }
    }
    public static void PrintArray(int[][] edgeMatchingArray) {
        for (int row = 0; row < edgeMatchingArray.length; row++) {
            System.out.println(edgeMatchingArray[row]);
        }
    }

    public static void main(String[] args)
            throws IOException, InterruptedException {

        System.out.println("Given Array from input:");
        PrintArray(edgeMatchingArray);

}
