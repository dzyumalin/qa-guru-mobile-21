package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.DeviceConfig;
import config.Project;
import drivers.SelenoidDriver;
import helpers.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.util.Objects;

public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        if (Objects.equals(Project.deviceConfig.driver(), "SelenoidDriver")) {
            SelenoidDriver.configure();
            System.out.println(Project.deviceConfig.hubUrl());
        } else {
            Configuration.browser = "drivers." + Project.deviceConfig.driver();
            Configuration.startMaximized = false;
            Configuration.browserSize = null;
            Configuration.timeout = 10000;
        }

    }

    @AfterEach
    public void allureAttachments() {
        AllureAttachments.addAttachments(Project.deviceConfig.driver());
        Configuration.browser = "drivers." + Project.deviceConfig.driver();
    }
}
