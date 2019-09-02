import java.util.Scanner;
class MySelectNumber {
    private static int n;
    private static int k;
    private static int[] a = new int[25];
    private static int sum;
    private static int ans;
    private static boolean check(int n) {
        if(n==1) return false;
        for(int i=2; i*i<n;i++){
            if((n%i)==0) return false;
        }
        return true;
    }
    private static void choose(int i,int j,int s){
        if(j==0){
            if(check(s)) ans++;
            return;
        }
        if(n-i+1<j) return;
        choose(i+1,j,s);
        choose(i+1,j-1,s+a[i-1]);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        k=s.nextInt();
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        s.close();
        choose(1, k, 0);
        System.out.println(ans);
    }
}
