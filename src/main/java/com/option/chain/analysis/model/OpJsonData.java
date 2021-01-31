package com.option.chain.analysis.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Option_Chain")
@Setter
@Getter
public class OpJsonData {

    @Column(name = "last_updated_time")
    Instant lastUpdatedTime;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "option_time_series", columnDefinition = "CLOB NOT NULL")
    private String optionTimeSeries;




}
