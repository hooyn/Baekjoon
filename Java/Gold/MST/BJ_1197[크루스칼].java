import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 최소 스패닝 트리: MST
 * [크루스칼 알고리즘]
 */
public class BJ_1197 {
    static int[] parent;
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int result = 0;

        parent = new int[v+1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.add(new Edge(start, end, cost));
        }

        Collections.sort(list);

        for (int i = 0; i < e; i++) {
            Edge edge = list.get(i);
            if(!isSameParent(edge.start, edge.end)){ //싸이클이 없다면
                union(edge.start, edge.end); //연결
                result += edge.cost; //가중치 증가
            }
        }

        System.out.println(result);
    }
    private static int find(int x){
        if(parent[x] == x){
            return x;
        } else {
            return parent[x] = find(parent[x]); //부모 찾기
        }
    }

    private static void union(int start, int end) {
        start = find(start);
        end = find(end);

        if(start!=end){
            parent[end] = start; //end를 start에 연결
        }
    }

    private static boolean isSameParent(int start, int end) {
        start = find(start);
        end = find(end);

        if(start==end) return true;
        else return false;
    }
}
