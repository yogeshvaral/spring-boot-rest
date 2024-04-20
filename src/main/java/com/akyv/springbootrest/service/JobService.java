package com.akyv.springbootrest.service;

import com.akyv.springbootrest.model.JobPost;
import com.akyv.springbootrest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo jobRepo;

    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Developer", "Must have good experiencein java", 5, Arrays.asList("Java", "React")),
            new JobPost(2, "Python Developer", "Must have good experiencing Python", 5, Arrays.asList("Python", "React"))
    ));


    public void addJob(JobPost job) {
        jobRepo.save(job);
    }

    public List<JobPost> getAllJobs() {
        return jobRepo.findAll();

    }

    public JobPost getPost(int postId) {
        return jobRepo.findById(postId).orElse(new JobPost());
    }

    public JobPost updateJob(JobPost jobPost) {
        return jobRepo.save(jobPost);
    }

    public void deleteJob(int postId) {
        jobRepo.deleteById(postId);
    }
    public void loadJobs(){
        jobRepo.saveAll(jobs);
    }

    public List<JobPost> findByKeyword(String keyword) {
        return jobRepo.findByPostProfileContainsOrPostDescContains(keyword,keyword);
    }
}
