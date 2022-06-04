import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 사분면 고르기
 */
public class BJ_14681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        if(n>0 && m>0){
            System.out.println("1");
        } else if(n<0 && m>0){
            System.out.println("2");
        } else if(n<0 && m<0){
            System.out.println("3");
        } else {
            System.out.println("4");
        }
    }
}
