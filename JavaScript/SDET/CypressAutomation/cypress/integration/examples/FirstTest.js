describe('My Test Suite', () => {

    it('Verify Title Of Page (Should Succeed)', () => {
        cy.visit('https://demo.nopcommerce.com/');
        cy.title().should('eq', 'nopCommerce demo store');
    })

    /*
    it('Verify Title Of Page (Should Fail)', () => {
        cy.visit('https://demo.nopcommerce.com/');
        cy.title().should('eq', 'nopCommerce store');
    })
    */

})