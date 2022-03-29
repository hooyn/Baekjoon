import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 숫자 정사각형
 */
public class BJ_1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int min = Math.min(n,m);

        int result = 1;

        char[][] arr = new char[n][m];
        for (int i = 0; i < arr.length; i++) {
            String input = br.readLine();
            for (int j = 0; j < arr[i].length; j++) {
                char ch = input.charAt(j);
                arr[i][j] = ch;
            }
        } //배열 초기화

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < min; k++) {
                    if(i+k<n&&j+k<m){ //범위 내에 위치할 때
                        if(arr[i][j] == arr[i][j+k] && arr[i][j] == arr[i+k][j] && arr[i+k][j+k]==arr[i][j]){
                            int area = (k+1)*(k+1);
                            result = Math.max(area, result);
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}
