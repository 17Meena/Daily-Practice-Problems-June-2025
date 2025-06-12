class Solution {
    class Pair{
        String word;
        int steps;

        public Pair(String w, int s){
            this.word = w;
            this.steps = s;
        }
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        for(int i=0; i<bank.length; i++){
            set.add(bank[i]);
        }
        set.remove(startGene);
        char[] charSet = new char[]{'A','C','G','T'};
        q.add(new Pair(startGene,0));

        while(!q.isEmpty()){
            String word = q.peek().word;
            int steps = q.peek().steps;
            q.poll();

            if(word.equals(endGene)) return steps;

            for(int i=0; i<word.length(); i++){
                for(char ch : charSet){
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

        return -1;
    }
}