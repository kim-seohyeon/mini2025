package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CartService.CartInsertService;
import CartService.CartListService;
import ItemRentalService.ItemRentalService;
import ItemRentalService.ItemRentalsService;
import ItemRentalService.ReturnService;
import ItemService.ItemAutoIdService;
import ItemService.ItemDeleteService;
import ItemService.ItemDetailService;
import ItemService.ItemListService;
import ItemService.ItemUpdateService;
import ItemService.ItemWriteService;
import RentalInfoService.OwnerListService;
import RentalInfoService.RenterListService;
import RentalWishItemService.RentalWishItemService;
import UserService.UserDeleteService;
import UserService.UserDetailService;
import UserService.UserUpdateService;
import UserService.UserWriteService;

public class UserFrontController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equals("/userAgree.mini")) {
			System.out.println("회원가입");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("user/userForm.jsp");
			dispatcher.forward(request, response);
		
		}else if(command.equals("/userDetail.mini")) {
			System.out.println("내 정보");
			
			UserDetailService action = new UserDetailService();
			action.execute(request);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("user/userDetail.jsp");
			dispatcher.forward(request, response);			
		
		}else if(command.equals("/userModify.mini")) {
			System.out.println("내 정보 수정하기");
			
			UserDetailService action = new UserDetailService();
			action.execute(request);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("user/userUpdate.jsp");
			dispatcher.forward(request, response);
		
		}else if(command.equals("/userDelete.mini")){
			System.out.println("회원탈퇴");
			
			UserDeleteService action = new UserDeleteService();
			action.execute(request);
			
			//삭제할 때 session에 저장되어 있는 거 불러와서 지우기
			HttpSession session = request.getSession();
			session.invalidate();
			
			response.sendRedirect("index.jsp");
		}
		
		else if(command.equals("/itemList.mini")) {
			System.out.println("대여상품 관리");
			
			ItemListService action = new ItemListService();
			action.excute(request);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("item/itemList.jsp");
			dispatcher.forward(request, response);
		
		}else if(command.equals("/itemWrite.mini")) {
			System.out.println("상품 추가");

			ItemAutoIdService action = new ItemAutoIdService();
			action.execute(request);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("item/itemForm.jsp");
			dispatcher.forward(request, response);
		
		}else if(command.equals("/itemDetail.mini")) {
			System.out.println("상품 상세보기");
			
			ItemDetailService action = new ItemDetailService();
			action.execute(request);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("item/itemDetail.jsp");
			dispatcher.forward(request, response);
			
		}else if(command.equals("/itemModify.mini")) {
			System.out.println("상품 수정하기");
			
			ItemDetailService action = new ItemDetailService();
			action.execute(request);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("item/itemUpdate.jsp");
			dispatcher.forward(request, response);
			
		}else if(command.equals("/itemDelete.mini")) {
			
			ItemDeleteService action = new ItemDeleteService();
			action.execute(request);
			
			System.out.println("상품 삭제");

			response.sendRedirect("itemList.mini");

		}else if(command.equals("/detailView.mini")) {
			System.out.println("상품구경");
			
			ItemDetailService action = new ItemDetailService();
			action.execute(request);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("item/itemDetailView.jsp");
			dispatcher.forward(request, response);
			
		}else if(command.equals("/cartList.mini")) {
			System.out.println("장바구니 목록");
		
			CartListService action = new CartListService();
			action.execute(request);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("item/cartList.jsp");
			dispatcher.forward(request, response);
		
		}else if(command.equals("/renterList.mini")) {
			System.out.println("대여자 목록");
			
			RenterListService action = new RenterListService();
			action.execute(request);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("rental/renterList.jsp");
			dispatcher.forward(request, response);
		
		}else if(command.equals("/ownerList.mini")) {
			System.out.println("빌린 상품 목록");
			
			OwnerListService action = new OwnerListService();
			action.execute(request);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("rental/ownerList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/return.mini")) {
			System.out.println("반납완료");
			ReturnService action = new ReturnService();
			action.execute(request);
			response.sendRedirect("renterList.mini");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		if(command.equals("/userWrite.mini")) {
			
			UserWriteService action = new UserWriteService();
			action.execute(request);
			
			System.out.println("회원가입 되었습니다.");
			response.sendRedirect(contextPath);
			
		}else if(command.equals("/userModify.mini")){
			
			UserUpdateService action = new UserUpdateService();
			action.execute(request);
			
			System.out.println("회원정보수정 되었습니다.");
	
			response.sendRedirect("userDetail.mini?userId="+request.getParameter("userId"));

		}else if(command.equals("/itemRegist.mini")) {
			
			ItemWriteService action = new ItemWriteService();
			action.execute(request);
			
			System.out.println("상품이 등록되었습니다.");
			response.sendRedirect("itemList.mini");
		
		}
		
		else if(command.equals("/itemModify.mini")) {
			
			ItemUpdateService action = new ItemUpdateService();
			action.execute(request);
			
			System.out.println("상품이 수정되었습니다.");
			response.sendRedirect("itemDetail.mini?itemId="+request.getParameter("itemId"));
			
		}else if(command.equals("/wishItem.mini")) {

			System.out.println("위시상품이 등록되었습니다.");
			RentalWishItemService action = new RentalWishItemService();
			action.execute(request);
			
		}else if(command.equals("/cart.mini")) {
			
			
			System.out.println("장바구니에 담겼습니다.");
			CartInsertService action = new CartInsertService();
			action.execute(request);
			
		}else if(command.equals("/itemRental.mini")) {
			System.out.println("대여하는 페이지입니다.");
			
			ItemRentalService action = new ItemRentalService();
			action.execute(request);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("item/itemRental.jsp");
			dispatcher.forward(request, response);
		
		}else if(command.equals("/itemRentals.mini")) {
			System.out.println("대여 상품 저장 페이지입니다.");
			
			ItemRentalsService action = new ItemRentalsService();
			action.execute(request);
			
			response.sendRedirect(contextPath);
		}
	}
}
