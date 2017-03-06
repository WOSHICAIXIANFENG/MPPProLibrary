# MPPProLibrary
We will work in groups to design and implement a solution to the Library Problem. 

Functional Requirements
The system you design should support the following statements:
1. Login
 The first screen a user of the system sees is the login screen, which requests ID and
password. When the Submit button is clicked, the ID is looked up in the data store. If this ID
can be found, and if the password for this ID matches the password submitted, the
authorization level is returned. Authorization levels are LIBRARIAN, ADMIN, and BOTH. If
login is successful, UI features are made available according to the authorization level of the
user.
2. Add a new library member to the system.
 When an Administrator selects the option to add a new member, is presented with a form
with the following fields: member id, first name, last name, street, city, state, zip, telephone
number.
3. Checkout a book for a library member.
 A librarian can enter in a form a member ID and see a list of the books that member
checkout records. The librarian can enter the ISBN number for a book and ask the system
whether the requested item is available for checkout. If ID is not found, the system will
display a message indicating this, or if the requested book is not found or if none of the
copies of the book are available, the system will return a message indicating that the item is
not available. If both member ID and book ID are found and a copy is available, a new
checkout record entry is created, containing the copy of the requested book and the
checkout date and due date. This checkout entry is then added to the member’s checkout
record. The copy that is checked out is marked as unavailable. The updated checkout
record is displayed on the UI. The display of the checkout record should use a TableView.
The librarian can continue cheking out more books for that member or start the process
with another member.
4. Add a copy of an existing book to the library collection.
 An administrator can look up a book by ISBN and add a copy to the collection.
5. Add a book to the library collection.
 An Administrator can add a book by selecting an “add book” option. The system responds by
displaying a screen with the necessary fields (ISBN, title, authors, maximum checkout length,
number of copies).
6. [Groups with more than 4 members] Given a library member id, print (to console) the checkout
record of that library member
 The Librarian can search for a library member by ID, and then select an option to print the
checkout record. When this is done, the checkout record appears in the console with
aligned columns.
