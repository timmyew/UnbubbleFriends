package com.unbubblefriends.core.component.gateways.es;

import com.unbubblefriends.core.component.gateways.IDbGateway;
import org.modelmapper.ModelMapper;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.ArrayList;
import java.util.List;

public class AbstractEsGateway<DB, DTO> implements IDbGateway<DTO> {

    private final Class<DB> dbClassType;
    private final Class<DTO> dtoClassType;
    private final ElasticsearchRepository<DB, Long> repository;
    protected final ModelMapper modelMapper;

    public AbstractEsGateway(ElasticsearchRepository<DB, Long> repository, ModelMapper modelMapper, Class<DB> dbClassType, Class<DTO> dtoClassType){
        this.dbClassType = dbClassType;
        this.dtoClassType = dtoClassType;
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DTO findById(Long id) {
        return modelMapper.map(repository.findById(id), dtoClassType);
    }

    @Override
    public List<DTO> findAllById(List<Long> idList) {
        List<DB> dbList = new ArrayList<>();

        repository.findAllById(idList).forEach(dbList::add);

        return dbList.stream().map(db -> modelMapper.map(db, dtoClassType)).toList();
    }

    @Override
    public DTO save(DTO dto) {
        return modelMapper.map(repository.save(modelMapper.map(dto, dbClassType)), dtoClassType);
    }

    @Override
    public List<DTO> saveAll(List<DTO> dtoList) {
        List<DB> dbList = new ArrayList<>();

        repository.saveAll(dtoList.stream().map(dto -> modelMapper.map(dto, dbClassType)).toList()).forEach(dbList::add);

        return dbList.stream().map(db -> modelMapper.map(db, dtoClassType)).toList();
    }

    @Override
    public void delete(DTO dto) {
        repository.delete(modelMapper.map(dto, dbClassType));
    }

    @Override
    public void deleteAll(List<DTO> dtoList) {
        repository.deleteAll(dtoList.stream().map(dto -> modelMapper.map(dto, dbClassType)).toList());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllById(List<Long> idList) {
        repository.deleteAllById(idList);
    }

    @Override
    public boolean isExistingById(Long id) {
        return repository.existsById(id);
    }
}
