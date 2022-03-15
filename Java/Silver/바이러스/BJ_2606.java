import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 바이러스
 */
public class BJ_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer_size = Integer.parseInt(br.readLine());
        int input_size = Integer.parseInt(br.readLine());

        int[][] network = new int[input_size][2]; //input 저장
        boolean[] result = new boolean[computer_size];
        int ans = 0;
        result[0] = true;

        for (int i = 0; i < input_size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                network[i][0] = x;
                network[i][1] = y;
        }

        for (int i = 0; i < input_size; i++) {
            int x = network[i][0];
            int y = network[i][1];

            if(result[x]){
                if(!result[y]){
                    result[y] = true;
                    i = -1;
                }
            } else if(result[y]){
                if(!result[x]){
                    result[x] = true;
                    i = -1;
                }
            } else {

            }
        }

        for (boolean b : result) {
            if(b){
                ans++;
            }
        }
        System.out.println(ans-1);
    }
}
