package dev.example.spring;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerRepo customerRepo;

    public CustomerController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping("/id")
    public Customer findById(@PathVariable("id") int id) {
        return this.customerRepo.findById(id).orElseThrow();
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer){
        return this.customerRepo.save(customer);
    }

    @GetMapping("/find-all")
    public List<Customer> findAll(){
        return this.customerRepo.findAll();

    }

    @GetMapping("/mail/{mail}")
    public Customer findByMail(@PathVariable("mail") String mail) {
        return this.customerRepo.findByMail(mail);

    }

    @GetMapping("/find/{mail}/{gender}")
    public Customer findByMailAndGender(@PathVariable("mail") String mail, @PathVariable("gender") Customer.Gender gender)
    {
        return this.customerRepo.findByMailAndGender(mail, gender);

    }

//    @GetMapping("/find/{gender}")
//    public List<Customer> findByGender(@PathVariable("gender") Customer.Gender gender){
//        return  this.customerRepo.findByGender(gender);
//    }


    //Aynı methodun custom versiyonu.
    @GetMapping("/find/{gender}")
    public List<Customer> findByGender(@PathVariable("gender") Customer.Gender gender){
        return  this.customerRepo.getQueryByGender(gender);
    }
}
