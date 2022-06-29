package com.knoldus.springbootcrud.repository;

import com.knoldus.springbootcrud.bean.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject,String> {


}