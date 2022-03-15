package baek0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 토너먼트
 */
public class BJ_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int kim_no = Integer.parseInt(st.nextToken());
        int lim_no = Integer.parseInt(st.nextToken());

        Integer[] member = new Integer[n+1];
        for (int i = 1; i <= n; i++) {
            member[i] = i;
        } // member 배열 초기화

        int round = 1;
        boolean check = false;
        while (true) {
            int cnt=1;
            int decrease = 0;
            for (int i = 1; i < n; i+=2) {
                if((i==kim_no&&i+1==lim_no)||(i+1==kim_no&&i==lim_no)){
                    //김지민과 임한수가 만났을 때
                    check=true;
                } else if(i==kim_no||i+1==kim_no){
                    //김지민일 때
                    member[cnt]=cnt;
                    member[cnt+1]=null;
                    kim_no=cnt;
                }  else if(i==lim_no||i+1==lim_no){
                    //임한수일 때
                    member[cnt]=cnt;
                    member[cnt+1]=null;
                    lim_no=cnt;
                } else{
                    //둘다 아닐 때
                    member[cnt]=cnt;
                    member[cnt+1]=null;
                }
                decrease++;
                cnt++;
            }
            if(n%2==1){
                member[cnt] = member[n];
                member[n] = null;
            }

            n = n - decrease;

            if(!check) {
                round++;
            }
            else break;
        }

        System.out.println(round);
    }
}
