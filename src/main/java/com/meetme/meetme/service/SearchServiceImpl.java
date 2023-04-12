package com.meetme.meetme.service;

import com.meetme.meetme.mapper.SearchMapper;
import com.meetme.meetme.model.SearchDTO;
import com.meetme.meetme.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final SearchRepository searchRepository;
    private final SearchMapper searchMapper;

    @Override
    public SearchDTO saveNewSearch(SearchDTO searchDTO) {
        return searchMapper.searchToSearchDto(searchRepository.save(searchMapper.searchDtoToSearch(searchDTO)));
    }
}
