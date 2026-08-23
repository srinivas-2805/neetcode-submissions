class CountSquares {

    // point -> frequency
    private Map<Integer, Map<Integer, Integer>> map;

    public CountSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {

        int x = point[0];
        int y = point[1];

        map.putIfAbsent(x, new HashMap<>());

        Map<Integer, Integer> yMap = map.get(x);

        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {

        int x = point[0];
        int y = point[1];

        int answer = 0;

        // No points having the same x-coordinate
        if (!map.containsKey(x)) {
            return 0;
        }

        Map<Integer, Integer> sameX = map.get(x);

        // Try every point (x, y2)
        for (int y2 : sameX.keySet()) {

            if (y2 == y) {
                continue;
            }

            int side = Math.abs(y2 - y);

            // Frequency of (x, y2)
            int countVertical = sameX.get(y2);

            // Case 1: square is to the right
            int rightX = x + side;

            int count1 = getCount(rightX, y);
            int count2 = getCount(rightX, y2);

            answer += countVertical * count1 * count2;

            // Case 2: square is to the left
            int leftX = x - side;

            count1 = getCount(leftX, y);
            count2 = getCount(leftX, y2);

            answer += countVertical * count1 * count2;
        }

        return answer;
    }

    private int getCount(int x, int y) {

        if (!map.containsKey(x)) {
            return 0;
        }

        return map.get(x).getOrDefault(y, 0);
    }
}