package com.olivierloukombo.awsimageupload.profil;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UserProfile {
    private UUID userId;
    private String username;
    private String imageLink;

    public Optional<String> getImageLink() {
        return Optional.ofNullable(imageLink);
    }
}
