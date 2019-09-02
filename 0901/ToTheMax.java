import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by richard on 29/08/2019.
 * 每套题5道，每道题需要30min
 * @author Richard Liu
 * @since 2019.08.29
 * Problem Description
Given a two-dimensional array of positive and negative integers, a sub-rectangle is any contiguous sub-array of size 1 x 1 or greater located within the whole array. The sum of a rectangle is the sum of all the elements in that rectangle. In this problem the sub-rectangle with the largest sum is referred to as the maximal sub-rectangle.

As an example, the maximal sub-rectangle of the array:

0 -2 -7 0
9 2 -6 2
-4 1 -4 1
-1 8 0 -2

is in the lower left corner:

9 2
-4 1
-1 8

and has a sum of 15.
Input
The input consists of an N x N array of integers. The input begins with a single positive integer N on a line by itself, indicating the size of the square two-dimensional array. This is followed by N 2 integers separated by whitespace (spaces and newlines). These are the N 2 integers of the array, presented in row-major order. That is, all numbers in the first row, left to right, then all numbers in the second row, left to right, etc. N may be as large as 100. The numbers in the array will be in the range [-127,127].
Output
Output the sum of the maximal sub-rectangle.
Sample Input
4
0 -2 -7 0 9 2 -6 2
-4 1 -4 1 -1
8 0 -2
Sample Output
15
Source
Greater New York 2001

 */
public class ToTheMax {

    public static void main(String[] args) {
        int[][] t = {{1, 2, 3}, {4, 5, -6}, {7, 8, 9}};
//        long r = getSumOfArray(a);
//        int[][] a = initArray();
//        printArray(a);

        List<int[][]> subArray = getSubArray(2, 2, t);
        long max = getMaxSum(subArray);
        System.out.println(max);


    }

    private static int[][] initArray() {
        System.out.println("pls input the size of the square array.");
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        System.out.println("the size of the square array is " + size);
        int[][] array = new int[size][size];
        System.out.println("pls input the array items.");
        int count = 0;
        while (count < size * size) {
            for (int i =0; i < size; i ++) {
                for (int j = 0; j < size; j++) {
                    try {
                        array[i][j] = input.nextInt();
                        count ++;
                    } catch (Exception ex) {
                        System.err.println("error occurred");
                    }

                }
//                System.out.println(";");
            }
        }
//        System.out.println("all array items initialized.");

        return array;
    }

    private static void printArray(int[][] array) {
        System.out.println("**********");
        for (int i =0; i < array.length; i ++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " | ");
            }
            System.out.println("");
            System.out.println("-----------------");
        }
        System.out.println("**********");
    }


    /**
     *   1 | 2 | 3
     * -------------
     *   4 | 5 | 6
     * -------------
     *   7 | 8 | 9
     *   Get sub array List with size a * b with parent array with parentSize
     * @param a
     * @param b
     * @param parentSquareArray
     */
    private static List<int[][]> getSubArray(int a, int b,  int[][] parentSquareArray) {
        List<int[][]> subArrayList = new ArrayList<>(4);
        int x = parentSquareArray.length;
        int y = parentSquareArray[0].length;
        for (int i = 0; i < x; i ++) {
            for (int j = 0; j < y; j++) {
                int[][] array = new int[a][b];
                for(int m =0; m < a && m + a <= x; m++) {
                    for(int n = 0; n < b && n + b <= y; n++) {
                        array[m][n] = parentSquareArray[i + m][j + n];
                    }
                }
                subArrayList.add(array);
                printArray(array);
            }
        }
        return  subArrayList;

    }

    private static long getSumOfArray(int[][] array) {
        int sum = 0;
        for (int i =0; i < array.length; i ++) {
            for (int j = 0; j < array[0].length; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }

    private static long getMaxSum(List<int[][]> arrayList) {
        final AtomicLong max = new AtomicLong(0);
        for (int i = 0; i < arrayList.size(); i++){
            long b = getSumOfArray(arrayList.get(i));
            if (max.get() < b) {
                max.set(b);
            }
        }
        return max.get();
    }
}
