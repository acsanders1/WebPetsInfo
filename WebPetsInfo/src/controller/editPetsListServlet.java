package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PetInfo;

/**
 * Servlet implementation class editPetsListServlet
 */
@WebServlet("/editPetsListServlet")
public class editPetsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPetsListServlet() {
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
		// TODO Auto-generated method stub
//		doGet(request, response);
		PetInfoHelper dao = new PetInfoHelper();
		String act = request.getParameter("doThisToPet");
		if(act == null)
		{
			getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request,  response);
		}
		else if(act.equals("Delete Selected Pet"))
		{
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			PetInfo petToDelete = dao.searchForItemById(tempId);
			dao.deleteItem(petToDelete);
			getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);
		}
		else if(act.equals("Edit Selected Pet"))
		{
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			PetInfo petToEdit = dao.searchForItemById(tempId);
			request.setAttribute("petToEdit", petToEdit);
			getServletContext().getRequestDispatcher("/edit-pet.jsp").forward(request, response);
		}
		else if(act.equals("Add New Pet"))
		{
			getServletContext().getRequestDispatcher("/addPet.html").forward(request,  response);
		}
	}

}
