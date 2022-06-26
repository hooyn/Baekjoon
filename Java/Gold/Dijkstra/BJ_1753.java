import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 최단경로
 * 주어진 시작점에서 다른 모든 정점으로의 최단 경로 구하기
 */
public class BJ_1753 {
    static class Info{
        int node;
        int cost;

        public Info(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    static int V;
    static int E;
    static int pi(String s){return Integer.parseInt(s);}
    static List<Info>[] list;
    static Integer[] dp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = pi(st.nextToken());
        E = pi(st.nextToken());

        visited = new boolean[V+1];
        list = new List[V+1];
        for (int i = 1; i < V+1; i++) {
            list[i] = new ArrayList<Info>();
        }

        int start = pi(br.readLine());
        dp = new Integer[V+1];
        visited[start] = true;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = pi(st.nextToken());
            int v = pi(st.nextToken());
            int w = pi(st.nextToken());

            Info info = new Info(v, w);
            list[u].add(info);
        }

        bfs(start, 0);

        for (int i = 1; i < V+1; i++) {
            if(dp[i]==null){
                System.out.println("INF");
            } else {
                System.out.println(dp[i]);
            }
        }
    }

    private static void bfs(int node, int cost) {
        if(dp[node]==null){
            dp[node] = cost;
        } else {
            dp[node] = Math.min(cost, dp[node]);
        }
        List<Info> infos = list[node];
        for (Info info : infos) {
            if(!visited[info.node]){
                visited[info.node] = true;
                bfs(info.node, cost+info.cost);
                visited[info.node] = false;
            }
        }
    }
}
