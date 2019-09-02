import java.util.Scanner;

/**
 * Created by richard on 01/09/2019.
 */
public class TreeOfSchoolGate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        l +=1;
        int d = scanner.nextInt();
        int[] a = new int[l];
        for (int i = 0;i < l; i++) {
            a[i] = 1;
        }
        for (int i = 0; i < d; i++) {
            int from = scanner.nextInt();
            int to  = scanner.nextInt();
            for (int j = from; j <= to ; j++) {
                a[j] = 0;
            }
        }
        int sum = 0;
        for (int i =0;i < l; i++) {
            if (a[i] == 1) {
                sum ++;
            }
        }
        System.out.println(sum);
    }
}
