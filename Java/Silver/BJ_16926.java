import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열 돌리기 1
 */
public class BJ_16926 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int row;
    static int col;
    static int count;
    static int[][] arr;
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = pi(st.nextToken());
        col = pi(st.nextToken());
        count = pi(st.nextToken());

        arr = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = pi(st.nextToken());
            }
        }

        /*--------------------입력값 저장--------------------*/

        int group_count = Math.min(row, col) / 2; // row와 col을 통해 배열 안에서 돌릴 그룹의 개수 설정

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < group_count; j++) {
                // 배열 1,1 -> 2,2 -> 3,3 ... -> group_count, group_count 만큼 반복
                int x = j;
                int y = j;

                int value = arr[x][y]; // 마지막에 값을 넣어주기 위해 초기값 저장

                int idx = 0; // 우상좌하를 가리킬 변수 idx

                while(idx<4) {
                    int nx = x + dx[idx]; // 이동
                    int ny = y + dy[idx]; // 이동

                    if(nx>=j&&ny>=j&&nx<row-j&&ny<col-j){ // 범위 내에 있다면 아래 로직 실행
                        arr[x][y] = arr[nx][ny]; // 이동한 배열의 값을 이동전 배열의 값에 저장
                        x = nx; // 이동
                        y = ny; // 이동
                    } else idx++; // 범위 내에 없다면 방향 전환
                }
                arr[j+1][j] = value; // 마지막 값에 value 넣어주기
            }
        }

        /*--------------------주요 로직--------------------*/

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        /*--------------------배열 출력--------------------*/
    }
}
