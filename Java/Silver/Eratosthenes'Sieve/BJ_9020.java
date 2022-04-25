import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 골드바흐의 추측
 */
public class BJ_9020 {
    static boolean[] num_arr = new boolean[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        num_arr[0] = num_arr[1] = true;
        isPrime(); //1~10000까지 소수 구하기

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                if(!num_arr[j]){
                    list.add(j);
                }
            } //num범위 내에 소수 list에 저장

            int first=0;
            int second=0;
            for (int j = 0; list.get(j) <= (num/2); j++) {
                //num의 중간 수와 가장 가까운 소수를 뽑아서
                Integer integer = list.get(j);

                //num-integer가 소수라면 그 수를 first와 second에 저장
                if(!num_arr[num-integer]){
                    first = integer;
                    second = num - first;
                }
            }

            //first가 가장 큰 수중에 second도 소수인 수를 출력하면 골드바흐 수가 나온다.
            System.out.println(first + " " + second);
        }
    }

    static void isPrime(){ //소수 구하기
        for (int i = 2; i < num_arr.length; i++) {
            if(num_arr[i]) continue;

            for (int j = i*2; j < num_arr.length; j += i) {
                num_arr[j] = true;
            }
        }
    }
}
