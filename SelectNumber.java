import java.util.Scanner;

/**
 * Created by richard on 01/09/2019.
 * https://www.luogu.org/problem/P1036
 * 从n个数字中选取k个数字
 */
public class SelectNumber {
    public static int a[] = new int[25];
    public static int n, k, ans = 0;
    /**
     * 检查一个数是否为素数，即只能被自身和1整除，
     * 1 不是素数
     * 考虑 x = a * b, 那么必然存在 a<b,
     * 那么考虑在 a^2 = x 的范围内枚举a的值，来判断是否存在这样的a，
     * 使得 x / a = b, 即 x % a = 0;
     * 
     */
    public static boolean check(int x) {
        if (x == 1) return false;
        for (int i=2; i*i<=x; ++i)
            if (x % i == 0)
                return false;
        return true;
    }
    /**
     * 一共要选取k个数字,开始选第index个数字,目前还剩下rest个数字需要选,
     * 已经选择的数字进行求和的值为sum.满足 index + rest -1 = k
     * 因为k <= n 
     * ==> index + rest -1 <= n
     * ==> rest <= n - index + 1
     * @param index 开始考虑第index个数字
     * @param rest 当前还剩多少个数字没选
     * @param sum 当前已经选择的数字的和
     */
    public static void choose(int index, int rest, int sum) {
        if (rest == 0) {
            if (check(sum))
                ++ans;
            return;
        }
        if (n - index + 1 < rest)
            return;
        //没有选择第 index 个数，开始考虑第index +1 个数
        choose(index + 1, rest, sum);
        //选择了第 index 个数，开始考虑第index +1 个数
        choose(index + 1, rest - 1, sum + a[index]);
    }
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        k = cin.nextInt();
        for (int i=1; i<=n; ++i)
            a[i] = cin.nextInt();
        cin.close();
        //开始考虑第 1 个数（还没决定选还是不选），这时候，
        //还有 k 个数等待选择，当前的求和值为 0
        choose(1, k, 0);
        System.out.println(ans);
    }
}
