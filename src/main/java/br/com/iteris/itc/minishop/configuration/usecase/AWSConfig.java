package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.DeleteFileFromS3;
import br.com.iteris.itc.minishop.core.dataprovider.UploadFileToS3;
import br.com.iteris.itc.minishop.core.usecase.impl.DeleteFileFromS3UseCaseImpl;
import br.com.iteris.itc.minishop.core.usecase.impl.UploadFileToS3UseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {
    @Bean
    public UploadFileToS3UseCaseImpl uploadFileToS3UseCase (
            UploadFileToS3 uploadFileToS3
    ) {
        return new UploadFileToS3UseCaseImpl(uploadFileToS3);
    }
    @Bean
    public DeleteFileFromS3UseCaseImpl deleteFileFromS3UseCase (
            DeleteFileFromS3 deleteFileFromS3
    ) {
        return new DeleteFileFromS3UseCaseImpl(deleteFileFromS3);
    }
}
