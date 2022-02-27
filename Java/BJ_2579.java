import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 계단 오르기
 * 마지막 계단은 무조건 밟아야하므로
 * top-down방식으로 풀기
 */
public class BJ_2579 {

    static Integer[] score;
    static int[] floor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int floor_count = Integer.parseInt(br.readLine()); //계단 개수 받기
        floor = new int[floor_count+1]; //계단의 점수를 저장하기 위한 배열 선언
        score = new Integer[floor_count+1]; //점수의 합을 저장하기 위한 배열

        for (int i = 1; i <= floor_count; i++) { //계단의 점수를 배열에 저장
            floor[i] = Integer.parseInt(br.readLine());
        }

        //동적 계획법 사용해서 풀기
      
        score[0] = floor[0];
        score[1] = floor[1];

        if(floor_count >= 2){
            score[2] = floor[1] + floor[2];
        }

        System.out.println(dp(floor_count));

    }

    static int dp(int n){
        if(score[n]==null){
            score[n] = Math.max(dp(n-2), dp(n-3) + floor[n-1]) + floor[n];
        }

        return score[n];
    }
}
