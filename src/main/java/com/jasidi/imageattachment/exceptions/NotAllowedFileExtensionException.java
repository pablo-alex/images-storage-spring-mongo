package com.jasidi.imageattachment.exceptions;

/**
 * This class is a custom RuntimeException
 *
 * @author Pablo Rodriguez
 * @version 1.0
 */
public class NotAllowedFileExtensionException extends RuntimeException {

  public static final String ERROR_MESSAGE = "File extension not allowed";

  public NotAllowedFileExtensionException() {
    super(ERROR_MESSAGE);
  }
}
