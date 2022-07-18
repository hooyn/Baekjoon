import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 전구와 스위치
 */
public class BJ_2138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result1 = 1, result2 = 0;

        String beforeStr = br.readLine();
        String afterStr = br.readLine();

        int[] before = new int[n];
        int[] before_ = new int[n];
        int[] after = new int[n];

        for (int i = 0; i < n; i++) {
            before[i] = beforeStr.charAt(i) - '0';
            before_[i] = beforeStr.charAt(i) - '0';
            after[i] = afterStr.charAt(i) - '0';
        }

        before[0] = 1-before[0];
        before[1] = 1-before[1];

        for (int i = 1; i < n; i++) {
            if(before[i-1] != after[i-1]){
                before[i-1] = 1-before[i-1];
                before[i] = 1-before[i];
                result1++;
                if(i != n-1){
                    before[i+1] = 1 - before[i+1];
                }
            }

            if(before_[i-1] != after[i-1]){
                before_[i-1] = 1-before_[i-1];
                before_[i] = 1-before_[i];
                result2++;
                if(i != n-1){
                    before_[i+1] = 1 - before_[i+1];
                }
            }
        }

        if(before[n-1] != after[n-1]) result1 = Integer.MAX_VALUE;
        if(before_[n-1] != after[n-1]) result2 = Integer.MAX_VALUE;

        if(result1==Integer.MAX_VALUE && result2==Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(Math.min(result1, result2));
        }
    }
}
