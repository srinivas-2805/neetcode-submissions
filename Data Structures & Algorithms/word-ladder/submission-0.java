class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(String word:wordList){
            set.add(word);
        }
        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        set.remove(beginWord);
        int len=1;

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String word=q.poll();
                if(word.equals(endWord)){
                    return  len;
                }
                char[]arr=word.toCharArray();
                for(int j=0;j<arr.length;j++){
                    char original=arr[j];
                    for(char ch='a';ch<='z';ch++){
                        if(ch==original){
                            continue;
                        }
                        arr[j]=ch;
                        String newword=new String(arr);
                        if(set.contains(newword)){
                           q.offer(newword);
                           set.remove(newword);
                        }
                    }
                    arr[j]=original;
                }
            }
            len++;
        }
        return 0;
    }
}
