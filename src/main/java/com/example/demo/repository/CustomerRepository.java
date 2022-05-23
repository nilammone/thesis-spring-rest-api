
// package com.example.demo.repository;

// import java.util.List;

// import com.example.demo.model.Tutorial;

// import org.springframework.data.jpa.repository.JpaRepository;

// public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
//     List<Tutorial> findByPublished(boolean published);

//     List<Tutorial> findByTitleContaining(String title);
// }

package com.example.demo.repository;

import com.example.demo.model.CustomerModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

}
