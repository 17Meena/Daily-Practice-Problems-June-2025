class Solution {
    public List<List<String>> findLadders(String startWord, String targetWord, List<String> wordList) {
        Set < String > st = new HashSet < String > ();
        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            st.add(wordList.get(i));
        }

        // Creating a queue ds which stores the words in a sequence which is
        // required to reach the targetWord after successive transformations.
        Queue < ArrayList < String >> q = new LinkedList < > ();
        ArrayList < String > ls = new ArrayList < > ();
        ls.add(startWord);
        q.add(ls);
        ArrayList < String > usedOnLevel = new ArrayList < > ();
        usedOnLevel.add(startWord);
        int level = 0;

        // A vector to store the resultant transformation sequence.
        List < List < String >> ans = new ArrayList < > ();
        int cnt = 0;

        // BFS traversal with pushing the new formed sequence in queue 
        // when after a transformation, a word is found in wordList.
        while (!q.isEmpty()) {
            cnt++;
            ArrayList < String > vec = q.peek();
            q.remove();

             // Now, erase all words that have been
             // used in the previous levels to transform
             if (vec.size() > level) {
                level++;
                for (String it: usedOnLevel) {
                    st.remove(it);
                }

                usedOnLevel.clear();
            }

            String word = vec.get(vec.size() - 1);

            // store the answers if the end word matches with targetWord.
            if (word.equals(targetWord)) {
                // the first sequence where we reached the end.
                if (ans.size() == 0) {
                    ans.add(vec);
                } else if (ans.get(0).size() == vec.size()) {
                    ans.add(vec);
                }
            }
            for (int i = 0; i < word.length(); i++) {

                // Now, replace each character of ‘word’ with char
                // from a-z then check if ‘word’ exists in wordList.
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if (st.contains(replacedWord)) {
                        vec.add(replacedWord);
                        q.add(new ArrayList<>(vec));
                        // mark as visited on the level 
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }

            }
        }
        return ans;
    }
}