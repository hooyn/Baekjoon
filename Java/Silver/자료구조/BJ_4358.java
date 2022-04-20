package baek0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 생태학
 */
public class BJ_4358 {
    static Map<String, Integer> map = new LinkedHashMap<>();
    static double total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        while(true){
            map.put(input, map.getOrDefault(input, 0) + 1);
            total++;

            input = br.readLine();
            if(input == null || input.length() == 0){
                break;
            }
        }

        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);

        for (Object key : keys) {
            String keyStr = (String) key;
            int count = map.get(keyStr);
            double per = (double)(count * 100.0) / total;

            System.out.println(keyStr + " " + String.format("%.4f", per));
        }
    }
}
