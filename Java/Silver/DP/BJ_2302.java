import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 극장 좌석
 */
public class BJ_2302 {
    static class pair{
        int x;
        int y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int m;
    static int pi(String s){return Integer.parseInt(s);}; // 형 변환을 위한 메서드
    static List<pair> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = pi(br.readLine());
        m = pi(br.readLine());

        int start = 1;
        for (int i = 0; i < m; i++) {
            int num = pi(br.readLine());
            list.add(new pair(start, num)); // 고정된 자리 제외하고 다른 집합의 index를 pair에 저장
            start = num+1;
        }
        list.add(new pair(start, n+1)); // 마지막 까지 index를 pair에 저장

        int[] arr = new int[41];
        // 각 자리 수에 따른 경우의 수 규칙 발견!
        // 피보나치처럼 arr[n] = arr[n-1] + arr[n-2];
        arr[0] = 1; //만약 n=1이고 vip좌석도 1이라면 곱하기 1을 result값이 변하지 않으므로 1로 설정
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        long result = 1;
        for (pair pair : list) { // pair에서 index범위를 꺼내서 자리를 배정할 수 있는 경우의 수 result에 곱하기
            int x = (pair.y - pair.x);
            result *= arr[x];
        }
        System.out.println(result);
    }
}
