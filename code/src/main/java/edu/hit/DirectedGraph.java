package edu.hit;

import java.util.HashMap;
import java.util.Map;

public class DirectedGraph extends HashMap<String,Map<String,Integer>>{
    private Map<String,Map<String,Integer>> graph = new HashMap<>();

    public String queryBridgeWords(String word1, String word2) {
        // 检查输入的单词是否在图中
        if (!this.containsKey(word1) || !this.containsKey(word2)) {
            return "No \"" + word1 + "\" or \"" + word2 + "\" in the graph!";
        }

        // 查找桥接词
        Map<String, Integer> word1Neighbors = this.get(word1);
        StringBuilder bridgeWords = new StringBuilder();
        boolean foundBridgeWord = false;

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



}
