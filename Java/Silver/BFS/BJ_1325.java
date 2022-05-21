import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 효율적인 해킹
 */
public class BJ_1325 {
    static boolean[][] map;
    static boolean[] visited;
    static int dp[];
    static int n;
    static int m;
    static int max = 0;
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = pi(st.nextToken());
        m = pi(st.nextToken());

        dp = new int[n+1];
        map = new boolean[n+1][n+1];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int to = pi(st.nextToken());
            int from = pi(st.nextToken());

            map[from][to] = true;
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            find(i, 1, i);
        }

        for (int i = 0; i < dp.length; i++) {
            if(dp[i] == max){
                System.out.print(i + " ");
            }
        }
    }

    private static void find(int depth, int count, int start) {
        boolean check = false;
        visited[depth] = true;

        for (int i = 1; i <= n; i++) {
            if(map[depth][i]==true && !visited[i]){
                find(i, count+1, start);
                check = true;
            }
        }

        if(!check){
            dp[start] = Math.max(dp[start], count);
            max = Math.max(max, count);
        }
    }
}
