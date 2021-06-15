package kr.inhatc.spring.boardjpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kr.inhatc.spring.boardjpa.entity.Boards;

@Repository
public interface BoardjpaRepository extends JpaRepository<Boards, Integer>{

	List<Boards> findAllByOrderByIdxDesc();

	Page<Boards> findByIdx(Integer idx, String string, Pageable pageable);
//	Page<Boards> findAllByOrderByTitleContainingOrNameContaining(String searchText, String searchText2,
//			Pageable pageable);

	Page<Boards> findByTitleContainingOrContentsContaining(String searchText, String searchText2, Pageable pageable);

//	Page<Boards> findAllByOrderByIdxContainingOrNameContaining(int parseInt, String searchText, Pageable pageable);

//	Page<Boards> findAllByOrderByIdxContainingOrNameContaining(Integer searchText, Integer searchText2,
//			Pageable pageable);


	
//	@Modifying
//    @Query("update Board p set p.view = p.view + 1 where p.id = :id")
//    int updateView(Long id);
}

