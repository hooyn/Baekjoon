import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 숨바꼭질
 */
public class BJ_6118 {
    static int n;
    static int m;
    static List<Integer> list[];
    static boolean[] visited;
    static int dest, dist, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        list = new ArrayList[n+1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }
        bfs();
        System.out.println(dest+" "+dist+" "+cnt);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited[1] = true;

        queue.offer(new int[]{1, 0});

        while (!queue.isEmpty()){
            int arr[] = queue.poll();
            int now = arr[0];
            int next = arr[1];

            if(next > dist){
                dist = next;
                dest = now;
                cnt = 1;
            } else if(next == dist){
                if(dest > now) dest = now;
                cnt++;
            }

            for (int i = 0; i < list[now].size(); i++) {
                int next_next = list[now].get(i);
                if(!visited[next_next]){
                    visited[next_next] = true;
                    queue.add(new int[] {next_next, next+1});
                }
            }
        }
    }
}
