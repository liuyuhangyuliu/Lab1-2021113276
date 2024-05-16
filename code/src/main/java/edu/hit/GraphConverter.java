package edu.hit; /**
 *生成有向图
 */
import java.util.HashMap;
import java.util.Map;

public class GraphConverter {

    //转化为有向图
    public static DirectedGraph convertTextToGraph(String processedText) {
        DirectedGraph graph = new DirectedGraph();

        // 将处理好的文本字符串按空格分割为单词数组
        String[] words = processedText.split("\\b\\s+\\b");


        // 构建有向图
        for (int i = 0; i < words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];

            // 将当前单词作为节点加入到图中
            if (!graph.containsKey(currentWord)) {
                graph.put(currentWord, new HashMap<>());
            }

            // 更新当前单词的邻居节点和边的权重
            Map<String, Integer> neighbors =  graph.get(currentWord);
            neighbors.put(nextWord, neighbors.getOrDefault(nextWord, 0) + 1);
        }

        return graph;
    }


    // 输出有向图
    public static void showDirectedGraph(DirectedGraph graph) {
        for (String node : graph.keySet()) {
            System.out.print(node + ": ");
            Map<String, Integer> neighbors =  graph.get(node);
            for (String neighbor : neighbors.keySet()) {
                System.out.print(neighbor + "(" + neighbors.get(neighbor) + ") ");
            }
            System.out.println();
        }
    }
}

