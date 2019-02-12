package com.geospiza.poc.repositories;

import com.geospiza.poc.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
