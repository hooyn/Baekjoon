import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 카드 정렬하기 골드4
 */
public class BJ_1715 {
    static class Card implements Comparable<Card>{
        int value;

        public Card(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Card o) {
            return this.value - o.value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        PriorityQueue<Card> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            pq.offer(new Card(val));
        }

        int sum = 0;
        while(pq.size()!=1){
            Card card1 = pq.poll();
            Card card2 = pq.poll();

            sum += card1.value + card2.value;
            Card card = new Card(card1.value + card2.value);
            pq.offer(card);
        }
        
        System.out.println(sum);
    }
}
