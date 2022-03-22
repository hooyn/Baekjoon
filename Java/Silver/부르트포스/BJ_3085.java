import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 사탕 게임
 * 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y
 */
public class BJ_3085 {
    static int max = 0;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) { //가로 탐색
            for (int j = 0; j < n-1; j++) {
                if(arr[i][j] != arr[i][j+1]){
                    char temp = arr[i][j];
                    arr[i][j] = arr[i][j+1];
                    arr[i][j+1] = temp;
                    check(arr);
                    temp = arr[i][j];
                    arr[i][j] = arr[i][j+1];
                    arr[i][j+1] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) { //새로 탐색
            for (int j = 0; j < n-1; j++) {
                if(arr[j][i] != arr[j+1][i]){
                    char temp = arr[j][i];
                    arr[j][i] = arr[j+1][i];
                    arr[j+1][i] = temp;
                    check(arr);
                    temp = arr[j][i];
                    arr[j][i] = arr[j+1][i];
                    arr[j+1][i] = temp;
                }
            }
        }

        System.out.println(max);
    }

    public static void check(char[][] arr){
        for (int i = 0; i < n; i++) {
            int sum = 1;
            for (int j = 0; j < n-1; j++) {
                if(arr[i][j] == arr[i][j+1])
                    sum++;
                else
                    sum = 1;

                max = Math.max(max, sum);
            }
        }

        for (int i = 0; i < n; i++) {
            int sum = 1;
            for (int j = 0; j < n-1; j++) {
                if(arr[j][i] == arr[j+1][i])
                    sum++;
                else
                    sum = 1;

                max = Math.max(max, sum);
            }
        }
    }
}
