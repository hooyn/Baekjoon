import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 단지번호붙이기
 */
public class BJ_2667 {
    static int count = 0;
    static int home = 0;
    static char[][] arr;
    static int n;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new char[n][n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j] == '1'){
                    home = 0; //단지내 가구의 수를 구하기 위한 변수 초기화
                    find(i, j);
                    list.add(home); //탐색 후에 home값을 list에 저장
                    count++; //한개의 단지의 탐색이 끝난 후 단지 수에 해당하는 변수 증가
                }
            }
        }

        Collections.sort(list); //단지 내 가구 수에 해당하는 리스트 정렬

        System.out.println(count);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    private static void find(int row, int col) {
        home++; //단지 내 가구 수 구하기 위한 변수 증가
        arr[row][col] = '-'; //방문한 가구를 '-'로 변경

        int[] dr = {0, 0, 1, -1}; // 배열의 상하좌우를 조사하기 위한 변수 배열
        int[] dc = {-1, 1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int ddr = row + dr[i];
            int ddc = col + dc[i];

            if((ddr>=0&&ddr<n) && (ddc>=0&&ddc<n)){ //범위내에 있고
                if(arr[ddr][ddc]=='1'){ //방문하지 않은 집이 있다면 find()를 통해 탐색
                    find(ddr, ddc);
                }
            }
        }
    }
}
