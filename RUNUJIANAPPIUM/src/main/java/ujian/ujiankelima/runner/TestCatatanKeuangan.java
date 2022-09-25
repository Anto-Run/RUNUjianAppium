package ujian.ujiankelima.runner;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import ujian.ujiankelima.pageobject.CatatanKeuangan;

public class TestCatatanKeuangan {
	
	private static AndroidDriver<MobileElement> driver;
	private CatatanKeuangan catatanKeuangan;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ASUS_Z01QD");
		capabilities.setCapability("uuid", "127.0.0.1:21533");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.1.2");
		capabilities.setCapability("appPackage", "com.chad.financialrecord");
		capabilities.setCapability("appActivity", "com.rookie.catatankeuangan.feature.main.MainActivity");//automationName
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		catatanKeuangan = new CatatanKeuangan(driver);
		
	}
	
	@Test(priority=0)
	public void testAdd() {
		System.out.println("------------------------------------------");
		System.out.println("       Menambahkan Data Pengeluaran     ");
		catatanKeuangan.AddExpense("10000", "Nasi Padang");
		assertTrue(catatanKeuangan.getTxtDesc().contains("Nasi Padang"));
		System.out.println("------------------------------------------");
	}
	
	@Test(priority=1)
	public void testAddIncome() {
		System.out.println("------------------------------------------");
		System.out.println("       Menambahkan Data Pemasukan        ");
		catatanKeuangan.AddIncome("10000000", "Gaji");
		assertTrue(catatanKeuangan.getTxtDesc().contains("Gaji"));
		System.out.println("------------------------------------------");
	}
	
	@Test(priority=2)
	public void testDeleteData() {
		System.out.println("------------------------------------------");
		System.out.println("             Menghapus Data        ");
		catatanKeuangan.deleteData("Gaji");
		assertTrue(catatanKeuangan.validasiDelete().contains("Nasi"));
		System.out.println("------------------------------------------");
	}
	@Test(priority=3)
	public void testExport() {
		System.out.println("------------------------------------------");
		System.out.println("               Export Data         ");
		catatanKeuangan.exportData("Laporan Bulan", "Pemasukan", "CSV");
		assertTrue(catatanKeuangan.getTxtAlertDone().contains("Berhasil"));
		System.out.println("------------------------------------------");
	}
	
	@AfterTest
	public void closeApp() {
		driver.quit();
	}
	

}
