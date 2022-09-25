package ujian.ujiankelima.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CatatanKeuangan {
	
	public AndroidDriver<MobileElement> driver;

	public CatatanKeuangan(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//locator
	@AndroidFindBy(id="android:id/button2")
	private MobileElement btnClose;
	
	@AndroidFindBy(id="com.chad.financialrecord:id/fabMenu")
	private MobileElement btnAdd;	
	
	@AndroidFindBy(id="com.chad.financialrecord:id/tvName")
	private MobileElement category;
	
	@AndroidFindBy(id = "com.chad.financialrecord:id/etAmount")
	private MobileElement amount;
	
	@AndroidFindBy(id="com.chad.financialrecord:id/etNote")
	private MobileElement note;
	
	@AndroidFindBy(id="com.chad.financialrecord:id/btSave")
	private MobileElement btnSave;
	
	@AndroidFindBy(id="com.chad.financialrecord:id/btnIncome")
	private MobileElement btnIncome;
	
	@AndroidFindBy(id="com.chad.financialrecord:id/tvDesc")
	private MobileElement txtDesc;
	
	@AndroidFindBy(id="com.chad.financialrecord:id/ibExport")
	private MobileElement btnExport;
	
	@AndroidFindBy(id="com.chad.financialrecord:id/etTitle")
	private MobileElement titleExport;
	
	//format export 
	@AndroidFindBy(id="com.chad.financialrecord:id/spFormat")
	private MobileElement btnFormat;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]")
	private MobileElement formatPdf;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]")
	private MobileElement formatXls;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]")
	private MobileElement formatCsv;
	
	//Category export
	@AndroidFindBy(id = "com.chad.financialrecord:id/spCategory")
	private MobileElement btnCategoryExport;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]")
	private MobileElement allCategory;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]")
	private MobileElement income;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]")
	private MobileElement expense;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]")
	private MobileElement customize;
	
	
	
	@AndroidFindBy(id="com.chad.financialrecord:id/btOk")
	private MobileElement btnDone;
	
	@AndroidFindBy(id="android:id/alertTitle")
	private MobileElement txtAlertDone;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]")
	private MobileElement dataOne;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]")
	private MobileElement dataTwo;
	
	@AndroidFindBy(id="com.chad.financialrecord:id/ibDelete")
	private MobileElement btnDelete;
	
	@AndroidFindBy(id="android:id/button1")
	private MobileElement btnIsDelete;
	public void AddExpense(String amount, String note) {
		btnClose.click();
		btnAdd.click();
//		this.category.click();
////		this.date.clear();
////		this.date.setId(date);
//		Select sCategory = new Select(this.category);
//		sCategory.selectByVisibleText(category);;
		this.amount.sendKeys(amount);
		this.note.sendKeys(note);
		btnSave.click();
	}	
	
	public void AddIncome(String amount, String note) {
		btnAdd.click();
		btnIncome.click();
//		this.category.click();
//		Select sCategory = new Select(this.category);
//		sCategory.selectByVisibleText(category);;
////		this.category.setId(category);
		this.amount.sendKeys(amount);
		this.note.sendKeys(note);
		btnSave.click();
	}	
	
	public void exportData(String title, String category, String format) {
		btnExport.click();
		titleExport.clear();
		titleExport.sendKeys(title);
		btnCategoryExport.click();
		if(category.equalsIgnoreCase("Semua Kategori")) {
			allCategory.click();
		}else if(category.equalsIgnoreCase("Pemasukan")) {
			income.click();
		}else if(category.equalsIgnoreCase("Pengeluran")) {
			expense.click();
		}else if(category.equalsIgnoreCase("Sesuaikan")) {
			customize.click();
		}else {
			System.out.println("Kategori Export Tidak Sesuai");
		}
		btnFormat.click();
		if(format.equalsIgnoreCase("PDF")) {
			formatPdf.click();
		}else if(format.equalsIgnoreCase("XLS")) {
			formatXls.click();
		}else if(format.equalsIgnoreCase("CSV")){
			formatCsv.click();
		}else {
			System.out.println("Format Export Tidak Sesuai");
		}
		btnDone.click();
		
	}
	
	public void deleteData(String desc) {
		
		if(dataOne.getText().equalsIgnoreCase(desc)) {
			dataOne.click();
		}else if(dataOne.getText().equalsIgnoreCase(desc)) {
			dataTwo.click();
		}
		btnDelete.click();
		btnIsDelete.click();
		
	}
	
	public String getTxtDesc() {
		return txtDesc.getText();
	}
	public String getTxtAlertDone() {
		return txtAlertDone.getText();
	}
	
	public String validasiDelete() {
		return dataOne.getText();
	}
	
	
	


}
