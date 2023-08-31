package com.unbubblefriends.core.services;

import org.springframework.http.ResponseEntity;

import java.util.List;

interface IDbService<REQUEST, RESPONSE> {
    ResponseEntity<RESPONSE> findById(Long id);
    ResponseEntity<List<RESPONSE>> findAllById(List<Long> idList);
    ResponseEntity<String> save(REQUEST request);
    ResponseEntity<String> saveAll(List<REQUEST> requestList);
    ResponseEntity<String> delete(REQUEST request);
    ResponseEntity<String> deleteAll(List<REQUEST> requestList);
    ResponseEntity<String> deleteById(Long id);
    ResponseEntity<String> deleteAllById(List<Long> idList);
    ResponseEntity<String> isExistingById(Long id);
}
