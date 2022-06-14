package com.olivierloukombo.awsimageupload.datastore;

import com.olivierloukombo.awsimageupload.profil.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeData {
    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();
    static{
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Zack olivier", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "qwerty", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "Azerty", null));
    }

    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }
}
