package br.com.iteris.itc.minishop.core.usecase;

import java.io.IOException;

public interface DeleteFileFromS3UseCase {
    void deleteFile(String fileName) throws IOException;
}
