import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 상근이의 여행
 */
public class BJ_9372_DFS {

    static boolean[][] list; //노드들이 연결되어 있는 정보를 담는 배열
    static boolean[] visited; //방문한 노드를 확인하는 배열

    static int country; //여행할 나라
    static int airplane; //비행기 경로

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            country = Integer.parseInt(st.nextToken()); // 2 <= n <= 1,000
            airplane = Integer.parseInt(st.nextToken()); // 1 <= m <= 10,000

            list = new boolean[airplane+2][airplane+2];
            visited = new boolean[airplane+2];

            for (int j = 0; j < airplane; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a][b] = true; //비행기의 경로가 주어지면
                list[b][a] = true; //가는 방향 오는 방향이 있으므로 둘다 true로 해준다.
            }

            //1번 노드 부터 DFS를 통해서 퍼져나간다. 
            //cnt는 모든 나라를 방문했는지 알기위해서 추가한 매개변수,
            //그리고 경로를 저장할 String
            dfs(1, 1, ""); 
        }
    }

    static void dfs(int n, int cnt, String route){
        visited[n] = true;
        route+=n + " "; //방문한 노드를 String에 저장

        if(cnt==country) System.out.println(route); //만약 모든 나라를 방문했다면 경로 출력하기

        List<Integer> line = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            if(list[n][i]){
                line.add(i); //노드들 중에서 true인 노드로 연결시킨다.
            }
        }

        for (Integer in : line) {
            if(!visited[in]){ //만약 노드가 false라면 dfs()돌려서 퍼져나가기
                dfs(in, cnt+1, route);
            }
        }
    }
}
