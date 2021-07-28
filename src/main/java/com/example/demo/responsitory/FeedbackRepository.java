package com.example.demo.responsitory;


import com.example.demo.entity.FeedbackEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<FeedbackEntity, Long>,JpaRepository<FeedbackEntity, Long>,
        PagingAndSortingRepository<FeedbackEntity, Long> {

    Page<FeedbackEntity> findAllByFullNameContaining(String fullName, Pageable pageable);
}
