import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 태권왕
 * A: 현재 점수만큼 점수를 얻을 수 있는 연속발차기: 상대 역시 3점을 득점
 * B: 1점을 얻는 연속 발차기
 */
public class BJ_14562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            System.out.println(find(s, t, 0));

        }
    }

    private static int find(int s, int t, int cnt) {
        if(s>t){ //s가 t보다 크다면 잘못된 경우이다
            return 1000;
            //Math.min으로 작은 값을 반환하기 때문에
            //이 방법은 틀린 방법이므로 큰 수를 반환한다.
        }
        if(s==t){ //s가 t랑 같아졌을 때의 cnt를 return해주어서 출력한다.
            return cnt;
        } else { //두가지 경우 중에 더 작은 값이 나오는 값을 return 해준다.
            int a = find(s+1, t, cnt+1);
            int b = find(s*2, t+3, cnt+1);
            return Math.min(a, b);
        }
    }
}
