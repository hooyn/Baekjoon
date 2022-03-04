import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1, 2, 3, 더하기
 */
public class BJ_9095 {
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            result = 0;
            int n = Integer.parseInt(br.readLine());

            find(0, n);

            System.out.println(result);
        }
    }

    static void find(int init, int n){
        if(init>n) return;
        else if(init==n) {
            result++;
            return;
        }
        else{
            find(init+1, n);
            find(init+2, n);
            find(init+3, n);
        }
    }
}
