package com.unbubblefriends.core.component.gateways.db;

import com.unbubblefriends.core.component.gateways.IDbGateway;
import com.unbubblefriends.core.models.AbstractDbModel;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public class AbstractDbGateway<DB extends AbstractDbModel, DTO> implements IDbGateway<DTO> {

    private final JpaRepository<DB, Long> repository;
    private final Class<DTO> dtoClassType;
    private final Class<DB> dbClassType;
    protected final ModelMapper modelMapper;

    public AbstractDbGateway(JpaRepository<DB, Long> repository, ModelMapper modelMapper, Class<DTO> dtoClassType, Class<DB> dbClassType){
        this.repository = repository;
        this.dtoClassType = dtoClassType;
        this.dbClassType = dbClassType;
        this.modelMapper = modelMapper;
    }

    @Override
    public DTO findById(Long id) {
        return modelMapper.map(repository.findById(id), dtoClassType);
    }

    @Override
    public List<DTO> findAllById(List<Long> idList) {
        return repository.findAllById(idList).stream().map(db -> modelMapper.map(db, dtoClassType)).toList();
    }

    @Override
    public DTO save(DTO dto) {
        return modelMapper.map(repository.save(modelMapper.map(dto, dbClassType)), dtoClassType);
    }

    @Override
    public List<DTO> saveAll(List<DTO> dtoList) {
        return repository.saveAll(dtoList.stream().map(dto -> modelMapper.map(dto, dbClassType)).toList())
                         .stream().map(db -> modelMapper.map(db, dtoClassType))
                         .toList();
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
