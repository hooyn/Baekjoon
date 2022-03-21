import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 예산
 */
public class BJ_2512 {
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //지역 수
        int[] arr = new int[n]; //지역이 필요한 예산 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } //배열 초기화

        Arrays.sort(arr);

        long m = Integer.parseInt(br.readLine()); //예산 총액

        long left = 0;
        long right = arr[n-1];
        long mid = 0;
        while (left <= right) {
            mid= (left + right) / 2;
            long sum = 0;
            for (int money : arr) {
                if(money >= mid) sum += mid;
                else sum += money;
            }
            if (sum > m) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = Math.max(mid, answer); 
                //sum 이 m보다 작거나 같을 때 예산의 최댓값을 
                //구해야하므로 이부분에 로직을 넣어준다.
            }
        }
        System.out.println(answer);
    }
}
