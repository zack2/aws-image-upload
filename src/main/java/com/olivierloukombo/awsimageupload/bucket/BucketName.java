package com.olivierloukombo.awsimageupload.bucket;

public enum BucketName {
    PROFILE_IMAGE("olivier-aws-image-upload-test");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
