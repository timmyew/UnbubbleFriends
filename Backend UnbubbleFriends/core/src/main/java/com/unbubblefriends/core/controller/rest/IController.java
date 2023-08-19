package com.unbubblefriends.core.controller.rest;

import com.unbubblefriends.core.models.IBaseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

interface IController<REQUEST extends IBaseModel, RESPONSE extends IBaseModel> {

    ResponseEntity<RESPONSE> find(Long id);
    ResponseEntity<List<RESPONSE>> findAll(List<Long> idList);
    ResponseEntity<String> save(REQUEST request);
    ResponseEntity<String> saveAll(List<REQUEST> requestList);
    ResponseEntity<String> delete(REQUEST request);
    ResponseEntity<String> deleteAll(List<REQUEST> request);
    ResponseEntity<String> deleteWithId(Long id);
    ResponseEntity<String> deleteWithIdAll(List<Long> idList);
}
