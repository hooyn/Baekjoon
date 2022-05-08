import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1로 만들기 2 (스폐셜 저지)
 */
public class BJ_12852 {
    static int n;
    static int count = Integer.MAX_VALUE;
    static String result = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        find(n, 0, "");

        System.out.println(count);
        System.out.println(result);
    }

    private static void find(int num, int co, String str) {
        if(num<=0) return;

        if(num==1){
            if(count>co){
                str += num;
                count = co;
                result = str;
                return;
            }
        }

        if(num%3==0){
            String temp = str;
            find(num/3, co+1, str+=num+" ");
            str = temp;
        }
        if(num%2==0){
            String temp = str;
            find(num/2, co+1, str+=num+" ");
            str = temp;
        }
        String temp = str;
        find(num-1, co+1,  str+=num+" ");
        str = temp;
    }
}
