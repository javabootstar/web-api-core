package com.ngsharma.SpringApp;

import com.ngsharma.SpringApp.model.Address;
import com.ngsharma.SpringApp.model.Employee;
import com.ngsharma.SpringApp.service.EmployeeService;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@SpringBootTest
class SpringAppApplicationTests {

	@Autowired
	EmployeeService employeeService;

	private Validator validator;

	@Test
	public void addEmployeeFakeData() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();

		List<Employee> employeeList = List.of(
				new Employee("N", "Sharma", "9311116074", "Quantum Developer", LocalDate.of(1993, 7, 31),
						new Address("3", "110078", "ngsharma415@gmail.com")),
				new Employee("Anjeet", "Sharma", "8130357667", "Full Stack Developer", LocalDate.of(1993, 8, 5),
						new Address("3", "110078", "anjeetsharma415@gmail.com"))

		);
		employeeList.forEach(e -> {
			Set<ConstraintViolation<Employee>> violations = validator.validate(e);
			violations.forEach(v -> System.out.println(v.getMessage()));
			assertEquals(e.getMobile().length(), 10);
			assertEquals(e.getCreateBy(), "Mr. Auditor");
			assertEquals(e.getLastModifiedBy(), "Mr. Auditor");
			assertNotNull(e.getCreationDate(), "Created Date is not null");
			assertNotNull(e.getLastModifiedDate(), "Last Modified Date is not null");
			System.out.println(employeeService.save(e));
		});
	}

	@Test
	public void updateData() {
		System.out.println(employeeService.save(new Employee(4,"Ng", "Sharma", "9891528966", "Quantum Developer", LocalDate.of(1993, 7, 31),
				new Address("3", "110078", "ngsharma@neostencil.com"))));
	}

}
