package jpabook.baekjoon.baek0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 랜선 자르기
 */
public class BJ_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] line = new int[k];
        long min = 0;
        long max = 0;
        for (int i = 0; i < k; i++) {
            line[i] = Integer.parseInt(br.readLine());
            if(line[i]>max) max = line[i];
        }

        //만약 2개의 랜선을 갖고 있고 2개의 랜선 모두 길이가 1이라고 해보자. 즉 {1, 1} 인 것이다.
        //이 때, min은 초기값으로 0을 갖고, max는 1이 된다.

        //그리고 이분 탐색을 통해 mid = (max + min) / 2 를 하게 되면
        // mid = (0 + 1) / 2가 되므로 mid = 0이 된다.

        max++;

        while (max > min){
            long mid = (max+min) / 2;
            long sum = 0;

            for (int len : line) {
                sum += len/mid;
            }

            if(sum < n){
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min-1);
    }
}

//참조: https://st-lab.tistory.com/269
