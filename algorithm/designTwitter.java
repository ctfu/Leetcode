/* One HashMap<Integer, User>
 * two important objects: Tweet User */
public class Twitter {
    private int timeStamp = 0; /* a global timeStamp, increment each time a new tweet */
    private Map<Integer, User> hm; /* connect with userId to each User */

    /** Initialize your data structure here. */
    public Twitter() {
        hm = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!hm.containsKey(userId)){
            hm.put(userId, new User(userId));
        }
        hm.get(userId).post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!hm.containsKey(userId)) return res;

        Set<Integer> followees = hm.get(userId).followees;
        PriorityQueue<Tweet> heap = new PriorityQueue<>(followees.size(), (a, b) -> b.time - a.time);
        for(Integer id : followees){
            Tweet t = hm.get(id).headTweet;
            if(t != null){      /* it is important to test null */
                heap.offer(t);
            }
        }
        while(!heap.isEmpty() && res.size() < 10){
            Tweet top = heap.poll();
            res.add(top.id);
            if(top.next != null){   /* important to check next */
                heap.offer(top.next);
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!hm.containsKey(followerId)){
            hm.put(followerId, new User(followerId));
        }
        if(!hm.containsKey(followeeId)){
            hm.put(followeeId, new User(followeeId));
        }
        hm.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!hm.containsKey(followerId) || followerId == followeeId){
            return;
        }
        hm.get(followerId).unfollow(followeeId);
    }

    class User{
        int userId;
        Set<Integer> followees;
        Tweet headTweet;

        public User(int userId){
            this.userId = userId;
            followees = new HashSet<>();
            follow(userId); /* always first follow self first */
        }
        public void follow(int id){
            followees.add(id);
        }
        public void unfollow(int id){
            followees.remove(id);
        }
        public void post(int id){
            Tweet t = new Tweet(id);
            t.next = headTweet;
            headTweet = t;
        }
    }
    class Tweet{
        int id;
        int time;
        Tweet next;

        public Tweet(int id){
            this.id = id;
            this.time = timeStamp++;
        }
    }
}
