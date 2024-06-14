package edu.hit;


import picocli.CommandLine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(name="Lab1",version = "Lab1 1.0",mixinStandardHelpOptions = true)
public class Lab1 implements Callable<Integer> {


    @CommandLine.Option(names = {"-s","--src"},description = "absolute path of source text file",required = true)
    private File[] srcFile;

    @CommandLine.Option(names = { "-h", "--help" }, usageHelp = true, description = "display a help message")
    private boolean helpRequested;

    @CommandLine.Option(names = {"--show"},description = "print DirectedGraph")
    private boolean showGraph;

    @CommandLine.Option(names = {"-d","--dst"},description = "absolute path of destination graph file")
    private File dstFile;

    @CommandLine.Option(names = {"-q","--query"},description = "query bridge-word of word1 and word2(split with space)",interactive = true,echo = true)
    private String words;

    @CommandLine.Option(names = {"-i","--insert"},description = "query bridge-words and generate new text by input(split with space)",interactive = true,echo = true)
    private String inputText;

    @CommandLine.Option(names = {"-c","--calculate"},description = "calculate shortest path of given words(split with space)",interactive = true,echo = true)
    private String calcWords;

    @CommandLine.Option(names = {"-r","--random"},description = "random walk and show randomPath and save randomPath as text at given absolute path")
    private File randomWalkFile;




    @Override
    public Integer call() {

        String processedText = TextProcessor.processTextFile(srcFile[0]);
        DirectedGraph graph = GraphConverter.convertTextToGraph(processedText);

        if(dstFile != null){
            if(dstFile.toString().equalsIgnoreCase("."))
                dstFile = new File("./directed_graph.png");
            GenerateImg.generate(graph,dstFile);
            System.out.printf("Generate Image of Graph at \"%s\" successfully\n\n",dstFile.getPath());
        }

        if(showGraph){
            System.out.println(GraphConverter.showDirectedGraph(graph));
        }

        if(words != null){
            try{
                String[] twoWords = words.split("\s+");
                if(twoWords.length != 2)
                    throw new Exception("wrong number of query words");
                System.out.println(graph.queryBridgeWords(twoWords[0],twoWords[1]));

            } catch (Exception e) {
                System.out.println(e.getMessage());
                //e.printStackTrace();

            }
        }

        if(inputText != null){
            System.out.println("Generate new text :");
            System.out.println(graph.generateNewText(inputText));

        }

        if(calcWords != null){
            try{
                String[] twoWords = calcWords.split("\s+");
                if(twoWords.length != 2)
                    throw new Exception("wrong number of calculate words");
                System.out.println(graph.calcShortestPath(twoWords[0],twoWords[1]));
            }catch (Exception e){
                System.out.println(e.getMessage());
                //e.printStackTrace();
            }

        }
        if(randomWalkFile != null){
            String randomPath = graph.randomWalk();
            try (FileWriter writer = new FileWriter(randomWalkFile)) {
                writer.write(randomPath);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                //e.printStackTrace();
            }
        }





        return 0;
    }


    public static void main(String[] args) {

        try{
        new CommandLine(new Lab1()).execute(args);}
        catch(RuntimeException e){
            e.printStackTrace();
        }
    }

}