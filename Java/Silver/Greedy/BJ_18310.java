import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 안테나
 */
public class BJ_18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int house_count = Integer.parseInt(br.readLine());

        int[] house_location = new int[house_count];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < house_count; i++) {
            int point = Integer.parseInt(st.nextToken());
            house_location[i] = point;
        }

        Arrays.sort(house_location);

        System.out.println(house_location[(house_count-1)/2]);
    }
}
