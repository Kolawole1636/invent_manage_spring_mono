package com.softcodemath.ProvisionInventoryManagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(
		info = @Info(
				title="The SoftCodeMath Academy IMS App",
				description = "Backend Rest APIs For Inventory Management System",
				version = "v1.0",
				contact= @Contact(
						name= "Ridwan Ilelaboye",
						email = "ilelaboyeridwan@gmail.com"

				)



		)
)
public class ProvisionInventoryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvisionInventoryManagementApplication.class, args);


		// URL to access the swagger UI
		// http://localhost:8080/swagger-ui/index.html

	}

}
