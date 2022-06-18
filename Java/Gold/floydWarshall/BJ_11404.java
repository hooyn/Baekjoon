import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 플로이드
 */
public class BJ_11404 {
    static final int INF = 1000000000;
    static int n; //city의 갯수
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        map = new int[n][n];

        //초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j) continue;
                else map[i][j] = INF;
            }
        }

        //입력 받기
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            
            map[start][end] = Math.min(map[start][end], cost);
        }
        
        floydWarshall();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] >= INF){
                    System.out.print(0 + " ");
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void floydWarshall() {
        for (int k = 0; k < n; k++) { //기준이 되는 거쳐가는 노드
            for (int i = 0; i < n; i++) { //출발 노드
                for (int j = 0; j < n; j++) { //도착 노드
                    //i에서 k를 거쳤다가 k에서 j까지 가는 거리와
                    //i에서 j까지 가는 거리를 비교해서 최소 값
                    map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }
    }
}
