package com.jasidi.imageattachment.services;

import com.jasidi.imageattachment.models.Attachment;
import org.springframework.web.multipart.MultipartFile;

/**
 * This interface is going to represent the interface for AttachmentService
 *
 * @author Pablo Rodriguez
 * @version 1.0
 */

public interface AttachmentService {

  /**
   * Save an Attachment object to the repository receiving an MultipartFile object.
   *
   * @param file object
   * @return the saved Attachment object
   */
  Attachment saveFile(MultipartFile file);

  /**
   * Get an Attachment object from the repository receiving an attachment id
   *
   * @param id attachment id
   * @return the Attachment found by id
   */
  Attachment getById(String id);
}
