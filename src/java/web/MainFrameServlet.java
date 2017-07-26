package web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import utility.ManagementSystem;
import utility.Product;
import utility.ProductHandler;
import utility.ViewCounter;
import web.forms.MainFrameForm;

@WebServlet("/main")
@MultipartConfig
public class MainFrameServlet extends HttpServlet {
	private static final long serialVersionUID = 5915869354354505354L;

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	log("GET called");
    	req.setCharacterEncoding("UTF-8");
   
    	String sort = req.getParameter("sort");
    	
    	MainFrameForm form = new MainFrameForm();
    	Collection<Product> products;
        try {
            products = ManagementSystem.getInstance().getAllProducts(sort);
        } catch (SQLException sql_e) {
            throw new IOException(sql_e.getMessage());
        }
        
        String type = req.getParameter("type"); //TODO move to sql part, combine with order
    	if (type != null && products != null) {
    		Iterator<Product> iter = products.iterator();
    		Collection<Product> filteredProducts = new ArrayList<>() ;
    		if (type.equals("exellent")) {
    			while (iter.hasNext()){
    				Product p = iter.next();
    				if (p.getRating() > 4)
    					filteredProducts.add(p);
    			}
    		}
    		if (type.equals("good")) {
    			while (iter.hasNext()){
    				Product p = iter.next();
    				if (p.getRating() > 3 && p.getRating() <= 4 )
    					filteredProducts.add(p);
    			}
    		}
    		if (type.equals("bad")) {
    			while (iter.hasNext()){
    				Product p = iter.next();
    				if (p.getRating() <= 3)
    					filteredProducts.add(p);
    			}
    		}
    		products = filteredProducts;
    	}
    	form.setProducts(products);
        req.setAttribute("form", form);
        req.setAttribute("productsViewCount", ViewCounter.getInstance().getViewCountOfAllProducts());
        getServletContext().getRequestDispatcher("/ShelfFrame.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	log("POST called");
    	req.setCharacterEncoding("UTF-8");
    	resp.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html; charset=UTF-8");
    }
    
    
    
}
