import java.io.*;
import java.util.ArrayList;
import java.util.Random;
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

    public static void randomElementCrossover(int[][] a, int i0, int j0, int i1, int j1){
        int temp = a[i0][j0]; 
        a[i0][j0] = a[i1][j1];
        a[i1][j1] = temp;
    }

    public static void swapElementCrossover(int[][] a, int i0, int j0, int i1, int j1){
        ArrayList<Integer> num1=numarray(a[i0][j0]);  // convert number to array
        ArrayList<Integer> num2=numarray(a[i1][j1]);
 
        boolean diff=num1.retainAll(num2); // check if there are any commun edges
 
        if(diff) {  // mismatching edges
            for(int i=j1;i<4;i++) {
                swapElementCrossover(a, i0, j0, i1, j1);  // switch pieces of puzzle
            }
        }
     }

    public static void SwapMutation(int [][] array, int columnA, int columnB){ //first attemt at trying to shift around columns
        int temp =0;

        for(int i =0; i < 7; i++){
            temp = array[i][columnA];
            array[i][columnA] = array[i][columnB];
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
    					 // log("mismatch with top check on [" + r + "][" + c + "]");
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
    					// log("mismatch with bottom check on [" + r + "][" + c + "]");
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
    					// log("mismatch with right check on [" + r + "][" + c + "]");
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
                        //log("mismatch with left check on [" + r + "][" + c + "]");
    					mismatches++;
    				}
    			}
    		}
    	}
    	
    	return mismatches;
    }

    public static void swapRowCrossover(int[][] populationMatrix, int A, int B){ //taking row A and row B in matrix, swapping them

        int[] temp = populationMatrix[A];
        populationMatrix[A]= populationMatrix[B];
        populationMatrix[B] = temp;
    }

    static int rotateMutation(int [][] array, int i0, int j0){

        Random random = new Random();
        i0 = random.nextInt(7);

        Random random1 = new Random();
        j0 = random.nextInt(7);

        int arrayValue = 0;

        arrayValue = array[i0][j0];

        int result = 0;
        int place = 1;

        result += place * 10 * (arrayValue % 10);
        arrayValue /= 10;
        result += place * (arrayValue % 10);
        arrayValue /= 10;
        place *= 100;

        return result + place * arrayValue;
    }


    public static void main(String args[]) throws Exception {
         //step 0 : initialization of the population 
            Scanner sc = new Scanner(new BufferedReader(new FileReader(  "Ass1Input.txt")));
            int rows = 8;
            int columns = 8;
            
            int [][] selectionArray = new int[rows][columns];
            while(sc.hasNextLine()) {
                for (int i=0; i<selectionArray.length; i++) {
                    String[] line = sc.nextLine().trim().split(" ");
                    for (int j=0; j<line.length; j++) {
                        selectionArray[i][j] = Integer.parseInt(line[j]);
                    }
                }
            }
            
      // initial checking output 
            //step 2 : random_wheel selection 
            System.out.print("hugh mckenzie 40088023 yves chuenmogne 40129773\n"); 
            System.out.print("Population\n"); 
//            int selectionArray[][] = {
//
            //3421 3127 7632 2231 5531 6417 3746 2625
            //1275 6135 1631 2243 3611 2337 2255 4655
            //2123 3136 5612 3664 7342 3756 2115 5162
            //4733 5167 7414 4256 6233 5513 5236 7433
            //2263 3415 2367 3145 2716 4547 2353 5225
            //5725 3555 7422 2231 2133 2137 4614 2456
            //3475 7562 5347 3215 5265 4563 3451 5424
            //7222 7257 2523 4113 3762 5232 5231 2567
//            };

            int upperbound = 7;

            Random random1 = new Random();
            int rowNumber = random1.nextInt(upperbound); //trying to find a number between 1 and 8 to swap

        System.out.println(rowNumber);

            Random random2 = new Random();
            int rowNumber2 = random2.nextInt(upperbound); //trying to find a number between 1 and 8 to find the column to swap

        System.out.println(rowNumber2);


        Random random3 = new Random();
            int rowIndexInteger1 = random3.nextInt(upperbound); //next 4 integers are random numbers between 0 and 8 for the index number of two numbers in the array to perform a swap on

        System.out.println(rowIndexInteger1);

        Random random4 = new Random();
            int columnIndexInteger1 = random4.nextInt(upperbound);

        System.out.println(columnIndexInteger1);


        Random random5 = new Random();
            int rowIndexInteger2 = random5.nextInt(upperbound);

        System.out.println(rowIndexInteger2);


        Random random6 = new Random();
            int columnIndexInteger2 = random6.nextInt(upperbound);

        System.out.println(columnIndexInteger2);

        System.out.println();

        int test = computeFitness(selectionArray, 8, 8); //computes the number of mismatched edges in the entire array
            // log("Mismatches found: " + test + "\n");


        int iterationCounter = 0;

        int[][] bestArray = new int[8][];
        int[][] rowswap = new int[8][8];
        int[][] crossover = new int[8][8];
        int[][] mutate = new int[8][8];

        int[][] tester = new int[8][];



//        while (test >= 50 && iterationCounter < 3){
//
//            swapRowCrossover(selectionArray, x, y); //swaps rows at random
//            rowswap = selectionArray;
//            randomElementCrossover(rowswap, a, b, c, d); //swaps two random numbers in the array
//            crossover = rowswap;
//            rotateMutation(rowswap, x, y);
//            mutate = crossover;
//            test = computeFitness(mutate,8,8);
//            bestArray = mutate;
//            printBestSolution(bestArray);
//            iterationCounter++;
//        }

            for (int i = 0; i < 5; i++) {
                if (test >= 50) {
                    swapRowCrossover(selectionArray, rowNumber, rowNumber2); //swaps rows at random
                    rowswap = selectionArray;
                    randomElementCrossover(rowswap, rowIndexInteger1, columnIndexInteger1, rowIndexInteger2, columnIndexInteger2); //swaps two random numbers in the array
                    crossover = rowswap;
                    rotateMutation(rowswap, rowNumber, rowNumber2);
                    mutate = crossover;
                    test = computeFitness(mutate, 8, 8);
                    bestArray = mutate;
                    selectionArray = bestArray;
                }
                tester = bestArray;
                //            printBestSolution(bestArray);
            }
            printBestSolution(tester);
        }
    }
