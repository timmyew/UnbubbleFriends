package com.unbubblefriends.core.component.gateways;

import java.util.List;

public interface IBaseDbGateway<DTO> {

    DTO find(Long id);
    DTO findAll(List<Long> idList);
    DTO save(DTO dto);
    DTO saveAll(List<DTO> dto);
    void delete(DTO dto);
    void deleteAll(List<DTO> dtoList);
    void deleteById(Long id);
    void deleteByIdList(List<Long> id);
}
