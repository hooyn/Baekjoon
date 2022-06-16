import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 뱀
 */

public class BJ_3190 {
    static class Pair{
        int second;
        String dir;

        public Pair(int second, String dir) {
            this.second = second;
            this.dir = dir;
        }
    }
    static int n;
    static int[][] arr;
    static Queue<Pair> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;

            arr[r][c] = 1; //사과의 위치 1로 표시
        }

        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            String d = st.nextToken();

            queue.add(new Pair(s, d)); //방향 변환 정보 저장
        }

        running();
    }

    private static void running() {
        int[] dr = {0, 1, 0, -1}; //우, 하, 좌, 상 방향
        int[] dc = {1, 0, -1, 0};

        List<int[]> snake = new ArrayList<>();
        snake.add(new int[]{0,0}); //뱀의 위치 저장
        int curR = 0;
        int curC = 0;

        int direction = 0; //오른쪽 부터 시작
        int second = 0;

        Pair data = queue.poll();
        int sec = data.second;
        String chdir = data.dir;

        while (true) {
            second++; //1초

            int nr = curR + dr[direction];
            int nc = curC + dc[direction];

            if(isCheck(snake, nr, nc)==false) break; //만약 뱀이 벽에 닿거나, 몸통에 닿는다면 게임 종료

            if(arr[nr][nc] == 1){ //사과를 먹었을 때
                snake.add(new int[]{nr, nc});
            } else {
                snake.add(new int[]{nr, nc});
                snake.remove(0); //꼬리 제거
            }

            curR = nr;
            curC = nc;

            if(second==sec && !queue.isEmpty()){ //방향 변환 정보에 초가 지나고 방향 전환하기
                if(chdir.equals("D")){
                    direction = (direction+1)%4;
                } else if(chdir.equals("L")) {
                    direction = (direction+3)%4;
                }

                data = queue.poll();
                sec = data.second;
                chdir = data.dir;
            }
        }

        System.out.println(second);
    }

    private static boolean isCheck(List<int[]> snake, int nr, int nc) {
        if(nr<0 || nr==n || nc<0 || nc==n) return false;

        for (int i = 0; i < snake.size(); i++) {
            int[] s = snake.get(i);
            if(s[0]== nr && s[1]== nc) return false;
        }

        return true;
    }
}
