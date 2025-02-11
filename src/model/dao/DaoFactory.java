package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	public static SallerDAO createSellerDao(){
		return new SellerDaoJDBC();
	}
}
