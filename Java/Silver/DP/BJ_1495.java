import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 기타리스트
 */
public class BJ_1495 {
    static int n;
    static int s;
    static int m;
    static int[] arr;
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = pi(st.nextToken());
        s = pi(st.nextToken());
        m = pi(st.nextToken());

        arr = new int[m+1];
        for (int i = 0; i <= m; i++) {
            arr[i] = -1;
        }
        arr[s] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int v = pi(st.nextToken());
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= m; j++) {
                if(arr[j] == i-1){ // 현재의 곡을 치기 전에 쳤던 곡이 있다면
                    int out1 = j + v; // 그 곡의 v 더하기
                    int out2 = j - v; // 그 곡의 v 빼기

                    if(out1 >= 0 && out1 <= m){ //범위 내에 있다면
                        list.add(out1); //몇번째로 친 곡인지 저장
                    }
                    if(out2 >= 0 && out2 <= m){
                        list.add(out2);
                    }
                }
            }
            for (Integer n : list) {
                arr[n] = i;
            }
        }

        int max = -1;
        for (int i = 0; i <= m; i++) {
            if(arr[i] == n){
                max = Math.max(max, i);
            }
        }

        System.out.println(max);
    }
}
