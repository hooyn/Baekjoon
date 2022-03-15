package jpabook.baekjoon.baek0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 카드2
 * 맨 앞 카드 버리고 맨 앞 카드 맨 뒤로 보내기
 * 반복 해서 카드가 1장 남을 때 까지 반복
 */
public class BJ_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.add(i+1);
        }

        while(deque.size()>1){
            deque.pollFirst();
            Integer integer = deque.pollFirst();
            deque.addLast(integer);
        }
        System.out.println(deque.peekFirst());
    }
}
