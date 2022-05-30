import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 골드바흐의 추측
 */
public class BJ_6588 {
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        boolean[] prime = new boolean[1_000_001];
        prime[0]=prime[1]=prime[2] = true;
        for (int i = 2; i*i < 1000001; i++) {
            for (int j = i*i; j < 1000001; j+=i) {
                if(!prime[j]){
                    prime[j] = true;
                }
            }
        } //에라토스테네스의 체 이용해서 홀수 필터

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = pi(br.readLine());
            if(n==0) break;
            else {
                boolean check = false;
                for (int i = 2; i <= n/2; i++) {
                    if(!prime[i] && !prime[n-i]){
                        System.out.println(n + " = " + i + " + " + (n-i));
                        check = true;
                        break;
                    }
                }
                if(!check) System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}
