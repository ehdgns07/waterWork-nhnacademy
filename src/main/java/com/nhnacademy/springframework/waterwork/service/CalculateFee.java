package com.nhnacademy.springframework.waterwork.service;

import com.nhnacademy.springframework.waterwork.comparerator.ComparatorForAscending;
import com.nhnacademy.springframework.waterwork.repository.CalculatedWaterFee;
import com.nhnacademy.springframework.waterwork.repository.CsvFileParser;
import com.nhnacademy.springframework.waterwork.repository.FileRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class CalculateFee implements Calculate {
    List<CalculatedWaterFee> calculatedWaterFee;
    FileRepository fileRepository;

    @Autowired
    public CalculateFee(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    @Bean
    public void calculator(int amount) {
        List<CalculatedWaterFee> calculatedWaterFee = new ArrayList<>();
        fileRepository.read();
        AtomicLong remainAmount = new AtomicLong(amount);
        ComparatorForAscending comp = new ComparatorForAscending();

        fileRepository.findAll().stream().forEach((waterFee -> {
            if (remainAmount.get() >= waterFee.getSectionStart() &&
                remainAmount.get() <= waterFee.getSectionEnd()) {
                calculatedWaterFee.add(new CalculatedWaterFee(waterFee.getNameOfCity(),
                    waterFee.getSector(), waterFee.getUnitPrice(),
                    waterFee.getUnitPrice() * amount));
            }
        }));
        Collections.sort(calculatedWaterFee, comp);
        for (int i = 0; i < 5; i++) {
            System.out.println(calculatedWaterFee.get(i).toString());
        }
    }
}
