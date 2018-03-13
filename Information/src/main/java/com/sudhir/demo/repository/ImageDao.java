package com.sudhir.demo.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudhir.demo.domain.Images;
@Repository
public interface ImageDao extends JpaRepository<Images, Integer>{

	

}
