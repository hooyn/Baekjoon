import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 계란으로 계란치기
 */
public class BJ_16987 {
    static int n;
    static Egg[] eggs;
    static boolean[] breakCheck;
    static int max = 0;
    static class Egg{
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        eggs = new Egg[n];
        breakCheck = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            eggs[i] = new Egg(durability, weight);
        }

        breakEgg(0, 0);

        System.out.println(max);
    }

    private static void breakEgg(int num, int cnt) {
        if(num==n){
            max = Math.max(cnt, max);
            return;
        }

        if(eggs[num].durability<=0 || cnt == n-1){
            breakEgg(num+1, cnt);
            return;
        }

        int recoverCnt = cnt;
        for (int i = 0; i < n; i++) {
            if(i!=num && eggs[i].durability>0){
                eggs[num].durability -= eggs[i].weight;
                eggs[i].durability -= eggs[num].weight;

                if(eggs[num].durability<=0){
                    cnt++;
                }
                if(eggs[i].durability<=0){
                    cnt++;
                }

                breakEgg(num+1, cnt);

                cnt = recoverCnt;

                eggs[num].durability += eggs[i].weight;
                eggs[i].durability += eggs[num].weight;
            }
        }
    }
}
