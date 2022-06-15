import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 토마토 (3차원)
 */

public class BJ_7569 {
    static class threeD{
        int r;
        int c;
        int z;

        public threeD(int r, int c, int z) {
            this.r = r;
            this.c = c;
            this.z = z;
        }
    }
    static int n;
    static int m;
    static int h;
    static int result = -1; //마지막에 모두 익었는데 Queue에 마지막 익은 토마토가 들어가므로 -1부터 시작
    static int[][][] box;
    static Queue<threeD> queue = new LinkedList<>(); //토마토 박스 위치를 저장하는 Queue
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = pi(st.nextToken());
        m = pi(st.nextToken());
        h = pi(st.nextToken());

        box = new int[h][m][n];

        boolean checkZero = true; //안익은 토마토가 있는지 확인하기 위한 변수
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    box[i][j][k] = pi(st.nextToken());
                    if(box[i][j][k] == 1){
                        queue.add(new threeD(j, k, i)); //익은 토마토의 위치 저장
                    }
                    if(box[i][j][k] == 0 && checkZero){
                        checkZero=false; //안익은 토마토가 있다면 false
                    }
                }
            }
        }

        if(checkZero) System.out.println(0);
        else{
            while (!queue.isEmpty()){ //queue가 비어있지 않다면 탐색하기
                int queueSize = queue.size(); //며칠이 걸리는지 구해야하기 때문에 현재 익은 토마토 개수 저장

                for (int i = 0; i < queueSize; i++) {
                    threeD data = queue.poll(); //익은 토마토 빼서
                    bfs(data); //익은 토마토 위치 기준 상하좌우위아래 탐색
                }

                result++; //하루 추가
            }

            if(checkBox()){ //모두 익었는지 확인 후 출력
                System.out.println(result);
            } else {
                System.out.println(-1);
            }
        }

    }

    private static void bfs(threeD data) {
        int[] dr = {1, 0, -1, 0, 0, 0};
        int[] dc = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        for (int i = 0; i < 6; i++) {
            int nr = data.r + dr[i];
            int nc = data.c + dc[i];
            int nz = data.z + dz[i];

            if(nr>=0 && nr<m && nc>=0 && nc<n && nz>=0 && nz<h){
                if(box[nz][nr][nc]==0){ //범위 내에 익지않은 토마토가 있다면 익은 토마토로 변경 후 queue에 추가
                    box[nz][nr][nc] = 1;
                    queue.add(new threeD(nr, nc, nz));
                }
            }
        }
    }

    static boolean checkBox(){
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if(box[i][j][k] == 0){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
