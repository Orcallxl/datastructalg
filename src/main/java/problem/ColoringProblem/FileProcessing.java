package problem.ColoringProblem;


import java.io.*;

/**
 * Created by orca on 2018/12/12.
 * 算法题中以文件作为输入输出的读写模板
 * 文件读写与字符串处理3个知识点：
 * 知识点1：Stringbuffer StringBuilder
 * 都能用于字符串操作，builder单线程，buffer多线程，append比直接用+连接字符串更节省内存和cpu时间
 * 在文件读写中，stringBuilder实际上是作为一个“写缓存”，先一行行构建好stringBuilder后再整体写入文件。
 * 知识点2：BufferReader BufferWriter
 * 是字符流的输入输出缓冲，几个常用方法：
 * reader：readline,read
 * writer:flush,write
 * 引申java输入输出流：http://www.runoob.com/java/java-files-io.html
 * 字节流的输入输出缓冲：InputStreamReader、InputStreamWriter
 * 知识点3：正则表达式
 *
 */
public class FileProcessing {
    public static void processFile(File in, File out) throws IOException {
        StringBuilder sb = new StringBuilder();
        FileReader reader = new FileReader(in);
        BufferedReader br = new BufferedReader(reader);
        String str;
        while ((str = br.readLine())!=null){
            //todo
            doSomething(str);
            sb.append(str+"/r/n");
        }
        reader.close();
        br.close();

        FileWriter writer = new FileWriter(out);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(sb.toString());
        writer.close();
        bw.close();//close会flush
    }

    private static void doSomething(String str) {
        str = str+" process2";
    }
}
