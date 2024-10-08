package com.example.want.api.state.service;

import com.example.want.api.state.domain.State;
import com.example.want.api.state.dto.CityResDto;
import com.example.want.api.state.dto.CountryRsDto;
import com.example.want.api.state.repository.ProjectStateRepository;
import com.example.want.api.state.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StateService {

    private final StateRepository stateRepository;
    private final ProjectStateRepository projectStateRepository;

    public List<CountryRsDto> getCountryList() {
        List<State> states = stateRepository.findAllByCityIsNull();
        List<CountryRsDto> countryRsDtos = new ArrayList<>();
        for (State state : states) {
            countryRsDtos.add(CountryRsDto.fromEntity(state));
        }
        return countryRsDtos;
    }

    public List<CityResDto> getCityList(String countryName) {
        List<State> states = stateRepository.findAllByCountryAndCityIsNotNull(countryName);
        List<CityResDto> cityResDtos = new ArrayList<>();
        for (State state : states) {
            cityResDtos.add(CityResDto.fromEntity(state));
        }
        return cityResDtos;
    }

    public List<CityResDto> getCitiesWithProjectCounts() {
        List<State> states = stateRepository.findAllByCityIsNotNull();
        List<CityResDto> cityResDtos = new ArrayList<>();
        for (State state : states) {
            Long projectCount = projectStateRepository.countByStateId(state.getId());
            cityResDtos.add(CityResDto.withProjectCount(state, projectCount));
        }

        return cityResDtos;
    }
}
