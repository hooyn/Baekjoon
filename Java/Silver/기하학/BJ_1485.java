import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 정사각형
 */
public class BJ_1485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (testCase-- > 0) {
            ArrayList<pair> list = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.add(new pair(x, y));
            }

            double[] len = new double[6]; // 각각의 두 점 거리를 구하면 6개가 나온다.
            int count = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = i+1; j < 4; j++) {
                    len[count++] = calculateDistance(list.get(i), list.get(j));
                }
            }
            boolean isSquare = true;

            Arrays.sort(len);
            //-> 정사각형이라면 정렬 시
            // 앞에 4개 같은 길이 (한 변의 길이)
            // 뒤에 2개 같은 길이 (대각선의 길이)

            for (int i = 1; i < 4; i++) {
                if(len[0] != len[i]) isSquare = false;
            }

            if(len[4] != len[5]) isSquare = false;

            if(isSquare) System.out.println("1");
            else System.out.println("0");
        }
    }
    static double calculateDistance(pair point1, pair point2) {
        int dx = point1.x - point2.x;
        int dy = point1.y - point2.y;
        return Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
    }
    
    static class pair{
        int x;
        int y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
