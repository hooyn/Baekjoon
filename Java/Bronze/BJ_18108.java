import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1998년생인 내가 태국에서는 2541년생?!
 */
public class BJ_18108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int trans = 2541-1998;

        System.out.println(N-trans);
    }
}
