package com.unbubblefriends.core.component.gateways.es;

import com.unbubblefriends.core.component.gateways.IDbGateway;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public class AbstractEsGateway<DB, DTO> implements IDbGateway<DTO> {

    protected final ElasticsearchRepository<DB, String> repository;

    public AbstractEsGateway(ElasticsearchRepository<DB, String> repository){
        this.repository = repository;
    }


    @Override
    public DTO find(Long id) {
        return null;
    }

    @Override
    public List<DTO> findAll(List<Long> idList) {
        return null;
    }

    @Override
    public DTO save(DTO dto) {
        return null;
    }

    @Override
    public List<DTO> saveAll(List<DTO> dtos) {
        return null;
    }

    @Override
    public void delete(DTO dto) {

    }

    @Override
    public void deleteAll(List<DTO> dtos) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAllById(List<Long> idList) {

    }

    @Override
    public boolean isExistingById(Long id) {
        return false;
    }
}
