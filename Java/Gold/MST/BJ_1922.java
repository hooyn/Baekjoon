import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 네트워크 연결
 */
public class BJ_1922 {
    static class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            if(this.cost < o.cost)
                return -1; //변경
            else if(this.cost == o.cost)
                return 0; //유지
            else
                return 1; //유지
        }
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        if( x != y )
            parent[y] = x;
    }

    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);
        if(x==y) return true;
        else return false;
    }

    public static int[] parent;
    public static List<Edge> edgeList;
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = pi(br.readLine());
        int m = pi(br.readLine());

        edgeList = new ArrayList<Edge>();
        while(m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r1 = pi(st.nextToken());
            int r2 = pi(st.nextToken());
            int cost = pi(st.nextToken());

            edgeList.add(new Edge(r1, r2, cost));
        }

        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        Collections.sort(edgeList);

        int sum = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if(!isSameParent(edge.v1, edge.v2)){
                sum += edge.cost;
                union(edge.v1, edge.v2);
            }
        }

        System.out.println(sum);
    }
}

/**
 * 유니온 파인드 알고리즘: https://brenden.tistory.com/33
 *  여러 노드가 존재할 때 두 개의 노드를 선택해서, 현재 두 노드가 서로 같은 그래프에 속하는지 판별
 * 크루스칼 알고리즘: https://brenden.tistory.com/36
 */
