import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 완전 이진 트리
 */
public class BJ_9934 {
    static int level;
    static int count;
    static int[] arr;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        level = Integer.parseInt(br.readLine());
        count = (int) (Math.pow(2.0, (double) level) - 1);
        arr = new int[count];

        list = new ArrayList[level];
        for (int i = 0; i < level; i++) {
            list[i] = new ArrayList<Integer>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        find(0, count, 0);

        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static void find(int start, int size, int level) {
        if(size==1){
            list[level].add(arr[start]);
            return;
        }

        int idx = size/2;
        list[level].add(arr[start+idx]);

        find(start, idx, level+1);
        find(start+idx+1, idx, level+1);
    }
}
