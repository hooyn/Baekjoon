import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 반복수열
 */
public class BJ_2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String start_num = st.nextToken();
        int mul_count = Integer.parseInt(st.nextToken());

        List<String> list = new ArrayList<>();
        list.add(start_num);

        while (true){
            int count = start_num.length();
            int sum = 0;
            for (int i = 0; i < count; i++) {
                int numericValue = Character.getNumericValue(start_num.charAt(i));
                int pow = (int) Math.pow(numericValue, mul_count);
                sum += pow;
            }
            start_num = String.valueOf(sum);
            if (list.contains(start_num)) {
                list.add(start_num);
                break;
            }
            list.add(start_num);

        }

        int idx = 0;
        while(true){
            String getString = list.get(idx);
            if(getString.equals(start_num)){
                break;
            }
            idx++;
        }

        System.out.println(idx);
    }
}
