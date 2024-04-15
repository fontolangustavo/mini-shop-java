package br.com.iteris.itc.minishop.dataprovider.aws;

import br.com.iteris.itc.minishop.core.dataprovider.DeleteFileFromS3;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.gamelift.model.Build;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;

@Component
public class DeleteFileFromS3Impl implements DeleteFileFromS3 {
    @Value("${aws.buckets.product}")
    private String bucketName;

    private final S3Client s3Client;
    public DeleteFileFromS3Impl() {
        this.s3Client = S3Client.builder()
                .region(Region.US_EAST_1)
                .build();
    }

    @Override
    public String deleteFile(String fileName) throws IOException {
        DeleteObjectResponse response = s3Client.deleteObject(
            builder -> builder
                .bucket(bucketName)
                .key(fileName)
                .build()
        );

        System.out.println("Delete response: " + response);

        return "https://" + bucketName + ".s3.amazonaws.com/" + fileName;
    }
}
