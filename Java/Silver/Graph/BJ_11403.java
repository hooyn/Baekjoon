import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 경로 찾기
 */
public class BJ_11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //플로이드 와샬 알고리즘 사용
        //참고: https://steady-coding.tistory.com/94
        for (int k = 0; k < arr.length; k++) { //거쳐가는 지점
            for (int i = 0; i < arr.length; i++) { //출발하는 지점
                for (int j = 0; j < arr.length; j++) { //도착하는 지점
                    if(arr[i][k]==1 && arr[k][j]==1){
                        arr[i][j] = 1;
                    }
                }
            }
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
