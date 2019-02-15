package com.ryu.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ryu.dto.MemberVO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청 파라미터 조회
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");		
		String email = request.getParameter("email");
		
		int age = -1;
		
		try {
			age = Integer.parseInt(request.getParameter("age"));
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		//2. 비즈니스로직
		MemberVO dto = new MemberVO(id, pass, name, age, email);
		request.setAttribute("dto", dto);
		
		HttpSession session = request.getSession(); //new가 아니라 getSession session은
		//이미 가지고 있으닌깐
		
		session.setAttribute("dto", dto);
		//3. 응답처리
		RequestDispatcher rdp = request.getRequestDispatcher("/VIEW/result._1.jsp");
		rdp.forward(request, response);
	}

}
