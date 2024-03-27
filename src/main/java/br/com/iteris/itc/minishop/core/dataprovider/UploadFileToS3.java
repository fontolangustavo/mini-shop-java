package br.com.iteris.itc.minishop.core.dataprovider;

import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;

public interface UploadFileToS3 {
    String uploadFile(MultipartFile multipartFile, String fileName) throws IOException;
}
