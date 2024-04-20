package com.akyv.springbootrest.repo;

import com.akyv.springbootrest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {


    List<JobPost> findByPostProfileContainsOrPostDescContains(String postProfile,String postDesc);
}
