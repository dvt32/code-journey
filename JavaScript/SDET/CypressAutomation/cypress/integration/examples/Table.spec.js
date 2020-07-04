/// <reference types="cypress" />

describe('My Test Suite', () => {

    it('Table Test', function() {
        // Visit URL
        cy.visit("http://testautomationpractice.blogspot.com/");

        // Check for value presence anywhere in a table
        cy.get("table[name=BookTable]")
            .contains("td", "Learn Selenium")
            .should("be.visible");

        // Check for value presence in specific column/row in tablle
        cy.get("table[name=BookTable] > tbody > tr:nth-child(2) > td:nth-child(3)")
            .contains("Selenium")
            .should("be.visible");

        // Check for book name "Master In Java" with author "Amod" (iterate rows)
        cy.get("table[name=BookTable] > tbody > tr:nth-child(2)").each( 
            ($rowElement, index, $rowElements) => {
                const text = $rowElement.text();
                if (text.includes("Amod")) {
                    cy.get("table[name=BookTable] > tbody > tr:nth-child(1)").eq(index).then(
                        function(bookNameElement) {
                            const bookNameText = bookNameElement.text();
                            expect(bookNameText).to.equal("Master In Java");
                        }
                    );
                }
            }
        );
    })

})