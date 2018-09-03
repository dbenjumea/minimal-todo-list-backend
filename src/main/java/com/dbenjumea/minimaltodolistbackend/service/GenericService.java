package com.dbenjumea.minimaltodolistbackend.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {
    Optional<T> findById(long id);

    List<T> findAll();

    void deleteById(long id);

    T save(T obj);
}
