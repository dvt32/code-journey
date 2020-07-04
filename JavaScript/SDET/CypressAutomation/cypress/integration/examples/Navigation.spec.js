/// <reference types="cypress" />

describe('My Test Suite', () => {

    it('Navigation Tests', function() {
        // Visit URL & verify title
        cy.visit('https://demo.nopcommerce.com/');
        cy.title().should('eq', 'nopCommerce demo store');
        
        // Open register page & verify title
        cy.get(".ico-register").contains("Reg").click();
        cy.title().should('eq', 'nopCommerce demo store. Register');

        // Go back to homepage & verify title again
        cy.go("back");
        cy.title().should('eq', 'nopCommerce demo store');

        // Go forward to register page again & verify title again
        cy.go("forward");
        cy.title().should('eq', 'nopCommerce demo store. Register');

        // Go back to homepage in a different way & verify title
        cy.go(-1); // same as "back"
        cy.title().should('eq', 'nopCommerce demo store');

        // Go foward to register page in a different way & verify title
        cy.go(1); // same as "forward"
        cy.title().should('eq', 'nopCommerce demo store. Register');

        // Reload page
        cy.reload();
    })

})