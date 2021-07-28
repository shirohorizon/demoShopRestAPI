package com.example.demo.api;

import com.example.demo.api.input.FeedbackRequest;
import com.example.demo.api.output.FeedbackResponse;
import com.example.demo.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class FeedbackAPI {

    @Autowired
    private IFeedbackService feedbackService;

    //GET

    //get list feedBacks by page and page-size
    @GetMapping(value = "/feedBacks")
    public ResponseEntity<FeedbackResponse> showFeedBacks(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "page_size",defaultValue = "10") int page_size,
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sort){
        try {
            Sort sortTable = null;
            if (sort.equals("desc")){
                sortTable = Sort.by(sortBy).descending();
            }else {
                sortTable = Sort.by(sortBy).ascending();
            }
            //page size max = 100
            if (page_size > 100){
                page_size = 100;
            }
            Pageable paging = PageRequest.of(page-1,page_size, sortTable);
            FeedbackResponse response = feedbackService.findAll(keyword, paging);
            return new ResponseEntity<FeedbackResponse>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //get feedback by id
    @GetMapping(value = "/feedBacks/{id}")
    public ResponseEntity<FeedbackResponse> showFeedBack(@PathVariable(name = "id") Long id){
        try {
            return new ResponseEntity<FeedbackResponse>(feedbackService.findOne(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //POST
    @PostMapping(value = "/feedBacks")
    public ResponseEntity<FeedbackResponse> createFeedback(@RequestBody FeedbackRequest feedback){
        try {
            return new ResponseEntity<>(feedbackService.save(feedback) , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //PUT
    @PutMapping(value = "/feedBacks/{id}")
    public ResponseEntity<FeedbackResponse> updateFeedback(@RequestBody FeedbackRequest feedback,
                                                           @PathVariable(name = "id") Long id){
        try {
            FeedbackResponse isFeedBackExist = feedbackService.findOne(id);
            if (isFeedBackExist.getFeedBacks().isEmpty()){
                feedback.getFeedback().setId(id);
                return new ResponseEntity<>(feedbackService.save(feedback), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //DELETE
    @DeleteMapping(value = "/feedBacks")
    public ResponseEntity<HttpStatus> deleteFeedback(@RequestBody Long[] ids){
        try {
            feedbackService.delete(ids);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
