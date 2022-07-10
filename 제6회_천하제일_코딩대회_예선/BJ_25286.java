import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11월 11일 브론즈 3
 */
public class BJ_25286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while(tc-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());

            System.out.println(search_d_day(year, month));
        }
    }

    // month월 month일의 month일 전의 날짜를 구하는 메서드
    private static String search_d_day(int year, int month) {
        int y = year;
        int m = month;
        int d = month;
        
        int cnt = month;
        
        while(cnt-->0){
            d--;
            if(d==0){
                m--;
                if(m==0){
                    y--;
                    m=12;
                    d=31;
                } else if(m==2){
                    if(check_year(y)){
                        d=29;
                    } else {
                        d=28;
                    }
                } else if(m==1 || m==3 || m==5 || m==7 || m==8 || m==10){
                    d=31;
                } else {
                    d=30;
                }
            }
        }
        
        return y + " " + m + " " + d;
    }

    //윤년을 확인하는 메서드
    private static boolean check_year(int year){
        if(year%400==0) return true;
        else{
            if(year%100!=0 && year%4==0){
                return true;
            } else {
                return false;
            }
        }
    }
}
