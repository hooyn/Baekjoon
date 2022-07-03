import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 민호와 강호 [골드4 스폐셜 저지]
 */
public class BJ_11662 {
    static class Point{
        double x;
        double y;

        public Point(String x, String y) {
            this.x = Double.parseDouble(x);
            this.y = Double.parseDouble(y);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int INF = 1_000_000;


        Point A = new Point(st.nextToken(), st.nextToken());
        Point B = new Point(st.nextToken(), st.nextToken());
        Point C = new Point(st.nextToken(), st.nextToken());
        Point D = new Point(st.nextToken(), st.nextToken());

        //A점과 C점의 X,Y 변화량 구하기
        double aDX = (B.x - A.x) / INF;
        double aDY = (B.y - A.y) / INF;
        double cDX = (D.x - C.x) / INF;
        double cDY = (D.y - C.y) / INF;

        int lo = 0;
        int hi = INF;

        while (hi - lo >= 3) {
            int p = (2*lo + hi)/3;
            int q = (lo + 2*hi)/3;

            double pValue = getDistance(A.x + aDX * p, A.y + aDY * p, C.x + cDX * p, C.y + cDY * p);
            double qValue = getDistance(A.x + aDX * q, A.y + aDY * q, C.x + cDX * q, C.y + cDY * q);

            if(pValue < qValue){
                hi = q -1;
            } else {
                lo = p +1;
            }
        }

        double min = getDistance(A.x + aDX * hi, A.y + aDY * hi, C.x + cDX * hi, C.y + cDY * hi);

        for (int i = lo; i < hi; i++) {
            double temp = getDistance(A.x + aDX * i, A.y + aDY * i, C.x + cDX * i, C.y + cDY * i);

            if(temp<min){
                min = temp;
            }
        }

        System.out.println(min);
    }

    static double getDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(Math.abs(x2-x1), 2) + Math.pow(Math.abs(y2-y1), 2));
    }
}
