package com.akyv.springbootrest.service;

import com.akyv.springbootrest.model.JobPost;
import com.akyv.springbootrest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost job){
        jobRepo.addJob(job);
    }
    public List<JobPost> getAllJobs(){
        return jobRepo.getAllJobs();
    }
    public JobPost getPost(int postId){
        return jobRepo.getPost(postId);
    }
    public JobPost updateJob(JobPost jobPost){
        return jobRepo.updateJob(jobPost);
    }
    public Boolean deleteJob(int postId){
        return jobRepo.deleteJob(postId);
    }
}
