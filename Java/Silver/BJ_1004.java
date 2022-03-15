import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 어린 왕자
 */
public class BJ_1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()); //출발
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken()); //도착
            int y2 = Integer.parseInt(st.nextToken());

            int planet_count = Integer.parseInt(br.readLine());
            int result = 0; //진입,이탈 횟수

            for (int j = 0; j < planet_count; j++) { //행성 정보 저장

                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                double r = Double.parseDouble(st.nextToken());

                /**
                 * 행성을 진입/이탈 하는지 판단하는 로직
                 * 출발점과 도착점 중에 하나는 행성안에 있고
                 * 다른 한 점은 행성 밖에 있다면 진입 또는 이탈을
                 * 할 수 밖에 없게 된다.
                 */

                boolean start_check = false;
                boolean end_check = false;

                //시작점과 원의 중심과의 거리
                double start_point_size = Math.sqrt(Math.pow(x1 - cx, 2) + Math.pow(y1 - cy, 2)); 
              
                //도착점과 원의 중심과의 거리
                double end_point_size = Math.sqrt(Math.pow(x2 - cx, 2) + Math.pow(y2 - cy, 2));
              
                //start_point_size와 원의 반지름의 비교
                if(r>start_point_size) start_check = true;
              
                //end_point_size와 원의 반지름의 비교
                if(r>end_point_size) end_check = true;

                if(start_check&&!end_check){
                    result++;
                } else if(!start_check&&end_check){
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
