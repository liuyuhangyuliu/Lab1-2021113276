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


}
