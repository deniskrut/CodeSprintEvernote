
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
        long[] arr = new long[N];
        long[] resarr = new long[N];
        ArrayList<Integer> zeros = new ArrayList<Integer>();
        long midRes = 1;
        for (int i = 0; i < N; i++){
            res = br.readLine();
            long ires = Long.parseLong(res);
            arr[i] = ires;
            if (ires != 0){
                if (i != 0) {
                    midRes *= ires;
                }
            } else {
                zeros.add(i);
            }
        }
        if (zeros.isEmpty()) {
            resarr[0] = midRes;
            for (int i = 1; i < N; i++){
                resarr[i] = (midRes / arr[i]) * arr[0];
            }
        }
        if (zeros.size() >= 1){
            for (int i = 0; i < N; i++){
                resarr[i] = 0;
            }
        }
        if (zeros.size() == 1){
            if (zeros.get(0) == 0) {
                resarr[0] = midRes;
            }
            else {
                resarr[zeros.get(0)] = midRes * arr[0];
            }
        }
        for (int i = 0; i < N; i++){
            System.out.println(resarr[i]);
        }
    }
}
