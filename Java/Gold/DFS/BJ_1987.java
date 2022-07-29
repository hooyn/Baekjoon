import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 알파벳
 */
public class BJ_1987 {
    static int row;
    static int col;
    static char[][] arr;
    static boolean[] visited = new boolean[26];
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        arr = new char[row][col];

        for (int i = 0; i < row; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, 0);

        System.out.println(max);
    }

    static void dfs(int r, int c, int cnt){
        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};

        if(visited[(arr[r][c]-'A')]){
            max = Math.max(cnt, max);
        } else {
            visited[(arr[r][c]-'A')] = true;

            for (int i = 0; i < 4; i++) {
                int ddr = dr[i] + r;
                int ddc = dc[i] + c;

                if(ddr>=0 && ddr<row && ddc>=0 && ddc<col){
                    dfs(ddr, ddc, cnt+1);
                }
            }

            visited[(arr[r][c]-'A')] = false;
        }
    }
}
