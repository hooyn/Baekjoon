import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 파티_골드3
 */
public class BJ_1238 {
    static class Road implements Comparable<Road> {
        int end;
        int cost;

        public Road(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return this.cost - o.cost;
        }
    }
    static List<List<Road>> list;
    static int n;
    static int m;
    static int x;
    static int[] dist;
    static int max = 0;
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = pi(st.nextToken()); // 마을의 수 입니다.
        m = pi(st.nextToken()); // 도로의 수 입니다.
        x = pi(st.nextToken()); // 파티를 하는 마을의 index 입니다.

        // 2차원 리스트를 초기화했습니다.
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Road>());
        }

        // 도로의 정보를 받아서 리스트에 저장하였습니다.
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = pi(st.nextToken());
            int end = pi(st.nextToken());
            int cost = pi(st.nextToken());

            list.get(start).add(new Road(end, cost));
        }

        for (int i = 1; i <= n; i++) {
            int cost = 0;
            // 출발지에서 목적지까지 가는 비용을 구했습니다.
            dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            cost += dijkstra(i, x);

            // 목적지에서 다시 출발지로 돌아오는 비용을 구했습니다.
            dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            cost += dijkstra(x, i);

            // 구한 값 중에 최고를 max에 저장했습니다.
            max = Math.max(cost, max);
        }

        System.out.println(max);
    }

    private static int dijkstra(int start, int end) {
        if(start==end) return 0;

        boolean[] check = new boolean[n+1];
        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.offer(new Road(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Road curRoad = pq.poll();
            int cur = curRoad.end;

            if(!check[cur]){
                check[cur] = true;

                for (Road road : list.get(cur)) {
                    if(!check[road.end] && dist[road.end] > dist[cur] + road.cost){
                        dist[road.end] = dist[cur] + road.cost;
                        pq.offer(new Road(road.end, dist[road.end]));
                    }
                }
            }
        }
        return dist[end];
    }
}
