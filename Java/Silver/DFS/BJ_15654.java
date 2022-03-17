import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N과 M (5)
 */
public class BJ_15654 {

    static StringBuffer sb = new StringBuffer();
    static int[] number_arr;
    static boolean[] visited;
    static int[] arr;

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        number_arr = new int[n];
        visited = new boolean[n];
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number_arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number_arr);

        find(0);
        System.out.println(sb);
    }

    private static void find(int cnt) {
        if(cnt==m){
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int j = 0; j < n; j++) {
            if(!visited[j]){
                visited[j] = true;
                arr[cnt] = number_arr[j];
                find(cnt+1);
                visited[j] = false;
            }
        }
    }
}
