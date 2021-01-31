package com.option.chain.analysis.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.option.chain.analysis.model.OpJsonData;
import com.option.chain.analysis.model.OptionTimeSeries;
import com.option.chain.analysis.model.StockMaster;
import com.option.chain.analysis.repository.OptionChainRepository;
import com.option.chain.analysis.repository.StockMasterRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Service

public class OptionChainService {

    @Autowired
    OptionChainRepository optionChainRepository;

    @Autowired
    StockMasterRepostory stockMasterRepostory;

    List<StockMaster> findAll = null;

    @PostConstruct
    private void getAllD() {

        findAll = stockMasterRepostory.findAll();
        getAllData();

    }

    List<OpJsonData> getAllData() {

        findAll.parallelStream().forEach(action -> {




            List<OpJsonData> findSymbolByIdNamedJpql = optionChainRepository.findSymbolByLastUpdatedTimeEqual("NIFTY");



            findSymbolByIdNamedJpql.stream().forEach(x -> {

                try {
                    List<OptionTimeSeries> convertJsonObject = convertJsonObject(x.getOptionTimeSeries());

                    convertJsonObject.sort(Comparator.comparing(OptionTimeSeries :: getCallOI).reversed());


                    convertJsonObject.stream().limit(3).forEach(s -> {

                        System.out.println(s.toString());


                    });



                } catch (IOException e) {

                    e.printStackTrace();
                }

            });

        });

        return null;

    }

    public List<OptionTimeSeries> convertJsonObject(String jsonStr) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonStr, new TypeReference<List<OptionTimeSeries>>() {
        });

    }
}
