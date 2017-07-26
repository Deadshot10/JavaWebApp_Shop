package web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.ManagementSystem;
import utility.Product;
import utility.ViewCounter;
import web.forms.ProductForm;

@WebServlet("/edit")
public class ProductFrameServlet extends HttpServlet {
	private static final long serialVersionUID = 4864778008367498745L;
	
	
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	resp.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html; charset=UTF-8");
    	String pId = req.getParameter("id");
    	ProductForm pForm = new ProductForm();
    	if (pId != null) {
	        try {
	        	pForm.initFromProduct(ManagementSystem.getInstance().getProductById(Long.parseLong(pId)));
	        } catch (SQLException sql_e) {
	            throw new IOException(sql_e.getMessage());
	        }
	        ViewCounter.getInstance().increaseCount(pId);
	        req.setAttribute("productsViewCount", ViewCounter.getInstance().getViewCountOfProduct(pId));
    	}
    	req.setAttribute("pForm", pForm);
    	
        getServletContext().getRequestDispatcher("/ProductFrame.jsp").forward(req, resp);
    }

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
    	resp.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html; charset=UTF-8");
    	
    	if (req.getParameter("Cancel") != null) {
    		resp.sendRedirect("main");
    	}

    	String pId = req.getParameter("id");

    	try {
	        if (pId != null) {
	        	if(req.getParameter("Create") != null) {
	            
	                if (Integer.parseInt(pId) > 0) {
	                	updateProduct(req);
	                }
	                else {
	                    insertProduct(req);
	                }
	                resp.sendRedirect("main");
	        	}
	        	if (req.getParameter("Delete") != null) {
	        		deleteProduct(req);
	        		resp.sendRedirect("main");
	        	}
	        }
    	} catch (SQLException|ParseException e) {
            e.printStackTrace();
            //TODO return response with errors
        } 
    }

    private void updateProduct(HttpServletRequest req) throws SQLException, ParseException {
        Product p = prepareProduct(req);
        ManagementSystem.getInstance().updateProduct(p);
    }

    private void insertProduct(HttpServletRequest req) throws SQLException, ParseException {
    	Product p = prepareProduct(req);
    	ManagementSystem.getInstance().insertProduct(p);
    }

    private void deleteProduct(HttpServletRequest req) throws SQLException, ParseException {
    	Product p = prepareProduct(req);
    	ManagementSystem.getInstance().deleteProduct(p);
    }
    
    private Product prepareProduct(HttpServletRequest req) throws ParseException {
    	Product s = new Product();
    	s.setId(Long.parseLong(req.getParameter("id")));
        s.setProduct_id(Long.parseLong(req.getParameter("product_id")));
        s.setTitle(req.getParameter("title").trim());
        s.setDescription(req.getParameter("description").trim());
        s.setRating(Float.parseFloat(req.getParameter("rating")));
        s.setPrice(Long.parseLong(req.getParameter("price")));
        s.setInet_price(Long.parseLong(req.getParameter("inet_price")));
        s.setImage(req.getParameter("image").trim());
        return s;
    }

}
