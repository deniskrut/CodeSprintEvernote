
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author denis
 */
public class Solution {
    static int[] top = new int[4];
    static int smallestIndex = 0;
    static int smallestValue = 0;
    
    public static void getSmallest(){
        if (top[0] < top[1])
            if (top[2]<top[3])
                if (top[0]<top[2])
                    smallestIndex = 0;
                else
                    smallestIndex = 2;
            else
                if (top[0]<top[3])
                    smallestIndex = 0;
                else
                    smallestIndex = 3;
        else
            if (top[2]<top[3])
                if (top[1]<top[2])
                    smallestIndex = 1;
                else
                    smallestIndex = 2;
            else
                if (top[1]<top[3])
                    smallestIndex = 1;
                else
                    smallestIndex = 3;
        smallestValue = top[smallestIndex];
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String res = br.readLine();
        int N = Integer.parseInt(res);
        for (int i = 0; i < 4; i++) {
            res = br.readLine();
            top[i] = Integer.parseInt(res);
        }
        getSmallest();
        for (int i = 4; i < N; i++) {
            res = br.readLine();
            int curVal = Integer.parseInt(res);
            if (curVal > smallestValue){
                top[smallestIndex] = curVal;
                getSmallest();
            }    
        }
        Arrays.sort(top);
        top[0]=top[0] ^ top[3];
        top[3]=top[0] ^ top[3];
        top[0]=top[0] ^ top[3];
        top[1]=top[1] ^ top[2];
        top[2]=top[1] ^ top[2];
        top[1]=top[1] ^ top[2];
        for (int i = 0; i < 4; i++) {
            System.out.println(top[i]);
        }
    }
}
