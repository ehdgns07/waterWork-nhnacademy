package com.nhnacademy.springframework.waterwork.comparerator;

import com.nhnacademy.springframework.waterwork.repository.CalculatedWaterFee;
import java.util.Comparator;

public class ComparatorForAscending implements Comparator<CalculatedWaterFee> {
    @Override
    public int compare(CalculatedWaterFee first, CalculatedWaterFee second) {
        if(first.getFee() == second.getFee()){
            return 0;
        }
        return first.getFee() < second.getFee() ? -1:1;
    }
}
