package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 택시 기하학
 */
public class BJ_3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br.readLine());

        System.out.println(r * r * Math.PI);
        System.out.println(r * r * 2);
    }
}
