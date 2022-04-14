import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 미로 탐색
 */
public class BJ_2178 {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j) - '0';

            }
        } //미로 배열 초기화

        visited[0][0] = true;
        find(0,0);

        System.out.println(arr[n-1][m-1]);
    }

    private static void find(int row, int col) {
        int[] d_row = {0, 0, 1, -1};
        int[] d_col = {-1, 1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            int queue_row = poll[0];
            int queue_col = poll[1];

            for (int i = 0; i < 4; i++) {
                int dd_row = queue_row + d_row[i];
                int dd_col = queue_col + d_col[i];

                if((dd_row>=0&&dd_row<n)&&(dd_col>=0&&dd_col<m)){
                    if(arr[dd_row][dd_col]==1&&!visited[dd_row][dd_col]){
                        queue.add(new int[] {dd_row, dd_col});
                        arr[dd_row][dd_col] = arr[queue_row][queue_col] + 1;
                        visited[dd_row][dd_col] = true;
                    }
                }
            }
        }
    }
}
