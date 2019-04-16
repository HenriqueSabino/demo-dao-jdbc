package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        
        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("----------------------------------");

        System.out.println("=== TEST 2: seller findByDepartment ===");

        Department dep = new Department(2, null);
        List<Seller> sellers = sellerDao.findByDepartment(dep);
        sellers.forEach(System.out::println);

        System.out.println("----------------------------------");

        System.out.println("=== TEST 3: seller findAll ===");
        sellers = sellerDao.findAll();
        sellers.forEach(System.out::println);
    }
}
