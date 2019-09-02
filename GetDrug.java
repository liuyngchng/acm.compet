
import java.util.Scanner;

/**
 * Created by richard on 31/08/2019.
 * https://www.luogu.org/problem/P1048
 * array[] v， v[i] 表示第i株草药的价值
 * array[] t, t[i] 表示采摘第i株草药所需要的时间
 * array[] f, f[i,j] 表示考虑了第i株草药，时间为j的时刻的总收益
 * 采集草药问题
 *
 * ^ j 表示时刻
 * |
 * |
 * |      . f(i,j)表示考虑过了第i株草药，采药的收益
 * |
 * |
 * |______________________> i 表示手里有第i 株草药.
 *
 * 时间在前进，要么采了草药，要么没采
 * (1) f[i,j] = f[i,j-1]                // 时间增加了1s，没采任何草药
 * (2) f[i,j] = f[i-1,j-t(i)] + v[i]    // 时间增加了t[i]，采集到了第i棵草药
 * (3) f[i,j] = f[i-1, j]               // 考虑了第 i颗草药，但决定不采集，时间没有增加
 * 最终取各种情况下的最大值，即 f[i,j] = max(f[i,j-1], f[i-1,j-t(i)] + v[i], f[i-1, j])
 *
 *
 */
public class GetDrug {

    private static int maxTime;

    private static int maxCount;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String condition = input.nextLine();
        String[] timeAndValueArray = condition.split(" ");
        maxTime = Integer.valueOf(timeAndValueArray[0]);
        maxCount = Integer.valueOf(timeAndValueArray[1]);
        int[] t = new int[maxCount + 1];
        int[] v = new int[maxCount + 1];
        for (int i = 1; i <= maxCount; i++) {
            String line = input.nextLine();
            String[] lineArray = line.split(" ");
            t[i] = Integer.valueOf(lineArray[0]);
            v[i] = Integer.valueOf(lineArray[1]);
        }
        input.close();
        int[][] f = new int[maxCount + 1][maxTime + 1];
        f[0][0] = 0;
        for (int i = 0; i <= maxCount; i++) {
            for (int j = 0; (j - t[i])<= maxTime && (j - t[i]) >= 0; j++) {
                f[i][j] = Math.max(
                    f[i] [j - 1],
                    Math.max(
                        f[i][j - 1],
                        f[i - 1][j - t[i]] + v[i]
                    )
                );
            }
        }
        System.out.println(f[maxCount][maxTime]);

    }


}
