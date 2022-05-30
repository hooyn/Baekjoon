import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 신입 사원
 */
public class BJ_1946 {
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = pi(br.readLine());

        while(testcase-->0){
            int n = pi(br.readLine());
            int[][] arr = new int[n][2];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                arr[i][0] = pi(st.nextToken());
                arr[i][1] = pi(st.nextToken());
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int min = arr[0][1]; //1등의 면접 등수 저장
            int result = 1; //1등은 뽑고
            for (int i = 1; i < n; i++) {
                //만약 면접 등수가 기존의 최소 등수 보다 작다면 채용!
                //그리고 min 초기화
                if(arr[i][1] < min){
                    result++;
                    min = arr[i][1];
                }
            }

            System.out.println(result);
        }
    }
}
