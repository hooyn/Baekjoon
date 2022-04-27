import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 안전 영역
 */
public class BJ_2468 {
    static int n;
    static int[][] arr;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        //배열 입력값 저장
        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <= 100; i++) {
            boolean[][] visited = new boolean[n][n];
            int count = 0;

            //기준이 i일 때 탐색하면서 몇개의 true 부분이 있는지 확인
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if(arr[j][k]>i && !visited[j][k]){ //기준보다 높은 곳들을 탐색
                        find(j, k, i, visited);
                        count++;
                    } else if(arr[j][k] <= i){
                        visited[j][k] = true;
                    }
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    private static void find(int row, int col, int num, boolean[][] visited) {
        visited[row][col] = true;

        int[] d_row = {0, 0, -1, 1};
        int[] d_col = {-1, 1, 0, 0};

        for (int i = 0; i < 4; i++) {
             int dd_row = row + d_row[i];
             int dd_col = col + d_col[i];

             if((dd_row>=0&&dd_row<n)&&(dd_col>=0&&dd_col<n)){ //배열의 범위 내에 있고
                 if(arr[dd_row][dd_col]>num&&!visited[dd_row][dd_col]){ //배열의 값이 기준보다 크고 방문하지 않은 곳이라면 탐색
                     find(dd_row, dd_col, num, visited);
                 }
             }
        }
    }


}
