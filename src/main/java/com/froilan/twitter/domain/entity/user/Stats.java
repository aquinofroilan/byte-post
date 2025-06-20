package com.froilan.twitter.domain.entity.user;

import org.springframework.data.mongodb.core.mapping.Field;

public class Stats {

    @Field("followers_count")
    private int followersCount;

    @Field("following_count")
    private int followingCount;

    @Field("tweets_count")
    private int tweetsCount;

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(int followingCount) {
        this.followingCount = followingCount;
    }

    public int getTweetsCount() {
        return tweetsCount;
    }

    public void setTweetsCount(int tweetsCount) {
        this.tweetsCount = tweetsCount;
    }
}
