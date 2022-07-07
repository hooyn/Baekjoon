import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 공유기 설치
 */
public class BJ_2110 {
    static int pi(String s){return Integer.parseInt(s);}
    static List<Integer> houses = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //집의 개수와 공유기의 개수를 입력받았습니다.
        int number_houses = pi(st.nextToken());
        int number_routers = pi(st.nextToken());

        //집의 위치를 입력받아서 List에 저장하였습니다.
        for (int i = 0; i < number_houses; i++) {
            houses.add(Integer.valueOf(br.readLine()));
        }

        //집의 위치 정보 리스트를 정렬하겠습니다.
        Collections.sort(houses);

        //인접한 두 공유기 사이의 거리를 X로 하고 이분탐색을 이용하겠습니다.
        //최소값은 lo 최대값은 hi에 저장하고 사이의 값을 mid에 저장하겠습니다.
        int lo = 1;
        //첫번째 집과 마지막 집 사이의 거리를 구하였습니다.
        int hi = houses.get(number_houses-1) - houses.get(0) + 1;

        while(lo < hi){
            int mid = (lo + hi) / 2;

            //두 개의 공유기 사이의 거리를 기준으로 이분 탐색 시작하겠습니다.
            if(routerInstallation(mid) < number_routers){
                hi = mid;
            } else {
                lo = mid +1;
            }
        }


        //Upper Bound는 탐색 값을 초과하는 첫 번째 값을 가리키므로,
        //1을 빼준 값이 조건식을 만족하는 최댓값이 됩니다.
        System.out.println(lo-1);
    }

    private static int routerInstallation(int two_adjacent_router) {
        //첫 번째 집에 라우터 설치했습니다.
        int recent_installed = houses.get(0);

        //설치한 라우터의 개수입니다.
        int number_installed = 1;

        //집의 위치 정보를 탐색하면서 설치할 수 있는 집에 라우터를 설치하겠습니다.
        for (int i = 1; i < houses.size(); i++) {
            if(houses.get(i) - recent_installed >= two_adjacent_router){
                number_installed++;
                recent_installed = houses.get(i);
            }
        }

        return number_installed;
    }
}
