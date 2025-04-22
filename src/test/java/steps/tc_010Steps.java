package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.tc_010Page;

public class tc_010Steps {
    tc_010Page page = new tc_010Page();

    @Given("the report is exported")
    public void reportIsExported() {
        page.exportReport();
    }

    @When("I open the Excel report to locate the 'Ramo' field")
    public void openExcelToFindRamo() {
        page.openExcelAndFindRamo();
    }

    @Then("I should identify the 'Ramo' field")
    public void identifyRamoField() {
        Assert.assertTrue(page.isRamoFieldIdentified());
    }

    @When("I check for the column 'Folio Pre solicitud' to the right of 'Ramo'")
    public void checkColumnToRight() {
        page.verifyColumnPreSolicitudIsRightOfRamo();
    }

    @Then("the 'Folio Pre solicitud' column should exist in the correct position without any data")
    public void verifyPreSolicitudColumn() {
        Assert.assertTrue(page.isPreSolicitudColumnCorrect());
    }
}