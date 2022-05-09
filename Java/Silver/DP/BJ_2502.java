import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 떡 먹는 호랑이 (스페셜 저지)
 */
public class BJ_2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int day = Integer.parseInt(st.nextToken());
        int rc = Integer.parseInt(st.nextToken());

        if(day==3){
            System.out.println(1);
            System.out.println(rc-1);
            return;
        } else {
            int[] Day1 = new int[day+1];
            int[] Day2 = new int[day+1];

            /**
             * a1 + a2 = a3 [a1_1, a2_1]
             * a1 + a2 + a2 = a4 [a1_1, a2_2] 여기서부터 계수가 규칙이 생긴다.
             * a1 + a2 + a2 + a1 + a2 = a5 [a1_2, a2_3]
             * a1 + a2 + a2 + a1 + a2 + a1 + a2 + a2 = a6 [a1_3, a2_5]
             */
            Day1[3] = Day2[3] = 1;
            Day1[4] = 1;
            Day2[4] = 2;

            for(int i = 5; i <= day; i++){
                Day1[i] = Day1[i-2] + Day1[i-1];
                Day2[i] = Day2[i-2] + Day2[i-1];
            }

            int first = 0;
            int second = 0;

            for(int i = 1;; i++){
                int res = rc - Day1[day] * i;

                if(res%Day2[day] == 0){
                    first = i;
                    second = res/Day2[day];
                    break;
                }
            }


            System.out.println(first);
            System.out.println(second);
        }
    }
}
