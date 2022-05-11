import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 맥주 마시면서 걸어가기
 */
public class BJ_9205 {
    static class pair{
        int row;
        int col;

        public pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            int beer = 20;
            int market_count = Integer.parseInt(br.readLine());
            int[][] market = new int[market_count][2];
            boolean[] visit_market = new boolean[market_count];

            int[] home = new int[2];
            int[] dest = new int[2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());

            Queue<pair> queue = new LinkedList<>();
            for (int j = 0; j < market_count; j++) {
                st = new StringTokenizer(br.readLine());
                market[j][0] = Integer.parseInt(st.nextToken());
                market[j][1] = Integer.parseInt(st.nextToken());

                if(Math.abs(home[0]-market[j][0])+Math.abs(home[1]-market[j][1])<=50*beer) {
                    queue.add(new pair(market[j][0], market[j][1]));
                }
            }

            st = new StringTokenizer(br.readLine());
            dest[0] = Integer.parseInt(st.nextToken());
            dest[1] = Integer.parseInt(st.nextToken());

            if(Math.abs(home[0]-dest[0])+Math.abs(home[1]-dest[1])<=50*beer){
                //현재 맥주로 바로 목적지에 갈 수 있다면
                System.out.println("happy");
            } else {
                while(true){
                    if(!queue.isEmpty()){
                        pair pi = queue.remove();
                        int row = pi.row;
                        int col = pi.col;

                        for (int j = 0; j < market_count; j++) {
                            if(!visit_market[j]){
                                if(Math.abs(row-market[j][0])+Math.abs(col-market[j][1])<=50*beer){
                                    visit_market[j] = true;
                                    queue.add(new pair(market[j][0], market[j][1]));
                                }
                            }
                        }

                        if(Math.abs(row-dest[0])+Math.abs(col-dest[1])<=50*beer){
                            System.out.println("happy");
                            break;
                        }
                    } else {
                        System.out.println("sad");
                        break;
                    }
                }
            }
        }
    }
}
