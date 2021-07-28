package com.example.demo.converter;


import com.example.demo.api.output.FeedbackResponse;
import com.example.demo.dto.FeedbackDTO;
import com.example.demo.entity.FeedbackEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeedbackConverter {

    public FeedbackEntity toEntity(FeedbackDTO dto){
        FeedbackEntity entity = new FeedbackEntity();
        entity.setContent(dto.getContent());
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setMobile(dto.getMobile());
        return entity;
    }

    public FeedbackEntity toEntity(FeedbackDTO dto , FeedbackEntity entity){
        entity.setContent(dto.getContent());
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setMobile(dto.getMobile());
        return entity;
    }

    public FeedbackResponse toResponse(FeedbackEntity entity){
        FeedbackResponse response = new FeedbackResponse();
        FeedbackDTO dto = new FeedbackDTO();
        dto.setFullName(entity.getFullName());
        dto.setMobile(entity.getMobile());
        dto.setEmail(entity.getEmail());
        dto.setContent(entity.getContent());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setModifiedBy(entity.getModifiedBy());
        response.getFeedBacks().add(dto);
        return response;
    }

    public FeedbackResponse toResponse(int page, int total_page, List<FeedbackEntity> entities){
        FeedbackResponse response = new FeedbackResponse();
        FeedbackDTO dto = new FeedbackDTO();
        response.setPage(page);
        response.setTotal_page(total_page);
        entities.forEach(e->{
            dto.setFullName(e.getFullName());
            dto.setMobile(e.getMobile());
            dto.setEmail(e.getEmail());
            dto.setContent(e.getContent());
            dto.setCreatedDate(e.getCreatedDate());
            dto.setCreatedBy(e.getCreatedBy());
            dto.setModifiedDate(e.getModifiedDate());
            dto.setModifiedBy(e.getModifiedBy());
            response.getFeedBacks().add(dto);
        });
        return response;
    }
}
