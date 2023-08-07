package com.jasidi.imageattachment.validations;

import java.util.regex.Pattern;
import org.springframework.web.multipart.MultipartFile;

/**
 * This class validate some file's properties
 *
 * @author Pablo Rodriguez
 * @version 1.0
 */
public class FileValidator {

  private static final String REGEX_EXTENSION = "^.+\\.(?i)(jpe?g|png|gif|mp3|mp4)$";

  /**
   * Valid the file extension.
   * Extension files allowed are jpeg|jpg|png|gif|mp3|mp4
   *
   * @param file object
   * @return true if the file have allowed extension otherwise return false
   */
  public static boolean isValidExtension(MultipartFile file) {
    return Pattern.matches(REGEX_EXTENSION, file.getOriginalFilename());
  }
}
