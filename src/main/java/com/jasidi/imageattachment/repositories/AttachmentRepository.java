package com.jasidi.imageattachment.repositories;

import com.jasidi.imageattachment.models.Attachment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * This class is going to represent the repository for Attachment. The interface we are going to extend is
 * MongoRepository
 *
 * @author Pablo Rodriguez
 * @version 1.0
 */

@Repository
public interface AttachmentRepository extends MongoRepository<Attachment, String> {

}