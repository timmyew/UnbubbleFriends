package com.unbubblefriends.core.services;

import org.springframework.http.ResponseEntity;

import java.util.List;

interface IDbService<REQUEST, RESPONSE> {
    ResponseEntity<RESPONSE> findById(Long id);
    ResponseEntity<List<RESPONSE>> findAllById(List<Long> idList);
    ResponseEntity<RESPONSE> save(REQUEST request);
    ResponseEntity<List<RESPONSE>> saveAll(List<REQUEST> requestList);
    void delete(REQUEST request);
    void deleteAll(List<REQUEST> requestList);
    void deleteById(Long id);
    void deleteAllById(List<Long> idList);
    ResponseEntity<String> isExistingById(Long id);
}
