package com.example.demo.api.output;

import com.example.demo.dto.FeedbackDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FeedbackResponse {
    private int page;
    private int total_page;
    private List<FeedbackDTO> feedBacks = new ArrayList<>();

    /*--------------constructor--------------*/
    public FeedbackResponse(){

    }

    public FeedbackResponse(int page, int total_page, List<FeedbackDTO> feedBacks){
        this.page = page;
        this.total_page = total_page;
        this.feedBacks = feedBacks;
    }

    public FeedbackResponse(int page, int total_page){
        this.page = page;
        this.total_page = total_page;
    }
    /*---------------------------------------*/
}
