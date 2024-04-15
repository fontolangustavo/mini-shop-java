package br.com.iteris.itc.minishop.core.dataprovider;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DeleteFileFromS3 {
    String deleteFile(String fileName) throws IOException;
}
