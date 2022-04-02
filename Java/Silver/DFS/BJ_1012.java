import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 유기농 배추
 */
public class BJ_1012 {
    static int[][] arr;
    static int col;
    static int row;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            int bachu = Integer.parseInt(st.nextToken());

            arr = new int[row][col];
            for (int j = 0; j < bachu; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[x][y] = 1;
            }

            int result = 0;

            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    int key = arr[j][k];
                    if(key==1){ //0이거나 -1이면 이미 관리받고 있거나 배추가 있는 위치가 아니다.
                        find(j,k); //먄약 배추가 있다면 find()를 통해 인접한 배추들을 찾는다.
                        result++;
                        //그리고 인접한 배추들을 find()를 통해 -1로 만들어주고
                        //벌레 한마리로 인접한 배추들을 관리할 수 있기 때문에
                        //result를 증가시켜준다.
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static void find(int j, int k) {
        int[] dx = {0, 0, 1, -1}; //위 아래 오른쪽 왼쪽
        int[] dy = {1, -1, 0, 0}; //인접한 배추가 있는지 확인하기 위한 배열 저장
        arr[j][k] = -1; //이미 관리받고 있는 배추임을 표시

        for (int i = 0; i < 4; i++) {
            int x = k + dx[i];
            int y = j + dy[i];

            if(x>=0&&x<col&&y>=0&&y<row){ //범위내에 위치해있고
                if(arr[y][x]==1){ //배추가 있다면 다시 find()호출
                    find(y, x); //인접한 배추들을 다 -1로 변경해준다.
                }
            }
        }
    }
}
