import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 동혁 피자
 */
public class BJ_6502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        while (true){
            String input = br.readLine();
            if(input.equals("0")) break;
            else{
                StringTokenizer st = new StringTokenizer(input);
                int r = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                double circle = 2 * r;
                double square = Math.pow(w, 2) + Math.pow(l, 2);
                square = Math.sqrt(square);

                if(circle>=square){
                    System.out.println("Pizza " + count + " fits on the table.");
                } else {
                    System.out.println("Pizza " + count + " does not fit on the table.");
                }
                count++;
            }
        }
    }
}
