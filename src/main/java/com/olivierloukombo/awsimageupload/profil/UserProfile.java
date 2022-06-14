package com.olivierloukombo.awsimageupload.profil;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode
public class UserProfile {
    private UUID userId;
    private String username;
    private String imageLink;
}
