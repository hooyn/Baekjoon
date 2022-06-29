import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 삼각형으로 자르기
 */
public class BJ_1198 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Point[] points;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max = 0;

        points = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    max = Math.max(max, getArea(i, j, k));
                }
            }
        }

        System.out.println((double) max/2);
    }

    //세 점을 이용한 삼각형의 넓이 구하는 공식
    private static int getArea(int a, int b, int c) {
        return Math.abs((points[a].y-points[b].y) * (points[c].x-points[b].x) - (points[a].x-points[b].x) * (points[c].y-points[b].y));
    }
}
