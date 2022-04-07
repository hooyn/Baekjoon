import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 베르트랑 공준
 */
public class BJ_4948 {
    static boolean[] erato = new boolean[250000];
    static long[] count = new long[250000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        erato[0] = erato[1] = true;
        for (int i = 2; i*i < erato.length; i++) {
            for (int j = i*i; j < erato.length; j+=i) {
                erato[j] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < erato.length; i++) {
            if(!erato[i]){
                result++;
            }
            count[i] = result;
        }

        while (true){
            int input = Integer.parseInt(br.readLine());
            if(input==0) break;
            else{
                System.out.println(count[input*2]-count[input]);
            }
        }
    }
}
