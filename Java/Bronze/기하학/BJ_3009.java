import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 네 번째 점
 */
public class BJ_3009 {
    static class pair{
        int x;
        int y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pair p1 = null;
        pair p2 = null;
        pair p3 = null;
        pair p4 = new pair(0, 0);

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(i==0) p1 = new pair(x, y);
            if(i==1) p2 = new pair(x, y);
            if(i==2) p3 = new pair(x, y);
        }

        if(p1.x == p2.x){
            p4.setX(p3.x);
        } else if(p1.x == p3.x){
            p4.setX(p2.x);
        } else {
            p4.setX(p1.x);
        }

        if(p1.y == p2.y){
            p4.setY(p3.y);
        } else if(p1.y == p3.y){
            p4.setY(p2.y);
        } else {
            p4.setY(p1.y);
        }

        System.out.println(p4.getX() + " " + p4.getY());
    }
}
