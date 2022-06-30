import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 최소비용 구하기
 */
public class BJ_1916 {
    static class Bus implements Comparable<Bus>{
        int end;
        int cost;

        public Bus(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return this.cost - o.cost; //오름 차순 정렬
        }
    }
    static int n;
    static int m;
    static List<List<Bus>> list;
    static int[] dist;
    static boolean[] check;
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = pi(br.readLine());
        m = pi(br.readLine());

        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        check = new boolean[n+1];

        //2차원 ArrayList 초기화
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        //버스 정보 입력 받기
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = pi(st.nextToken());
            int end = pi(st.nextToken());
            int cost = pi(st.nextToken());

            list.get(start).add(new Bus(end, cost));
        }

        //출발지와 목적지 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int origin = pi(st.nextToken());
        int destination = pi(st.nextToken());

        System.out.println(dijkstra(origin, destination));
    }

    private static int dijkstra(int origin, int destination) {
        //우선순위 큐를 이용한 다익스트라 알고리즘
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        //시작점 큐에 추가
        pq.offer(new Bus(origin, 0));
        dist[origin] = 0;

        while(!pq.isEmpty()){
            //큐에서 가장 cost가 적은 버스 경로 부터 꺼내기
            Bus curBus = pq.poll();
            int cur = curBus.end;

            //도착지가 방문되지 않았다면
            if(!check[cur]){
                check[cur] = true;

                //도착지에서 탐색 할 수 있는 버스를 찾아서
                for (Bus bus : list.get(cur)) {
                    //기존 값보다 최소 값이라면 pq에 추가
                    if(!check[bus.end] && dist[bus.end] > dist[cur] + bus.cost){
                        dist[bus.end] = dist[cur] + bus.cost;
                        pq.add(new Bus(bus.end, dist[bus.end]));
                    }
                }
            }
        }
        return dist[destination];
    }
}
