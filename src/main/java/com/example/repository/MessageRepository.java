package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer>
{

/*
Using @Query to avoid this error:
Failed to create query for method public abstract 
java.util.List com.example.repository.MessageRepository.findAllMessageByPostedBy(java.lang.Integer)! 
No property postedBy found for type Message! Did you mean 'posted_by'?
*/
//Message must be the class name, not the table name
@Query("from Message where posted_by=:paramPostedBy")
List<Message> findAllMessageByPostedBy(@Param("paramPostedBy") Integer postedBy);

//Passing params can also be done this way
// @Query("from Message where posted_by=?1")
// List<Message> findAllMessageByPostedBy(Integer postedBy);

}
