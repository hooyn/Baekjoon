import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 단어 정렬 실버 5
 */
public class BJ_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if(!list.contains(input)){
                list.add(input);
            }
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        for (String s : list) {
            System.out.println(s);
        }
    }
}
