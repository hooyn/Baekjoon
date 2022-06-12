import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 치킨 배달
 */
public class BJ_15686 {
    static class Coordinates{
        int x;
        int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static List<Coordinates> homeList = new ArrayList<>();
    static List<Coordinates> chickenList = new ArrayList<>();
    static int n;
    static int m;
    static int Min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        /**
         * 치킨집 좌표와 집의 좌표 저장
         */
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());

                if(num==1){
                    homeList.add(new Coordinates(i, j));
                }
                else if(num==2){
                    chickenList.add(new Coordinates(i, j));
                }
            }
        }

        int[] check = new int[m];
        find(0, 0, check);

        System.out.println(Min);
    }

    /**
     * 치킨집 m만큼 정하기
     */
    private static void find(int depth, int start, int[] check) {
        if(depth==m){
            /**
             * 집과 치킨집의 거리 최소값 구하기
             */
            Min = Math.min(Min, findDistance(check));

            return;
        }

        for (int i = start; i+(m-1-depth) < chickenList.size(); i++) {
            check[depth] = i;
            find(depth+1, i+1, check);
            check[depth] = 0;
        }
    }

    private static int findDistance(int[] check) {
        int min = 0;

        /**
         * 집과 치킨집의 최소 거리를 구해서 더하기
         */
        for (Coordinates home : homeList) {
            int x = home.x;
            int y = home.y;

            int distance = Integer.MAX_VALUE;

            for (int i = 0; i < check.length; i++) {
                Coordinates chicken = chickenList.get(check[i]);

                int dif = Math.abs(chicken.x - x) + Math.abs(chicken.y - y);
                distance = Math.min(distance, dif);
            }

            min += distance;
        }

        return min;
    }
}
