package kr.inhatc.spring.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

//db객체
@Entity
//테이블 이름 설정
@Table(name = "users")
//디폴트 생성자
@NoArgsConstructor
//get, set
@Data 
public class Users {

	@Id //기본키
	@Column(name = "USER_ID") // 컬럼명 변경, @Column의 속성 변경
	private String id;
	private String pw;
	
	//@Column(length = 20)
	private String name;
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
	private Date joinDate;
	private String enabled;
	private String role;
}
