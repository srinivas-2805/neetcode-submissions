class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {

            int startIndex = i;

            // Last occurrence of the first character
            int endIndex = s.lastIndexOf(s.charAt(i));

            // Expand the partition if necessary
            for (int j = i + 1; j <= endIndex; j++) {

                int lastIndex = s.lastIndexOf(s.charAt(j));

                if (lastIndex > endIndex) {
                    endIndex = lastIndex;
                }
            }

            // Partition is now complete
            partitions.add(endIndex - startIndex + 1);

            // Start next partition
            i = endIndex + 1;
        }

        return partitions;
    }
}