
# Task

Implement a simple payment application using Grails 2.5+

## Description

As a user I want to make transfers from one account to another so that I can make payments to others.

## Problem in context

Transferring sums between accounts is a common task in many financial organisations. The purpose of this story is to create this functionality as part of a simple payment system.

## Assumptions
* Accounts have a name, balance and email address
* All accounts have a starting balance of £200
* There are no overdrafts
* The system has no security or user management functionality

### Running tests

Just run a regular 'grails test-app'. This will run several unit specs and one functional spec (sorry, I didn't have enough time to add more functional specs).

IMPORTANT: you need to have Google Chrome installed for the functional spec to run.

### Running the app

Run 'grails run-app'. On the home page you'll find two options:

* View all accounts: allows the user to see a list of all accounts in the system and their balances (Acceptance Criteria #1) and
    provides a link for the selection of account, in which page the list of transactions can be visualized (AC #2).

* Transfer sum: enables the user to perform a transfer of a given amount between 2 accounts (AC #3, 4, 5)

### About the domain classes

On Account domain class, I tried to make account attribute private, and only modifiable via the decrease() and increase()
    methods (in my head, it makes sense for the balance to get update only by adding or withdrawing money, it wouldn't make
    much sense to just set balance to a random value), but unfortunately it was not possible, I had all sorts of trouble
    with the way GORM works.
