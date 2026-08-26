package com.sabarish.placement.dao;

import com.sabarish.placement.model.Job;
import java.util.List;

public interface JobDAO {

    void save(Job job);

    Job findByJobId(String jobId);

    List<Job> findAll();
}