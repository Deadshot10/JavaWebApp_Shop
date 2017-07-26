package web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
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

@WebServlet("/service")
@MultipartConfig
public class ServiceFrameServlet extends HttpServlet {
	private static final long serialVersionUID = 6335824354657899304L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String savedpath = "C:\\User\\1.xml";
		req.setAttribute("savedpath", savedpath);
		getServletContext().getRequestDispatcher("/ServiceFrame.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log("POST called");
    	req.setCharacterEncoding("UTF-8");
    	resp.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html; charset=UTF-8");
    	
    	if (req.getParameter("Upload") != null) {
    		readFile(req, resp);
    	}
    	resp.sendRedirect("main");
	}

private void readFile(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    	
    	final Part filePart = req.getPart("file");
	    InputStream filecontent = null;

	    try {
	        filecontent = filePart.getInputStream();
	        ArrayList<Product> products = new ProductHandler(getServletContext()).parseFile(filecontent);
	        Iterator<Product> iter = products.iterator();
	        
	        while (iter.hasNext()) {
	        	
	        	ManagementSystem.getInstance().insertProduct(iter.next());
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if (filecontent != null) {
	            filecontent.close();
	        }
	    }
	    
    }
	
	
}
