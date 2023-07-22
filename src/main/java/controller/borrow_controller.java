package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BookDAO;
import DAO.BorrowDAO;
import DAO.MemberDAO;
import DAO.StatsDAO;
import model.Book_Model;
import model.Borrow_Model;
import model.Member_Model;
import model.Stats_Model;

/**
 * Servlet implementation class borrow_controller
 */
public class borrow_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borrow_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = request.getSession();
		
		if(request.getParameter("mode") != null) {
			String mode = request.getParameter("mode");
			
			System.out.println(mode);
			
			if(mode.equals("search_book")) {
				String search_result = request.getParameter("search_result");
				BorrowDAO BMDAO = new BorrowDAO();
				System.out.println(search_result);
				ArrayList<Borrow_Model> blist = BMDAO.find(search_result);
				request.setAttribute("borrowlist", blist);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}else if(mode.equals("stats")) {
				StatsDAO stdao = new StatsDAO();
				ArrayList<Stats_Model>  stats_data = stdao.Get_stats();
				request.setAttribute("stats_result", stats_data);
				request.getRequestDispatcher("Stats.jsp").forward(request, response);
				
			}else if(mode.equals("borrow")) {
				MemberDAO mmdao = new MemberDAO();
				ArrayList<Member_Model> mm = mmdao.findAll();
				
				
				BookDAO bdao = new BookDAO();
				ArrayList<Book_Model> bm = bdao.findAll();
				
				request.setAttribute("MemberAll",mm);
				request.setAttribute("BookAll", bm);
				
				request.getRequestDispatcher("Borrow.jsp").forward(request, response);
//				response.sendRedirect("Borrow.jsp?form=1");
			}else if(mode.equals("borrow_submit")) {
				 
				 
				String bid = request.getParameter("b_id");
				String mid = request.getParameter("m_id");
				String date = request.getParameter("DateSelected");
				
				System.out.println("b_id" + bid + "m_id" + mid);
				
				BorrowDAO bdao = new BorrowDAO();
				
				int status = bdao.AddBorrow(bid, mid, date);
				
				if(status != 0) {
					session.setAttribute("success", "เพิ่มการยืมหนังสือสำเร็จ !");
					request.getRequestDispatcher("borrow_controller?mode=borrow").forward(request, response);
				}else {
					session.setAttribute("error", "เพิ่มการยืมหนังสือไม่สำเร็จ !");
					request.getRequestDispatcher("borrow_controller?mode=borrow").forward(request, response);
				}
				
			}else if(mode.equals("return")) {
				
				BorrowDAO bdao = new BorrowDAO();
				
				ArrayList<Borrow_Model> brm = bdao.findAllNotReturn();
			
				
				request.setAttribute("bnotrt",brm);
				
				request.getRequestDispatcher("Return.jsp").forward(request, response);
			}else if(mode.equals("return_submit")) {
				String br_date_br = request.getParameter("br_date_br");
				String fine = request.getParameter("fine");
				String br_date_rt = request.getParameter("date_rt");
				String b_id = request.getParameter("b_id");
				String m_id = request.getParameter("m_id");
				
				BorrowDAO bdao = new BorrowDAO();
				
				int status = bdao.ReturnEdit(br_date_br, fine, br_date_rt, b_id, m_id);
				
				if(status != 0) {
					session.setAttribute("success", "คืนหนังสือสำเร็จ !");
					request.getRequestDispatcher("borrow_controller?mode=return").forward(request, response);
				}else {
					session.setAttribute("error", "คืนหนังสือไม่สำเร็จ !");
					request.getRequestDispatcher("borrow_controller?mode=return").forward(request, response);
				}
			}else if(mode.equals("search_return")) {
				String search = request.getParameter("search");
				
				BorrowDAO bdao = new BorrowDAO();
				
				ArrayList<Borrow_Model> brm = bdao.SearchAllNotReturn(search);
				
				request.setAttribute("bnotrt",  brm);
				request.getRequestDispatcher("Return.jsp").forward(request, response);
			}
			
		}else {
			BorrowDAO BMDAO = new BorrowDAO();
			ArrayList<Borrow_Model> blist = BMDAO.findAll();
			request.setAttribute("borrowlist", blist);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
