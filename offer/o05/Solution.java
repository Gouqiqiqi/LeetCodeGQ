package offer.o05;

class Solution {
    public String replaceSpace(String s) {
        StringBuffer sb =new StringBuffer();
        for(int i = 0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==' '){
                sb.append("%20");
            }
            else sb.append(c);

        }
        return sb.toString();
    }
}