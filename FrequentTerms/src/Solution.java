
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

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
        HashMap<String, Integer> words = new HashMap<String, Integer>(N);
        TreeMap<Integer, ArrayList> counts = new TreeMap<Integer, ArrayList>();
        for (int i = 0; i < N; i++){
            res = br.readLine();
            Integer count = 0;
            if (words.containsKey(res)) {
                count = (Integer) words.get(res);
                ArrayList wrds = counts.get(Integer.MAX_VALUE - count);
                wrds.remove(res);
            }
            
            count++;
            if (counts.containsKey(Integer.MAX_VALUE - count)){
                ArrayList wrds = counts.get(Integer.MAX_VALUE - count);
                wrds.add(res);
            } else {
                ArrayList wrds = new ArrayList();
                wrds.add(res);
                counts.put(Integer.MAX_VALUE - count, wrds);
            }
            words.put(res, count);
        }
        res = br.readLine();
        int K = Integer.parseInt(res);
        int i = 0;
        for (Iterator<Entry<Integer, ArrayList>> it = counts.entrySet().iterator(); it.hasNext();) {
            Entry <Integer, ArrayList> mp = it.next();
            ArrayList wrds = mp.getValue();
            Collections.sort(wrds);
            for (Object wrdo : wrds){
                String wrd = (String)wrdo;
                System.out.println(wrd);
                i++;
                if (i >= K)
                    break;
            }
            if (i >= K)
                break;
        }
    }
}
