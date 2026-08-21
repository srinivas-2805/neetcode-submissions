class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()){
            return false;
        }
        Map<String,Boolean> cache=new HashMap<>();
        return canInterleave(s1,s2,s3,0,0,cache);
    }
    private boolean canInterleave(String s1,String s2,String s3,int s1index,int s2index,Map<String,Boolean>cache){
        if(s1index==s1.length() && s2index==s2.length()){
            return true;
        }
        String cachekey=s1index+","+s2index;
        if(cache.containsKey(cachekey)){
            return cache.get(cachekey);
        }
        int s3index=s1index+s2index;
        boolean result=false;
        if(s1index<s1.length() && s1.charAt(s1index)==s3.charAt(s3index)){
            result=canInterleave(s1,s2,s3,s1index+1,s2index,cache);
        }
        if(!result && s2index<s2.length() && s2.charAt(s2index)==s3.charAt(s3index)){
            result=canInterleave(s1,s2,s3,s1index,s2index+1,cache);
        }
        cache.put(cachekey,result);
        return result;
    }
}
