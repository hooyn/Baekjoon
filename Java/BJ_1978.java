import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 소수 찾기
 */
public class BJ_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];

        int max = 1001;
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] checkList = new boolean[max+1];
        checkList[0] = true;
        checkList[1] = true;

        for (int i = 2; i*i < max; i++) {
            for (int j = i*i; j < max; j+=i) {
                if(!checkList[j]){
                    checkList[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }


        int result = 0;
        for (int i = 0; i < n; i++) {
            int num = list[i];
            if(!checkList[num]){
                result++;
            }
        }
        System.out.println(result);
    }
}
