package com.nhnacademy.springframework.waterworks.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class jsonFileParserTest {

    JsonFileParser jsonFileParser = new JsonFileParser();

    @DisplayName("json파일 로드하고 파싱하는 테스트")
    @Test
    void read() {
        jsonFileParser.read("./Tariff_20220331.json");
        List<WaterFee> waterFeeList = new ArrayList<>(jsonFileParser.findAll());

        assertThat(waterFeeList).isNotNull();
        assertThat(waterFeeList.get(0).getNameOfCity()).isEqualTo("동두천시");
        assertThat(waterFeeList.get(0).getUnitPrice()).isEqualTo(690);
        assertThat(waterFeeList.get(302).getNameOfCity()).isEqualTo("고성군");
        assertThat(waterFeeList.get(302).getUnitPrice()).isEqualTo(2170);
    }
}