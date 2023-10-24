package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // => 모든 값을 초기화하는 생성자를 자동으로 추가
@NoArgsConstructor // => default 생성자를 자동으로 추가
@Data // => getter, setter, toString 자동으로 추가
public class BoardDTO {
	private int seq;
	private String id;
	private String title;
	private String content;
	private String regdate;
	private int cnt;
}// class