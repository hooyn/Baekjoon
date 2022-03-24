import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 안테나
 */
public class BJ_18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int house_count = Integer.parseInt(br.readLine());

        int min = 100001;
        int max = 0;

        int[] house_location = new int[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < house_count; i++) {
            int point = Integer.parseInt(st.nextToken());

            if(point<min) min = point;
            if(point>max) max = point;

            house_location[point]++;
        }

        int criteria = min;
        int result = 1000000000;
        int result_idx = 0;
        while (true) {
            int sum = 0;
            for (int i = min; i <= max; i++) {
                if(house_location[i]!=0){
                    sum += Math.abs(criteria-i)*house_location[i];
                }
            }
            if(sum<result) {
                result = sum;
                result_idx = criteria;
            }
            criteria++;
            if(criteria>max) break;
        }

        System.out.println(result_idx);
    }
}
