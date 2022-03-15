import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 토마토
 * 골드 V
 */
public class BJ_7576 {
    static int[][] tomatoes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};

        tomatoes = new int[row][col]; //토마토 박스 배열 선언
        for (int i = 0; i < row; i++) { //토마토 박스 배열에 데이터 저장
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0; //일 수

        while(true){
            boolean change = false; //박스가 바뀌었는지 안바뀌었는지 체크
            boolean[][] visit = new boolean[row][col]; //박스에 바뀐자리는 다음날로 넘겨야 하므로 체크
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(tomatoes[i][j]==1&&(!visit[i][j])){ //토마토가 익었고, 오늘 익은 토마토가 아니라면 처리해주기
                        for (int k = 0; k < 4; k++) {
                            int x = j + dx[k];
                            int y = i + dy[k];
                            if(x>=0&&x<col&&y>=0&&y<row){ //박스 내의 범위인지 확인하고
                                if(tomatoes[y][x]==0) { //인접한 토마토가 익지 않았다면 처리해주기
                                    visit[y][x] = true;
                                    //이제 이 토마토는 익었지만 오늘 익은 토마토는
                                    //다음날 부터 인접한 토마토들에게 영향을 주기 때문에
                                    //visit을 true로 해주어서 다음날에 검사를 하도록 한다.
                                    change = true;
                                    //그리고 박스가 바뀌었는지에 대해서 change값을 true로 해준다.
                                    tomatoes[y][x] = 1;
                                }
                            }
                        }
                    }
                }
            }
            if(change==false) break; //아무것도 변경되지 않았다면 while문 탈출
            else {
                day++; //일수 증가
            }
        }

        /**
         * 익었는지 확인
         */
        boolean check = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(tomatoes[i][j] == 0){
                    check = false;
                    break;
                }
            }
            if(!check) break;
        }

        if(check){
            System.out.println(day);
        } else {
            System.out.println(-1);
        }

    }
}
