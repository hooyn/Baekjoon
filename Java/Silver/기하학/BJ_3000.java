import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 직각 삼각형
 */
public class BJ_3000 {
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long result = 0;

        long[] X = new long[100_001];
        long[] Y = new long[100_001];

        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Point(x, y);

            X[x]++; //x좌표 개수 구하기
            Y[y]++; //y좌표 개수 구하기
        }

        for (int i = 0; i < N; i++) {
            //점을 하나씩 꺼내기
            Point point = points[i];

            //점의 x좌표와 y좌표가 같은 다른 점이 있는지 확인 후 곱하기
            //참고: https://thinking-face.tistory.com/entry/3000-%EC%A7%81%EA%B0%81%EC%82%BC%EA%B0%81%ED%98%95
            result += ((X[point.x]-1) * (Y[point.y]-1));
        }

        System.out.println(result);
    }
}
