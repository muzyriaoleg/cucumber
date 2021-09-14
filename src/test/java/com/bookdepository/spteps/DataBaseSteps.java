package com.bookdepository.spteps;

import com.bookdepository.db.DBService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

public class DataBaseSteps {

    DBService dbService = new DBService();

    public DataBaseSteps() throws SQLException {
    }

    @When("^Select users with occupation \"(.+)\" and age (.+) years, there are (.+) users in result set$")
    public void selectUsersWithFilter(String occupation, String ageFilter, int userQuantity)
        throws SQLException {
        ResultSet resultSet = dbService.select(String.format(
            "SELECT count(*) FROM users "
                + "WHERE occupation = '%s' "
                + "AND age %s;", occupation, ageFilter));
        Assertions.assertThat(resultSet.getInt("count(*)")).isEqualTo(userQuantity);
    }

    @When("^Select users with occupation \"(.+)\" and companies with employers number (.+) in same city - there is \"(.+)\" in \"(.+)\" in result$")
    public void selectUsersAndCompaniesWithFilter(String occupation, String employeeFilter,
        String employeeName, String companyName)
        throws SQLException {
        ResultSet resultSet = dbService.select(String.format(
            "SELECT users.user_name, companies.company_name FROM users "
                + "INNER JOIN companies "
                + "ON users.city = companies.city "
                + "WHERE occupation = '%s' "
                + "AND employers_number %s;", occupation, employeeFilter));
        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(resultSet.getString("user_name")).isEqualTo(employeeName);
        softAssert.assertThat(resultSet.getString("company_name")).isEqualTo(companyName);
        softAssert.assertAll();
    }

    @Given("^There is a row in companies table with company name \"(.+)\"$")
    public void createRowInTable(String companyName) throws SQLException {
        dbService.update(String.format(
            "INSERT INTO companies (company_name, city, employers_number, specialization) "
                + "VALUES ('%s', 'Cabul', 123, 'Potter');", companyName));

    }

    @When("^Delete row where company name is \"(.+)\"$")
    public void deleteRowFromTable(String companyName) throws SQLException {
        dbService.update(String.format(
            "DELETE "
                + "FROM companies "
                + "WHERE company_name = '%s';", companyName));

    }

    @Then("^There is no row where company name is \"(.+)\"$")
    public void verifyCompanyIsNotPresentInTable(String companyName) throws SQLException {
        ResultSet resultSet = dbService.select(String.format(
            "SELECT company_name "
                + "FROM companies "
                + "WHERE company_name = '%S';", companyName));
        resultSet.last();
        Assertions.assertThat(dbService.countRowsInResultSet()).isZero();
    }

    @When("^I create new table$")
    public void createNewTable() throws FileNotFoundException, SQLException {
        dbService.dropTableIfExist("userz");
        dbService
            .createTableWithSQLFile("src/test/resources/com.cucumber/sql/createUsersTable.sql");
    }

    @Then("New table appears in DataBase")
    public void verifyTableIsCreated() throws SQLException {
        Assertions.assertThat(dbService.countRowsInTable("userz")).isEqualTo(12);
    }
}
