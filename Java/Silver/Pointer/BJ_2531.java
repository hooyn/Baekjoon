import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 회전 초밥
 */
public class BJ_2531 {
    static int n;
    static int d;
    static int k;
    static int c;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //접시의 수
        d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
        k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
        c = Integer.parseInt(st.nextToken()); //쿠폰 번호

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j != (i+k)%n; j=(j+1)%n) {
                set.add(arr[j]);
            }
            set.add(c);
            count = Math.max(count, set.size());
        }

        System.out.println(count);
    }
}
