package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;;

/**
 * 수 정렬하기 2
 */
public class BJ_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.valueOf(br.readLine()));
        }

        Collections.sort(list);

        StringBuffer sb = new StringBuffer();
        for (Integer integer : list) {
            sb.append(integer+"\n"); // 시간초과가 되지 않기 위해 Buffer에 모아서 한번에 출력 진행
        }

        System.out.println(sb);
    }
}
