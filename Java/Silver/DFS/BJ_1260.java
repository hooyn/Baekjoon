import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * DFS와 BFS
 */
public class BJ_1260 {

    static int vertex_count;
    static int edge_count;
    static int start_point;

    static boolean[][] edge;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertex_count = Integer.parseInt(st.nextToken());
        edge_count = Integer.parseInt(st.nextToken());
        start_point = Integer.parseInt(st.nextToken());

        edge = new boolean[vertex_count+1][vertex_count+1];
        visited = new boolean[vertex_count+1];

        for (int i = 0; i < edge_count; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edge[x][y] = edge[y][x] = true;
        }

        dfs(start_point);

        System.out.println();

        visited = new boolean[vertex_count+1];
        //dfs()에서 사용한 visited를 그대로 사용하기 때문에 bfs()전에 초기화해줘야 한다.

        bfs();
    }

    static void dfs(int start){
        System.out.print(start + " ");
        visited[start] = true;
        for (int i = 1; i < edge.length; i++) {
            if((edge[start][i]==true)&&(visited[i]==false)){
                dfs(i);
            }
        }
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start_point);
        visited[start_point] = true;
        System.out.print(start_point+" ");

        while (!queue.isEmpty()){
            int poll = queue.poll();

            for (int i = 1; i < edge.length; i++) {
                if((edge[poll][i]==true)&&(visited[i]==false)){
                    queue.offer(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
