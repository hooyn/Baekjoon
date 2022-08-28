import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 소수
 */
public class BJ_2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] decimal = new boolean[10_001];

        decimal[0] = decimal[1] = true;
        for (int i = 2; i*i < decimal.length; i++) {
            for (int j = i*i; j < decimal.length; j+=i) {
                decimal[j] = true;
            }
        }
        //소수 구별

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int MIN = -1;
        int SUM = 0;
        for (int i = N; i <= M; i++) {
            if(!decimal[i]){
                SUM += i;
                if(MIN==-1){
                    MIN = i;
                }
            }
        }

        if(MIN==-1){
            System.out.println(-1);
        } else {
            System.out.println(SUM+"\n"+MIN);
        }
    }
}
