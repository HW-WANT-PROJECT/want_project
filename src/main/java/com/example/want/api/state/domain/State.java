package com.example.want.api.state.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class State {
    @Id
    private Long id;

    private String name;

    private Double Latitude;

    private Double Longitude;

    private Long useCount;

}