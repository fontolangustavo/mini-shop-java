package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.UploadFileToS3;
import br.com.iteris.itc.minishop.core.usecase.UploadFileToS3UseCase;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;
import java.util.UUID;

public class UploadFileToS3UseCaseImpl implements UploadFileToS3UseCase {
    private final UploadFileToS3 uploadFileToS3;

    public UploadFileToS3UseCaseImpl(UploadFileToS3 uploadFileToS3) {
        this.uploadFileToS3 = uploadFileToS3;
    }

    @Override
    public String uploadFile(MultipartFile multipartFile) throws IOException {
        UUID randomUUID = UUID.randomUUID();

        String fileExtension = getFileExtension(multipartFile);
        String fileName = randomUUID.toString() + "." + fileExtension;

        return uploadFileToS3.uploadFile(multipartFile, fileName);
    }

    private String getFileExtension(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();

        if (originalFilename != null && originalFilename.contains(".")) {
            return originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        }

        return null;
    }
}
