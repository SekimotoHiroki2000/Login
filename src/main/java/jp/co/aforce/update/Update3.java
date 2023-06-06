package jp.co.aforce.update;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.DAO.MemberDAO;
import jp.co.aforce.bean.MemberBean;

/**
 * Servlet implementation class Update3
 */
@WebServlet("/view/update3")
public class Update3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update3() {
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
		PrintWriter out = response.getWriter();

		MemberBean u = new MemberBean();
	        
	    String member_id = request.getParameter("member_id");
		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		String sex = request.getParameter("sex");
		int birth_year = Integer.parseInt(request.getParameter("birth_year"));
		int birth_month = Integer.parseInt(request.getParameter("birth_month"));
		int birth_day = Integer.parseInt(request.getParameter("birth_day"));
		String job = request.getParameter("job");
		String phone_number = request.getParameter("phone_number");
		String mail_address = request.getParameter("mail_address");
		
		u.setMember_id(member_id);
		u.setLast_name(last_name);
		u.setFirst_name(first_name);
		u.setSex(sex);
		u.setBirth_year(birth_year);
		u.setBirth_month(birth_month);
		u.setBirth_day(birth_day);
		u.setJob(job);
		u.setPhone_number(phone_number);
		u.setMail_address(mail_address);
		
		MemberDAO dao = new MemberDAO();
		try {
			int line = dao.update(u);
			if(line > 0) {
				request.setAttribute("member", u);
				request.getRequestDispatcher("update_success.jsp").forward(request, response);
			}else {
				out.println("会員情報の更新に失敗しました。");
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		

}
	}

