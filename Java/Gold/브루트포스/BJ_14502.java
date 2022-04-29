import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 연구소
 */
public class BJ_14502 {
    static class virus{
        int row, col;

        public virus(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static int n;
    static int m;
    static int[][] arr;

    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        make_wall(0);

        System.out.println(result);
    }

    static void make_wall(int depth){
        //벽 3개를 모두 세웠다면 바이러스 퍼트리기
        if(depth==3){
            spread_virus();
            return;
        }

        //벽을 세울 수 있는 모든 경우의 수 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    make_wall(depth+1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    static void spread_virus(){
        int[] d_row = {0, 0, -1, 1};
        int[] d_col = {1, -1, 0, 0};
        int[][] copy_arr = new int[n][m];
        Queue<virus> queue = new LinkedList<>();

        //copy_arr 생성
        //copy_arr를 생성하지 않으면 바이러스가 퍼졌을 때 static arr에
        //0을 2로 저장시키게 된다. 그러면 다음에 make_wall할 때 백트래킹 하는데
        //문제가 생기게된다. 그래서 copy를 만드는 것은 꼭 필요하다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy_arr[i][j] = arr[i][j];
            }
        }

        //arr에서 바이러스 탐색하여 queue에 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(copy_arr[i][j] == 2){
                    queue.add(new virus(i, j));
                }
            }
        }

        while(!queue.isEmpty()){
            virus vi = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dd_row = vi.row + d_row[i];
                int dd_col = vi.col + d_col[i];

                //범위 내에 있고, 빈 공간이면 바이러스화
                if(dd_row>=0&&dd_col>=0&&dd_row<n&&dd_col<m){
                    if(copy_arr[dd_row][dd_col] == 0){
                        copy_arr[dd_row][dd_col] = 2;
                        queue.add(new virus(dd_row, dd_col));
                    }
                }
            }
        }
        //safe_zone 개수 구하기
        int safe_zone_count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(copy_arr[i][j] == 0) safe_zone_count++;
            }
        }

        result = Math.max(safe_zone_count, result);
    }
}
