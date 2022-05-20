import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 경비원
 */
public class BJ_2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        int[][] arr = new int[row+1][col+1];

        int market_count = Integer.parseInt(br.readLine());

        for (int i = 0; i < market_count; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == 1) { //북
                arr[0][y] = 1;
            } else if (x == 2) { //남
                arr[row][y] = 1;
            } else if (x == 3) { //서
                arr[y][0] = 1;
            } else if (x == 4) { //동
                arr[y][col] = 1;
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        if (x == 1) { //북
            arr[0][y] = 2;
        } else if (x == 2) { //남
            arr[row][y] = 2;
        } else if (x == 3) { //서
            arr[y][0] = 2;
        } else if (x == 4) { //동
            arr[y][col] = 2;
        }

        /*--------------------입력값 저장--------------------*/

        int r = 0;
        int c = 0;
        int[] dr = {1, 0, -1, 0}; //하 우 상 좌
        int[] dc = {0, 1, 0, -1};
        int idx = 0; //

        int move = 0; //움직인 횟수
        int change_move = (row+col); // 최대로 증가할 수 있는 범위
        int result = 0;
        boolean start = false; //시작 위치를 찾고 이제 상점 탐색 시작
        boolean pl_ma = false; //최대로 증가할 수 있는 범위가 넘어가면 감소시키기
        while (market_count > 0) {
            int nr = r + dr[idx];
            int nc = c + dc[idx];

            if(nr>=0&&nc>=0&&nr<=row&&nc<=col){
                if(start){
                    if(!pl_ma){ //증가할 수 있다면 move++하고
                        move++;
                        if(move==change_move) pl_ma=true; //만약 최대로 증가할 수 있는 곳 까지 도달했다면 pl_ma = true
                    } else {
                        move--; //그리고 감소 시키기
                    }
                    if(arr[nr][nc]==1){ //만약 상점이라면
                        result += move; //현재 move를 result에 더하고
                        market_count--; //market_count 감소시키기
                    }
                    r = nr; //이동
                    c = nc; //이동
                } else { //아직 시작 위치를 찾지 못했다면 탐색하여 시작위치 부터 찾기
                    if(arr[nr][nc]==2){ //찾았다면 start=true로 하고 상점 위치 찾기
                        start = true;
                    }
                    r = nr; //이동
                    c = nc; //이동
                }
            } else idx=(idx+1)%4; // 순환하기 위해 %4를 이용해서 idx 순환
        }

        /*--------------------주요 로직--------------------*/

        System.out.println(result);

        /*--------------------결과값 출력--------------------*/
    }
}
