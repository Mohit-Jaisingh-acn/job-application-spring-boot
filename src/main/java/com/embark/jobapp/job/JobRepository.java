package com.embark.jobapp.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> { //other option CrudRepository provides basic crud.

}
