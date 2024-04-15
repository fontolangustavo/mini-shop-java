package br.com.iteris.itc.minishop.core.usecase.impl;

import br.com.iteris.itc.minishop.core.dataprovider.DeleteFileFromS3;
import br.com.iteris.itc.minishop.core.usecase.DeleteFileFromS3UseCase;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DeleteFileFromS3UseCaseImpl implements DeleteFileFromS3UseCase {
    private final DeleteFileFromS3 deleteFileFromS3;

    public DeleteFileFromS3UseCaseImpl(DeleteFileFromS3 deleteFileFromS3) {
        this.deleteFileFromS3 = deleteFileFromS3;
    }


    @Override
    public void deleteFile(String filePath) throws IOException {
        String fileName = getFilename(filePath);
        System.out.println("File name: " + fileName);

        deleteFileFromS3.deleteFile(fileName);
    }

    private String getFilename(String filePath) throws MalformedURLException {
        URL url = new URL(filePath);
        String path = url.getPath();

        return path.substring(path.lastIndexOf('/') + 1);
    }
}
