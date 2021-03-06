package com.nhnacademy.springframework.waterworks.service;

import com.nhnacademy.springframework.waterworks.comparerator.ComparatorForAscending;
import com.nhnacademy.springframework.waterworks.config.MainConfigFile;
import com.nhnacademy.springframework.waterworks.repository.CsvFileParser;
import com.nhnacademy.springframework.waterworks.repository.FileParser;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = MainConfigFile.class)
class LoggingResultServiceTest {

    ComparatorForAscending comp = new ComparatorForAscending();
    FileParser file = new CsvFileParser();
    DataRead dataRead = new DataLoadService(file);
    Calculate calculate = new CalculateFee(dataRead);

    @DisplayName("내림차순으로 정렬하고, 화면에 5개씩 출력 해주는 테스트")
    @Test
    void printingResult() {


        dataRead.dataLoadAndSave("Tariff_20220331.csv");
        calculate.calculator(1000);
        Collections.sort(calculate.getCalculatedWaterFee(), comp);
        for (int i = 0; i < 5; i++) {
            System.out.println(calculate.getCalculatedWaterFee().get(i).toString());
        }
    }
}