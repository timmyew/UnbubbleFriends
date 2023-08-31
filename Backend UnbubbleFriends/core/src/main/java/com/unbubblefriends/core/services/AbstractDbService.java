package com.unbubblefriends.core.services;

import com.unbubblefriends.core.component.gateways.IDbGateway;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AbstractDbService<REQUEST, RESPONSE, DTO> implements IDbService<REQUEST, RESPONSE> {

    private final IDbGateway<DTO> dbGateway;
    private final IDbGateway<DTO> esGateway;
    private final ModelMapper modelMapper;
    private final Class<RESPONSE> responseClass;
    private final Class<DTO> dtoClass;
    protected final Logger logger;

    protected AbstractDbService(IDbGateway<DTO> dbGateway, IDbGateway<DTO> esGateway, ModelMapper modelMapper, Class<RESPONSE> responseClass, Class<DTO> dtoClass, Logger logger){
        this.dbGateway = dbGateway;
        this.esGateway = esGateway;
        this.modelMapper = modelMapper;
        this.responseClass = responseClass;
        this.dtoClass = dtoClass;
        this.logger = logger;
    }

    @Override
    public ResponseEntity<RESPONSE> findById(Long id) {
        try {
            RESPONSE response = modelMapper.map(esGateway.findById(id), responseClass);

            return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
        }catch (Exception exception){
            logger.error(exception.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<List<RESPONSE>> findAllById(List<Long> idList) {
        try {
            List<RESPONSE> responseList = esGateway.findAllById(idList).stream().map(dto -> modelMapper.map(dto, responseClass)).toList();

            return !responseList.isEmpty() ? ResponseEntity.ok(responseList) : ResponseEntity.notFound().build();
        }
        catch(Exception exception){
            logger.error(exception.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<String> save(REQUEST request) {
        try {
            DTO dto = modelMapper.map(request, dtoClass);
            return ((esGateway.save(dto) != null) && (dbGateway.save(dto) != null)) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
        }
        catch (Exception exception){
            logger.error(exception.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<String> saveAll(List<REQUEST> requestList) {
        try {
            List<DTO> dtoList = requestList.stream().map(request -> modelMapper.map(request, dtoClass)).toList();

            return ((! esGateway.saveAll(dtoList).isEmpty()) &&
                    (! dbGateway.saveAll(dtoList).isEmpty())) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
        }
        catch (Exception exception){
            logger.error(exception.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<String> delete(REQUEST request) {
        try {
            DTO dto = modelMapper.map(request, dtoClass);

            esGateway.delete(dto);
            dbGateway.delete(dto);

            return ResponseEntity.ok().build();
        }
        catch(Exception exception){
            logger.error(exception.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<String> deleteAll(List<REQUEST> requestList) {
        try {
            List<DTO> dtoList = requestList.stream().map(request -> modelMapper.map(request, dtoClass)).toList();

            esGateway.deleteAll(dtoList);
            dbGateway.deleteAll(dtoList);

            return ResponseEntity.ok().build();
        }
        catch(Exception exception){
            logger.error(exception.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        try {
            esGateway.deleteById(id);
            dbGateway.deleteById(id);

            return ResponseEntity.ok().build();
        }
        catch(Exception exception){
            logger.error(exception.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<String> deleteAllById(List<Long> idList) {
        try {
            esGateway.deleteAllById(idList);
            dbGateway.deleteAllById(idList);

            return ResponseEntity.ok().build();
        }
        catch(Exception exception){
            logger.error(exception.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<String> isExistingById(Long id) {
        try {
            return esGateway.isExistingById(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
        }
        catch(Exception exception){
            logger.error(exception.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
