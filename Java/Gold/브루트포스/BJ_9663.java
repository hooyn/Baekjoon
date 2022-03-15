import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * N-Queen
 */
public class BJ_9663 {

    public static int[] chess;
    public static int n;
    public static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        chess = new int[n];

        nQueen(0);
        System.out.println(result);

    }

    public static void nQueen(int depth) {
        // 모든 Queen을 배치했다면 return
        if (depth == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            chess[depth] = i; //Queen 배치

            if (Check(depth)) {
                //만약 Queen을 배치할 수 있다면
                //재귀호출을 통해 다음 Queen배치
                nQueen(depth + 1);
            }
        }
    }

    public static boolean Check(int depth) {
        for (int i = 0; i < depth; i++) {

            // 같은 행에 위치하는 경우
            if (chess[depth] == chess[i]) {
                return false;
            }

            // 행의 차이 == 열의 차이 -> 대각선 상에 위치하는 경우
            else if (Math.abs(depth - i) == Math.abs(chess[depth] - chess[i])) {
                return false;
            }
        }

        return true;
    }
}
