package offer.offerUnder20.o12;
class Solution {
    public enum visitRes{
        yes(true , 1),no(false , -1),never(false, 0);
        private  boolean a;
        private  int b ;
        private  visitRes(boolean a ,int b){
            this.a= a;
            this.b = b;
        }
    }
    public boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null || board.length == 0 || board[0].length == 0 || word == null || word.equals("")) {
            return false;
        }
        visitRes[][]  ex= new visitRes[board.length][board[0].length];
        for(int i = 0 ;i < board.length; i++){
            for(int j = 0 ; j <board[0].length;j++) {
                ex[i][j]=visitRes.never;
            }
        }
        char first = word.charAt(0);
        boolean res = false;
        for(int i = 0 ;i < board.length; i++){
            for(int j = 0 ; j <board[0].length;j++){
                res= res || dfs(board,word,i,j,0,ex);
            }
        }
        System.out.println(res);
        return res;
    }
    public boolean dfs(char[][] board,String word,int x ,int y,int start,visitRes[][]  ex){

        if(ex[x][y]==visitRes.yes) return  false;
        boolean res = false;
        if(word.charAt(start)==board[x][y]) {
            ex[x][y]=visitRes.yes;
            if(start==word.length()-1){
                return  true;
            }
            if (x - 1 >= 0 && x - 1 < board.length) {
                res = res || dfs(board, word, x - 1, y, start + 1,ex);
            }
            if (x + 1 >= 0 && x + 1 < board.length) {
                res = res || dfs(board, word, x + 1, y, start + 1,ex);
            }
            if (y - 1 >= 0 && y - 1 < board[0].length) {
                res = res || dfs(board, word, x, y - 1, start + 1,ex);
            }
            if (y + 1 >= 0 && y + 1 < board[0].length) {
                res = res || dfs(board, word, x, y + 1, start + 1,ex);
            }
        }
        ex[x][y]=visitRes.never;
        return res;
    }


    public static void main(String[] args) {
        char[][] board = new char[][] {
            {'A','B','C','D'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        new Solution().exist(board,word);
    }
}