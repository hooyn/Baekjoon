import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 토마토
 * 골드 V
 */
class Tomato{ //queue에 넣기 위한 클래스 선언
    int x;
    int y;

    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BJ_7576 {
    static int col;
    static int row;

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    static int[][] tomatoes;
    static Queue<Tomato> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        tomatoes = new int[row][col]; //토마토 박스 배열 선언
        queue = new LinkedList<Tomato>();

        for (int i = 0; i < row; i++) { //토마토 박스 배열에 데이터 저장
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoes[i][j] == 1){
                    queue.add(new Tomato(i, j)); //1인 토마토를 큐에 저장하고 처리
                }
            }
        }

        System.out.println(bfs()); //bfs활용
    }

    private static int bfs() {
        while (!queue.isEmpty()) { //큐가 비어있다면 while문 탈출
            Tomato t = queue.remove(); //큐에 있는 토마토 정보 받아와서
            int x = t.x;
            int y = t.y;

            for (int i = 0; i < 4; i++) { //오른쪽 왼쪽 위 아래를 점검한다.
                int ddx = x + dx[i];
                int ddy = y + dy[i];

                if (ddx >= 0 && ddy >= 0 && ddx < row && ddy < col) {
                    if (tomatoes[ddx][ddy] == 0) { //범위 내에 있고 0이라면 배열의 정보를 업데이트 해주고
                        queue.add(new Tomato(ddx, ddy)); //큐에 그 토마토의 위치 정보를 넣어준다.
                        tomatoes[ddx][ddy] = tomatoes[x][y] + 1; //일수 정보를 얻기 위해 원래 익은 토마토가 있었던 수에서 +1을 해준다.
                    }
                }
            }
        }
        int result = Integer.MIN_VALUE; //제일 작은 수로 설정해주고
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(tomatoes[i][j] == 0)
                    return -1;
                result = Math.max(result, tomatoes[i][j]); //for문을 돌리면서 찾는다.
            }
        }

        if(result==1)
            return 0;
        else
            return result-1;
    }
}
