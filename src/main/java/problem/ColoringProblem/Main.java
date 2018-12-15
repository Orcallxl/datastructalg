package problem.ColoringProblem;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {
            // read file content from file
            StringBuilder sb = new StringBuilder();

            FileReader reader = new FileReader("C://Users/orca/Desktop/gc_1.txt");
            BufferedReader br = new BufferedReader(reader);

            String str = null;

            while((str = br.readLine()) != null) {
                //sb的操作
//                Algo algo = new Algo();
//                algo.begin(str);
                str = str +" proces by xialin";
                sb.append(str+"\r\n");
                System.out.println(str.length());
            }

            br.close();
            reader.close();

            // write string to file
            FileWriter writer = new FileWriter("C://Users/orca/Desktop/gc_1.out");
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(sb.toString());

            bw.close();
            writer.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

}