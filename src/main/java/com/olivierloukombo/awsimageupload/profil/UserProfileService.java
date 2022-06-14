package com.olivierloukombo.awsimageupload.profil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {

    private final UserProfileDataService userProfileDataService;

    @Autowired
    public UserProfileService(UserProfileDataService userProfileDataService) {
        this.userProfileDataService = userProfileDataService;
    }

    List<UserProfile> getUserProfiles(){
        return userProfileDataService.getUserProfiles();
    }
}
