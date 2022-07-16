import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주식 실버 2
 */
public class BJ_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            long result = 0; //결과 출력
            long[] arr = new long[n]; //주식의 가격을 저장하는 배열
            long max = 0; //최대 수 일때 주식을 팔아야하는데 그 기준

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //큰수에서 작은 수로 탐색합니다.
            for (int i = n-1; i >= 0 ; i--) {
                if(arr[i] > max){
                    max = arr[i];
                } else {
                    result += (max - arr[i]);
                }
            }

            System.out.println(result);
        }
    }
}
