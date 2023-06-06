package jp.co.aforce.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.DAO.MemberDAO;
import jp.co.aforce.bean.MemberBean;

/**
 * Servlet implementation class Delete2
 */
@WebServlet("/view/delete2")
public class Delete2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String member_id = request.getParameter("member_id");
	
		
		MemberDAO mem = new MemberDAO();
		try {
			MemberBean member = mem.search(member_id);
			request.setAttribute("member", member);
			
			if(member != null) {
				request.getRequestDispatcher("searchsuccess2.jsp").forward(request, response);
			}else {
				member =  new MemberBean();
				member.setMember_id(member_id);
				request.setAttribute("member", member);
				request.getRequestDispatcher("searchfail2.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}

}
