package com.option.chain.analysis.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
@Table(name = "stock_master")
public class StockMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int stock_Id;
    @Column(name = "stock_Name")
    private String stockName;
    @Column(name = "active")
    private String active;

}
