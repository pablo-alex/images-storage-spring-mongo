package com.jasidi.imageattachment.exceptions;

/**
 * This class is a custom RuntimeException
 *
 * @author Pablo Rodriguez
 * @version 1.0
 */
public class NotFoundException extends RuntimeException {

  public NotFoundException(String message) {
    super(message);
  }
}
