import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class EdgeSortingCode {

    public static void mutate(){


    }

    public static void crossover(){ //a swap function which switches two different pieces of the puzzle

    }

    public static void printArray(int[][] a) {
        int rows = a.length;
        int cols = a[0].length;
        System.out.print("[ ");
        for (int row=0; row<rows; row++) {
            if (row > 0) System.out.print("  ");
            System.out.print("[");
            for (int col=0; col<cols; col++) {
                if (col > 0) System.out.print(", ");
                System.out.format("%3d",a[row][col]); // field-width = 3
            }
            System.out.println("]");
        }
        System.out.println("]");
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
            printArray(edgeMatchingArray);
        }
}
