import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 분수 합
 */
public class BJ_1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        int son = x1*y2 + x2*y1;
        int mom = y1*y2;

        int gcd = gcd(son, mom);
        son = son/gcd;
        mom = mom/gcd;

        System.out.println(son + " " + mom);
    }

    static int gcd(int a, int b){
        if(b==0){
            return a;
        } else {
            return gcd(b, a%b);
        }
    }
}
