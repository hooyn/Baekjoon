import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최단경로
 * 주어진 시작점에서 다른 모든 정점으로의 최단 경로 구하기
 */
public class BJ_1753 {

    static BufferedReader br;
    static BufferedWriter bw;

    static class Edge implements Comparable<Edge>{
        int id;
        int cost;

        public Edge(int node, int cost) {
            this.id = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost; //오름차순
        }
    }
    static int V, E, K;
    static int u, v, w;
    static int[] dist;
    static ArrayList[] adjList; //인접리스트
    static int pi(String s){return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = pi(st.nextToken());
        E = pi(st.nextToken());
        K = pi(br.readLine());

        dist = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        adjList = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            adjList[i] = new ArrayList<Edge>();
        }

        for (int i = 1; i < E + 1; i++) {
            st = new StringTokenizer(br.readLine());

            u = pi(st.nextToken());
            v = pi(st.nextToken());
            w = pi(st.nextToken());

            adjList[u].add(new Edge(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            }
            else {
                sb.append(dist[i]+"\n");
            }
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if(now.cost > dist[now.id]) continue;

            int len = adjList[now.id].size();
            for (int i = 0; i < len; i++) {
                Edge next = (Edge) adjList[now.id].get(i);

                if(dist[next.id] > now.cost + next.cost){
                    dist[next.id] = now.cost + next.cost;
                    pq.add(new Edge(next.id, dist[next.id]));
                }
            }
        }
    }
}

//출처: https://subbak2.com/m/55
