package com.unbubblefriends.core.component.gateways.es;

import com.unbubblefriends.core.component.gateways.IBaseDbGateway;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public class AbstractEsGateway<DB, DTO> implements IBaseDbGateway<DTO> {

    protected final ElasticsearchRepository<DB, String> repository;

    public AbstractEsGateway(ElasticsearchRepository<DB, String> repository){
        this.repository = repository;
    }

    @Override
    public DTO find(Long id) {
        return null;
    }

    @Override
    public DTO findAll(List<Long> idList) {
        return null;
    }

    @Override
    public DTO save(DTO dto) {
        return null;
    }

    @Override
    public DTO saveAll(List<DTO> dto) {
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
    public void deleteByIdList(List<Long> id) {

    }
}
