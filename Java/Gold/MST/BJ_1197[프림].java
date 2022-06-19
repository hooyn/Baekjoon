import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 최소 스패닝 트리: MST
 * [프림 알고리즘]
 */
public class BJ_1197 {
   static int total;
   static List<Node>[] list;
   static boolean[] visited;
   static class Node implements Comparable<Node>{
       int to;
       int val;

       public Node(int to, int val) {
           this.to = to;
           this.val = val;
       }


       @Override
       public int compareTo(Node o) {
           return this.val - o.val;
       }
   }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        list = new ArrayList[v+1];
        visited = new boolean[v+1];
        for (int i = 1; i < v+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, w));
            list[b].add(new Node(a, w));
        }

        prim(1);
        System.out.println(total);
    }

    private static void prim(int start) {
        Queue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        while (!pq.isEmpty()){
            Node p = pq.poll();
            int node = p.to;
            int weight = p.val;

            if(visited[node]) continue;

            visited[node] = true;
            total += weight;

            for (Node next : list[node]) {
                if(!visited[next.to]){
                    pq.add(next);
                }
            }
        }
    }
}

/**
 * 크루스칼 알고리즘은 간선 위주로 탐색을 진행하고 프림 알고리즘은 정점 위주로 탐색을 진행한다.
 * 간선의 개수가 적은 경우 크루스칼이 더 용이하며 많은 경우 정점 위주 탐색인 프림이 더 용이하다.
 * 둘 다 시간복잡도는 O(ElogV)로 같다.
 * 출처: https://loosie.tistory.com/330
 */
