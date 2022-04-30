package jpabook.baekjoon02.baek0430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 나이트의 이동
 */
public class BJ_7562 {
    static class pair{
        int row;
        int col;

        public pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {

            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            Queue<pair> queue = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur_row = Integer.parseInt(st.nextToken()); //현재 나이트의 위치 정보 row
            int cur_col = Integer.parseInt(st.nextToken()); //현재 나이트의 위치 정보 col
            queue.add(new pair(cur_row, cur_col));

            st = new StringTokenizer(br.readLine());
            int point_row = Integer.parseInt(st.nextToken()); //도착 위치 정보 row
            int point_col = Integer.parseInt(st.nextToken()); //도착 위치 정보 col
            arr[point_row][point_col] = -1;

            if((cur_row==point_row) && (cur_col==point_col)) {
                System.out.println(0);
                continue;
            }

            boolean check = false;
            while (!queue.isEmpty()){
                int[] d_row = {2, 1, -1, -2, -2, -1, 2, 1}; //나이트가 이동할 수 있는 범위 row
                int[] d_col = {1, 2, -2, -1, 1, 2, -1, -2}; //나이트가 이동할 수 있는 범위 col

                pair pa = queue.poll();
                for (int j = 0; j < 8; j++) {
                    int dd_row = pa.row + d_row[j];
                    int dd_col = pa.col + d_col[j];

                    if(dd_row>=0&&dd_col>=0&&dd_row<n&&dd_col<n){ //범위 내에 있고,
                        if(arr[dd_row][dd_col]==-1){ //-1이라면 도착위치니까 while문 빠져나가기
                            check = true;
                            arr[dd_row][dd_col] = arr[pa.row][pa.col] + 1;
                            break;
                        } else if(arr[dd_row][dd_col]==0){ //0이면 방문하지 않은 곳이기 때문에 현재 이동 한 횟수 +1
                            arr[dd_row][dd_col] = arr[pa.row][pa.col] + 1;
                            queue.add(new pair(dd_row, dd_col));
                        }
                    }
                }

                if(check) break;
            }

            System.out.println(arr[point_row][point_col]);
        }
    }
}
