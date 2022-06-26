import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 겉넓이 구하기 실버2
 */
public class BJ_16931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean arr[][][] = new boolean[101][n+2][m+2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int num = Integer.parseInt(st.nextToken());
                for (int k = 1; k <= num; k++) {
                     arr[k][i][j] = true; //도형이 있는 곳 true
                }
            }
        }

        int sum = 2*n*m; //윗면, 아랫면 넓이
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k < 101; k++) {
                    if(arr[k][i][j]){ //만약 도형이 위치해 있다면
                        int[] di = {-1, 1, 0, 0};
                        int[] dj = {0, 0, -1, 1};

                        for (int l = 0; l < 4; l++) { //위, 아래, 좌, 우를 확인
                            int ni = i+di[l];
                            int nj = j+dj[l];

                            if(!arr[k][ni][nj]){ //만약 도형이 없다면 넓이 1추가
                                sum++;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
