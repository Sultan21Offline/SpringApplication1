package com.springapp.springapp1.repo;

import com.springapp.springapp1.models.TableDB;
import org.springframework.data.repository.CrudRepository;

public interface TableRepository extends CrudRepository<TableDB, Long> {

}
