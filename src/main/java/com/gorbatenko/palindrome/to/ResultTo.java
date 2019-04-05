package com.gorbatenko.palindrome.to;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultTo {
    private Long value;
    private Long minUI;
    private Long maxUI;

    private String info;
}
