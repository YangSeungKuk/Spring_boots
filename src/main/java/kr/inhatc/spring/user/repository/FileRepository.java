package kr.inhatc.spring.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.user.entity.FileDto;
import kr.inhatc.spring.user.entity.Users;

@Repository
public interface FileRepository extends JpaRepository<FileDto, String>{

//	List<Users> findAllByOrderByIdDesc();

}
