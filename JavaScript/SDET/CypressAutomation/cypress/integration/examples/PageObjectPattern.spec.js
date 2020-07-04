/// <reference types="cypress" />

import LoginPage from "../PageObjects/LoginPage";

describe('My Page Object Pattern Test Suite', () => {

    it('Login Test', function() {
        const loginPage = new LoginPage();

        loginPage.visit();
        loginPage.fillEmail("admin@yourstore.com");
        loginPage.fillPassword("admin");
        loginPage.submit();

        cy.title().should("be.equal", "Dashboard / nopCommerce administration");
    })

})