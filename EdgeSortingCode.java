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

 	public static void log(String msg) {
 		System.out.println(msg);
 	}
 	public static void log(int msg) {
 		System.out.println(msg);
 	}

    
     public static void selectionArray (int[][] a) throws FileNotFoundException{
        Scanner sc = new Scanner(new BufferedReader(new FileReader("Ass1Input.txt")));
        int rows = 8;
        int columns = 8;
        int [][] arrayRepresentation = new int[rows][columns];
        while(sc.hasNextLine()) {
            for (int i=0; i<arrayRepresentation.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j=0; j<line.length; j++) {
                    arrayRepresentation[i][j] = Integer.parseInt(line[j]);
                }
            }}
        }

    public static void randomMutation(int[][] a, int i0, int j0, int i1, int j1){

        int temp = a[i0][j0]; 
        a[i0][j0] = a[i1][j1];
        a[i1][j1] = temp;
    }    
    public static void crossover(int[][] a, int i0, int j0, int i1, int j1){
        ArrayList<Integer> num1=numarray(a[i0][j0]);  // convert number to array
        ArrayList<Integer> num2=numarray(a[i1][j1]);
 
        boolean diff=num1.retainAll(num2); // check if there are any commun edges
 
        if(diff) {  // mismatching edges
            for(int i=j1;i<4;i++) {
                randomMutation(a, i0, j0, i1, j1);  // switch pieces of puzzle
            }
        }
     }   


     public static void printBestSolution(int[][] a) {
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
    					log("mismatch with top check on [" + r + "][" + c + "]");
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
    					log("mismatch with bottom check on [" + r + "][" + c + "]");
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
    					log("mismatch with right check on [" + r + "][" + c + "]");
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
    					log("mismatch with left check on [" + r + "][" + c + "]");
    					mismatches++;
    				}
    			}
    		}
    	}
    	
    	return mismatches;
    }

    public static void main(String args[]) throws Exception {
         //step 0 : initialization of the population 
            Scanner sc = new Scanner(new BufferedReader(new FileReader(  "Ass1Input.txt")));
            int rows = 8;
            int columns = 8;
            
            int [][] arrayRepresentation = new int[rows][columns];
            while(sc.hasNextLine()) {
                for (int i=0; i<arrayRepresentation.length; i++) {
                    String[] line = sc.nextLine().trim().split(" ");
                    for (int j=0; j<line.length; j++) {
                        arrayRepresentation[i][j] = Integer.parseInt(line[j]);
                    }
                }
            }
            
      // initial checking output 
            //step 2 : random_wheel selection 
            System.out.print("hugh mckenzie 40088023 yves chuenmogne 40129773\n"); 
            System.out.print("Population\n"); 
            int selectionArray[][] = {
        		

                {2310 ,2016, 6521, 1120, 4420, 5306, 2635, 1514},
                {1164 ,5024 ,1520, 1132, 2500, 1226, 1144, 3544},
                {1012 ,2025 ,4501, 2553 ,6231, 2645, 1004, 4051},
                {3622 ,4056, 6303, 3145, 5122, 4403, 4125, 6322},
                {1152 ,2304 ,1256, 2034 ,1605, 3436, 1242, 4114},
                {4614 ,2444, 6311 ,1120, 1022, 1026, 3503, 1345},
                {2364 ,6451, 4236 ,2104, 4514, 3452, 2340, 4313},
                {6111 ,6146, 1412 ,3002 ,2651, 4121, 4120 ,1456}
            };
            printBestSolution(selectionArray);
            
            //recheck the fitness again
            
            
            int test = computeFitness(selectionArray, 8, 8);
            log("Mismatches found: " + test + "\n");
            

          
    }

}
