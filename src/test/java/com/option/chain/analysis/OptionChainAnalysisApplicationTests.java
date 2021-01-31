package com.option.chain.analysis;

import com.option.chain.analysis.repository.OptionChainRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@SpringBootApplication
@DataJpaTest
class OptionChainAnalysisApplicationTests {

    @Autowired
    OptionChainRepository optionChainRepository;


    @Test
    void testSave() {

        //List<OpJsonData> result = optionChainRepository.

    }

}
