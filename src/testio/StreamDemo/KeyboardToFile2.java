package testio.StreamDemo;

import java.io.*;

/**
 * Created by cashlu on 15/4/13.
 */
public class KeyboardToFile2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/cashlu/Desktop/file.txt"));
        StringBuilder sb;
        while ((sb = new StringBuilder(br.readLine())) != null){
            if (sb.toString().equals("over")){
                break;
            }
            bw.write(sb.toString());
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
