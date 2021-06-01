package kr.inhatc.spring.boardjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kr.inhatc.spring.boardjpa.entity.Boards;
import kr.inhatc.spring.boardjpa.repository.BoardjpaRepository;
import kr.inhatc.spring.user.entity.Users;

@Service
public class BoardjpaServiceImpl implements BoardjpaService{

	@Autowired
	BoardjpaRepository boardjpaRepository;
	
	@Override
	public List<Boards> boardjpaList() {
		List<Boards> list = boardjpaRepository.findAllByOrderByIdxDesc();
		System.out.println("===============> 크기 : "+ list.size());
		return list;
	}

	@Override
	public void saveBoardjpa(Boards board) {
		boardjpaRepository.save(board);
		
	}
	
	@Override
	public void saveBoardjpa2(Boards board) {
		
		boardjpaRepository.save(board);
		
	}
	
	@Override
	public void savecntup(Boards board) {
		
		boardjpaRepository.save(board);
		
	}

	@Override
	public Boards boardjpaDetail(Integer idx) {
//		System.out.println("여기까진 오나?"+ idx);
		Optional<Boards> optional = boardjpaRepository.findById(idx);
		Optional<Boards> optional1 = boardjpaRepository.findById(idx);
//		System.out.println("여기까진 오나?" + optional);
		if(optional.isPresent()) {
			
			Boards board = optional.get();
			return board;
		} else {
			throw new NullPointerException();
		}
	}

	@Override
	public void boardjpaDelete(Integer idx) {
		boardjpaRepository.deleteById(idx);
		
	}

	@Override
	public Page<Boards> boardjpaPageList(String searchText, Pageable pageable) {
		Page<Boards> list = boardjpaRepository.findByTitleContainingOrContentsContaining(searchText, searchText, pageable);
		System.out.println("real : " + list);
		return list;
//		return null;
	}



}
