import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 앵그리 창영
 */
public class BJ_3034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        double max = Math.sqrt(Math.pow(w,2) + Math.pow(h,2));
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x<=max){
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
