import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1904_fibo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //결과가 규칙적으로 나온다.
        //1,2,3,5,8,13,21...피보나치 수의 수열처럼 증가

        if(n==1){
            System.out.println(1);
        } else if(n==2){
            System.out.println(2);
        } else {
            int[] ints = new int[n+1];
            ints[1] = 1;
            ints[2] = 2;
            for (int i = 3; i < n+1; i++) {
                ints[i] = (ints[i-1] + ints[i-2])%15746;
            }
            System.out.println(ints[n]);
        }
    }
}
