package edu.hit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class GenerateImg {
    public static void generate(DirectedGraph graph, File dstFile) {

        File dotFile = new File("directed_graph.dot");

        // 生成dot文件内容
        StringBuilder dotContent = new StringBuilder();
        dotContent.append("digraph G {\n");
        for (String node : graph.keySet()) {
            Map<String, Integer> neighbors = graph.get(node);
            for (String neighbor : neighbors.keySet()) {
                dotContent.append("    ").append(node).append(" -> ").append(neighbor)
                        .append(" [label=\"").append(neighbors.get(neighbor)).append("\"];\n");
            }
        }
        dotContent.append("}");

        // 将dot内容写入文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dotFile))) {
            writer.write(dotContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 调用Graphviz命令行工具将dot文件转换为PNG图像
        String command = "dot -Tpng directed_graph.dot -o " + dstFile.getPath();
        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor(); // 等待命令执行完毕
        } catch (IOException | InterruptedException e ){
            e.printStackTrace();
        }

    }
}
