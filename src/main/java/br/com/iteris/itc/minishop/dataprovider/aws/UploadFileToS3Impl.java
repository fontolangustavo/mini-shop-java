package br.com.iteris.itc.minishop.dataprovider.aws;

import br.com.iteris.itc.minishop.core.dataprovider.UploadFileToS3;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.http.ContentStreamProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ObjectAttributes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.stream.Stream;

@Component
public class UploadFileToS3Impl implements UploadFileToS3 {
    @Value("${aws.buckets.product}")
    private String bucketName;

    private final S3Client s3Client;
    public UploadFileToS3Impl() {
        this.s3Client = S3Client.builder()
                .region(Region.US_EAST_1)
                .build();
    }

    @Override
    public String uploadFile(MultipartFile multipartFile, String fileName) throws IOException {
        byte[] file = multipartFile.getBytes();

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .contentLength(multipartFile.getSize())
                .contentType(multipartFile.getContentType())
                .key(fileName)
                .build();

        PutObjectResponse response = s3Client.putObject(
                request,
                RequestBody.fromBytes(file)
        );

        System.out.println("Upload response: " + response);

        return "https://" + bucketName + ".s3.amazonaws.com/" + fileName;
    }
}
