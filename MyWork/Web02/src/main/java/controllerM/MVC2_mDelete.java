package controllerM;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

@WebServlet("/mdelete")
public class MVC2_mDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MVC2_mDelete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberService service = new MemberService();
		MemberDTO dto = new MemberDTO();
		
		String id = request.getParameter("id");
		dto.setId(id);

		if (service.delete(dto) > 0) {
			// 2-1) 삭제 성공
			request.setAttribute("message", id + "님 삭제 성공");
		} else {
			// 2-2) 삭제 실패
			request.setAttribute("message", id + "님 삭제 실패");
		}
		request.getRequestDispatcher("mlist").forward(request, response);
	}
}
