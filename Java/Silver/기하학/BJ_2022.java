import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사다리
 */
public class BJ_2022 {
    static double ip(String s){ return Double.parseDouble(s); };
    static double x;
    static double y;

    // 주어진 x,y,d를 기반으로 두 사다리의 교점에서의 높이값을 반환하는 함수
    static double getC(double d) {
        double a = Math.sqrt(x*x-d*d);
        double b = Math.sqrt(y*y-d*d);
        return (a*b)/(a+b);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = ip(st.nextToken());
        y = ip(st.nextToken());
        double c = ip(st.nextToken());

// 둘 중 큰 쪽을 x로 넣어주려고 한다
        if(x < y) {
            double temp = x;
            x = y;
            y = temp;
        }
// d의 최솟값으로 0, 최댓값으로 y를 준다
        double l = 0;
        double r = y;

        while(true){
            // l,r의 평균값을 d로 잡는다
            double d = (l+r)/2;
// 해당 d값에서의 교점에서의 높이를 알아낸다
            double myC = getC(d);

// 주어진 c값과의 차이가 0.001 미만이면 종료
            if(Math.abs(myC - c) <= 0.0001) {
                System.out.println(String.format("%.3f",d));
                return;
            }

// 구한값이 c보다 크면 d가 좁다는 얘기
            if(myC > c) {
                l = d;
            }else { // 반대면 d가 너무 크다는 얘기
                r = d;
            }
        }

    }
}
