import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 삼각형과 세 변
 */
public class BJ_5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            String result = "";

            if(a==0 && b==0 && c==0) break;

            String answer = triangle(a,b,c);
            System.out.println(answer);
        }
    }

    private static String triangle(int a, int b, int c) {
        int key = Math.max(a, Math.max(b, c));

        if(key==a){
            if(a>=b+c) {
                return "Invalid";
            }
        } else if(key==b){
            if(b>=a+c) {
                return "Invalid";
            }
        } else{
            if(c>=b+a) {
                return "Invalid";
            }
        }

        if(a==b && b==c) return "Equilateral";
        else if((a==b && b!=c) || (a==c && b!=c) || (b==c && a!=b)) return "Isosceles";
        else if(a!=b && b!=c && a!=c) return "Scalene";

        return null;
    }
}
