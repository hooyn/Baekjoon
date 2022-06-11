import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 블랙잭 Bronze2
 */
public class BJ_2798 {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;
    static int sum = 0;
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = pi(st.nextToken());
        m = pi(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = pi(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    int temp = arr[i] + arr[j] + arr[k];
                    if(sum<temp && temp<=m){
                        sum = temp;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
