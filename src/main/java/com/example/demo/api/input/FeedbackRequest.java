package com.example.demo.api.input;

import com.example.demo.dto.FeedbackDTO;
import lombok.Data;

@Data
public class FeedbackRequest {
    private FeedbackDTO feedback;

    /*--------------constructor--------------*/
    public FeedbackRequest(){

    }

    public FeedbackRequest(FeedbackDTO feedback){
        this.feedback = feedback;
    }
    /*---------------------------------------*/
}
