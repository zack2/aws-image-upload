package com.olivierloukombo.awsimageupload.profil;

import com.olivierloukombo.awsimageupload.datastore.FakeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserProfileDataService {

    private final FakeData fakeData;

    @Autowired
    public UserProfileDataService(FakeData fakeData) {
        this.fakeData = fakeData;
    }

    List<UserProfile>getUserProfiles(){
        return fakeData.getUserProfiles();
    }
}
