package com.meetme.meetme.mapper;

import com.meetme.meetme.entity.Search;
import com.meetme.meetme.model.SearchDTO;
import org.mapstruct.Mapper;

@Mapper
public interface SearchMapper {

    Search searchDtoToSearch(SearchDTO searchDTO);
    SearchDTO searchToSearchDto(Search search);
}
