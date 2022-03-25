import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 후위 표기식2
 */
public class BJ_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String postfix = br.readLine();

        double[] abc = new double[n]; //65(A)~90(Z)
        for (int i = 0; i < n; i++) {
            abc[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> operand = new Stack<>();
        int len = postfix.length();
        for (int i = 0; i < len; i++) {
             char ch = postfix.charAt(i);
             if('A' <= ch && ch <= 'Z'){
                 double d = abc[ch - 'A'];
                 operand.push(d);
             } else {
                 double d1 = operand.pop();
                 double d2 = operand.pop();
                 double d3 = 0.0;
                 switch (ch){
                     case '+':
                         d3 = d2 + d1;
                         break;
                     case '-':
                         d3 = d2 - d1;
                         break;
                     case '*':
                         d3 = d2 * d1;
                         break;
                     case '/':
                         d3 = d2 / d1;
                         break;
                 }
                 operand.push(d3);
             }
        }
        System.out.println(String.format("%.2f", operand.pop()));
    }
}
