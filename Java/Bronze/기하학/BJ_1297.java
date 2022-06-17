import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * TV 크기
 */
public class BJ_1297 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        double res = Math.sqrt(Math.pow(d,2) / (Math.pow(h,2)+Math.pow(w,2)));
        System.out.println((int)Math.floor(res*h) + " " + (int)Math.floor(res*w));
    }
}
