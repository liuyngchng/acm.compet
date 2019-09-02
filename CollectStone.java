import java.util.Scanner;

/**
 * Created by richard on 31/08/2019.
 * int[] a = {4, 5, 9, 4}
 * 定义f[i] 为第 i个节点合并后的最小得分，根据递推原则
 *
 */
public class CollectStone {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pileCount = input.nextInt();
        int[] stoneArray = new int[pileCount];
        String b = input.nextLine();
        String[] a = b.split(" ");
        for (int i = 0; i < stoneArray.length; i++) {
            stoneArray[i] = Integer.valueOf(a[i]);
        }


    }

}
