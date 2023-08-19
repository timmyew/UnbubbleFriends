package com.unbubblefriends.core.component.gateways.db;

import com.unbubblefriends.core.component.gateways.IBaseDbGateway;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class AbstractDbGateway<DB, DTO> implements IBaseDbGateway<DTO> {

    private final JpaRepository<Long, DB> repository;

    public AbstractDbGateway(JpaRepository<Long, DB> repository){
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
