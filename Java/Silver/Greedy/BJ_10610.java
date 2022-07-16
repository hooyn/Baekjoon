import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 30 실버 4
 *
 * 조건 1) 30으로 나누기 위해서는 0이 있어야 합니다.
 * 조건 2) 3의 배수는 각 자리수의 합이 3으로 나누어떨어져야 합니다.
 */
public class BJ_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] arr = new int[10]; //각 자리수 count
        long sum = 0; //자리수의 합
        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            arr[num]++;
            sum += num;
        }

        String result = ""; //결과 값 변수 생성
        if(arr[0]>0 && sum%3==0){ //조건 1과 2가 만족한다면
            int idx = 9; //가장 큰수를 구해야하기 때문에 9부터 result에 추가

            while(true){ 
                int count = arr[idx]; //가장 큰수의 개수를 구해서

                for (int i = 0; i < count; i++) { //result에 넣어주기
                    result += idx;
                }

                idx--; //다음으로 큰 수

                if(idx<0){ //만약 0까지 수들을 모두 넣었다면 break;
                    break;
                }
            }

            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
}
