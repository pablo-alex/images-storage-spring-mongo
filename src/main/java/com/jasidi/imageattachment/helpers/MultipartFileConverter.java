package com.jasidi.imageattachment.helpers;

import com.jasidi.imageattachment.models.Attachment;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * This class is a helper for MultipartFile
 *
 * @author Pablo Rodriguez
 * @version 1.0
 */
public class MultipartFileConverter {

  private static final Logger logger = LoggerFactory.getLogger(MultipartFileConverter.class);
  private static final String ERROR_MESSAGE = "Error trying get file bytes";

  /**
   * Convert MultipartFIle to attachment
   *
   * @param file object
   * @return a Attachment object
   */
  public static Attachment toAttachment(MultipartFile file) {
    try {
      return Attachment.builder()
          .name(file.getOriginalFilename())
          .size(file.getSize())
          .type(file.getContentType())
          .content(file.getBytes())
          .build();
    } catch (IOException error) {
      logger.error(error.getMessage());
      throw new RuntimeException(ERROR_MESSAGE);
    }
  }
}
