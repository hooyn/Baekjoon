import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 영역 구하기
 */
public class BJ_2583 {
    static int vertex;
    static int horizontal;
    static int[][] arr;
    static int count = 0;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        horizontal = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[vertex][horizontal];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int l = x1; l < x2; l++) {
                    arr[j][l] = 1;
                }
            } //직사각형 표시하기 (상하 반전으로 표시)
        }

        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < horizontal; j++) {
                if(arr[i][j] == 0){
                    count = 0; //영역의 크기를 저장하기 위한 변수 초기화
                    find(i, j);
                    list.add(count); //find()함수가 끝나고 영역의 크기를 list에 저장한다.
                }
            }
        }

        Collections.sort(list); //리스트를 정렬한 후

        System.out.println(list.size()); //영역의 개수
        for (Integer integer : list) { //영역의 크기를 출력한다.
            System.out.print(integer + " ");
        }
    }

    private static void find(int row, int col) {
        count++;
        arr[row][col] = -1;

        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int ddr = row + dr[i];
            int ddc = col + dc[i];

            if(ddr>=0&&ddr<vertex&&ddc>=0&&ddc<horizontal){ //범위 내에 있고,
                if(arr[ddr][ddc]==0){ //방문하지 않았고, 직사각형이 아니라면,
                    find(ddr, ddc); //find()호출
                }
            }
        }
    }
}
