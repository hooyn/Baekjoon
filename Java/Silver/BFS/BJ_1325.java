import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 효율적인 해킹
 */
public class BJ_1325 {
    static List<Integer>[] list;
    static int[] visited;
    static int dp[];
    static int n;
    static int m;
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = pi(st.nextToken());
        m = pi(st.nextToken());

        visited = new int[n+1];
        dp = new int[n+1];

        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = pi(st.nextToken());
            int y = pi(st.nextToken());

            list[x].add(y);
        }

        for (int i = 1; i <= n; i++) {
            visited = new int[n+1];
            find_optimize(i);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
             if(dp[i] > max) max = dp[i];
        }

        for (int i = 1; i <= n; i++) {
            if(dp[i] == max){
                System.out.print(i + " ");
            }
        }
    }

    private static void find(int node) {
        for (int i = 0; i < list[node].size(); i++) {
            Integer integer = list[node].get(i);
            if(visited[integer] == 0){
                dp[integer]++;
                visited[integer] = 1;
                find(integer);
            }
        }

    }

    private static void find_optimize(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        visited[node] = 1;
        while (!queue.isEmpty()) {
            node = queue.remove();
            for (Integer integer : list[node]) {
                if(visited[integer]==0){
                    dp[integer]++;
                    visited[integer] = 1;
                    queue.add(integer);
                }
            }
        }

    }
}
