package com.gorbatenko.palindrome.to;

import com.gorbatenko.palindrome.model.History;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResultTo {
    private Long value;
    private Long minUI;
    private Long maxUI;

    private String info;
    private boolean isGuest = true;
    private List<History> history;
}
