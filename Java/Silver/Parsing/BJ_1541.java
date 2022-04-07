import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 잃어버린 괄호
 */
public class BJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int result = 0;

        StringTokenizer st = new StringTokenizer(input, "-");

        List<Integer> list = new ArrayList<>();
        int st_size = st.countTokens();
        for (int i = 0; i < st_size; i++) {
            String token = st.nextToken();

            int sum = 0;
            StringTokenizer sst = new StringTokenizer(token, "+");
            //+부터 먼저 계산하고 -계산하기
            int sst_size = sst.countTokens();
            for (int j = 0; j < sst_size; j++) {
                int n = Integer.parseInt(sst.nextToken());
                sum += n;
            }

            list.add(sum);
        }

        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            if(i==0){
                result += integer;
            } else {
                result -= integer;
            }
        }

        System.out.println(result);
    }
}

//참고: https://st-lab.tistory.com/148
