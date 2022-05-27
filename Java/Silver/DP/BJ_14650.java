import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 걷다보니 신천역 삼 (Small)
 */
public class BJ_14650 {
    static int n = 0;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        find("", 0);

        System.out.println(result);
    }

    private static void find(String num, int depth) {
        if(depth==n){ // 자리수가 n일 때
            int x = Integer.parseInt(num);

            if(x%3==0){ // num이 3의 배수라면
                result++; // 경우의 수 증가
            }

            return;
        }

        if(depth==0){ // 첫번째 자리수는 1, 2만 가능
            find(num+"1", depth+1);
            find(num+"2", depth+1);
        } else { // 첫번째 자리수가 아니라면 0, 1, 2 가능
            find(num+"0", depth+1);
            find(num+"1", depth+1);
            find(num+"2", depth+1);
        }
    }
}
