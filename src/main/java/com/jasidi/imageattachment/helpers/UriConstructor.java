package com.jasidi.imageattachment.helpers;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * This class is a helper to construct uris
 *
 * @author Pablo Rodriguez
 * @version 1.0
 */
public class UriConstructor {

  private static final String DOWNLOAD_PATH = "/api/v1/attachments/download/";

  /**
   * Create uri for an attachment using its id
   *
   * @param id attachment id
   * @return a Attachment object
   */
  public static String createUriAttachment(String id){
    return ServletUriComponentsBuilder
        .fromCurrentContextPath()
        .path(DOWNLOAD_PATH)
        .path(id)
        .toUriString();
  }

}
