package edu.hit; /**
 * 处理初始文本
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextProcessor {

    //文本处理
    public static String processTextFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            // 打开文件
            Scanner scanner = new Scanner(file);

            // 逐行读取文件内容并处理
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // 将非字母字符替换成空格，并转换为小写
                line = line.replaceAll("[^a-zA-Z]", " ").toLowerCase();
                // 将处理后的行追加到StringBuilder中
                stringBuilder.append(line).append(" ");
            }

            // 关闭文件
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // 返回处理后的文本内容
        return stringBuilder.toString().trim();
    }
}
