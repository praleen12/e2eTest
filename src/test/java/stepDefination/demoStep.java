package stepDefination;

import io.cucumber.java.en.*;

public class demoStep {

	@Given("I launch to demo application")
	public void i_launch_to_demo_application() {
		System.out.println("I m in first step");

	}

	@When("I complete action")
	public void i_complete_action() {
		System.out.println("I m in second step");

	}

	@When("some other action")
	public void some_other_action() {
		System.out.println("I m in third step");

	}
	
	
	@Given("calculate value of i")
	public void calculate_value_of_i() {
		int i;
		i=10/0;
		System.out.println(i);
		
	}
	


}
