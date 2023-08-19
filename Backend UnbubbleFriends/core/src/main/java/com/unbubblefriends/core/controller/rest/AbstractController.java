package com.unbubblefriends.core.controller.rest;

import com.unbubblefriends.core.models.IBaseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AbstractController<REQUEST extends IBaseModel, RESPONSE extends IBaseModel> implements IController<REQUEST, RESPONSE>{

    public AbstractController(){

    }
    @Override
    public ResponseEntity<RESPONSE> find(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<RESPONSE>> findAll(List<Long> idList) {
        return null;
    }

    @Override
    public ResponseEntity<String> save(REQUEST request) {
        return null;
    }

    @Override
    public ResponseEntity<String> saveAll(List<REQUEST> requests) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(REQUEST request) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteAll(List<REQUEST> request) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteWithId(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteWithIdAll(List<Long> idList) {
        return null;
    }
}
