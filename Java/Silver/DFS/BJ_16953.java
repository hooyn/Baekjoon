import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * A -> B
 */
public class BJ_16953 {
    static long n;
    static long m;
    static int count = Integer.MAX_VALUE;
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        find(n, 1);
        if(!check){
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

    private static void find(long k, int c) {
        if(k>m) return;
        else if(k==m){
            check = true;
            count = Math.min(count, c);
        } else {
            find(2*k, c+1);
            find((10*k)+1, c+1);
        }
    }
}
