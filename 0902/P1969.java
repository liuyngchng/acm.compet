/**
 * https://www.luogu.org/problem/P1969
 * 使用栈的思想，考虑出栈入栈操作，反向拆解积木，
 * 添加一个最终高度为0的积木
 * 2 3 4 入栈，1 比4小，不能入栈
 * 出栈4，直到1可以入栈，
 */
import java.util.*;
public class P1969 {
	private static int n;
	private static int[] h = new int[100000 + 10];
	private static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++)
			h[i] = sc.nextInt();
		List<Integer> q = new ArrayList<Integer>();
		for (int i = 1; i <= n + 1; i++) {
			if (q.isEmpty() || h[i] > q.get(q.size() - 1)) {
				q.add(h[i]);
			} else if (h[i] == q.get(q.size() - 1)) {
				continue;
			} else {
				pop(q, h[i]);
			}
		}
		System.out.println(ans);
	}

	private static void pop(List<Integer> q, int h) {
		int max = 0;
		if (q.size() > 1) {
			max = Math.max(q.get(q.size() - 2), h);
		} else {
			max = h;
		}
		ans += q.get(q.size() - 1) - max;
		q.remove(q.size() - 1);
		if (!q.isEmpty() && q.get(q.size() - 1) > h) {
			pop(q, h);
		} else {
			q.add(h);
		}
	}
}
