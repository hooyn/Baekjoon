import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 암호 키
 */
public class BJ_1816 {
    static int bigPrime = 1_000_001;
    static boolean[] checkPrime = new boolean[bigPrime];
    static List<Integer> primeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        checkPrime[0]=checkPrime[1]=true;
        for (int i = 2; i*i < bigPrime; i++) {
            for (int j = i*i; j < bigPrime; j+=i) {
                if(!checkPrime[j]){
                    checkPrime[j] = true;
                }
            }
        }

        for (int i = 2; i < bigPrime; i++) {
            if(!checkPrime[i]){
                primeList.add(i);
            }
        }

        int testcase = Integer.parseInt(br.readLine());

        while(testcase-->0){
            long num = Long.parseLong(br.readLine());
            boolean check = false;

            for (int i = 0; i < primeList.size(); i++) {
                Integer div = primeList.get(i);
                if(num%div==0){
                    check = true;
                    break;
                }
            }

            if(check){
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
