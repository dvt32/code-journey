/// <reference types="Cypress" />

describe('UI Elements', () => {

    it('Verify Inputbox & Radiobuttons', () => {
        // Visit URL
        cy.visit('http://newtours.demoaut.com/');

        // Verify that URL includes the string 'newtours'
        cy.url().should('include', 'newtours');

        // Enter username
        cy.get('input[name=userName')
            .should('be.visible')
            .should('be.enabled')
            .type('mercury');

        // Enter password
        cy.get('input[name=password')
            .should('be.visible')
            .should('be.enabled')
            .type('mercury');

        // Click "Sign-In" button
        cy.get('input[name=login]')
            .should('be.visible')
            .click();

        // Verify title
        cy.title().should('eq', 'Find a Flight: Mercury Tours:');

        // Switch to "One Way" radio button
        cy.get('input[value=roundtrip]')
            .should('be.visible')
            .should('be.checked');
        cy.get('input[value=oneway]')
            .should('be.visible')
            .should('not.be.checked')
            .click();

        // Click "Continue" button
        cy.get('[name=findFlights]')
            .should('be.visible')
            .click();

        // Verify title again
        cy.title().should('eq', 'Select a Flight: Mercury Tours');
    })

})