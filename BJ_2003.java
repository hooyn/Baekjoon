import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수들의 합
 */
public class BJ_2003 {
    static int[] arr;
    static int n;
    static int m;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } //배열 초기화

        int cnt = 0;
        while (cnt<n) {
            int sum = 0; //Arr 합 저장하기 위한 변수
            for (int i = cnt; i < n; i++) { //cnt~n까지 반복
                sum += arr[i]; //sum에 Arr[i] 더하기
                if(sum==m) {
                    result++; //만약 sum==m이라면 전역변수 result 1증가
                    break; //for문 나가기
                }
                else if(sum>m) break; //sum이 m보다 커졌을 때도 더이상 계산할 필요 없으므로 for문 나가기
            }
            if(sum<m){
                break; //sum이 m보다 작다면 이후에 cnt를 증가시켜도 조건을 만족하는 경우가 없으므로  while문 나오기
            }
            cnt++;
        }
        System.out.println(result);
    }
}
