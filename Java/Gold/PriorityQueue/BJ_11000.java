import java.io.*;
import java.util.*;

/**
* ㄱㅏㅇㅇㅡㅣㅅㅣㄹ ㅂㅐㅈㅓㅇ
*/
public class BJ_11000 {
    static int pi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = pi(br.readLine());
      
      	// 강의실 정보를 저장하기위한 배열을 생성하였습니다.
      	int[][] arr = new int[n][2];

      	for(int i = 0; i < n; i++){
          	StringTokenizer st = new StringTokenizer(br.readLine());
          	arr[i][0] = pi(st.nextToken());
          	arr[i][1] = pi(st.nextToken());
        }
      
      	Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
              	// 만약 시작시간이 같다면 끝나는 시간기준으로 오름차순 정렬합니다.
				if(o1[0] == o2[0]) return o1[1] - o2[1];
              
              	// 시작시간을 오름차순 정렬합니다.
              	return o1[0] - o2[0];
            }
        });
          
      	// 정렬된 강의정보에서 첫번째 정보를 가져와서 PQ에 저장합니다.
      	// 시작시간이 가장 짧으면서 끝나는 시간이 짧은 강의입니다.
      	PriorityQueue<Integer> pq = new PriorityQueue<>();
      	pq.offer(arr[0][1]);
      
      	for(int i = 1; i < n; i++){
          	// 강의 끝나는 시간이 다음 강의에 시작하는 시간보다 작거나 같으면 강의실을 추가하지 않아도 되므로
          	// PQ에서 제거하고 다음 강의의 끝나는 시간을 PQ에 저장합니다.
          	if(pq.peek() <= arr[i][0]) pq.poll();
          
          	// 강의의 끝나는 시간을 PQ에 저장합니다.
          	pq.offer(arr[i][1]);
        }
      
      	// 현재 PQ의 사이즈가 강의실의 개수이므로 PQ의 사이즈를 출력해줍니다.
      	System.out.println(pq.size());
    }
}
