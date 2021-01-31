package com.option.chain.analysis.repository;

import com.option.chain.analysis.model.OpJsonData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface OptionChainRepository extends JpaRepository<OpJsonData, Integer> {


    String FIND_BY_ADDRESS_QUERY = "SELECT b FROM OpJsonData b WHERE b.symbol = :symbol and LAST_UPDATED_TIME >= CAST(CURRENT_TIMESTAMP-1 as date)order by id desc";


    <T> Collection<T> findBySymbolOrderByIdDesc(String symbol, Class<T> type);

    @Query(FIND_BY_ADDRESS_QUERY)
    List<OpJsonData> findSymbolByLastUpdatedTimeEqual(@Param("symbol") String symbol);


    @Query(value = "select * from Option_Chain st where st.LAST_UPDATED_TIME >= ?1", nativeQuery = true)
    List<OpJsonData> getData(@Param("lastUpdatedTime") @DateTimeFormat(iso = ISO.DATE) String lastUpdatedTime);
}
