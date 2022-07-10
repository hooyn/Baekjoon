import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 에어컨 실버 4
 */
public class BJ_25044_solv {

    //분을 hh:mm 형태로 변환하는 클래스입니다.
    static class changeTimeFormat{
        int min;
        public changeTimeFormat(int min){
            this.min = min;
        }

        public String getTime(){
            //숫자는 항상 최소 2개의 숫자로 작성되어야 함을 나타내는 % 02d입니다.
            // 따라서 1을 입력하면 01이라고 표시되고 11을 입력하면 11이 됩니다.
            return String.format("%02d:%02d",(min/60)%24, min%60);
        }
    }

    //일 수를 분으로 변환하여 반환합니다.
    public static int dayToMin(int day){
        return day*24*60;
    }

    //통합된 분을 시로 변환하여 반환합니다.
    public static int minToHour(int min){
        return min/60;
    }

    //통합된 분에서 분으로 변환하여 반환합니다.
    public static int getMin(int min){
        return min%60;
    }

    public static List<changeTimeFormat> getStopTime(int day, int stopMin){
        //에어컨이 종료되는 시간의 간격입니다.
        int[] term = {3*60, 3*60, 18*60};
        List<changeTimeFormat> list = new ArrayList<>();

        int count = 0; //에어컨이 종료되는 횟수입니다.
        int min = 15*60; //처음 에어컨이 멈추는 시간입니다. 15:00
        int today = dayToMin(day); //오늘을 분으로 변환합니다.
        int tomorrow = dayToMin(day+1); //내일을 분으로 변환합니다.

        //종료시간이 내일보다 작으면 계속합니다.
        while(min<tomorrow){
            //오늘의 종료시간이라면
            if(min>=today){
                list.add(new changeTimeFormat(min));
            }

            min+=term[count%3];
            if(count%3==2) min+=stopMin;

            count++;
        }

        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<changeTimeFormat> list = getStopTime(n, k);

        System.out.println(list.size());
        for (changeTimeFormat time : list) {
            System.out.println(time.getTime());
        }
    }
}
