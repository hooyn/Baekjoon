import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 하늘에서 정의가 빗발친다!
 */
public class BJ_13411 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double[][] arr = new double[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            double time = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))/v;
            arr[i][0] = i+1.0;
            arr[i][1] = time;
        }

        Arrays.sort(arr, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]>o2[0]?1:(o1[0]<o2[0]?-1:0);
                }
                return o1[1]>o2[1]?1:(o1[1]<o2[1]?-1:0);
            }
        });

        for (double[] doubles : arr) {
            System.out.println((int) doubles[0]);
        }
    }
}
