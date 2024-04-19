package com.akyv.springbootrest.repo;

import com.akyv.springbootrest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1,"Java Developer","Must have good experiencein java",5,Arrays.asList("Java","React")),
            new JobPost(2,"Python Developer","Must have good experiencing Python",5,Arrays.asList("Python","React"))
    ));
    public List<JobPost> getAllJobs(){
        return jobs;
    }
    public void addJob(JobPost job){
        jobs.add(job);
        System.out.println(jobs);
    }
    public JobPost getPost(int postId){
        for(JobPost job : jobs){
            if(job.getPostId()==postId){
                return job;
            }
        }
        return null;
    }

    public JobPost updateJob(JobPost jobPost) {
        for(JobPost jobPost1 :jobs){
            if(jobPost1.getPostId()==jobPost.getPostId()){
                jobPost1.setPostDesc(jobPost.getPostDesc());
                jobPost1.setPostProfile(jobPost.getPostProfile());
                jobPost1.setPostTechStack(jobPost.getPostTechStack());
                jobPost1.setReqExperience(jobPost.getReqExperience());
            }
        }
        return getPost(jobPost.getPostId());
    }
    public Boolean deleteJob(int postId) {
        for(JobPost jobPost :jobs){
            if(jobPost.getPostId()==postId){
                return jobs.remove(jobPost);
            }
        }
        return false;
    }

}
