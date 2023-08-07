package com.jasidi.imageattachment.exceptions.handlers;

import com.jasidi.imageattachment.exceptions.NotAllowedFileExtensionException;
import com.jasidi.imageattachment.exceptions.responses.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * This class handle exceptions
 *
 * @author Pablo Rodriguez
 * @version 1.0
 */
@RestControllerAdvice
public class ErrorHandler {

  /**
   * Return an ErrorResponse object if the exception occurs
   *
   * @param exception object
   * @return object type JSON with a status 400 if the exception occurs
   */
  @ExceptionHandler(NotAllowedFileExtensionException.class)
  public ResponseEntity<ResponseError> handleNotAllowedFileExtensionException(
      NotAllowedFileExtensionException exception) {
    return ResponseEntity.badRequest().body(
        ResponseError.builder()
            .status(HttpStatus.BAD_REQUEST)
            .error(exception.getClass().getSimpleName())
            .message(exception.getMessage())
            .build());
  }

  /**
   * Return an ErrorResponse object if the exception occurs
   *
   * @param exception object
   * @return object type JSON with a status 417 if the exception occurs
   */
  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public ResponseEntity<ResponseError> handleMaxSizeException(MaxUploadSizeExceededException exception) {
    return ResponseEntity.badRequest().body(
        ResponseError.builder()
            .status(HttpStatus.EXPECTATION_FAILED)
            .error(exception.getClass().getSimpleName())
            .message(exception.getMessage())
            .build());
  }

}
