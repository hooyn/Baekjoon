import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 마라톤 1
 */
public class BJ_10655 {
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
        int n = Integer.parseInt(br.readLine());

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Point(x, y);
        }

        int[] dist = new int[n];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n-1; i++) {
            Point point1 = points[i];
            Point point2 = points[i + 1];

            dist[i+1] = distance(point1.x, point1.y, point2.x, point2.y);
            sum+=dist[i+1];
        }

        // 첫번째 점과 마지막 점은 무조건 지나야 하므로 두번째 점부터 마지막 점 전까지 하나씩 빼면서
        // 뺐을 때 가장 큰 차이를 max 변수에 저장 해놓고 전체 경로 sum에서 max를 빼주기
        for (int i = 1; i < n-1; i++) {
            int dif = (dist[i]+dist[i+1])-(distance(points[i-1].x, points[i-1].y, points[i+1].x, points[i+1].y));
            if(dif>max){
                max = dif;
            }
        }

        System.out.println(sum-max);
    }
    static int distance(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}
