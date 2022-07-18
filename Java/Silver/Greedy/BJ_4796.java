import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 캠핑 실버 5
 */
public class BJ_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int result = 0;

            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(l==0){
                break;
            }

            int mok = v / p;
            int remain = v % p;

            result += (mok * l);

            if(remain<=l){
                result += remain;
            } else {
                result += l;
            }


            System.out.println("Case " + cnt + ": " + result);
            cnt++;
        }
    }
}
