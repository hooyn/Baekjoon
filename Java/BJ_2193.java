import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이친수
 */
public class BJ_2193 {

    static Long[] list; //n==90일 때 int의 범위를 넘기 때문에 Long으로 해준다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new Long[n+1]; //list배열 초기화

        if(n==1){
            list[1] = 1L; //n==1일때는 list[2]를 초기화 할 수 없기 때문에 예외 처리를 해준다.
        } if(n>=2){ //n>=2일 때는 list[1] list[2]를 초기화해주고 find(n)을 호출한다.
            list[1] = list[2] = 1L;
        }
        System.out.println(find(n));
    }

    private static long find(int n) {
        if(list[n]==null){ //topdown방식으로 dp를 활용해서 푼다.
            list[n] = find(n-1)+find(n-2);
        }

        return list[n];
    }
}
