/**
 * Created by richard on 31/08/2019.
 * https://www.luogu.org/problem/P1048
 * array[] v， v[i] 表示第i株草药的价值
 * array[] t, t[i] 表示采摘第i株草药所需要的时间
 * array[] f, f[i,j] 表示考虑了第i株草药，时间为j时刻的总收益
 * 采集草药问题
 *      y 表示时刻
 *      ^
 *      |
 *      |           f[i-1][j]
 *     j|               x    * f[i][j]
 *   j-1|                    x f[i][j-1]
 *     ... 
 *j-t[i]|               x      
 *      |               f[i-1][j-t[i]]
 *      |
 *      |
 *      |____|____| ..  |....|__________> x 表示已经考虑的草药株数.
 *      0    1    2    i-1   i
 * 时间在前进，要么采了草药，要么没采
 * (1) f[i][j]=f[i][j-1]                           // 时间增加了1s，没考虑任何草药
 * (2) f[i][j]=max(f[i][j],f[i-1][j-t[i]]+v[i])     // 考虑采集第i株草药，时间增加了t[i]
 * (3) f[i][j]=max(f[i][j],f[i-1][j])               // 考虑不采集第i颗草药，时间没有增加
 * 最终取各种情况下的最大值，即 f[i][j]=max(f[i][j-1],f[i-1][j-t[i])]+v[i],f[i-1][j])
 * input
 * 70 3
 * 71 100
 * 69 1
 * 1 2
 * output
 * 3
 */
import java.util.Scanner;
public class GetDrug {
    private static int T;
    private static int C;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        T=sc.nextInt();
        C=sc.nextInt();
        int[] t=new int[T+10];
        int[] v=new int[C+10];
        for (int i=1;i<= C;i++){
            t[i]=sc.nextInt();
            v[i]=sc.nextInt();
        }
        sc.close();
        int[][] f=new int[C+10][T+10];
        f[0][0]=0;
        for (int i=1;i<=C;i++) {
            for (int j=1; j<=T;j++){
                f[i][j]=f[i][j-1];
                f[i][j]=Math.max(f[i][j],f[i-1][j]);
                if(j-t[i]>=0){
                    f[i][j]=Math.max(f[i][j],f[i-1][j-t[i]]+v[i]);
                }
            }
        }
        System.out.println(f[C][T]);
    }
}
