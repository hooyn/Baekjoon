import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수 이어 쓰기 1
 */
public class BJ_1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();

        long result = 0;
        int length = number.length();

        if(length==1){
            System.out.println(number);
        } else {
            for (int i = 0; i < length-1; i++) {
                if(i==0){
                    result += 9;
                } else {
                    result += 9*Math.pow(10,i)*(i+1);
                }
            }

            String maxNum = "1";
            for (int i = 1; i < length; i++) {
                maxNum += "0";
            }

            int finNum = Math.abs(Integer.parseInt(maxNum)-Integer.parseInt(number))+1;
            result += finNum*number.length();

            System.out.println(result);
        }
    }
}
