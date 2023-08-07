package com.jasidi.imageattachment.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class is going to represent the entity Attachment
 *
 * @author Pablo Rodriguez
 * @version 1.0
 */

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {

  @Id
  private String id;
  private String name;
  private String type;
  private Long size;
  @JsonIgnore
  private byte[] content;
  private String url;
}
