package com.akyv.springbootrest;

import com.akyv.springbootrest.model.JobPost;
import com.akyv.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobRestController {
    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{postID}")
    public JobPost getJob(@PathVariable("postID") int postId) {
        return jobService.getPost(postId);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
        return jobService.getPost(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        jobService.updateJob(jobPost);
        return jobService.getPost(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postID}")
    public void deleteJob(@PathVariable("postID") int postId) {
        jobService.deleteJob(postId);
    }

    @PostMapping("load")
    public void loadJobs() {
        jobService.loadJobs();
    }

    @GetMapping("jobPost/keyword/{keyword}")
    public List<JobPost> getJobPostByKeyword(@PathVariable("keyword") String keyword){
        return jobService.findByKeyword(keyword);
    }
}
