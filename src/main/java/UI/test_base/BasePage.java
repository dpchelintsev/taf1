package UI.test_base;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import UI.utils.MailUtils;

public class BasePage extends PageInstance {

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

   public WebDriverWait wait = new WebDriverWait(driver, 10);

    public String getCodeFromEmail(String mail, String pass){
        String host = "pop.gmail.com";// change accordingly
        String code = MailUtils.check(host, mail, pass);
        return code;
    }
}
