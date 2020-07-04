/// <reference types="cypress" />

describe('My Custom Commands Test Suite', () => {

    it('Login Test', function() {
        cy.login("admin@yourstore.com", "admin");
        cy.title().should("be.equal", "Dashboard / nopCommerce administration");

        cy.login("admin@yourstore.com", "admin123");
        cy.title().should("not.be.equal", "Dashboard / nopCommerce administration");

        cy.login("admin123@yourstore.com", "admin");
        cy.title().should("be.equal", "Your store. Login");
    })

    it('Add Customer Test', function() {
        cy.login("admin@yourstore.com", "admin");
        cy.log("Adding customer...");
    })

    it('Edit Customer Test', function() {
        cy.login("admin@yourstore.com", "admin");
        console.log("Editing customer...");
    })

})