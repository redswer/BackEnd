package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// ** Entity 설정
// => password 처음 입력은 가능하지마느, 
//    수정은 별도로 처리해야 하므로 수정불가로
// => MultipartFile uploadfilef 
//	  SQL 구문에서 제외시켜줌

@Entity 
@Table(name="member")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	
	@Id
	private String id; // Primary Key
	
	@Column(updatable = false)
	private String password; // 별도로 수정하기위함
	
	private String name;
	private int age;
	private int jno;
	private String info;
	private double point;
	private String birthday;
	private String rid;  // 추천인
	private String uploadfile; // Table에 보관된 File_Path
	
	@Transient // SQL에서 제외시켜야함
	private MultipartFile uploadfilef;
	// => form 의 Upload_File 정보를 전달받기위한 필드
	//    MultipartFile (Interface) -> CommonsMultipartFile

} //class
