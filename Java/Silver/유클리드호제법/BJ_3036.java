import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 링
 */
public class BJ_3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] radii = new int[testcase];
        for (int i = 0; i < testcase; i++) {
            radii[i] = Integer.parseInt(st.nextToken());
        }

        int criteria = radii[0];
        for (int i = 1; i < radii.length; i++) {
            int check_num = check(criteria, radii[i]);
            int left = criteria/check_num;
            int right = radii[i]/check_num;
            String result = left+"/"+right;
            System.out.println(result);
        }

    }
    public static int check(int a, int b){
        while (true) {
            int c = a % b;
            a = b;
            b = c;
            if(b==0) break;
        }
        return a;
    }
}
