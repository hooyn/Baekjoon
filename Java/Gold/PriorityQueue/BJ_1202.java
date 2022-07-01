import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 보석 도둑
 */
public class BJ_1202 {
    static class Jewelry {
        int weight;
        int price;

        public Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int jewelry_count = Integer.parseInt(st.nextToken());
        int backpack_count = Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[jewelry_count];

        // 보석에 대한 정보를 입력받았습니다.
        for (int i = 0; i < jewelry_count; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            jewelries[i] = new Jewelry(w, p);
        }

        // 보석에 대한 정보를 정렬
        Arrays.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if(o1.weight == o2.weight){
                    return o2.price - o1.price; //내림차순
                }
                return o1.weight - o2.weight; //오름차순
            }
        });

        // 가방에 대한 정보를 입력받았습니다.
        int[] backpack_info = new int[backpack_count];
        for (int i = 0; i < backpack_info.length; i++) {
            backpack_info[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(backpack_info);

        PriorityQueue<Integer> pa = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        for (int i = 0, j = 0; i < backpack_info.length; i++) {

            // 현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣는다.
            while(j<jewelry_count && jewelries[j].weight <= backpack_info[i]){
                pa.offer(jewelries[j++].price);
            }

            // 우선순위에 들어간 값 중 가장 큰값 ans에 저장
            if(!pa.isEmpty()){
                ans += pa.poll();
            }
        }

        System.out.println(ans);
    }
}
