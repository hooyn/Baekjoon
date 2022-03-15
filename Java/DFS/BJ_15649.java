import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N과 M (1)
 */
public class BJ_15649 {

    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        boolean[] check = new boolean[n];
        dfs(n, m, arr, check, 0);
        System.out.println(sb);
    }

    public static void dfs(int n, int m, int[] arr, boolean[] check, int i) {
        if(i == m){
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int j = 0; j < n; j++) {
             if(!check[j]){
                 check[j] = true;
                 arr[i] = j + 1;
                 dfs(n, m, arr, check, i+1);
                 check[j] = false;
                 //false를 해주는 이유는 dfs()를 호출하고 다시 check값을 그 전 상태로 돌리고
                 //j++된 상태에서 처음 받은 check값을 사용해야되기 때문이다.
                 //백트래킹 하는 것이라고 생각하면 편하다.
             }
        }
    }
}
