import java.util.Scanner;

/**
 * Created by richard on 01/09/2019.
 * https://www.luogu.org/problem/P2084
 */
public class JinzhiTransfer {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String  i = s.nextLine();
        String[] a = i.split(" ");
        String f = a[0];
        String number = a[1];
        int length = number.length();
        StringBuilder sb = new StringBuilder(length);
        for (int m = 0; m< length; m++) {
            char c = number.charAt(m);
            if (c == '0')
                continue;
            if (sb.length() != 0)
                sb.append('+');
            sb.append(c + "*" + f + "^" + (length - m-1));
        }
        System.out.println(sb);
    }
}
