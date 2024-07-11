package dev.example.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//CrudRepository, JPARepository
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Customer findByMail(String mail);

    Customer findByMailAndGender(String mail, Customer.Gender gender );

    List<Customer> findByGender(Customer.Gender gender);
}
