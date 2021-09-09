package leet.leet68;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        fillRow(words,maxWidth,0,new StringBuilder(), res);
        return  res;
    }

    private void fillRow(String[] words, int maxWidth, int start, StringBuilder sb, List<String> res) {
        int lenCount = 0 ;
        int end = start;
        while(end <words.length && lenCount+words[end].length()<=maxWidth){
            if(lenCount+words[end].length()==maxWidth){
                lenCount+=words[end].length();
            }
            else   lenCount=lenCount+words[end].length()+1;
            end++;
        }
        if(end!=words.length) {//两端对齐
            if(end-start==1){//单个
                sb.append(words[start]);
                while(sb.length()<maxWidth){
                    sb.append(" ");
                }
            }
            else {//多个
                int chu, yu;lenCount=0;
                for(int i = start ; i< end ; i++){
                    lenCount+=words[i].length();
                }
                chu = (maxWidth - lenCount) / (end - start - 1);//end-start-2 是空格填充槽数量
                yu = (maxWidth - lenCount) % (end - start - 1);
                for (int i = start; i < end; i++) {
                    sb.append(words[i]);
                    if(i!=end-1) {
                        for (int j = 0; j < chu; j++) {
                            sb.append(" ");
                        }
                        if (yu != 0) {
                            sb.append(" ");
                            yu -= 1;
                        }
                    }
                }
            }
        }
        else {//最后一行左对齐
            for (int i = start; i < end; i++) {
                sb.append(words[i]);
                if(sb.length()<maxWidth)                sb.append(" ");
            }
            for(int i = sb.length();i<maxWidth;i++){
                sb.append(" ");
            }
        }
        res.add(sb.toString());
        System.out.println(sb.toString());
        if(end!=words.length) fillRow(words,maxWidth,end,new StringBuilder(),res);
    }

    public static void main(String[] args) {
        new Solution().fullJustify(new String[]{"Science","is","what","we","understand","well",
                "enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"},
        20);
    }
}
