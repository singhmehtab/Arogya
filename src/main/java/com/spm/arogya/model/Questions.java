package com.spm.arogya.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spm.arogya.model.enums.ProblemFrequency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(content = JsonInclude.Include.NON_NULL)
public class Questions implements Serializable{

    private static final String QUESTION_1 = "Over the past 2 weeks, how often have you been bothered by any of the following problems: Little interest or pleasure in doing things?";
    private static final String QUESTION_2 = "Over the past 2 weeks, how often have you been bothered by any of the following problems: Feeling down, depressed or hopless?";
    private static final String QUESTION_3 = "Over the past 2 weeks, how often have you been bothered by any of the following problems: Trouble falling asleep, staying asleep, or sleeping too much?";
    private static final String QUESTION_4 = "Over the past 2 weeks, how often have you been bothered by any of the following problems: Feeling tired or having little energy?";
    private static final String QUESTION_5 = "Over the past 2 weeks, how often have you been bothered by any of the following problems: Poor appetite or overeating?";
    private static final String QUESTION_6 = "Over the past 2 weeks, how often have you been bothered by any of the following problems: Feeling bad about yourself - or that you're a failure or have let yourself or your family down?";
    private static final String QUESTION_7 = "Over the past 2 weeks, how often have you been bothered by any of the following problems: Trouble concentrating on things, such as reading the newspaper or watching television?";
    private static final String QUESTION_8 = "Over the past 2 weeks, how often have you been bothered by any of the following problems: Moving or speaking so slowly that other people could have noticed. Or, the opposite - being so fidgety or restless that you have been moving around a lot more than usual?";
    private static final String QUESTION_9 = "Over the past 2 weeks, how often have you been bothered by any of the following problems: Thoughts that you would be better off dead or of hurting yourself in some way?";


    @JsonProperty("questions_list")
    private List<Pair> pairList;


    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(content = JsonInclude.Include.NON_NULL)
    @Getter
    @Builder
    @Setter
    static class Pair implements Serializable {

        @JsonProperty("question")
        private String question;

        @JsonProperty("problem_frequency")
        private ProblemFrequency problemFrequency;

        public Pair(String question){
            this.question = question;
        }

    }

    public static Questions getListOfQuestions(){
        return Questions.builder().pairList(getListOfPairs()).build();
    }

    private static List<Pair> getListOfPairs(){
        return Arrays.asList(new Pair(QUESTION_1), new Pair(QUESTION_2), new Pair(QUESTION_3), new Pair(QUESTION_4), new Pair(QUESTION_5),
                new Pair(QUESTION_6), new Pair(QUESTION_7), new Pair(QUESTION_8), new Pair(QUESTION_9));
    }


}
