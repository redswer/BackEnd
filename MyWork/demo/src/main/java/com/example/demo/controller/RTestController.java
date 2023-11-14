package com.example.demo.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.BoardDTO;
import com.example.demo.domain.JoDTO;
import com.example.demo.domain.MemberDTO;
import com.example.demo.domain.UserDTO;
import com.example.demo.service.BoardService;
import com.example.demo.service.JoService;
import com.example.demo.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

//** @RestController
//=> 스프링4 부터 추가됨,
//  Controller의 모든 매핑메서드 리턴타입을 기존과 다르게 처리함을 명시
// viewPage가 아닌 Data를 다양한 Type으로 return 하며,
//  이들을 JSON이나 XML로 자동으로 처리함.
//=> @ResponseBody 애너테이션을 생략해도 
// xhr, ajax, fetch, axios(리액트) 등의 비동기 요청에 Data로 응답을 해줄수 있음.
//=> Return 데이터 Type
// - String, Integer 등의 단일값
// - 사용자 정의 객체
// - Collection
// - ResponseEntity<> 타입 : 주로 이용됨

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//** status 
//=> https://ko.wikipedia.org/wiki/HTTP_상태코드
//1xx (메시지정보): 요청을 받았으며 프로세스를 계속한다
//2xx (요청성공): 요청을 성공적으로 받았으며 인식했고 수용하였다
//3xx (리다이렉션): 요청 완료를 위해 추가 작업 조치가 필요하다
//4xx (클라이언트 오류): 요청의 문법이 잘못되었거나 요청을 처리할 수 없다
//5xx (서버 오류): 서버가 명백히 유효한 요청에 대해 충족을 실패했다

//400: Bad request (사용자의 잘못된 요청을 처리할 수 없음)
//401: Unauthorized (허가_승인 되지 않음, 권한 없음) 
//403: Forbidden (금지된, 접근금지, 서버에 요청이 전달되었지만, 권한 때문에 거절되었음을 의미)
// ( 401은 익명의 사용자, 403는 로그인은 하였으나 권한이 없는 사용자, 
//   HTTP1.1 에서는 이 둘을 명확하게 구분하지 않고 Web API의 속성은 대부분 401을 내보낸다고 하지만,
//      401은 익명의 사용자, 403는 로그인은 하였으나 권한이 없는 사용자로 구분 가능하다.
//   즉 로그인전 접근시에는 401 , 로그인후 접근시는 403 ) 
//415: 지원되지 않는 미디어 유형 (요청이 요청한 페이지에서 지원하지않는 형식으로 되어있음.)

//404: Not found (요청한 페이지 없음)
//405: Method not allowed (허용되지 않는 http method 사용함)
//500: Internal server error (내부 서버 오류)
//501: Not implemented (웹 서버가 처리할 수 없음)
//503: Service unavailable (서비스 제공 불가)
//504: Gateway timeout (게이트웨이 시간초과)
//505: HTTP version not supported (해당 http 버전 지원되지 않음)

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//*** JSON 제이슨, (JavaScript Object Notation) **********
//=> 자바스크립트의 객체표기법으로, 데이터를 전달할때 사용하는 표준형식.
//  속성(key) 과 값(value) 이 하나의 쌍을 이룸
//=> JSON의 파일 확장자는 .json
//=> 주요 메서드
// - JSON.stringify() : JavaScript 값이나 객체를 JSON 문자열로 변환.
// - JSON.parse() :  JSON 문자열을 구문 분석하여 JavaScript 값이나 객체를 생성함.

//** JAVA의 Data 객체 -> JSON 변환하기
//** 참고용어 
//=> 마샬링(Marshalling)
// - 메모리상에 형상화된 객체 데이터를 다른 데이터 형태로 변환하는 과정을 말함.
// - JAVA 객체를 JSON 포맷으로 변환하는것
//=> 언마샬링(UnMarshalling)
// - 변환된 데이터를 다시 원래의 객체 모양으로 복원하는 작업
// - JSON 포맷을 JAVA 객체로 변환하는것
//=> 직렬화(Serialization)
// - 객체 데이터를 일련의 byte stream으로 변환하는 작업
// - 반대로 일련의 byte stream을 본래 객체 모양으로 복원하는 작업은 역직렬화(Deserialization) 
// - 직렬화와 마샬링은 거의 같은개념이지만, 직렬화 작업이 프로그래밍적으로 보다더 전문화 된것이 마샬링.
//( 즉, 직렬화는 마샬링이 포함된 폭넓은 개념 )

