package com.som.tutorials.fileupload.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class FileUploadController {

    @Value("${file.upload-dir}")
    String fileDirectory;
    @PostMapping("/uploadFile")
    public ResponseEntity<Object> uploadFile(
            @RequestParam("File") MultipartFile file) throws IOException {

        File myFile = new File(fileDirectory+file.getOriginalFilename());
        myFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(myFile);
        fos.write(file.getBytes());
        fos.close();
        return new ResponseEntity<Object>("File Uploaded successfuly", HttpStatus.OK);

    }
}

