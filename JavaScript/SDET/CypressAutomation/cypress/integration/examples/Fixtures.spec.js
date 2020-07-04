/// <reference types="cypress" />

describe('My Fixtures Test Suite', () => {

    before(
        // Load "fixtures/example.json" & allow using JSON data from file in tests
        function() {
            cy.fixture("example").then( 
                function(data) {
                    this.data = data;
                }
            ); 
        }
    )

    it('Fixtures Test', function() {
        // Visit URL
        cy.visit("https://admin-demo.nopcommerce.com/login");

        // Enter data
        cy.get("input[name=Email]").type(this.data.email);
        cy.get("input[name=Password]").type(this.data.password);

        // Click login button
        cy.get("input[type=submit]").click();
    })

})