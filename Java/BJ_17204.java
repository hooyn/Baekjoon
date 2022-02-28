import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 죽음의 게임
 * DP: bottom up_방식
 */
public class BJ_17204 {

    static int[] list;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //참여하는 사람 수
        int k = Integer.parseInt(st.nextToken()); //보성이 번호

        list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(find(0, n, k));

    }

    public static int find(int n, int num, int k){
        cnt++;
        if(list[n]==k){
            // 보성이에게 최초로 도달 했다면 몇번만에 도달했는지 출력하기
            return cnt;
        } else if(cnt>num){
            // 만약 사람 인원수 보다 많이 이동했는데
            // 도달하지 못했다면 보성이에게 도달 할
            // 가능성이 없다고 판단하여 -1 출력하기
            return -1;
        } else {
            // 아직 도달하지 못한 경우이므로 list[n]을 n으로 하여
            // find를 다시 호출한다.
            // num, k는 그대로 같이 매개변수로 넣어준다.
            return find(list[n], num, k);
        }
    }
}
