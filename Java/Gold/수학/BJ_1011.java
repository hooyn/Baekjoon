import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Fly me to the Alpha Centauri
 */
public class BJ_1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while(testCase-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int distance = y - x;

            int max = (int)Math.sqrt(distance);

            if(max == Math.sqrt(distance)) {
                System.out.println(max * 2 - 1);
            }
            else if(distance <= max * max + max) {
                System.out.println(max * 2);
            }
            else {
                System.out.println(max * 2 + 1);
            }
        }
    }
}

//참고: https://st-lab.tistory.com/79
