import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 카드 합체 놀이 실버 1
 */
public class BJ_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //카드의 개수와 합체를 하는 횟수
        int card_count = Integer.parseInt(st.nextToken());
        int union_count = Integer.parseInt(st.nextToken());

        //숫자를 오름차순으로 정렬하는 Priority Queue 선언
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());

        //카드 목록 배열
        for (int i = 0; i < card_count; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < union_count; i++) {

            //제일 작은 수 두개를 빼서
            Long first = pq.poll();
            Long second = pq.poll();

            //더한 후
            Long sum = first + second;

            //다시 Queue에 삽입
            pq.offer(sum);
            pq.offer(sum);
        }

        long result = 0;
        while(!pq.isEmpty()){
            result += pq.poll();
        }

        System.out.println(result);

    }
}
