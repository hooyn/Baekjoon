package jpabook.baekjoon.baek0412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 예쁜 케이크
 */
public class BJ_24040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            BigInteger bigInteger = new BigInteger(br.readLine());
            BigInteger nine = new BigInteger("9");
            BigInteger three = new BigInteger("3");

            String s = bigInteger.remainder(nine).toString();

            if(bigInteger.remainder(nine).toString().equals("0") || bigInteger.remainder(three).toString().equals("2")){
                System.out.println("TAK");
            } else {
                System.out.println("NIE");
            }
        }
    }
}
