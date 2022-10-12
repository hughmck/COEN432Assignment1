import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EdgeSortingCode {
     
     public static ArrayList<Integer> numarray(int num) {
        ArrayList<Integer> arrayNum = new ArrayList<Integer>();
        do{
            num /= 10;
        } while  (num > 0);

        return arrayNum;
    }

     public static void mutate(int[][] a, int i0, int j0, int i1, int j1){
       ArrayList<Integer> num1=numarray(a[i0][j0]);  // convert number to array
       ArrayList<Integer> num2=numarray(a[i1][j1]);

       boolean diff=num1.retainAll(num2); // check if there are any commun edges

       if(diff) {  // mismatching edges
           for(int i=j1;i<4;i++) {
               crossover(a, i0, j0, i1, j1);  // switch pieces of puzzle
           }
       }
    }
      public static void selection (int[][] a) throws FileNotFoundException{
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
            }}
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
      public static int computeFitness( int[][] a, int rows, int columns )
    {
    	int r = 0, c = 0;
    	int tmp1 = 0, tmp2 = 0;
    	
    	int mismatches = 0;
    	
    	for( r = 0; r < rows; r++ )
    	{
    		for( c = 0; c < columns; c++ )
    		{
    			// Check for the value on the top
    			if(r > 0)
    			{
    				tmp1 = a[r][c];
    				tmp2 = a[r-1][c];

    				tmp1 /= 1000;
    				
    				tmp2 /= 10;
    				tmp2 = (int) (tmp2 - Math.floor((tmp2/10))*10);

    				if(tmp1 != tmp2)
    				{
    					System.out.println("error with top check on [" + r + "][" + c + "]");
    					mismatches++;
    				}
    			}
    			
    			// Check for the value on the bottom
    			if(r < rows-1)
    			{
    				tmp1 = a[r][c];
    				tmp2 = a[r+1][c];
    				
    				tmp1 /= 10;
    				tmp1 = (int) (tmp1 - Math.floor((tmp1/10))*10);

    				tmp2 /= 1000;

    				if(tmp1 != tmp2)
    				{
    					System.out.println("error with bottom check on [" + r + "][" + c + "]");
    					mismatches++;
    				}
    			}
    			
    			// Check for the value on the right
    			if(c < columns-1)
    			{
    				tmp1 = a[r][c];
    				tmp2 = a[r][c+1];

    				tmp1 /= 100;
    				tmp1 = (int) (tmp1 - Math.floor((tmp1/10))*10);

    				tmp2 = (int) (tmp2 - Math.floor((tmp2/10))*10);

    				if(tmp1 != tmp2)
    				{
    					System.out.println("error with right check on [" + r + "][" + c + "]");
    					mismatches++;
    				}
    			}

    			
    			// Check for the value on the left
    			if(c > 0)
    			{
    				tmp1 = a[r][c];
    				tmp2 = a[r][c-1];
    				
    				tmp1 = (int) (tmp1 - Math.floor((tmp1/10))*10);

    				tmp2 /= 100;
    				tmp2 = (int) (tmp2 - Math.floor((tmp2/10))*10);

    				if(tmp1 != tmp2)
    				{
    					System.out.println("error with left check on [" + r + "][" + c + "]");
    					mismatches++;
    				}
    			}
    		}
    	}
    	
    	return mismatches;
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
           int testingArray[][] = {
        		{1120,		1011},
        		
        		{1000,		1000}
            };
            printArray(testingArray);
            int test = computeFitness(testingArray, 2, 2);
            System.out.println("Errors found: " + test + "\n");
        
        }
}
