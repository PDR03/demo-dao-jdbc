package Application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SallerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[]args) {
		
	
	SallerDAO sellerDao = DaoFactory.createSellerDao();
	System.out.println("=== Teste 1 ===");
	Seller seller = sellerDao.findById(3);
	System.out.println(seller);
	
	System.out.println("=== Teste 2 ===");
	Department department = new Department(2 , null);
	List<Seller> list = sellerDao.findByDepartment(department);
	

		for(Seller obj : list) {
			System.out.println(obj);
		}
	}
}
