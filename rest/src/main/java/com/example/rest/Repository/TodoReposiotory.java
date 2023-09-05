
package com.example.rest.Repository;

import com.example.rest.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoReposiotory extends JpaRepository<Task, Long>{
    
}
