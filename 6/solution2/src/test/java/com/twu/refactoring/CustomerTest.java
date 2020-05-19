package com.twu.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static com.twu.refactoring.PriceCode.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CustomerTest {

    private static final String OUTPUT_PATH = "/data/";

    private final Customer dinsdale = new Customer("Dinsdale Pirhana");

    private final Movie python = new Movie("Monty Python and the Holy Grail", REGULAR);
    private final Movie ran = new Movie("Ran", REGULAR);
    private final Movie la = new Movie("LA Confidential", NEW_RELEASE);
    private final Movie trek = new Movie("Star Trek 13.2", NEW_RELEASE);
    private final Movie wallace = new Movie("Wallace and Gromit", CHILDRENS);

    @BeforeEach
    public void setUpRentalList() {
        dinsdale.addRental(new Rental(python, 3));
        dinsdale.addRental(new Rental(ran, 1));
        dinsdale.addRental(new Rental(la, 2));
        dinsdale.addRental(new Rental(trek, 1));
        dinsdale.addRental(new Rental(wallace, 6));
    }

    @Test
    public void shouldOutputEmptyStatementWhenNoMovieRented() throws IOException {
        Customer customer = new Customer("Golden Shark");
        verifyOutput(customer.statement(), "outputEmpty");
    }

    @Test
    public void shouldOutputCustomerStatementWithRentalList() throws IOException {
        verifyOutput(dinsdale.statement(), "outputRentalList");
    }

    @Test
    public void shouldOutputChangedStatementWhenPriceCodeIsChanged() throws IOException {
        la.setPriceCode(REGULAR);
        verifyOutput(dinsdale.statement(), "outputChange");
    }

    private void verifyOutput(String actualValue, String fileName) throws IOException {
        final List<String> expected = Files.readAllLines(Paths.get(getClass().getResource(OUTPUT_PATH + fileName).getFile()));
        assertThat(Arrays.asList(actualValue.split("\n")), equalTo(expected));
    }

}
