import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 프린터 큐
 */
public class BJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int doc_count = Integer.parseInt(st.nextToken()); //문서의 개수
            int find_doc_idx = Integer.parseInt(st.nextToken()); //찾아야 하는 문서의 index
            int[] doc_list = new int[doc_count]; //문서의 우선순위를 저장할 배열

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < doc_list.length; j++) {
                doc_list[j] = Integer.parseInt(st.nextToken());
            } // 우선순위 저장

            if(doc_count==1){
                System.out.println(1); //만약 문서의 개수가 1개이면 무조건 출력이 1이므로 따로 처리해준다.
            } else {
                //그렇지 않다면 Queue 의 자료구조를 생각하면서 배열을 처리해준다.
                int result = 0; //프린터가 완료된 문서의 개수를 저장하기 위한 변수
                int cnt = 0; //Queue 자료구조처럼 동작하기 위해서 배열의 index 를 저장하기 위한 변수
                while(true){
                    int doc = doc_list[cnt]; //0부터 우선순위를 뽑아서
                    if(doc != -1){ //처리안된 문서일 때만 처리 (아래에 설명)
                        boolean check = false;
                        //나머지 문서들의 우선순위가 현재 문서의 우선순위보다 낮거나 같은지 확인
                        //그렇지 않다면 check 변수를 true 로 해주어서 밑에서 처리해준다.
                        for (int j = (cnt+1)%doc_count; j != cnt; j = (j+1)%doc_count) {
                            //현재의 문서 다음부터 반복문을 돌면서 우선순위를 비교한다.
                            if(doc<doc_list[j]) {
                                //만약 우선순위가 더 높은 문서가 나온다면 check 값을 true 로 바꿔준다.
                                check = true;
                                break;
                                //그리고 while문 빠져나와서 다음 문서 처리하기;
                            }
                        }

                        if(!check){
                            //위에서 반복문을 통해서 우선순위가 더 높은 문서가 없으므로 -1로 처리된 문서임을 나타낸다.
                            doc_list[cnt] = -1;
                            result++;
                            if(cnt==find_doc_idx){
                                break; //그리고 만약 현재 처리된 문서가 우리가 찾고 있던 문서라면 바로 while문 종료
                            }
                        }
                    }

                    cnt = (cnt+1)%doc_count;
                }
                System.out.println(result);
            }
        }
    }
}
