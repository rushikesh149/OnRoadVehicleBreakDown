package com.ora.dao;

import java.util.List;

import com.ora.entity.Feedback;

public interface FeedbackDAO {
 public boolean addFeedback(Feedback feedback);
 public List<Feedback> viewFeedback();

}
