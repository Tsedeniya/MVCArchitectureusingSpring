package com.tsedi.MVCExample.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tsedi.MVCExample.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

}
