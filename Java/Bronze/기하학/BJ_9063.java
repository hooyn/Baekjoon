import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 대지
 */
public class BJ_9063 {
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = pi(br.readLine());

        int xMin = 10_001;
        int xMax = -10_001;
        int yMin = 10_001;
        int yMax = -10_001;

        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = pi(st.nextToken());
            int y = pi(st.nextToken());

            xMin = Math.min(x, xMin);
            xMax = Math.max(x, xMax);
            yMin = Math.min(y, yMin);
            yMax = Math.max(y, yMax);
        }

        int width = xMax-xMin;
        int height = yMax - yMin;

        System.out.println(width*height);
    }
}
