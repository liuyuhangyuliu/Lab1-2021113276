package edu.hit;

import java.util.*;

public class DirectedGraph extends HashMap<String,Map<String,Integer>>{
    private Map<String,Map<String,Integer>> graph = new HashMap<>();

    private  boolean foundBridgeWord;

    private  StringBuilder bridgeWords;
    public String queryBridgeWords(String word1, String word2) {

        // 查找桥接词
        Map<String, Integer> word1Neighbors = this.get(word1);
        bridgeWords = new StringBuilder();
        foundBridgeWord = false;

        // 检查输入的单词是否在图中
        if (!this.containsKey(word1) || !this.containsKey(word2)) {
            return "No \"" + word1 + "\" or \"" + word2 + "\" in the graph!";
        }



        for (String potentialBridge : word1Neighbors.keySet()) {
            if (this.containsKey(potentialBridge) && this.get(potentialBridge).containsKey(word2)) {
                if (foundBridgeWord) {
                    bridgeWords.append(", ");
                }
                bridgeWords.append(potentialBridge);
                foundBridgeWord = true;
            }
        }

        if (!foundBridgeWord) {
            return "No bridge words from \"" + word1 + "\" to \"" + word2 + "\"!";
        } else {
            return "The bridge words from \"" + word1 + "\" to \"" + word2 + "\" are: " + bridgeWords.toString() + ".";
        }
    }

    public String generateNewText(String inputText){

        //https://blog.csdn.net/hjing123/article/details/93725752
        List<String> list = new ArrayList<>(Utils.getList(inputText));

        for (int i = 0 ;i < list.size() - 1 ;i++ ) {
            queryBridgeWords(list.get(i),list.get(i+1));
            //System.out.println(foundBridgeWord);
            if(foundBridgeWord){
                List<String> bridgeWordsList = Utils.getBridgeWordsList(bridgeWords.toString());

                list.add(i + 1,bridgeWordsList.getFirst());

                //System.out.println(bridgeWords);
            }
        }
        return String.join(" ",list);
    }

    public String calcShortestPath(String word1, String word2) {
        // 初始化距离和前驱节点映射
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> predecessors = new HashMap<>();
        for (String vertex : this.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
            predecessors.put(vertex, null);
        }
        distances.put(word1, 0);

        // 存储未访问顶点集合
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        pq.addAll(this.keySet());

        while (!pq.isEmpty()) {
            // 选择当前未访问顶点中距离最小的顶点
            String current = pq.poll();

            // 如果已经找到目标顶点，可以提前结束
            if (current.equals(word2)) break;

            // 遍历当前顶点的所有邻居
            for (Map.Entry<String, Integer> neighborEntry : this.get(current).entrySet()) {
                String neighbor = neighborEntry.getKey();
                int edgeWeight = neighborEntry.getValue();

                // 计算通过当前顶点到达邻居的路径长度
                int newDistance = distances.get(current) + edgeWeight;

                // 如果新路径更短，更新距离和前驱节点
                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    predecessors.put(neighbor, current);
                    // 由于我们使用了优先队列，需要重新调整邻居在队列中的位置
                    pq.remove(neighbor);
                    pq.offer(neighbor);
                }
            }
        }

        // 打印结果
        if (distances.get(word2) == Integer.MAX_VALUE) {
           return("No path exists from " + word1 + " to " + word2);
        } else {
            //System.out.println("Shortest distance from " + word1 + " to " + word2 + " is: " + distances.get(word2));
            List<String> path = buildPath(predecessors, word2);
            Collections.reverse(path);
            return("Shortest distance from " + word1 + " to " + word2 + " is: " + distances.get(word2) + "\nPath: " + String.join(" -> ", path));
        }
    }
    
    private static List<String> buildPath(Map<String, String> predecessors, String word2) {
        List<String> path = new ArrayList<>();
        String current = word2;
        while (current != null) {
            path.add(current);
            current = predecessors.get(current);
        }
        return path;
    }


    public String randomWalk(){

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        List<String> nodes = new ArrayList<>(this.keySet());
        String currentNode = nodes.get(random.nextInt(nodes.size()));
        Set<String> visitedNodesAndEdges = new HashSet<>();
        visitedNodesAndEdges.add(currentNode + "->" + currentNode); // 初始化位置

        StringBuilder pathBuilder = new StringBuilder(currentNode);

        System.out.println("Current path: " + pathBuilder);


        while (!this.get(currentNode).isEmpty()) {
            if (this.containsKey(currentNode)) {

                // 用户交互部分
                System.out.print("Press 'y' to continue walking, any other key to stop: ");
                String input = scanner.nextLine();
                if (!input.equalsIgnoreCase("y")) {
                    System.out.println("Walk stopped by user.");
                    break;
                }
                // 随机选择下一个节点
                List<String> neighbors = new ArrayList<>(this.get(currentNode).keySet());
                String nextNode = neighbors.get(random.nextInt(neighbors.size()));

                // 检查是否形成重复边
                String nextEdge = currentNode + "->" + nextNode;
                if (!visitedNodesAndEdges.contains(nextEdge)) {
                    currentNode = nextNode;
                    visitedNodesAndEdges.add(nextEdge);
                    pathBuilder.append("->").append(currentNode);
                    System.out.println("Current path: " + pathBuilder);
                } else {
                    // 如果形成重复边，则结束循环
                    pathBuilder.append("->").append(nextNode);
                    System.out.println("Current path: " + pathBuilder);
                    System.out.println("Stopped due to reaching the first repeated edge.");
                    break;
                }
            } else {
                // 当前节点没有出度，结束循环
                break;
            }
        }

        return pathBuilder.toString();

    }

}
