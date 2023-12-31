package com.jasidi.imageattachment.controllers;

import com.jasidi.imageattachment.models.Attachment;
import com.jasidi.imageattachment.services.AttachmentService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * This class is going to represent the Rest Controller for Attachment The path is .../attachments/
 *
 * @author Pablo Rodriguez
 * @version 1.0
 */

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/attachments")
public class AttachmentController {

  private static final Logger logger = LoggerFactory.getLogger(AttachmentController.class);
  private static final String CONTENT_DISPOSITION = "attachment; filename=\"%s\"";

  private final AttachmentService service;

  /**
   * Save MultipartFile in database as a byte array. Return an object that
   * contain an url to download file
   * Extension files allowed are jpeg|jpg|png|gif|mp3|mp4
   *
   * @param file object
   * @return object type JSON with a status 200 if okay, and an autogenerated id
   */
  @PostMapping("/upload")
  public ResponseEntity<Attachment> uploadFile(@RequestBody MultipartFile file) {
    logger.info("{} file received", file.getOriginalFilename());
    Attachment savedAttachment = service.saveFile(file);
    logger.info("{} file saved", file.getOriginalFilename());
    return ResponseEntity.status(HttpStatus.CREATED).body(savedAttachment);
  }

  /**
   * @param id attachment id
   * @return file as a byte array
   */
  @GetMapping("/download/{id}")
  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
    Attachment attachment = service.getById(id);
    logger.info("{} file downloaded", attachment.getName());
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, String.format(CONTENT_DISPOSITION, attachment.getName()))
        .header(HttpHeaders.CONTENT_TYPE, attachment.getType())
        .body(attachment.getContent());
  }
}
