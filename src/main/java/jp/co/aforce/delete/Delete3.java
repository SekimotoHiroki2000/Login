package jp.co.aforce.delete;

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
 * Servlet implementation class Delete3
 */
@WebServlet("/view/delete3")
public class Delete3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete3() {
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
		String member_id = request.getParameter("member_id");
		MemberBean d = new MemberBean();
		d.setMember_id(member_id);
		
		MemberDAO dao = new MemberDAO();
		try {
			int line = dao.delete(d);
			if(line > 0) {		
				request.getRequestDispatcher("delete_success.jsp").forward(request, response);
			}else {
				out.println("会員情報の削除に失敗しました。");
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}

}
