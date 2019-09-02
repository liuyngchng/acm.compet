import java.util.Scanner;

/**
 * Created by richard on 01/09/2019.
 * https://www.luogu.org/problem/P1116
 */
public class RotateTrain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        int[] d = new int[a];
        for (int i = 0; i< a; i++) {
            d[i] = scanner.nextInt();
        }
        int count = 0;
        for (int i = 0; i < d.length; i++) {
            for (int j = i + 1; j < d.length; j++) {
                if (d[j] < d[i]) {
                    int temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                    count ++;
                }
            }
        }
        System.out.println(count);
    }
}
