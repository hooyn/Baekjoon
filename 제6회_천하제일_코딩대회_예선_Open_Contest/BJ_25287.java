import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 순열 정렬 실버 4
 */

/**
 * <문제 풀이 방법>
 * 배열이 감소하지 않도록 만들 수 있는지 판별하는 프로그램 작성
 * N-i+1 연산은 반복됩니다.
 * 예를 들어 5라고 하면 5(N)-5(i)+1 = 1이고
 * 5(N)-1(i)+1 = 5 이므로 5 -> 1 -> 5 -> 1 ... 으로 반복됩니다.
 * 그래서 연산을 한번 처리하고도 배열이 감소한다면 그것은 No를 출력하면 됩니다.
 */
public class BJ_25287 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while(tc --> 0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            //배열을 입력
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if(n==1){
                System.out.println("YES");
            } else {
                //연산 실행하여 감소하는지 감소하지 않는지 확인
                boolean check = check_arr(arr, n);
                if(check){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static boolean check_arr(int[] arr, int n) {
        //첫 번째 값을 연산을 처리한 결과값과 비교해서 작은 값을 대입
        arr[1] = Math.min(arr[1], n - arr[1] + 1);

        for (int i = 2; i <= n; i++) {
            if(arr[i-1]<=arr[i]){
                continue;
            } else if(arr[i-1]<=(n - arr[i] +1)){
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
