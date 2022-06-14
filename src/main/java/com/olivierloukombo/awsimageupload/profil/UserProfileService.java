package com.olivierloukombo.awsimageupload.profil;

import com.olivierloukombo.awsimageupload.bucket.BucketName;
import com.olivierloukombo.awsimageupload.filestore.FileStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;


@Service
public class UserProfileService {

    private final UserProfileDataService userProfileDataService;
    private final FileStoreService fileStoreService;

    @Autowired
    public UserProfileService(UserProfileDataService userProfileDataService, FileStoreService fileStoreService) {
        this.userProfileDataService = userProfileDataService;
        this.fileStoreService = fileStoreService;
    }




    List<UserProfile> getUserProfiles(){
        return userProfileDataService.getUserProfiles();
    }

    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {
        isFileEmpty(file);

        isValidImage(file);

        UserProfile userProfile = getUserProfile(userProfileId);

        Map<String, String> metaData = extractMetaData(file);
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), userProfile.getUserId());
        String fileName = String.format("%s-%s", file.getOriginalFilename(), userProfile.getUserId());
        try {
            fileStoreService.save(path,  fileName, Optional.of(metaData), file.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, String> extractMetaData(MultipartFile file) {
        Map<String, String> metaData = new HashMap<>();
        metaData.put("Content-Type", file.getContentType());
        metaData.put("Content-Length", String.valueOf(file.getSize()));
        return metaData;
    }

    private UserProfile getUserProfile(UUID userProfileId) {
        return userProfileDataService
                .getUserProfiles()
                .stream()
                .filter(userProfileFiltered -> userProfileFiltered.getUserId().equals(userProfileId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("User profile %s not found", userProfileId)));
    }

    private void isValidImage(MultipartFile file) {
        if(!Arrays.asList(
                IMAGE_JPEG.getMimeType(),
                IMAGE_PNG.getMimeType(),
                IMAGE_GIF.getMimeType()).contains(file.getContentType())){
            throw new IllegalStateException("Please provide an image [ "+ file.getContentType() + "]");
        }
    }

    private void isFileEmpty(MultipartFile file) {
        if(file.isEmpty()){
            throw new IllegalStateException("there is not file [ " + file.getSize() + " ] ");
        }
    }
}
