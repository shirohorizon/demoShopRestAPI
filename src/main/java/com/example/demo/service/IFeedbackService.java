package com.example.demo.service;

import com.example.demo.api.input.FeedbackRequest;
import com.example.demo.api.output.FeedbackResponse;
import org.springframework.stereotype.Service;

@Service
public interface IFeedbackService extends BaseService<FeedbackRequest, FeedbackResponse>{
}
