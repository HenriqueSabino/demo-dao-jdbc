package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
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

        System.out.println("----------------------------------");

        System.out.println("=== TEST 4: seller insert ===");
          Seller newSeller = new Seller(9, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new Id = " + newSeller.getId());

        System.out.println("----------------------------------");

        System.out.println("=== TEST 5: seller update ===");
        newSeller.setName("Greg Orange");
        System.out.println("Updating Greg to Greg Orange!...");
        sellerDao.update(newSeller);
        sellers = sellerDao.findAll();
        sellers.forEach(System.out::println);

        System.out.println("----------------------------------");

        System.out.println("=== TEST 6: seller delete ===");
        System.out.println("Deleting...");
        sellerDao.deleteById(6);
        sellers = sellerDao.findAll();
        sellers.forEach(System.out::println);
    }
}
