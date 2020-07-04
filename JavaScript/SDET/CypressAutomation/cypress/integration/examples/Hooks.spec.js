/// <reference types="cypress" />

describe('My Hooks Test Suite', () => {

    // Runs once before all tests in the block
    before( () => {
        cy.log("*** This is a TEST SETUP block ***");
    })

    // Runs once after all tests in the block
    after( () => {
        cy.log("*** This is a TEST TEARDOWN block ***");
    })

    // Runs before each test in the block
    beforeEach( () => {
        cy.log("*** This a LOGIN block ***");
    })

    // Runs after each test in the block
    afterEach( () => {
        cy.log("*** This a LOGOUT block ***");
    })

    it('Searching Test', function() {
        cy.log("*** This is a searching test ***");
    })

    it('Advanced Searching Test', function() {
        cy.log("*** This is an advanced searching test ***");
    })

    it('Listing Products Test', function() {
        cy.log("*** This is a listing products test ***");
    })

})