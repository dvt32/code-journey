/// <reference types="cypress" />

describe('Locating Elements', function() {

    it('Verify Types of Locators', function() {
        // Open URL
        cy.visit("https://demo.nopcommerce.com");

        // Search for item
        cy.get("#small-searchterms").type("Apple MacBook Pro 13-inch");

        // Click "Search" button
        cy.get("[type='submit']").click();

        // Click "Add to cart" button
        cy.get(".product-box-add-to-cart-button[value='Add to cart']").click();

        // Change quantity
        cy.get("#addtocart_4_EnteredQuantity").clear().type("2");

        // Click "Add to cart" button again
        cy.get("#add-to-cart-button-4").click();

        // Open shopping cart page (after some time has passed)
        cy.wait(5000);
        cy.get("#topcartlink > a > span.cart-label").click();
        cy.wait(3000);

        // Verify that product price is equal to $1800
        cy.get(".product-unit-price").contains("$1,800.00");
    })

})