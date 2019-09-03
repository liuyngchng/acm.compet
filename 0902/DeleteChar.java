/**
 * 1.question 
 * a = "abdefaddwd";
 * b="dfghia";
 * 给定字符串a,b,从a,b中删除字符,删除1个字符算1次,
 * 问，求最少删除多少个字符，a b 可以相等
 * 2.状态描述 
 * f[i][j]考虑a前i个字符，b前j个字符，最少删除多少个字符，
 * 可以使得a[1...i]=b[1...j]
 * 3.状态转移
 * f[0][0]=0 else f[i][j]=inf;
 * f[i][j]=min(f[i][j-1],f[i-1][j])+1;
 * f[i][j]= f[i-1][j]+1     //删除a中的第i个字符
 *          f[i][j-1]+1     //删除b中的第j个字符
 *          f[i-1][j-1]     //a,b均不删除字符,if(a[i]==b[j])
 *          f[i-1][j-1]+2   //这个转移可以考虑分解成1,2的两个转移状态
 *
 */
import java.util.Scanner;
public class DeleteChar {
    private static int l;
    private static String a;
    private static String b;
    private static int[][] f;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        l=sc.nextInt();
        sc.nextLine();
        a=sc.nextLine();
        b=sc.nextLine();
        f=new int[l+10][l+10];
        for(int i=0;i<l+10;i++)
            for(int j=0;j<l+10;j++)
                if(i==0||j==0)
                    f[i][j]=i+j;
                else
                    f[i][j]=Integer.MAX_VALUE;
        for(int i=1;i<=a.length();i++)
            for(int j=1;j<=b.length();j++)
                if(a.charAt(i-1)==b.charAt(j-1))
                    f[i][j]=f[i-1][j-1];
                else
                    f[i][j]=Math.min(f[i][j-1],f[i-1][j])+1;
        System.out.println(f[a.length()][b.length()]);
    }
}
