import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 점 숫자
 */
public class BJ_8891 {
    static class Pair{
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            Pair pair1 = ReturnPair(first);
            Pair pair2 = ReturnPair(second);

            int r = pair1.row + pair2.row;
            int c = pair1.col + pair2.col;

            int k = r+c-1;
            int row = k;
            int col = 1;
            int sum = 1;

            for (int i = 1; i < k; i++) {
                sum += i;
            }

            while (true){
                if(row == r && col == c){
                    break;
                } else {
                    sum++;
                    row--;
                    col++;
                }
            }
            System.out.println(sum);
        }
    }

    private static Pair ReturnPair(int num) {
        int sum = 1;
        int cnt = 1;

        int row=1, col=1;

        while (true) {
            if(num >= sum && num < sum+cnt){
                row = cnt;
                break;
            } else {
                sum += cnt;
                cnt++;
            }
        }


        while (true) {
            if(sum==num){
                break;
            } else {
                sum++;
                row--;
                col++;
            }
        }

        return new Pair(row, col);
    }
}
