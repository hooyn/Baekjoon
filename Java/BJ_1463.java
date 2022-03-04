import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1로 만들기
 */
public class BJ_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = find(n, 0);
        System.out.println(result);
    }

    public static int find(int n, int cnt){
        if(n<0) return 1000000;
        if(n==1) return cnt;

        boolean a = false;
        boolean b = false;

        if(n%3==0){
            a = true;
        } else if(n%2==0){
            b = true;
        }

        int aa = 1000001;
        int bb = 1000001;
        int cc = find(n-1, cnt+1);
        if(a){
            aa = find(n/3, cnt+1);
        }
        if(b){
            bb = find(n/2, cnt+1);
        }

        int min = cc;
        if(bb<min) min = bb;
        if(aa<min) min = aa;

        return min;
    }
}
