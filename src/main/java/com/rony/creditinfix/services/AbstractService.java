package com.rony.creditinfix.services;

import org.springframework.data.domain.Page;

import java.util.List;

public interface AbstractService<T> {
    T create(T t);

    T update(Long id, T t);

    Boolean delete(Long id);

    T findById(Long id);

    Page<T> findAll(int page, int size);

    List<T> findAll();
}
