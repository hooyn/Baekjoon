import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 로봇 청소기
 */
public class BJ_14503 {
    static int result = 0;
    static int n;
    static int m;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken()); //0:북 1:동 2:남 3:서

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find(r, c, dir);

        System.out.println(result);
    }

    private static void find(int r, int c, int dir) {
        if(arr[r][c]==0){
            arr[r][c] = 2; //청소하기
            result++;
        }
        
        int checkCount = 0;
        while (true) {
            if(checkCount==4) {
                int nr = 0;
                int nc = 0;
                if(dir==0){
                    nr = r+1;
                    nc = c;
                } else if(dir==1){
                    nr = r;
                    nc = c-1;
                } else if(dir==2){
                    nr = r-1;
                    nc = c;
                } else if(dir==3){
                    nr = r;
                    nc = c+1;
                }

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if(arr[nr][nc] != 1){
                        find(nr, nc, dir);
                    }
                }

                break;
            }

            int nr = 0;
            int nc = 0;

            if(dir==0){
                dir=3;
                nr = r;
                nc = c-1;
            } else if(dir==1){
                dir=0;
                nr = r-1;
                nc = c;
            } else if(dir==2){
                dir=1;
                nr = r;
                nc = c+1;
            } else if(dir==3){
                dir=2;
                nr = r+1;
                nc = c;
            }

            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                if(arr[nr][nc] == 0){
                    find(nr, nc, dir);
                    break;
                }
            }
            checkCount++;
        }
    }
}
