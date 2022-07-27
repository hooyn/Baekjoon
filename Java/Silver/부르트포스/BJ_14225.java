import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 부분수열의 합
 */
public class BJ_14225 {
    static int n;
    static int[] arr;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        int cnt = 1;
        while(true){
            if(set.contains(cnt)){
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int depth, int sum) {
        if(depth==n){
            set.add(sum);
        } else {
            dfs(depth+1, sum+arr[depth]);
            dfs(depth+1, sum);
        }
    }
}
