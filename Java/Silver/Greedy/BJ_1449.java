import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 수리공 항승
 *
 * 가장 왼쪽에서 정수만큼 떨어진 거리에 물이 샌다.
 * 길이가 L인 테이프를 무한개 가지고 있고,
 * 테이프를 이용해서 물을 막으려고 한다.
 * 물을 막을 때는 적어도 그 위치의 좌우 0.5만큼 간격을 줘야 물이 다시는 안샌다.
 *
 * 테이프의 최소 개수를 구하는 프로그램
 */
public class BJ_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int tape = 0;
        int point = 0;
        while(true){

            int now = list.get(point);
          
            //테이프를 썼을 때 최대로 커버할 수 있는 길이
            int constraint = now + l; 

            while(true){
                //다음 배수관을 탐색
                point++;
                //만약 저장되어 있는 배수관을 모두 탐색했으니 break;
                if(point>=list.size()) break;

                int next = list.get(point);
              
                //다음 배수관이 지금 사용한 테이프로 커버할 수 없다면 break;
                //커버할 수 있다면 커버할 수 없을 때까지 반복
                if(next>=constraint){
                    break;
                }
            }

            //하나의 테이프로 커버할 수 있는 모든 배수관을 막았으니 +1
            tape++;
          
            //배수관을 모두 막았다면 break;
            if(point>=list.size()) break;
        }

        //사용한 테이프 개수 출력
        System.out.println(tape);
    }
}
