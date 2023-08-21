package com.unbubblefriends.core.component.gateways;

import java.util.List;

public interface IDbGateway<DTO> {

    DTO findById(Long id);
    List<DTO> findAllById(List<Long> idList);
    DTO save(DTO dto);
    List<DTO> saveAll(List<DTO> dtoList);
    void delete(DTO dto);
    void deleteAll(List<DTO> dtoList);
    void deleteById(Long id);
    void deleteAllById(List<Long> idList);
    boolean isExistingById(Long id);
}