//1) GSON
// : 자바 객체의 직렬화/역직렬화를 도와주는 라이브러리 (구글에서 만듦)
// 즉, JAVA객체 -> JSON 또는 JSON -> JAVA객체

//2) @ResponseBody (매핑 메서드에 적용)
// : 메서드의 리턴값이 View 를 통해 출력되지 않고 HTTP Response Body 에 직접 쓰여지게 됨.
// 이때 쓰여지기전, 리턴되는 데이터 타입에 따라 종류별 MessageConverter에서 변환이 이뤄진다.
// MappingJacksonHttpMessageConverter 를 사용하면 request, response 를 JSON 으로 변환
// view (~.jsp) 가 아닌 Data 자체를 전달하기위한 용도
// @JsonIgnore : VO 에 적용하면 변환에서 제외

//3) jsonView
//=> Spring 에서 MappingJackson2JsonView를 사용해서
//  ModelAndView를 json 형식으로 반환해 준다.
//=> 방법
// -> pom dependency추가
// -> 설정화일 xml 에 bean 등록 
// ( 안하면 /WEB-INF/views/jsonView.jsp 를 찾게되고  없으니 404 발생 )
// -> return할 ModelAndView 생성시 View_Name을 "jsonView"로 설정
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   

@RestController
@Log4j2
@AllArgsConstructor
@RequestMapping("/rest")
public class RTestController {

	MemberService service;
	JoService jservice;
	BoardService bservice;
	PasswordEncoder passwordEncoder;

	@GetMapping("/hello") // => http://localhost:8088/rest/hello 로 직접 요청
	public String hello() {
		log.info("Rest API Test");
		return "** Hello Spring Boot Rest API Test **";
	}
//	======================================================
	// ** RestController 의 다양한 Return Type

