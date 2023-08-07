package com.jasidi.imageattachment.exceptions.responses;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * This class is going to represent the response error
 *
 * @author Pablo Rodriguez
 * @version 1.0
 */
@Data
@Builder
public class ResponseError {

  private HttpStatus status;
  private String error;
  private String message;
}
