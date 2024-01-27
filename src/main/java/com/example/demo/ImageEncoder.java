package com.example.demo;

import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

public class ImageEncoder {
    public String encode(String filename) throws IOException {
        String format = filename.split("\\.")[1];
        if ("svg".equals(format) || "png".equals(format)) {
            String encodedBase64String = Base64.getEncoder()
                    .encodeToString(FileUtils.readFileToByteArray(ResourceUtils.getFile(filename)));

            return switch (format) {
                case "svg" -> "data:image/svg+xml;base64," + encodedBase64String;
                default -> "data:image/png;base64," + encodedBase64String;
            };
        } else {
            throw new IllegalArgumentException();
        }


    }
}
