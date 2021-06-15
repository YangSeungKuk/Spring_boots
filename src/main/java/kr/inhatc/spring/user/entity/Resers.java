package kr.inhatc.spring.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //db객체, 테이블을 만들수 있게 해줌
@Table(name = "P_Resers")
@NoArgsConstructor  //디폴트 생성자
@Data //get, set  지우면 @Getter, @ToString, @Builder 만들어야함
public class Resers {

	@Id //기본키
	@Column(name="idx")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idxs;
	
	private String dates;
	
	private String times;
	
	private String thema;
	
	private String userid;
	
	private String prices;
	
}
