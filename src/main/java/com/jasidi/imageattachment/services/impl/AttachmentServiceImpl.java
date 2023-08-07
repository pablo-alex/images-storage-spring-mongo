package com.jasidi.imageattachment.services.impl;

import com.jasidi.imageattachment.exceptions.NotAllowedFileExtensionException;
import com.jasidi.imageattachment.exceptions.NotFoundException;
import com.jasidi.imageattachment.helpers.MultipartFileConverter;
import com.jasidi.imageattachment.helpers.UriConstructor;
import com.jasidi.imageattachment.models.Attachment;
import com.jasidi.imageattachment.repositories.AttachmentRepository;
import com.jasidi.imageattachment.services.AttachmentService;
import com.jasidi.imageattachment.validations.FileValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * This class is going to represent the service for Attachment The interface we are going to extend
 * is AttachmentService
 *
 * @author Pablo Rodriguez
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {

  private static final String ATTACHMENT_NOT_FOUND = "Attachment with %s not found";

  private final AttachmentRepository repository;

  /**
   * {@inheritDoc}
   */
  @Override
  public Attachment saveFile(MultipartFile file) {
    if (!FileValidator.isValidExtension(file)) {
      throw new NotAllowedFileExtensionException();
    }
    Attachment savedAttachment = repository.save(MultipartFileConverter.toAttachment(file));
    savedAttachment.setUrl(UriConstructor.createUriAttachment(savedAttachment.getId()));
    return savedAttachment;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Attachment getById(String id) {
    return repository.findById(id)
        .orElseThrow(() -> new NotFoundException(String.format(ATTACHMENT_NOT_FOUND, id)));
  }
}
