import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 주사위 굴리기
 */
public class BJ_14499 {
    static int n,m,r,c,k;
    static int[][] map;
    static int sero[] = new int[4];
    static int garo[] = new int[4];
    static int dr[] = {0, 0, 0, -1, 1};
    static int dc[] = {0, 1, -1, 0, 0};

    static void seroUpdate(int i, int j){
        if(map[i][j] == 0){
            map[i][j] = sero[1]; //주사위 바닥 면
            garo[1] = sero[1]; //가로에 하단도 변경
        } else {
            sero[1] = map[i][j];
            garo[1] = sero[1];
            map[i][j] = 0;
        }
        System.out.println(sero[3]);
    }

    static void garoUpdate(int i, int j){
        if(map[i][j] == 0){
            map[i][j] = garo[1]; //주사위 바닥 면
            sero[1] = garo[1]; //세로에 하단도 변경
        } else {
            garo[1] = map[i][j];
            sero[1] = garo[1];
            map[i][j] = 0;
        }
        System.out.println(garo[3]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken())+1;
        c = Integer.parseInt(st.nextToken())+1;
        k = Integer.parseInt(st.nextToken());

        map = new int [n+2][m+2];

        //주사위 면의 숫자를 0으로 초기화
        Arrays.fill(sero, 0);
        Arrays.fill(garo, 0);

        //지도 주위를 -1로 감싸기
        for(int i=0; i<n+2; i++){
            Arrays.fill(map[i], -1);
        }

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken());

            r += dr[dir];
            c += dc[dir];

            if(map[r][c] != -1){
                if (dir == 1 || dir == 2) { //동쪽 아니면 서쪽일 때
                    if(dir==1){
                        int temp = garo[0];
                        for (int j = 0; j < 3; j++) {
                            garo[j] = garo[j+1];
                        }
                        garo[3] = temp;
                        sero[1] = garo[1];
                        sero[3] = garo[3];
                        garoUpdate(r, c);
                    } else {
                        int temp = garo[3];
                        for (int j = 3; j > 0; j--) {
                            garo[j] = garo[j-1];
                        }
                        garo[0] = temp;
                        sero[1] = garo[1];
                        sero[3] = garo[3];
                        garoUpdate(r, c);
                    }
                }
                if (dir == 3 || dir == 4) {
                    if(dir==3){
                        int temp = sero[0];
                        for (int j = 0; j < 3; j++) {
                            sero[j] = sero[j+1];
                        }
                        sero[3] = temp;
                        garo[1] = sero[1];
                        garo[3] = sero[3];
                        seroUpdate(r, c);
                    } else {
                        int temp = sero[3];
                        for (int j = 3; j > 0; j--) {
                            sero[j] = sero[j-1];
                        }
                        sero[0] = temp;
                        garo[1] = sero[1];
                        garo[3] = sero[3];
                        seroUpdate(r, c);
                    }
                }
            } else {
                r -= dr[dir];
                c -= dc[dir];
            }
        }
    }
}
