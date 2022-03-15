package jpabook.baekjoon.baek0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 나무 자르기
 * 톱날이 땅으로부터 H미터 위로 올라간다.
 * 높이가 H보다 큰 나무는 H 위의 부분이 잘릴 것이고,
 * 낮은 나무는 잘리지 않을 것이다.
 *
 * 나무의 높이가 20, 15, 10, 17이라고 하자.
 * 높이를 15로 지정했다면,
 * 나무를 자른 뒤의 높이는 15, 15, 10, 15가 될 것이고,
 * 상근이는 길이가 5인 나무와 2인 나무를 들고 집에 갈 것이다.
 *
 * M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값
 */
public class BJ_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tree_count = Integer.parseInt(st.nextToken());
        int tree_m = Integer.parseInt(st.nextToken());

        int[] tree_list = new int[tree_count];
        st = new StringTokenizer(br.readLine());

        int down = 0; //이분 탐색에 필요한 min
        int top = 0; //이분 탐색에 필요한 max
        int mid = 0;
        for (int i = 0; i < tree_list.length; i++) {
            tree_list[i] = Integer.parseInt(st.nextToken());
            if(tree_list[i]>top){
                top = tree_list[i]; //max설정
            }
        }

        while (top > down) {
            mid = (top+down)/2;
            long sum = 0;

            for (int tree : tree_list) {
                if(tree-mid>0){
                    sum += (tree-mid);
                }
            }

            //sum이 목표보다 작으면 더 내려서 더 많은 나무를 자른다.
            //sum이 목표보다 크면 더 올려서 더 적은 나무를 자른다.
            //tree를 자를 때 upper bound를 사용해서 목표를 초과하는 index를 구해서 -1을 한다.

            if(sum<tree_m){
                top = mid;
            } else {
                down = mid + 1;
            }
        }

        System.out.println(top-1);
    }
}

//참고: https://st-lab.tistory.com/270
