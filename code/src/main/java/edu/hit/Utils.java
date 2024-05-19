package edu.hit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static List<String> getList(String str){
        return Arrays.stream(str.split("\s+")).toList();
    }

    public static List<String> getBridgeWordsList(String str){
        return Arrays.stream(str.split(",")).toList();
    }
}
