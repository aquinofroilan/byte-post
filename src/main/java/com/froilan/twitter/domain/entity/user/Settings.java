package com.froilan.twitter.domain.entity.user;

import org.springframework.data.mongodb.core.mapping.Field;

public class Settings {
    @Field("private_account")
    private boolean privateAccount;

    @Field("preference")
    private Preference preference;

    public Preference getPreference() {
        return preference;
    }


    public boolean isPrivateAccount() {
        return privateAccount;
    }

    public void setPrivateAccount(boolean privateAccount) {
        this.privateAccount = privateAccount;
    }
}
