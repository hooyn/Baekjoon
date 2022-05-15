import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 통나무 건너뛰기
 */
public class BJ_11497 {
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = pi(br.readLine());

        for (int i = 0; i < testcase; i++) {
            /**
             * 입력값 저장
             */
            int n = pi(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[j] = pi(st.nextToken());
            }

            /**
             * 로직
             */
            Arrays.sort(arr);

            int[] result = new int[n];
            int left = 0;
            int right = n-1;
            for (int j = 0; j < n; j++) {
                if(j%2==0){
                    result[left] = arr[j];
                    left++;
                } else {
                    result[right] = arr[j];
                    right--;
                }
            }
            int out = Math.abs(result[0] - result[n-1]);

            for (int j = 1; j < n; j++) {
                 out = Math.max(out, Math.abs(result[j]-result[j-1]));
            }

            System.out.println(out);
        }
    }
}
