package com.softcodemath.ProvisionInventoryManagement.service;


import com.softcodemath.ProvisionInventoryManagement.dto.EmailDetails;
import com.softcodemath.ProvisionInventoryManagement.dto.OrderRequest;
import com.softcodemath.ProvisionInventoryManagement.entity.Customer;
import com.softcodemath.ProvisionInventoryManagement.entity.Order;
import com.softcodemath.ProvisionInventoryManagement.entity.Product;
import com.softcodemath.ProvisionInventoryManagement.repository.CustomerRepo;
import com.softcodemath.ProvisionInventoryManagement.repository.OrderRepo;
import com.softcodemath.ProvisionInventoryManagement.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private EmailService emailService;

    public ResponseEntity<String> createOrder(OrderRequest orderRequest) {

        Order order = new Order();
        if(productRepo.existsById(orderRequest.getProductId())){

            Product findProduct = productRepo.findById(order.getProductId()).get();

            if(findProduct.getAvailableQuantity()>= order.getQuantityOrder()){

                findProduct.setAvailableQuantity(findProduct.getAvailableQuantity() - order.getQuantityOrder());

                order.setCustomerId(orderRequest.getCustomerId());
                order.setProductId(order.getProductId());
                order.setTotalPrice(findProduct.getPrice() * orderRequest.getQuantityOrder());

                orderRepo.save(order);
                productRepo.save(findProduct);

                Customer customer = customerRepo.findById(order.getCustomerId()).get();


                EmailDetails details = new EmailDetails();
                details.setRecipient(customer.getEmail());
                details.setSubject("ORDER CREATION");
                details.setMessageBody("Welcome To SoftCode Store your order has been successfully created"+"\n"
                        + "Product Ordered:" + findProduct.getName() + "\n"
                        + "Quantities:" + orderRequest.getQuantityOrder() + "\n"
                        + "Total Price:" + order.getTotalPrice() + "\n"
                        + "Customer Name:" + customer.getName());
                emailService.sendMail(details);

                return new ResponseEntity<>("Order has been created successfully", HttpStatus.CREATED);


            }

            else{
                String no_quantity ="We don't have enough quantities for the product you want to order";

                return new ResponseEntity<>(no_quantity, HttpStatus.NO_CONTENT);
            }


        }

        String product_not_exist ="the product you are trying to order does not exist.";

        return new ResponseEntity<>(product_not_exist, HttpStatus.NOT_FOUND);


    }


    public Order getOrder(int id) {

        return orderRepo.findById(id).get();
    }


}
