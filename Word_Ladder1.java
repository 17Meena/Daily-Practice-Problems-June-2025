class Pair{
    String word;
    int steps;
    public Pair(String w, int s){
        this.word = w;
        this.steps = s;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int len = wordList.size();

        for(int i=0; i<len; i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);

        q.add(new Pair(beginWord,1));

        while(!q.isEmpty()){
            String word = q.peek().word;
            int steps = q.peek().steps;
            q.poll();

            if(word.equals(endWord)) return steps;

            for(int i=0; i<word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] charArr = word.toCharArray();
                    charArr[i] = ch;
                    String replacedWord = new String(charArr);

                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}