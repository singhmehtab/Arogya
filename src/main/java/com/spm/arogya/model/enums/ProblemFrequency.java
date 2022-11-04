package com.spm.arogya.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProblemFrequency {

    NOT_AT_ALL(0, "Not At All"),

    SEVERAL_DAYS(1, "Several Days"),

    MORE_THAN_HALF_THE_DAYS(2, "More Than Half the Days"),

    NEARLY_EVERY_DAY(3, "Nearly Every Day");

    private int problem;
    private String problemFrequencyDisplay;

}
