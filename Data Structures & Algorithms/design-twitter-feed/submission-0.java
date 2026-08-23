class Twitter {

    // userId -> set of users they follow
    private Map<Integer, Set<Integer>> following;

    // userId -> list of tweets
    private Map<Integer, List<Tweet>> tweets;

    // Increasing number to represent tweet recency
    private int time;

    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        tweets.putIfAbsent(userId, new ArrayList<>());

        tweets.get(userId).add(
            new Tweet(tweetId, time++)
        );
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Tweet> allTweets = new ArrayList<>();

        // Add user's own tweets
        if (tweets.containsKey(userId)) {
            allTweets.addAll(tweets.get(userId));
        }

        // Add tweets of people user follows
        if (following.containsKey(userId)) {

            for (int followeeId : following.get(userId)) {

                if (tweets.containsKey(followeeId)) {
                    allTweets.addAll(tweets.get(followeeId));
                }
            }
        }

        // Most recent first
        allTweets.sort((a, b) -> b.time - a.time);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < Math.min(10, allTweets.size()); i++) {
            result.add(allTweets.get(i).tweetId);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        following.putIfAbsent(followerId, new HashSet<>());

        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}