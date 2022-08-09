import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 에너지 모으기
 */
public class BJ_16198 {
    static int max = 0;
    static int n;
    static List<Integer> list = new ArrayList<>();
    static int pi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = pi(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(pi(st.nextToken()));
        }

        dfs(0, list);

        System.out.println(max);
    }

    private static void dfs(int energy, List<Integer> list) {
        int listSize = list.size();

        if(listSize==2){
            max = Math.max(energy, max);
            return;
        }

        for (int i = 1; i < listSize-1; i++) {
            List<Integer> copyList = new ArrayList<>(list);
            energy += list.get(i - 1) * list.get(i + 1);
            copyList.remove(i);
            dfs(energy, copyList);
            energy -= list.get(i - 1) * list.get(i + 1);
        }
    }
}
