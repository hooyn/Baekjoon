import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두 수의 합
 */
public class BJ_3273 {
    static int m;
    static int n;
    static int[] arr;
    static int result = 0;

    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } //수 배열 저장

        m = Integer.parseInt(br.readLine()); //목표 값

        Arrays.parallelSort(arr);

        int start = 0;
        int end = n-1;
        int sum = 0;
        while (start<end){
            sum = arr[start]+arr[end];
            if(sum==m){
                result++;
            }

            if(sum<=m){
                start++;
            } else {
                end--;
            }
        }

        System.out.println(result);
    }
}
