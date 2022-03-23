import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 패션왕 신해빈
 */
public class BJ_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                if(map.containsKey(type)){
                    map.put(type, map.get(type)+1);
                } else {
                    map.put(type, 1);
                }
            }

            int result = 1;
            for (Integer value : map.values()) {
                //순열 사용 예를 들어 2종류의 옷이 있으면 2종류의 옷을 입는경우와 
                // 입지않는 경우 3가지 경우중에 1가지 고르기!!
                //+1을 해주는 이유는 안입는 경우도 생각했기 때문
                result *= (value+1); 
            }

            //아무것도 입지 않는 경우의 수 1 빼기
            System.out.println(result-1);

        }
    }
}
