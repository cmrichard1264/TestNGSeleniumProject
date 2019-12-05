package tests.vytrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.CreateCalendarEventPage;
import pages.LoginPage;
import tests.TestBase;

public class CreateCalendarEventTests extends TestBase {

    @Test(description = "Verify owners name is equals to 'Stevan Haley'")
    public void test1(){
        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();

        loginPage.login("storemanager85", "UserUser123");

        loginPage.navigateTo("Activities", "Calendar Events");

        //click on create calendar event button
        calendarEventsPage.waitUntilLoaderMaskDisappear();
        calendarEventsPage.clickToCreateCalendarEvent();

        calendarEventsPage.waitUntilLoaderMaskDisappear();
        String expectedOwner = "Stephan Haley";
        String actualOwner = createCalendarEventPage.owner.getText().trim();

        Assert.assertEquals(actualOwner, expectedOwner);



    }
}
