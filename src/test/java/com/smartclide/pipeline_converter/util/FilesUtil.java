package com.smartclide.pipeline_converter.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FilesUtil {

  private static final Logger logger = LogManager.getLogger(FilesUtil.class);

  static final String ROOT_PATH = "/tmp/files/";

  public static void createTempRepository(String folderToCreate, String nameFile) throws IOException {
    if (Files.notExists(Paths.get(folderToCreate))) {
      Files.createDirectories(Paths.get(folderToCreate));
    }
    Path file =  Paths.get(folderToCreate).resolve(nameFile);
    if(!Files.exists(file) ) {
    	Files.createFile(file);
    }    
  }

  public static void deleteTempRepositoryFileSystem() throws IOException {
    try {
      Files.walk(Paths.get(ROOT_PATH)).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);

    } catch (Exception e) {
      logger.error(e);
    }
  }

}
