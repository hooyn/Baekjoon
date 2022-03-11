import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N과 M(4)
 */
public class BJ_15652 {
    static int n;
    static int m;
    static int[] arr;

    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        find(1, 0);
        System.out.println(sb);
    }

    static void find(int start, int depth){
        if(depth == m) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            find(start, depth+1);
            start++;
        }
    }
}
