import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 * N과 M (9)
 */
public class BJ_15663 {
    static int n;
    static int m;
    static int[] arr;
    static int[] store;
    static boolean[] visited;
    static LinkedHashSet<String> list = new LinkedHashSet<>(); //값의 중복을 허용하지 않는 LinkedHashSet 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        store = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        find(0);

        for (String str : list) {
            System.out.println(str);
        }
    }

    private static void find(int depth) {
        if(depth==m){
            String str = "";
            for (int val : store) {
                str += val + " ";
            }
            list.add(str); //기존의 list.contains()로직 제거
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                store[depth] = arr[i];
                find(depth+1);
                visited[i] = false;
            }
        }
    }
}
