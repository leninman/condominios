package com.resimanager.backoffice.service.mapper;

import com.resimanager.backoffice.dto.OwnerRequestDto;
import com.resimanager.backoffice.dto.OwnerResponseDto;
import com.resimanager.backoffice.repository.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", imports = {Owner.class, OwnerResponseDto.class, OwnerRequestDto.class})
public interface OwnerMapper {
    OwnerMapper MAPPER = Mappers.getMapper(OwnerMapper.class);

    @Mapping(target = "id", source = "ownerId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "address", source = "address")
    OwnerResponseDto mapToDto(Owner entity);

    Owner mapToEntity(OwnerRequestDto dto);

}
