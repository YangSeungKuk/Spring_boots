package kr.inhatc.spring.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.user.entity.FileDto;
import kr.inhatc.spring.user.entity.Resers;
import kr.inhatc.spring.user.entity.Users;

@Repository
public interface ReserRepository extends JpaRepository<Resers, String>{

//	Optional<Resers> findAllByUserid(String name);

	Resers findAllByUserid(String name);

//	List<Resers> findAllByOrderByIdDesc();



}
