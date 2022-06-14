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
        USER_PROFILES.add(new UserProfile(UUID.fromString("63427993-0e61-492b-bd10-6abce0159007"), "Zack olivier", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("429d61fd-3521-4748-ad17-0bb67b016f7e"), "qwerty", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("2ddd41a7-1349-4a0b-8eb6-4e2109ed0c0a"), "Azerty", null));
    }

    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }
}
