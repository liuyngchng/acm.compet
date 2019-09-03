/**
 * https://www.luogu.org/problem/P1969
 * 使用栈的思想，考虑出栈入栈操作，反向拆解积木，
 * 添加一个最终高度为0的积木
 * 2 3 4 入栈，1 比4小，不能入栈
 * 出栈4，直到1可以入栈，
 */
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;
public class P1969 {
    private static int n;
    private static int[] h=new int[100000+10];
    private static int ans;
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++)
            h[i]=sc.nextInt();
        h[n+1]=0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=n+1;i++) {
        	if(q.isEmpty()){
                q.push(h[i]);
        		continue;
        	}
        	if(h[i]>q.getFirst()){
        		q.push(h[i]);
        	}else if(h[i]==q.getFirst()){
        		continue;
        	}else{
        		Integer b=-1;
        		do{
        			if(q.isEmpty()) {
        				b=0;
        				break;
        			} else {
	        			b=q.pop();
	        			ans++;
        			}
        		}while(b>h[i]);
        		if(h[i]>b) q.push(h[i]);
        		else continue;
        	}
        }
        System.out.println(ans);
	}
}
