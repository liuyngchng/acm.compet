import java.util.Scanner;

/**
 * Created by richard on 31/08/2019.
 * https://www.luogu.org/problem/P1880
 * int[] a = {4, 5, 9, 4}
 * 定义f[i][j] 为第i道第j个节点合并后的最小得分，根据递推原则
 */
public class CollectStone {
    private static int c;
    private static int a[];
    private static int f[];
    private static int minS;
    private static int maxS;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int c= sc.nextInt();
        a=new int[c+100];
        f=new int[2c+100];
        for(int i=1;i<=c;i++)
            a[i] = sc.nextInt();
        for(int i=1;i<c;i++)
            a[c+i]=a[i];
        for(int i=1;i<=c*2-1;i++){
            f[1][1]=0;
            for(int j=2;j<=c*2-1;j++){
                f[i][j]=f[i][j-1]+a[j]
            }
        }

        System.out.println(minS);
        System.out.println(maxS);
    }
}
