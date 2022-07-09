import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 심준의 병역판정검사 브론즈3
 */
public class BJ_25285 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while(tc-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int length = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            System.out.println(military_service_check(length, weight));
        }
    }

    static int military_service_check(int length, int weight){
        double bmi = bmi(length, weight);

        if(length<=140){
            return 6;
        } else if(length>=140.1 && length < 146) {
            return 5;
        }else if(length>=146 && length<159){
            return 4;
        } else if(length>=159 && length <161){
            if(bmi<16 || bmi >= 35){
                return 4;
            } else return 3;
        } else if(length>=161 && length < 204){
            if(bmi < 16 || bmi >= 35) return 4;
            else if((bmi>=16&&bmi<18.5) || (bmi>=30&&bmi<35)) return 3;
            else if((bmi>=18.5&&bmi<20) || (bmi>=25&&bmi<30)) return 2;
            else return 1;
        } else {
            return 4;
        }
    }

    static double bmi(int length, int weight){
        double m2 = Math.pow((length*0.01), 2);
        return weight / m2;
    }
}
