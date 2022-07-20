import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 뒤집기
 */
public class BJ_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char ch = input.charAt(0);

        int count0 = 0;
        int count1 = 0;

        if(ch=='0') count0++;
        else count1++;

        for (int i = 1; i < input.length(); i++) {
            if(ch!=input.charAt(i)){
                if(input.charAt(i)=='0') {
                    count0++;
                    ch = '0';
                }
                else {
                    count1++;
                    ch = '1';
                }
            }
        }

        int result = Math.min(count1, count0);

        System.out.println(result);
    }
}
