import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 01타일
 * 00, 1로 만들 수 있는 수
 * N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개
 */
public class BJ_1904 {

    static String oo = "00";
    static String l = "1";
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            result = 1;
        } else if (n == 2) {
            result = 2;
        } else {
            find(n, "");
        }

        System.out.println(result);
    }

    //모든 경우의 수를 다 계산해서 답을 나타내려고 했지만
    //계속 메모리 초과 오류가 났다.
    //그래서 다른 방식으로 접근을 해봤다.
    //결과를 n=1부터 n=5정도 까지 나타내보니까 수가 피보나치 수의 수열처럼 증가하는 것을 파악했다.
    //다른 알고리즘을 통해서 풀자!

    public static void find(int n, String str){
        if(str.length()>n){
            return;
        } else if(str.length()==n){
            result = (result+1)%15746;
            return;
        } else {
            find(n, str+"00");
            find(n, str+"1");
        }
    }
}
