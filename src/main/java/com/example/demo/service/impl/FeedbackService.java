package com.example.demo.service.impl;

import com.example.demo.api.input.FeedbackRequest;
import com.example.demo.api.output.FeedbackResponse;
import com.example.demo.converter.FeedbackConverter;
import com.example.demo.entity.FeedbackEntity;
import com.example.demo.responsitory.FeedbackRepository;
import com.example.demo.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService implements IFeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackConverter feedbackConverter;

    @Override
    public FeedbackResponse findOne(Long id) {
        FeedbackEntity entity = feedbackRepository.findById(id).get();
        return feedbackConverter.toResponse(entity);
    }

    @Override
    public FeedbackResponse findAll(String keyword, Pageable pageable) {
        Page<FeedbackEntity> page = feedbackRepository.findAllByFullNameContaining(keyword, pageable);
        return feedbackConverter.toResponse(page.getNumber(), page.getTotalPages(), page.getContent());
    }

    @Override
    public FeedbackResponse save(FeedbackRequest request) {
        FeedbackResponse response = new FeedbackResponse();
        FeedbackEntity entity = new FeedbackEntity(), oldEntity = new FeedbackEntity();
        //check id -> post or put
        if (request.getFeedback().getId() == null){
            //post
            entity = feedbackConverter.toEntity(request.getFeedback());
        }else {
            oldEntity = feedbackRepository.findById(request.getFeedback().getId()).get();
            entity = feedbackConverter.toEntity(request.getFeedback(), oldEntity);
            //put
        }
        entity = feedbackRepository.save(entity);
        return feedbackConverter.toResponse(entity);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id: ids){
            feedbackRepository.deleteById(id);
        }
    }

//    @Override
//    public int totalItem() {
//        return 0;
//    }
}
