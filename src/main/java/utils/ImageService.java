package utils;

import com.sun.org.apache.xalan.internal.lib.Extensions;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Nikolay on 09.02.2017.
 */
public class ImageService {

    private static final Logger LOGGER = Logger.getLogger(ImageService.class);


    public static void imageSaveToFS(MultipartFile multipartFile, String path) {
        File pathFile = new File(path);
        if (!pathFile.exists()) {
            pathFile.mkdir();
        }
        try {
            multipartFile.transferTo(pathFile);
        } catch (IOException e) {
            LOGGER.error("Error saving photo");
        }
    }

    public static byte[] readImage(String pathPhoto) throws IOException {
        Path path = Paths.get(pathPhoto);
        byte[] imageBytes = Files.readAllBytes(path);
        return imageBytes;
    }
}
