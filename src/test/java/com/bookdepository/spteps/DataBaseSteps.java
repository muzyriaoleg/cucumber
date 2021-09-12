package com.bookdepository.spteps;

import com.bookdepository.db.DBConnector;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

public class DataBaseSteps {

    Connection connection = DBConnector.getConnection();
    Statement statement = connection.createStatement();
    ResultSet resultSet;

    public DataBaseSteps() throws SQLException {
    }

    @When("^Select users with occupation \"(.+)\" and age (.+) years$")
    public void selectUsersWithFilter(String occupation, String ageFilter) throws SQLException {
        resultSet = statement.executeQuery(String.format(
            "SELECT count(*) FROM users "
                + "WHERE occupation = '%s' "
                + "AND age %s;", occupation, ageFilter));
    }

    @Then("^There are (.+) users in result set$")
    public void verifyUserQuantityInResult(int userQuantity) throws SQLException {
        resultSet.next();
        Assertions.assertThat(resultSet.getInt("count(*)")).isEqualTo(userQuantity);
    }

    @When("^Select users with occupation \"(.+)\" and companies with employers number (.+) in same city$")
    public void selectUsersAndCompaniesWithFilter(String occupation, String employeeFilter)
        throws SQLException {
        resultSet = statement.executeQuery(String.format(
            "SELECT users.user_name, companies.company_name FROM users "
                + "INNER JOIN companies "
                + "ON users.city = companies.city "
                + "WHERE occupation = '%s' "
                + "AND employers_number %s;", occupation, employeeFilter));
    }

    @Then("^There is \"(.+)\" in \"(.+)\" in result$")
    public void verifyEmployeeAndCompanyInResult(String employeeName, String companyName)
        throws SQLException {
        resultSet.next();
        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(resultSet.getString("user_name")).isEqualTo(employeeName);
        softAssert.assertThat(resultSet.getString("company_name")).isEqualTo(companyName);
        softAssert.assertAll();
    }

    @Given("^There is a row in companies table with company name \"(.+)\"$")
    public void createRowInTable(String companyName) throws SQLException {
        statement.executeUpdate(String.format(
            "INSERT INTO companies (company_name, city, employers_number, specialization) "
                + "VALUES ('%s', 'Cabul', 123, 'Potter');", companyName));
    }

    @When("^Delete row where company name is \"(.+)\"$")
    public void deleteRowFromTable(String companyName) throws SQLException {
        statement.executeUpdate(String.format(
            "DELETE "
                + "FROM companies "
                + "WHERE company_name = '%s';", companyName));
    }

    @Then("^There is no row where company name is \"(.+)\"$")
    public void verifyCompanyIsNotPresentInTable(String companyName) throws SQLException {
        resultSet = statement.executeQuery(String.format(
            "SELECT company_name "
                + "FROM companies "
                + "WHERE company_name = '%S';", companyName));
        Assertions.assertThat(resultSet.getFetchSize()).isZero();
    }

    @When("^I create new table$")
    public void createNewTable() throws FileNotFoundException {
        Reader reader = new BufferedReader(new FileReader(
            "src/test/resources/com.cucumber/sql/createUsersTable.sql"));
        ScriptRunner runner = new ScriptRunner(connection);
        runner.runScript(reader);
    }

    @Then("New table appears in DataBase")
    public void verifyTableIsCreated() throws SQLException {
        resultSet = statement.executeQuery(
            "SELECT count(*) "
            + "FROM userz;");
        resultSet.next();
        Assertions.assertThat(resultSet.getInt("count(*)")).isEqualTo(12);
    }
}
