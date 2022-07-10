package DGIST_현풍전산배_알고리즘_대회_2022;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 에어컨 실버 4
 */
public class BJ_25044 {
    static class Time{
        int hour;
        int minute;

        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        public void addHour(int hour){
            this.hour += hour;
        }

        public void addMinute(int minute){
            this.minute += minute;
            if(this.minute >= 60){
                this.hour++;
                this.minute -= 60;
            }
        }

        public int getHour() {
            return hour;
        }

        public int getMinute() {
            return minute;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n==0 || k==0){
            System.out.println(3);
            System.out.println("15:00");
            System.out.println("18:00");
            System.out.println("21:00");
        } else {
            checkTime(n, k);
        }
    }

    private static void checkTime(int n, int k) {
        int day = 1;
        int[] dt = {3, 3, 18};
        int controller = 0;
        List<Time> list = new ArrayList<>();
        Time time = new Time(15, 00);
        while(true){
            if(n==day){
                list.add(new Time(time.getHour(), time.getMinute()));
                while(true){
                    time.addHour(dt[controller]);
                    if(controller==2){
                        time.addMinute(k);

                        if(time.getHour()>=24){
                            time.setHour(time.getHour()-24);
                            controller = (controller+1)%3;
                            break;
                        } else {
                            list.add(new Time(time.getHour(), time.getMinute()));
                            continue;
                        }
                    }

                    if(time.hour>=24){
                        time.setHour(time.getHour()-24);
                        controller = (controller+1)%3;
                        break;
                    }

                    list.add(new Time(time.getHour(), time.getMinute()));
                    controller = (controller+1)%3;
                }

                System.out.println(list.size());
                for (Time t : list) {
                    System.out.println(t.hour+":"+t.minute);
                }
                return;
            }

            while(true){
                time.addHour(dt[controller]);
                if(controller==2){
                    time.addMinute(k);
                    if(time.getHour()>=24){
                        time.setHour(time.getHour()-24);
                        controller = (controller+1)%3;
                        break;
                    }
                } else {
                    if(time.getHour()>=24){
                        time.setHour(time.getHour()-24);
                    }
                }
                controller = (controller+1)%3;
            }
            day++;
        }
    }
}
