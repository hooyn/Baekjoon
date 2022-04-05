import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 섬의 개수
 */
public class BJ_4963 {
    static int[][] arr;
    static boolean[][] visited;
    static int result;
    static int a;
    static int b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(a==0&&b==0) break;

            arr = new int[b][a];
            visited = new boolean[b][a];
            for (int i = 0; i < b; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < a; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = 0;
            for (int i = 0; i < b; i++) {
                for (int j = 0; j < a; j++) {
                    if(!visited[i][j]&&arr[i][j]==1){
                        find(i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static void find(int i, int j) {
        int[] da = {-1,-1,-1,0,1,1,1,0};
        int[] db = {-1,0,1,1,1,0,-1,-1};

        visited[i][j] = true;
        for (int k = 0; k < 8; k++) {
            int ka = da[k] + j;
            int kb = db[k] + i;
            if((ka>=0&&ka<a)&&(kb>=0&&kb<b)){ //범위 내에 있다면
                if(arr[kb][ka]==1&&!visited[kb][ka]){
                    find(kb, ka); // 탐색
                }
            }
        }

    }
}
