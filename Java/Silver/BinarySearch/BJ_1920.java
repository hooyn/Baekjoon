package jpabook.baekjoon.baek0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 수 찾기
 */
public class BJ_1920 {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            check(num);
        }
    }

    private static void check(int num) {
        int head = 0;
        int tail = list.size()-1;

        boolean check = false;

        int center_idx = (head+tail)/2;
        while(true){
            if(head>tail) break;

            int center = list.get(center_idx);
            if(center>num){
                tail = center_idx-1;
            } else if(center<num){
                head = center_idx+1;
            } else {
                check = true;
                break;
            }

            center_idx = (head+tail)/2;
        }

        if(check){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
