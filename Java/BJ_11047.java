import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 동전 0
 */
public class BJ_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int coin_count = Integer.parseInt(st.nextToken());
        int coin_sum = Integer.parseInt(st.nextToken());
        int[] coin_list = new int[coin_count];
        int result = 0;

        for (int i = 0; i < coin_count; i++) {
            coin_list[i] = Integer.parseInt(br.readLine());
        }

        for (int i = coin_count-1; i >= 0; i--) { //제일 비싼 코인부터 비교해서
            int coin = coin_list[i];

            if(coin_sum >= coin){ //코인을 사용할 수 있을 때(전체코인 >= 코인하나)
                int mok = coin_sum/coin; //코인을 몇개를 사용할 것인가.
                coin_sum = coin_sum - (coin * mok); //사용할 수 있는 만큼의 코인을 사용하고 sum을 돌려준다.
                result += mok; //사용한 코인의 개수만큼 result에 증가시켜주기

                if(coin_sum==0){
                    break; //만약 sum==0이라면 코인을 다 사용한 것이므로 break를 통해 반복문을 빠져나간다
                }
            }
        }

        System.out.println(result);
    }
}
