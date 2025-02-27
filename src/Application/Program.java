package Application;

import model.dao.DaoFactory;
import model.dao.SallerDAO;
import model.entities.Seller;

public class Program {
	public static void main(String[]args) {
		
	
	SallerDAO sellerDao = DaoFactory.createSellerDao();
	System.out.println("=== Teste 1 ===");
	Seller seller = sellerDao.findById(3);
	System.out.println(seller);
	
	}

}
