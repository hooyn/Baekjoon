import java.io.IOException;
import java.util.Scanner;

/**
 * 평행사변형
 */
public class BJ_1064 {
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);

        Pair[] arr = new Pair[3]; //좌표 저장
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double[] leng = new double[3];

        for(int i=0; i<3; i++){
            arr[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        //세 점이 한 직선 위에 있으면 평행사변형을 만들 수 없습니다.
        if((arr[1].y-arr[0].y)*(arr[2].x-arr[1].x)==(arr[1].x-arr[0].x)*(arr[2].y-arr[1].y))
            System.out.println("-1");

        // 세 점이 만드는 세 직선 중 2개를 뽑아 만들 수 있는 평행사변형의 둘레 길이 중 최대 - 최소 가 답입니다.
        else {
            double one = Math.sqrt(Math.pow(arr[1].y-arr[0].y, 2)+Math.pow(arr[1].x-arr[0].x, 2));
            double two = Math.sqrt(Math.pow(arr[2].y-arr[0].y, 2)+Math.pow(arr[2].x-arr[0].x, 2));
            double three = Math.sqrt(Math.pow(arr[2].y-arr[1].y, 2)+Math.pow(arr[2].x-arr[1].x, 2));
            leng[0] = one + two;
            leng[1] = two + three;
            leng[2] = one + three;

            for(int i=0; i<3; i++) {
                if(min>leng[i])
                    min=leng[i];
                if(max<leng[i])
                    max=leng[i];
            }

            System.out.println(2*max-2*min);
        }
    }
}
