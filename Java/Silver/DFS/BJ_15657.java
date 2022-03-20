import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N과 M (8)
 */
public class BJ_15657 {
    static int n;
    static int m;
    static int[] arr;
    static int[] num_arr;
    static boolean[] visited;

    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        num_arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num_arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num_arr);
        find(0, 0);

        System.out.println(sb);
    }

    private static void find(int start, int depth) {
        if(depth==m){
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < num_arr.length; i++) {
            arr[depth] = num_arr[i];
            find(i, depth+1);
        }
    }
}
