package edu.hit;


import picocli.CommandLine;

import java.io.File;
import java.util.concurrent.Callable;

@CommandLine.Command(name="Lab1",version = "Lab1 1.0",mixinStandardHelpOptions = true)
public class Lab1 implements Callable<Integer> {


    @CommandLine.Option(names = {"-s","--src"},description = "absolute path of source text file",required = true)
    private File srcFile;

    @CommandLine.Option(names = { "-h", "--help" }, usageHelp = true, description = "display a help message")
    private boolean helpRequested;

    @CommandLine.Option(names = {"--show"},description = "print DirectedGraph")
    private boolean showGraph;

    @CommandLine.Option(names = {"-d","--dst"},description = "absolute path of destination graph file")
    private File dstFile;

    @CommandLine.Option(names = {"-q","--query"},description = "query bridge-word of word1 and word2(split with space)",interactive = true,echo = true)
    private String words;




    @Override
    public Integer call() {

        String processedText = TextProcessor.processTextFile(srcFile);
        DirectedGraph graph = GraphConverter.convertTextToGraph(processedText);

        if(dstFile != null){
            if(dstFile.toString().equalsIgnoreCase("."))
                dstFile = new File("./directed_graph.png");
            GenerateImg.generate(graph,dstFile);
            System.out.printf("Generate Image of Graph at \"%s\" successfully\n\n",dstFile.getPath());
        }

        if(showGraph){
            GraphConverter.showDirectedGraph(graph);
        }

        try{
            String[] twoWords = words.split("\s+");
            if(twoWords.length != 2)
                throw new Exception("wrong number of query words");
            System.out.println(graph.queryBridgeWords(twoWords[0],twoWords[1]));

        } catch (Exception e) {
            e.printStackTrace();

        }


        return 0;
    }


    public static void main(String[] args) {
        new CommandLine(new Lab1()).execute(args);
    }

}