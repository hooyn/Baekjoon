import java.io.*;

/**
 * 별 찍기 - 10
 */
public class BJ_2447 {
    static int n;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        recursion(0, 0, n, false);

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    private static void recursion(int row, int col, int n, boolean check_blank) {

        if(check_blank){
            for (int i = row; i < row+n; i++) {
                for (int j = col; j < col+n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if(n==1){
            arr[row][col] = '*';
            return;
        }

        int size = n/3;
        int count = 0;
        for (int i = row; i < row + n; i += size) {
            for (int j = col; j < col + n; j += size) {
                count++;
                if(count==5){
                    recursion(i, j, size, true);
                } else {
                    recursion(i, j, size, false);
                }
            }
        }
    }
}

//참조: https://st-lab.tistory.com/95
