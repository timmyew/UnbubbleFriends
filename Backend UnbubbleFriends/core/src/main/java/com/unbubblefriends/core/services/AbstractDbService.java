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
    private final Class<REQUEST> requestClass;
    private final Class<RESPONSE> responseClass;
    private final Class<DTO> dtoClass;
    protected final Logger logger;

    protected AbstractDbService(IDbGateway<DTO> dbGateway, IDbGateway<DTO> esGateway, ModelMapper modelMapper, Class<REQUEST> requestClass, Class<RESPONSE> responseClass, Class<DTO> dtoClass, Logger logger){
        this.dbGateway = dbGateway;
        this.esGateway = esGateway;
        this.modelMapper = modelMapper;
        this.requestClass = requestClass;
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
        return null;
    }

    @Override
    public ResponseEntity<RESPONSE> save(REQUEST request) {
        return null;
    }

    @Override
    public ResponseEntity<List<RESPONSE>> saveAll(List<REQUEST> dtoList) {
        return null;
    }

    @Override
    public void delete(REQUEST dto) {

    }

    @Override
    public void deleteAll(List<REQUEST> dtoList) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAllById(List<Long> idList) {

    }

    @Override
    public ResponseEntity<String> isExistingById(Long id) {
        return null;
    }
}
