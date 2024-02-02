package com.blog.demo.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MethodsUtils {
    public static void fileUpload(String filesPath, String folderName, MultipartFile file){
        Path pathDirectory = Paths.get(folderName, filesPath);
        Path filePath = pathDirectory.resolve(file.getOriginalFilename());

        try{
            Files.createDirectories(pathDirectory);
            file.transferTo(filePath.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar arquivo");
        }
    }

}
