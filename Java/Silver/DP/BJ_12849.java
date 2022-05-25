import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* 본대 산책
*/
public class BJ_12849 {
    static final long div = 1000000007;
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = pi(br.readLine());

        long[][] map = new long[n+1][8]; //[현재 산책하는 시간][노드]
        map[0][0] = 1; //0분에 목표지점에 도착하기 위해서는 그 위치에 있어야하는 경우의 수 1개이므로 1을 저장한다.

        for (int i = 0; i < n; i++) {
            //각 노드와 연결된 노드에 해당 분에 도착할 경우의 수를 더해준다.
            map[i+1][0] = (map[i][1] + map[i][2]) % div;
            map[i+1][1] = (map[i][0] + map[i][2] + map[i][3]) % div;
            map[i+1][2] = (map[i][0] + map[i][1] + map[i][3] + map[i][4]) % div;
            map[i+1][3] = (map[i][1] + map[i][2] + map[i][4] + map[i][5]) % div;
            map[i+1][4] = (map[i][2] + map[i][3] + map[i][5] + map[i][6]) % div;
            map[i+1][5] = (map[i][3] + map[i][4] + map[i][7]) % div;
            map[i+1][6] = (map[i][4] + map[i][7]) % div;
            map[i+1][7] = (map[i][5] + map[i][6]) % div;
        }

        System.out.println(map[n][0]);
    }
}
