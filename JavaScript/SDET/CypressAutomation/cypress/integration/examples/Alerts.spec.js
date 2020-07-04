/// <reference types="Cypress" />

describe('Alerts Suite', () => {

    it('Alerts', () => {
        // Visit URL
       cy.visit("http://demo.automationtesting.in/Alerts.html");

       // Click button which opens alert
       cy.get("button.btn-danger").click();

       // Verify alert message
       cy.on("window:alert", (str) => {
            expect(str).to.equal("I am an alert box!");
       });
    })

    it('Confirm Alerts', () => {
        // Visit URL
       cy.visit("http://testautomationpractice.blogspot.com/");

       // Click button which opens confirm alert
       cy.get("#HTML9 > div.widget-content > button").click();

       // Verify alert message
       cy.on("window:confirm", (str) => {
            expect(str).to.equal("Press a button!");
       });
    })

})