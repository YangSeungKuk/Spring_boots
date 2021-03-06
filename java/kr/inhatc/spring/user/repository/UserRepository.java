package kr.inhatc.spring.user.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.user.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String>{

	List<Users> findAllByOrderByIdDesc();

	Page<Users> findByIdContainingOrNameContaining(String title, String contents, Pageable pageable);


}
