package com.nhnacademy.springframework.waterworks.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CsvFileParserTest {
    CsvFileParser csvFileParser = new CsvFileParser();
    @DisplayName("csv파일을 읽어오고 제대로 저장되는지 테스트")
    @Test
    void read() {
        csvFileParser.read("./Tariff_20220331.csv");
        List<WaterFee> waterFeeList = new ArrayList<>(csvFileParser.findAll());

        assertThat(waterFeeList.size()).isEqualTo(303);
        assertThat(waterFeeList.get(0).getNameOfCity()).isEqualTo(" 동두천시 ");
        assertThat(waterFeeList.get(0).getUnitPrice()).isEqualTo(690);
        assertThat(waterFeeList.get(302).getNameOfCity()).isEqualTo(" 고성군 ");
        assertThat(waterFeeList.get(302).getUnitPrice()).isEqualTo(2170);
    }
}
