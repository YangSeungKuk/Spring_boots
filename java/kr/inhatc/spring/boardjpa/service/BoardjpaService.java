package kr.inhatc.spring.boardjpa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.inhatc.spring.boardjpa.entity.Boards;

public interface BoardjpaService {

	List<Boards> boardjpaList();

	void saveBoardjpa(Boards board);

	Boards boardjpaDetail(Integer idx);

	void boardjpaDelete(Integer idx);

	void saveBoardjpa2(Boards board);

	void savecntup(Boards board);

	Page<Boards> boardjpaPageList(String searchText, Pageable pageable);

}
