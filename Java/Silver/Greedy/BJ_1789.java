import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수들의 합
 * N개의 서로 다른 자연수의 합이 S라고 할 때
 * 자연수 N의 최대값이라고 하면 많은 수들의 조합으로 
 * 자연수의 합 S를 만들어야 한다고 생각했습니다.
 * 
 * <결론>
 *     1부터 x까지 더하고 그 수가 S를 넘었다면 그 전의 수가
 *     최대 N이라고 생각했습니다. 이를 바탕으로 로직을 구성하였습니다.
 * </결론>
 */
public class BJ_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long sum = 0;
        long cnt = 1;
        while(true){
            //sum에 1부터 더하기
            sum += cnt;

            //만약 sum이 n보다 커졌다면 break;
            if(sum>n){
                break;
            }

            //cnt 증가
            cnt++;
        }

        //sum이 n보다 커진 cnt의 -1을 출력
        System.out.println(cnt-1);
    }
}
