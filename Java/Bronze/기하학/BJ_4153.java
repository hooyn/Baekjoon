import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 직각삼각형
 */
public class BJ_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            double n = Double.parseDouble(st.nextToken());
            double m = Double.parseDouble(st.nextToken());
            double l = Double.parseDouble(st.nextToken());

            if(n==0 && m==0 && l==0) break;
            else{
                double max = Math.max(n, Math.max(m, l));

                if(max==n){
                    if(Math.pow(n, 2) == (Math.pow(m, 2) + Math.pow(l, 2))){
                        System.out.println("right");
                    } else {
                        System.out.println("wrong");
                    }
                } else if(max==m){
                    if(Math.pow(m, 2) == (Math.pow(n, 2) + Math.pow(l, 2))){
                        System.out.println("right");
                    } else {
                        System.out.println("wrong");
                    }
                } else if(max==l){
                    if(Math.pow(l, 2) == (Math.pow(m, 2) + Math.pow(n, 2))){
                        System.out.println("right");
                    } else {
                        System.out.println("wrong");
                    }
                }
            }
        }
    }
}
