/**
 * 1.https://www.luogu.org/problem/P1049
 * 2.状态表示
 * f[i][j] =0/1, 表示使用了i个方格，体积为j的方案是否存在
 * 3.状态转移
 * f[0][0]=1
 * f[i][j]=f[i-1][j-v[i]];  //使用第i个方块
 * f[i][j]=f[i-1][j];       //不使用第i个方块
 *  i   1   2   3   4
 *  v   4   5   1   2
 *  f[1][1]=0,....,f[1][4]=1,0,....,
 *  f[2][1]=0,...,f[2][4]=1,...,f[2][9]=1
 * 4.ans
 * ans=V-max(j) if(f[n][j]==1)
 */
import java.util.Scanner;
public class P1049 {
    private static int V;
    private static int n;
    private static int[] v=new int[30+10];
    private static int[][] f=new int[40][20000+10];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        V=sc.nextInt();
        n=sc.nextInt();
        for(int i=1;i<=n;i++)
            v[i]=sc.nextInt();
        f[0][0]=1;
        for(int i=1;i<=n;i++)
            for(int j=1;j<=V;j++){
                f[i][j]=f[i-1][j];
                if(j-v[i]>=0)
                    f[i][j]=f[i-1][j-v[i]];
            }
        int max=0;
        for(int j=1;j<=V;j++)
            if(f[n][j]==1)
                max=Math.max(max,j);
        System.out.println(V-max);
    }   
}
