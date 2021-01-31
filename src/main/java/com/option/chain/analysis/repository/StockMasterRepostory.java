package com.option.chain.analysis.repository;

import com.option.chain.analysis.model.StockMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockMasterRepostory extends JpaRepository<StockMaster, Integer> {


}
