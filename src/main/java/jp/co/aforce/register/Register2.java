package jp.co.aforce.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.DAO.MemberDAO;
import jp.co.aforce.bean.MemberBean;
/**
 * Servlet implementation class Register
 */
@WebServlet("/view/register2")
public class Register2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register2() {
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

		MemberBean r = new MemberBean();
	    
		Date d = new Date();
		SimpleDateFormat d1 = new SimpleDateFormat("yyMMddhhmmss");
	    String id = d1.format(d);
	    
	    String member_id = "A" +  id;
		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		String sex = request.getParameter("sex");
		int birth_year = Integer.parseInt(request.getParameter("birth_year"));
		int birth_month = Integer.parseInt(request.getParameter("birth_month"));
		int birth_day = Integer.parseInt(request.getParameter("birth_day"));
		String job = request.getParameter("job");
		String phone_number = request.getParameter("phone_number");
		String mail_address = request.getParameter("mail_address");
		
		r.setMember_id(member_id);
		r.setLast_name(last_name);
		r.setFirst_name(first_name);
		r.setSex(sex);
		r.setBirth_year(birth_year);
		r.setBirth_month(birth_month);
		r.setBirth_day(birth_day);
		r.setJob(job);
		r.setPhone_number(phone_number);
		r.setMail_address(mail_address);
		
		MemberDAO dao = new MemberDAO();
		try {
			MemberBean line2 = dao.registerSearch(r);
			if(line2 != null) {
				request.getRequestDispatcher("register_fail.jsp").forward(request, response);
			
			}else {
				try {
					int line = dao.register(r);
					if(line > 0) {
						request.setAttribute("member", r);
						request.getRequestDispatcher("register_success.jsp").forward(request, response);
					}else {
						out.println("会員情報の登録に失敗しました。");
					}
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		

}
}
