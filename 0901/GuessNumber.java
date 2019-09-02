import java.util.Random;
import java.util.Scanner;

/**
 * Created by richard on 29/08/2019.
 * 猜数字
 * @author Richard Liu
 * @since 2019.08.29

 Time Limit : 20000/10000ms (Java/Other)   Memory Limit : 65536/32768K (Java/Other)
 Total Submission(s) : 0   Accepted Submission(s) : 0
 Font: Times New Roman | Verdana | Georgia
 Font Size: ← →
 Problem Description
 猜数字游戏是gameboy最喜欢的游戏之一。游戏的规则是这样的：计算机随机产生一个四位数，然后玩家猜这个四位数是什么。每猜一个数，计算机都会告诉玩家猜对几个数字，其中有几个数字在正确的位置上。
 比如计算机随机产生的数字为1122。如果玩家猜1234,因为1,2这两个数字同时存在于这两个数中，而且1在这两个数中的位置是相同的，所以计算机会告诉玩家猜对了2个数字，其中一个在正确的位置。如果玩家猜1111,那么计算机会告诉他猜对2个数字，有2个在正确的位置。
 现在给你一段gameboy与计算机的对话过程，你的任务是根据这段对话确定这个四位数是什么。
 Input
 输入数据有多组。每组的第一行为一个正整数N(1<=N<=100)，表示在这段对话中共有N次问答。在接下来的N行中，每行三个整数A,B,C。gameboy猜这个四位数为A，然后计算机回答猜对了B个数字，其中C个在正确的位置上。当N=0时，输入数据结束。
 Output
 每组输入数据对应一行输出。如果根据这段对话能确定这个四位数，则输出这个四位数，若不能，则输出"Not sure"。
 Sample Input
 6
 4815 2 1
 5716 1 0
 7842 1 0
 4901 0 0
 8585 3 3
 8555 3 2
 2
 4815 0 0
 2999 3 3
 0
 Sample Output
 3585
 Not sure

 */
public class GuessNumber {

    public static void main(String[] args) {
        while (true) {
            if (doTask()) {
                return;
            }
        }

    }

    private static boolean doTask() {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        if (null != text && !text.equals("") && text.equals("0")) {
            return true;
        }
        Integer maxLine;
        try {
            maxLine = Integer.valueOf(text);
        } catch (Exception ex) {
            System.err.println("error for " + text);
            return true;
        }
        if (maxLine < 1 || maxLine > 100) {
            return true;
        }
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        while (randomNumber < 1000) {
            randomNumber = random.nextInt(10000);
        }
        System.out.println("randomNumber is " + randomNumber);
        Integer rightNumber;
        int lineCount = 0;
        boolean getRightNumber = false;
        while (lineCount < maxLine) {
            int rightBitCount = 0;
            int rightPositionCount = 0;
            int num = input.nextInt();
            lineCount ++;
            String userInput = String.valueOf(num);
            String textedRandomNumber = String.valueOf(randomNumber);
            try {
                Integer.valueOf(userInput);
            } catch (Exception ex) {
                System.err.println("error for " + userInput);
                return true;
            }
            if (textedRandomNumber.equals(userInput)) {
                getRightNumber = true;
                System.out.println(userInput);
                break;
            }
            String subInput = userInput;
            String subRandom = textedRandomNumber;
            for (int i = 0; i < 4; i ++) {
                String bit = subInput.substring(0, 1);
                int index = subRandom.indexOf(bit);
                if (index >= 0) {
                    subRandom = subRandom.replaceFirst(bit, "*");
                    rightBitCount ++;
                }
                if (index == i) {
                    rightPositionCount ++;
                }
                subInput = subInput.substring(1);
            }
            System.out.println(rightBitCount + " " + rightPositionCount);

        }
        if (!getRightNumber) {
            System.out.println("Not sure");
        }
        return false;
    }
}
