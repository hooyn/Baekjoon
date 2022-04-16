import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * N과 M (12)
 */
public class BJ_15666 {
    static int n;
    static int m;
    static int[] arr;
    static LinkedHashSet<String> list = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        find(0, "", 0);

        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void find(int depth, String str, int start) {
        if(depth==m){
            list.add(str);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            String temp = str;
            str += (arr[i] + " ");
            find(depth+1, str, i);
            str = temp;
        }
    }
}
