import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 쿼드트리
 */
public class BJ_1992 {
    static StringBuffer sb = new StringBuffer();
    static int[][] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.charAt(j)-'0';
            }
        }

        //탐색 시작
        find(0, 0, n);

        System.out.println(sb);
    }

    private static void find(int row, int col, int num) {
        boolean check = false;
        int criteria = arr[row][col];

        //해당 부분 같은 숫자인지 확인
        for (int i = row; i < row+num; i++) {
            for (int j = col; j < col+num; j++) {
                if(arr[i][j]!=criteria){ //같은 숫자가 아니라면 check값 변경해주고 break;
                    check = true;
                    break;
                }
            }
            if(check) break; //check값이 true로 변경되었다면 바로 반복만 빠져나오기
        }

        if(check){ //check값이 true라면 4개 부분으로 나눠서 다시 탐색
            sb.append('(');
            find(row, col, num/2);
            find(row, col+num/2, num/2);
            find(row+num/2, col, num/2);
            find(row+num/2, col+num/2, num/2);
            sb.append(')');
        } else {
            sb.append(criteria);
        }
    }
}