	// 1) Text Return
	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	// => produces 속성
	// - 해당 메서드 결과물의 MIME Type을 의미 ( UI Content-Type 에 표시됨 )
	// - 위처럼 문자열로 직접 지정 할수도 있고, 메서드내의 MediaType 클래스를 이용할 수도 있음
	// - 필수속성은 아님 (디폴트값은 text/html : 지정하지 않으면 return 값에 태그 적용 가능)
	public String getText() {
		log.info("** MIME Type => " + MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요 Rest API";
	}

//	-------------------------------
	// ** 객체 주의사항
	// => Java 의 객체를 UI 가 인식 가능한 형태로 변환 후 전송해야 함
	// -> XML 또는 JSON 포맷(형식)
	// => 즉, Java <=> JSON/XML 변환을 지원하는 API 가 필요함
	// ** 여기부터는 pom 에 dependency 추가 해야함

	// 2) 사용자 정의 객체
	// 2.1) 객체 Return1. : produces 지정한 경우
	@GetMapping(value = "/getdto1", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	// => produces
	// - JSON 과 XML 방식의 데이터를 생성할 수 있도록 설정
	// - Response Data Type을 제한 함으로 오류를 줄임
	// - 입력값을 제한할때는 "consumes" 속성 사용
	// => 요청 url의 확장자에 따라 다른 타입으로 서비스
	// - Test1) 브라우져에서 /rest/getdto1 호출 -> 위 둘중 XML 전송(default)
	// - Test2) 브라우져에서 /rest/getdto1.json 호출 -> JSON 전송
	public UserDTO getDTO01() {
		return new UserDTO("mytoken11", "banana", "홍길동", "banana@green.com", "12345!");
	}

	// 2.2) 객체 Return2. : produces 지정하지 않은 경우
	@GetMapping(value = "/getdto2")
	public UserDTO getDTO02() {
		return new UserDTO("mytoken22", "banana", "홍길동", "banana@green.com", "12345!");
	}

//	-------------------------------
	// 3) Collection Return
	// 3.1) Map
	@GetMapping("/getmap")
	public Map<String, UserDTO> getmap() {
		Map<String, UserDTO> map = new HashMap<String, UserDTO>();

		map.put("one", new UserDTO("mytoken11", "banana", "홍길동", "banana@green.com", "12345!"));
		map.put("two", new UserDTO("mytoken22", "banana", "홍길동", "banana@green.com", "12345!"));
		map.put("삼", new UserDTO("mytoken33", "banana", "홍길동", "banana@green.com", "12345!"));
		map.put("4", new UserDTO("mytoken44", "banana", "홍길동", "banana@green.com", "12345!"));

		return map;
	}

	// 3.2) List
	@GetMapping("/getlist")
	public List<JoDTO> getlist() {
		return jservice.selectList();
	}

//	=======================================================
	// ** ResponseEntity
	// => Status (200, 404 등 응답 상태 코드) , Headers, Body 등을 함께 전송할수있음.
	// => status : 200(OK), 502(BAD_GATEWAY) , 500(INTERNAL_SERVER_ERROR)
	// => 즉, 직접 status code 지정 가능.
	// => 사용법
	// - Builder Pattern (권장)
	// - Constructor 사용하는 방식 : 아래 rsdelete 참고

	// ** Parameter 를 쿼리스트링으로 전달하는 경우 서버에서 처리방법
	// 1) params 속성으로 처리
	// - URL Query_String Param Parsing, "key=value" 형식으로 전달된 파라미터 매핑

	// 2) @RequestParam 으로 처리
	// - @RequestParam("jno") int jno -> Spring02의 MemberController, /dnload 참고
	// => params 와 @RequestParam 비교 해보세요.

	// 3) @PathVariable
	// 4) @RequestBody

	// ** params 속성
	// => 값에 상관없이 파라미터에 params 속성으로 정의한 "jno", "id" 이 반드시 있어야 호출됨
	// 만약 하나라도 전달받지 못하면 "400–잘못된 요청" 오류 발생
	// => Parameter name 과 매개변수는 이름으로 매핑함. (즉, 같아야함)
	// => Spring02 의 MemberController의 상단 주석 params 참고

//	--------------------------------------
	// 1) params 속성으로 처리
	// 전달된 jno값의 조건에 의하여 502(BAD_GATEWAY) 또는 200(OK) 상태코드와 데이터를 함께 전송하므로
	// 요청 User가 이 응답결과(body값)의 정상/비정상 여부를 알수있도록 해준다
	// => 200 Test: http://localhost:8088/rest/incheck?jno=11&id=banana
	// http://localhost:8088/rest/incheck.json?jno=11&id=banana
	// => 502 Test: http://localhost:8088/rest/incheck?jno=5&id=banana

//	@GetMapping(value = "/incheck", params = {"jno", "id"})
//	public ResponseEntity<?> incheck(int jno, String id) {
	// => 2) params 속성 대신 @RequestParam 으로 처리 가능
	@GetMapping(value = "/incheck")
	public ResponseEntity<MemberDTO> incheck(@RequestParam("jno") int jno, @RequestParam("id") String id) {

		// 1. 준비
//		ResponseEntity<JoDTO> result = null;
//		JoDTO dto = new JoDTO(jno, "119", id, "펫밀리", "애완동물을 위한 홈페이지");
		ResponseEntity<MemberDTO> result = null;
		MemberDTO dto = service.selectOneJno(id, jno);
		// => Mapper 의 selectOneJno 를 이용하여 id 와 jno 가 일치해야 출력되도록 수정

		// 2. service 처리
		// => jno 의 값이 11~20 이면 성공 / 아니면 오류
//		if (jno > 10 && jno <= 20) {
		if (dto != null) {
			// => Mapper 의 selectOneJno 를 이용하도록 수정
			result = ResponseEntity.status(HttpStatus.OK).body(dto);
		} else {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(dto);
		}

		return result;
	}

//	-------------------------------
	// 3) @PathVariable
	// => URL 경로의 일부를 파라미터로 사용할때 이용
	// http://localhost:8088/rest/order/outer/노랑
	// => 요청 URI 매핑에서 템플릿 변수를 설정하고 이를 매핑메서드 매개변수의 값으로 할당 시켜줌.
	// 이때 파라미터가 1개이면 @PathVariable 과 같이 name을 생략할수 있다

	@GetMapping("/order/{test1}/{test2}")
	public String[] order(@PathVariable("test1") String category, @PathVariable("test2") String color) {

		return new String[] { "category: " + category, "color: " + color };
	}

//	-------------------------------
	// 4) @RequestBody
	// => JSON 형식으로 전달된 Data를 컨트롤러에서 사용자정의 객체(DTO) _Java객체 로 변환할때 사용
	// => 요청 url : http://localhost:8088/rest/convert
	// => Payload : {"jno":33, "jname":"삼삼오오", "id":"victory",
	// "project":"RequestBody Test 중"}
	// => REST Client 플러그인으로 확인
	@PostMapping("/convert")
	public ResponseEntity<?> convert(@RequestBody JoDTO dto) {
		ResponseEntity<JoDTO> result = null;

		if (dto != null) {
			result = ResponseEntity.status(HttpStatus.OK).body(dto);
		} else {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(dto);
		}

		return result;
	}

//	=========================================================
	// ** Ajax : 비동기 통신
	// => Request : JSON, Response : Text
	// => fetch 요청
	@PostMapping(value = "/rslogin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<?> rslogin(@RequestBody MemberDTO dto, HttpSession session) {
		ResponseEntity<String> result = null;

		// 1. password 보관
		String password = dto.getPassword();

		// 2. service 처리
		dto = service.selectOne(dto);

		if (dto != null && passwordEncoder.matches(password, dto.getPassword())) {
			// id 확인 성공 -> password 확인 진행
			session.setAttribute("loginID", dto.getId());
			session.setAttribute("loginName", dto.getName());
			session.setAttribute("img", dto.getUploadfile());
			result = ResponseEntity.status(HttpStatus.OK).body("로그인 성공");
		} else {
			// 로그인 실패
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("로그인 실패");
		}

		return result;
	}

//	---------------------------------
	// ** JSON -> JSON
	@PostMapping(value = "/rsloginjj", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> rsloginjj(@RequestBody MemberDTO dto, HttpSession session) {
		ResponseEntity<UserDTO> result = null;

		String password = dto.getPassword();

		dto = service.selectOne(dto);

		if (dto != null && passwordEncoder.matches(password, dto.getPassword())) {
			session.setAttribute("loginID", dto.getId());
			session.setAttribute("loginName", dto.getName());
			session.setAttribute("img", dto.getUploadfile());

			// ** 빌더 패턴(Builder pattern)
			// => DTO 에 @Builder 적용하여 사용
			// => 객체 생성시 보통 생성자를 사용해서 맴버변수를 초기화 하지만,
			// 이 경우 몇 가지 단점이 있어 객체를 생성하는 별도의 builder를 두는 방법
			final UserDTO userDTO = UserDTO.builder()
					// => 데이터 값 변경을 방지하기 위해 final 사용
					.id(dto.getId()).username(dto.getName()).build();

			result = ResponseEntity.status(HttpStatus.OK).body(userDTO);
		} else {
			// 로그인 실패
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);
		}

		return result;
	}

//	-------------------------
	// Join
	// => img 포함, 'multipart/form-data' type 으로 요청
	// => text type 으로 전송
	@PostMapping(value = "/rsjoin", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<?> rsjoin(MemberDTO dto) throws Exception {
		ResponseEntity<?> result = null;

		// ** Join Service
		// => PasswordEncoder (암호화 적용)
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));

		// => MultipartFile
		String realPath = "D:\\JinHyuk_Ahn\\BackEnd\\MyWork\\demo\\src\\main\\webapp\\resources\\uploadImage\\";
		String file1, file2 = "resources/uploadImage/basicman4.png";

		MultipartFile uploadfilef = dto.getUploadfilef();
		if (uploadfilef != null && !uploadfilef.isEmpty()) {

			// => 물리적위치 저장 (file1)
			file1 = realPath + uploadfilef.getOriginalFilename(); // 저장경로 완성
			uploadfilef.transferTo(new File(file1)); // 해당경로에 저장(붙여넣기)

			// => 저장경로 완성 (file2)
			file2 = "resources/uploadImage/" + uploadfilef.getOriginalFilename();
		} // Image 선택한 경우

		// => 완성된 경로를 dto 에 set
		dto.setUploadfile(file2);

		// => Service 처리
		if (service.insert(dto) > 0) { // Transaction_Test, insert2
			result = ResponseEntity.status(HttpStatus.OK).body("~~ 회원가입 성공!! 로그인후 이용하세요 ~~");
		} else {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("~~ 회원가입 실패!! 다시 하세요 ~~");
		}

		return result;
	}
	
//	------------------------------
	// axios delete
	@DeleteMapping(value = "/axidelete/{ii}")
	public ResponseEntity<?> axidelete(@PathVariable("ii") String id, MemberDTO dto) {
		dto.setId(id);
		
		if (service.delete(dto) > 0) {
			log.info(HttpStatus.OK);
			return new ResponseEntity<String>("** 삭제 성공 **", HttpStatus.OK);
		} else {
			log.info(HttpStatus.BAD_GATEWAY);
			return new ResponseEntity<String>("** 삭제 실패, Data_NotFound **", HttpStatus.BAD_GATEWAY);
		}
	}
	
//	-----------------------------
	// axios board
	@GetMapping(value = "idblist/{ii}")
	public ResponseEntity<?> axiboard(@PathVariable("ii") String id) {
		ResponseEntity<?> result = null;
		List<BoardDTO> list = bservice.idBList(id);
		
		// ** 출력 Data 유/무 구별
		if (list != null && list.size() > 0) {
			result = ResponseEntity.status(HttpStatus.OK).body(list);			
		} else {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("데이터 없음");			
		}
		
		return result;
	}
}
