package com.example.springscrapingmobile;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = SpringScrapingMobileApplication.class)
@Slf4j
class SpringScrapingMobileApplicationTests {

    @Test
    void contextLoads() throws Exception {
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);

        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.setCssErrorHandler(new SilentCssErrorHandler());

        webClient.getOptions().setCssEnabled(true);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getOptions().setAppletEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setPopupBlockerEnabled(true);
        webClient.getOptions().setTimeout(10000);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(true);
        webClient.getOptions().setThrowExceptionOnScriptError(true);
        webClient.getOptions().setPrintContentOnFailingStatusCode(true);
        webClient.waitForBackgroundJavaScript(5000);
        try {
            HtmlPage page = webClient.getPage("https://www.tokopedia.com/p/handphone-tablet/handphone");
            page.executeJavaScript("var scrollingElement = (document.scrollingElement || document.body);\n" +
                    "scrollingElement.scrollTop = scrollingElement.scrollHeight;");
            log.info("result {}",page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        webClient.close();
    }

}
