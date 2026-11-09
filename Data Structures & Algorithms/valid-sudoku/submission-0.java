class Solution {
    public boolean isValidSudoku(char[][] board) {
       final HashMap<Integer,HashSet<Character>> c = new HashMap();
       final HashMap<Integer,HashSet<Character>> r = new HashMap();
       final HashMap<Integer,HashSet<Character>> s = new HashMap();
       for(int i = 0; i < board.length; i++){
          for(int j = 0; j < board[i].length; j++){
             if(board[i][j] != '.'){
              final int k = (i / 3) * 3 + (j / 3); 
             final char rc = board[i][j];
             final HashSet<Character> col = c.getOrDefault(j,new HashSet<Character>());
             final HashSet<Character> row = r.getOrDefault(i,new HashSet<Character>());
             final HashSet<Character> set = s.getOrDefault(k,new HashSet<Character>());
             final boolean iss = col.add(rc) && row.add(rc) && set.add(rc);
             if(!iss)
                return false;
             c.put(j,col);
             r.put(i,row);
             s.put(k,set);
             }     
          }
       }
       return true; 
    }
}
