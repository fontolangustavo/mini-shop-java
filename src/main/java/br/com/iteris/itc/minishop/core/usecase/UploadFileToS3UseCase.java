package br.com.iteris.itc.minishop.core.usecase;

import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;

public interface UploadFileToS3UseCase {
    String uploadFile(MultipartFile multipartFile) throws IOException;
}
