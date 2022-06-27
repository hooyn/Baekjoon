import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 선분과 점
 */
public class BJ_11664 {
    static double pi(String s){return Double.parseDouble(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double Ax = pi(st.nextToken());
        double Ay = pi(st.nextToken());
        double Az = pi(st.nextToken());

        double Bx = pi(st.nextToken());
        double By = pi(st.nextToken());
        double Bz = pi(st.nextToken());

        double Cx = pi(st.nextToken());
        double Cy = pi(st.nextToken());
        double Cz = pi(st.nextToken());

        double min = 987654321; //큰 수 설정
        int cnt = 10_000_000; //천만 번 반복하기
        while (cnt-->0) {
            double mx = (Ax + Bx) /2; //선분의 중간 점 구하기
            double my = (Ay + By) /2;
            double mz = (Az + Bz) /2;

            double leftSide = distance(Ax, Ay, Az, Cx, Cy, Cz); //선분의 왼쪽 점과 점 사이의 거리
            double midSide = distance(mx, my, mz, Cx, Cy, Cz); //선분의 가운데 점과 점 사이의 거리
            double rightSide = distance(Bx, By, Bz, Cx, Cy, Cz); //선분의 오른쪽 점과 점 사이의 거리

            if(Math.abs(midSide - min) <= 0.00000000001) break; //만약 오차가 별로 나지 않는다면 break;

            if(midSide < min) min = midSide; //만약 선분의 가운데 점의 거리가 min보다 작다면 min 업데이트

            if(rightSide < leftSide){ //선분의 오른쪽 점과 C점의 거리가 선분의 왼쪽 점과 C점의 거리보다 작다면 이분탐색처럼 업데이트
                Ax = mx;
                Ay = my;
                Az = mz;
            } else {
                Bx = mx;
                By = my;
                Bz = mz;
            }
        }

        System.out.println(String.format("%.10f", min));
    }

    static double distance(double x1, double y1, double z1, double x2, double y2, double z2){
        return Math.sqrt(
                Math.pow(
                        Math.abs(x2-x1),2
                ) + Math.pow(
                        Math.abs(y2-y1),2
                ) + Math.pow(
                        Math.abs(z2-z1),2
                )
        );
    }
}
