package TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGKrishna {


	@BeforeSuite
	public void beforesuite()
	{
		System.out.println("i am before suite");
	}
	@BeforeClass
	public void beforecalss()
	{
		System.out.println("i am before class");
	}
	@BeforeTest()
	public void beforetest()
	{
		System.out.println("i am before test");
	}
	@BeforeMethod()
	public void beforemethod()
	{
		System.out.println("i am before method");
	}
	@Test
	public void z_test1()
	{
		System.out.println("I am only Z");
	}
	@Test (dependsOnMethods = "z_test1")
	public void a_test2()
	{
		System.out.println("I am only A");
	}
	@Test (enabled = true)
	public void BPV2_1000_001()
	{
		System.out.println("I am only BPV2_1000_001");
	}
	@Test (priority = 0)
	public void p0()
	{
		System.out.println("I am priority = 0");
	}
	@Test (priority = 2)
	public void p2()
	{
		System.out.println("I am priority = 2");
	}
	@Test (priority = -1)
	public void p1()
	{
		System.out.println("I am priority = -1");
	}
	@Test 
	public void include1()
	{
		System.out.println("Include me 1");
	}
	@Test (groups = {"Sanity"})
	public void include2()
	{
		System.out.println("i am only Sanity");
	}
	@Test
	public void include3()
	{
//		Validating a case here
		Assert.assertEquals(false, null); // hard assert
		
//		Validating a case here
		Assert.assertEquals(false, null);
		
//		Validating a case here
		Assert.assertEquals(false, null);
		
		
//		Soft Assert
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(false, false);
		
	}
	
	@Test (dataProvider = "getData")
	public void logindP(String email, String password)
	{
		System.out.println(email);
		System.out.println(password);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object data[][] = new Object[3][2];
		
//		1st DataSet
		data[0][0] = "positiveemailaddress";
		data[0][1] = "positivepassword";
		
//		2nd DataSet
		data[1][0] = "negetiveemailaddress";
		data[1][1] = "positivepassword";
		
//		3rd DataSet
		data[2][0] = "positiveemailaddress";
		data[2][1] = "negetivepassword";
		
		return data;
		
	}
	@Parameters({"URL","URL1"})
	@Test (groups = {"Sanity","Smoke"})
	public void loginfromxml(String URL, String URL1)
	{
		System.out.println(URL);
		System.out.println(URL1);
		
	}
	
}
