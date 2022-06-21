import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 벽 부수고 이동하기
 */
public class BJ_2206 {
    static class Pair{
        int r;
        int c;
        int cnt;
        boolean check;

        public Pair(int r, int c, int cnt, boolean check) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.check = check;
        }
    }
    static int row;
    static int col;
    static int min = 100_000_001;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        arr = new char[row][col];

        for (int i = 0; i < row; i++) {
            String input = br.readLine();
            for (int j = 0; j < col; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        bfs();
    }

    private static void bfs() {
        boolean[][][] visited = new boolean[row][col][2];

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, 1, false));

        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            if(pair.r == row-1 && pair.c == col-1){
                System.out.println(pair.cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = pair.r + dr[i];
                int nc = pair.c + dc[i];

                if(nr >= 0 && nr < row && nc >= 0 && nc < col){
                    if(arr[nr][nc] == '0'){
                        if(!pair.check && !visited[nr][nc][0]) {
                            queue.add(new Pair(nr, nc, pair.cnt+1, false));
                            visited[nr][nc][0] = true;
                        } else if(pair.check && !visited[nr][nc][1]){
                            queue.add(new Pair(nr, nc, pair.cnt+1, true));
                            visited[nr][nc][1] = true;
                        }
                    } else if(arr[nr][nc] == '1'){
                        if(!pair.check){
                            queue.add(new Pair(nr, nc, pair.cnt+1, true));
                            visited[nr][nc][1] = true;
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
