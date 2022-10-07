import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class EdgeSortingCode {

    public EdgeSortingCode() throws FileNotFoundException {
    }

    public static void mutate(){

    }

    public static void crossover(){

    }

    public static void main(String args[]) throws Exception {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("Ass1Input.txt")));
            int rows = 8;
            int columns = 8;
            int [][] edgeMatchingArray = new int[rows][columns];
            while(sc.hasNextLine()) {
                for (int i=0; i<edgeMatchingArray.length; i++) {
                    String[] line = sc.nextLine().trim().split(" ");
                    for (int j=0; j<line.length; j++) {
                        edgeMatchingArray[i][j] = Integer.parseInt(line[j]);
                    }
                }
            }
            System.out.println(Arrays.deepToString(edgeMatchingArray));
        }
}
