package edu.hit;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class DirectedGraphTest{

    @Test
    public void test(){
        String inputText = "Seek to explore new and exciting synergies";
        String processedText = "to explore strange new worlds to seek out new life and new";
        DirectedGraph graph = GraphConverter.convertTextToGraph(processedText);
        //System.out.println(graph.generateNewText(inputText));
        System.out.println(graph.calcShortestPath("to","and"));
    }

    @Test
    public void test1(){
        String processedText = "to explore strange new worlds to seek out new life and new";
        DirectedGraph graph = GraphConverter.convertTextToGraph(processedText);
        //graph.randomWalk();
    }


    @Test
    public void queryBridgeWordsTest1() {
        String word1 = "damn";
        String word2 = "you";
        String processedText = TextProcessor.processTextFile(new File("D:\\SElab\\lab1\\code\\testcase\\testcase1.txt"));
        DirectedGraph graph = GraphConverter.convertTextToGraph(processedText);
        assertEquals("No \"damn\" or \"you\" in the graph!",graph.queryBridgeWords(word1,word2));
    }
    @Test
    public void queryBridgeWordsTest2() {
        String word1 = "you";
        String word2 = "damn";
        String processedText = TextProcessor.processTextFile(new File("D:\\SElab\\lab1\\code\\testcase\\testcase1.txt"));
        DirectedGraph graph = GraphConverter.convertTextToGraph(processedText);
        assertEquals("No \"you\" or \"damn\" in the graph!",graph.queryBridgeWords(word1,word2));
    }
    @Test
    public void queryBridgeWordsTest6() {
        String word1 = "aiyo";
        String word2 = "yoyo";
        String processedText = TextProcessor.processTextFile(new File("D:\\SElab\\lab1\\code\\testcase\\testcase1.txt"));
        DirectedGraph graph = GraphConverter.convertTextToGraph(processedText);
        assertEquals("The bridge words from \"aiyo\" to \"yoyo\" are: biubiu, boomboom.",graph.queryBridgeWords(word1,word2));
    }
}