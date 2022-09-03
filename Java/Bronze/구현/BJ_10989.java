import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  수 정렬하기 3
 */
public class BJ_10989 {
    public static void main(String[] args) throws IOException {
        int[] cnt = new int[10_001]; //카운팅 정렬을 이용하기 위해 배열 선언

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            cnt[Integer.parseInt(br.readLine())] ++;
        }

        br.close();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10_001; i++) { //카운팅 정렬을 이용한 출력
            while(cnt[i] > 0){
                sb.append(i).append('\n');
                cnt[i]--;
            }
        }

        System.out.println(sb);
    }
}
