import java.util.Scanner;

/**
 * Created by richard on 29/08/2019.
 * @author Richard Liu
 * @since 2019.08.29
 * Problem Description
输入一行数字，如果我们把这行数字中的‘5’都看成空格，那么就得到一行用空格分割的若干非负整数（可能有些整数以‘0’开头，这些头部的‘0’应该被忽略掉，除非这个整数就是由若干个‘0’组成的，这时这个整数就是0）。

你的任务是：对这些分割得到的整数，依从小到大的顺序排序输出。

Input
输入包含多组测试用例，每组输入数据只有一行数字（数字之间没有空格），这行数字的长度不大于1000。

输入数据保证：分割得到的非负整数不会大于100000000；输入数据不可能全由‘5’组成。
Output
对于每个测试用例，输出分割得到的整数排序的结果，相邻的两个整数之间用一个空格分开，每组输出占一行。
Sample Input
0051231232050775
Sample Output
0 77 12312320
Source
POJ
 */
public class Sort {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        if (text.length() > 1000) {
            System.err.println("error");
            return;
        }
        if (text.startsWith("5")) {
            text = text.substring(1);
        }
        String[] array = text.split("5");
        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
            if (Integer.valueOf(array[i]) > 100000000) {
                return;
            }
            if (!array[i].matches("0*") && array[i].startsWith("0")) {
                array[i] = array[i].substring(1);
            }
            if (array[i].matches("0*")) {
                array[i] = "0";
            }
        }
//        System.out.println();
        if (array.length == 0) {
            return;
        }

        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = Integer.valueOf(array[i]);
        }
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i; j < intArray.length; j++) {
                if (intArray[j] < intArray[i]) {
                    int temp = intArray[i];
                    intArray[i] = intArray[j];
                    intArray[j] = temp;
                }
            }
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray   [i] + " ");
        }
    }
}
