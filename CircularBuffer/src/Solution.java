
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denis
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String res = br.readLine();
        int N = Integer.parseInt(res);
        String[] buff = new String[N];
        int start = 0;
        int count = 0;
        while (true) {
            res = br.readLine();
            String[] command = res.split(" ");
            if ("A".equals(command[0])){
                int cnt = Integer.parseInt(command[1]);
                for (int i = 0; i < cnt; i++){
                    res = br.readLine();
                    Integer pos = (start + count) % N;
                    buff[pos] = res;
                    if (count < N) {
                        count++;
                    } else {
                        start++;
                    }
                }
            }
            if ("R".equals(command[0])){
                int cnt = Integer.parseInt(command[1]);
                count-=cnt;
                start+=cnt;
                if (count < 0) {
                    count = 0;
                }
            }
            if ("L".equals(command[0])){
                for (int i = start; i < start+count; i++){
                    Integer pos = (i) % N;
                    System.out.println(buff[pos]);
                }
            }
            if ("Q".equals(command[0])){
                break;
            }
        }
    }
}
