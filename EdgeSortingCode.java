import java.io.*;
import java.util.Scanner;

public class EdgeSortingCode {
     
     public static int[] numarray(int num) {
        ArrayList<Integer> arrayNum = new ArrayList<Integer>();
        do{
            array.add(num % 10);
            num /= 10;
        } while  (num > 0);

        return arrayNum;
    }

     public static void mutate(int[][] a, int i0, int j0, int i1, int j1){
       ArrayList<Integer> num1=numarray(a[i0][j0]);  // convert number to array
       ArrayList<Integer> num2=numarray(a[i1][j1]);

       ArrayList<Integer> diff=num1.retainAll(num2); // check if there are any commun edges

       if(diff.isEmpty()) {  // mismatching edges
           for(int i=k;i<4;i++) {
               crossover(a, i0, j0, i1, j1);  // switch pieces of puzzle
           }
       }
    }

    public static void crossover(int[][] a, int i0, int j0, int i1, int j1){ //a swap function which switches two different pieces of the puzzle
        int temp = a[i0][j0]; //
        a[i0][j0] = a[i1][j1];
        a[i1][j1] = temp;
    }       // example of the function: crossover(a,0,1,2,0); // swap a[0][1] with a[2][0]


    public static void printArray(int[][] a) {
        int rows = a.length;
        int cols = a[0].length;
        System.out.print("[ ");
        for (int row=0; row<rows; row++) {
            if (row > 0) System.out.print("  ");
            System.out.print("[");
            for (int col=0; col<cols; col++) {
                if (col > 0) System.out.print(", ");
                System.out.format("%3d",a[row][col]);
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
