import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 하키
 */
public class BJ_1358 {
    static int pi(String s){return Integer.parseInt(s);}
    static int result = 0;
    static int w, h, x, y, p, r;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = pi(st.nextToken());
        h = pi(st.nextToken());
        x = pi(st.nextToken());
        y = pi(st.nextToken());
        p = pi(st.nextToken());
        r = h/2;

        while(p-->0){
            st = new StringTokenizer(br.readLine());

            int xx = pi(st.nextToken());
            int yy = pi(st.nextToken());

            if(checkCircle(xx, yy, x, y+r)){
                result++;
                continue;
            } else if(checkCircle(xx, yy, x+w, y+r)){
                result++;
                continue;
            } else if(checkSquare(xx, yy)){
                result++;
                continue;
            }
        }

        System.out.println(result);
    }

    public static boolean checkCircle(int x1, int y1, int x2, int y2){
        double distance = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
        if(distance <= r){
            return true;
        } else return false;
    }

    public static boolean checkSquare(int x1, int y1){
        if(x1 >= x && x1 <= x+w && y1 >= y && y1 <= y+h){
            return true;
        } else return false;
    }
}
