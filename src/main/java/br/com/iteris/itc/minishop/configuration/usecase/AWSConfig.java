package br.com.iteris.itc.minishop.configuration.usecase;

import br.com.iteris.itc.minishop.core.dataprovider.UploadFileToS3;
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
}
