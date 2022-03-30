import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 풍선 터뜨리기
 */
public class BJ_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } //배열 초기화

        StringBuffer sb = new StringBuffer();
        int check = 1; //시작하자마자 0번 index의 숫자를 없애기 때문에 1부터 시작
        int point = 0; //index를 가리키는 포인터 변수
        while (true) {
            sb.append(point+1).append(' '); //sb에 삭제하는 index저장 -> index는 0부터 시작이므로 +1을 해준다.
            if(check==n) break; //그리고 n번째 숫자를 터트렸을 때 while문 탈출
            int num = arr[point]; //arr[point]로 이동해야 할 칸수를 받고
            arr[point] = 0; //0은 없기 때문에 삭제한 것을 표시하기위해 0으로 바꿔준다.

            if(num<0){ //num이 음수라면 왼쪽으로 포인터 이동
                num = Math.abs(num); //이동한 횟수를 count하기 위해 절댓값으로 저장한다.
                int cnt = 0; //이동한 횟수를 저장할 변수
                while (true) {

                    point--; //왼쪽으로 포인터 이동
                    if(point==-1) point = n-1; //만약 포인터가 -1이라면 순환하기 위해 n-1로 이동시켜준다.

                    if(arr[point]!=0){ //그리고 삭제된 위치가 아니라면 아래 로직 진행
                        cnt++;
                        if(cnt==num){
                            check++; //몇개의 숫자 풍선을 터트렸는지 count
                            break;
                        }
                    }
                }
            } else if(num>0){ //num이 양수라면 오른쪽으로 포인터 이동
                int cnt = 0; //이동한 횟수를 저장할 변수
                while (true) {
                    point++; //오른쪽으로 포인터 이동
                    if(point==n) point = 0; //만약 포인터가 n이라면 순환하기 위해 0으로 이동시켜준다.

                    if(arr[point]!=0){ //삭제된 위치가 아니라면 아래 로직 진행
                        cnt++;
                        if(cnt==num){
                            check++; //몇개의 숫자 풍선을 터트렸는지 count
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
