import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 회의실 배정
 */
public class BJ_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] info = new int[n][2];
        for (int i = 0; i < info.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        //끝나는 시간을 기준으로 정렬
        Arrays.sort(info, new Comparator<int[]>(){
            /**
             * compare() 메서드는 비교 대상 2 개의 객체를 인자를 차례로 인자로 받습니다.
             * 첫번째 인자가 두번째 인자보다 작다면 음수, 같다면 0, 크다면 양수를 리턴하면 됩니다.
             * https://www.daleseo.com/java-comparable-comparator/
             *
             * 음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 변경된다
             * https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html
             */

            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]){ //끝나는 시간이 같다면 시작시간이 빠른 순으로
                    return o1[0] - o2[0];
                    //즉 o1이 크면 양수이므로 두 객체의 자리가 변경된다.
                    //그래서 큰 수가 오른쪽으로 이동 즉 오름차순 정렬
                    //o2[0] - o1[0]으로 하면 내림차순이 된다.
                }
                return o1[1] - o2[1];
            }
        });

        int result = 0;
        int end_time = 0;

        for (int i = 0; i < info.length; i++) {
            if(end_time<=info[i][0]){
                end_time=info[i][1];
                result++;
            }
        }

        System.out.println(result);
    }
}

/**
 * 참고: https://st-lab.tistory.com/145
 */
