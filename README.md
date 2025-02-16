# Library-Management-App
12th grade peoject ,Library Management App is a simple Android application that allows users to manage books by adding, deleting, and viewing details. The app stores book information in an SQLite database and provides a user-friendly interface for interaction.

## Features

Add new books with details (ID, Name, Author, Category).

Delete books from the library.

View a list of all books.

Search for a book by name.

Display book details in a separate activity.

Uses an SQLite database for persistent storage.


## Technologies Used

Kotlin (Android development language)

Android SDK

SQLite Database (DBHelper)

AlertDialog for confirmations

## UI Design

The app follows a fragment-based architecture and structured activities:

Main Activity (activity_main.xml): Allows users to add books and navigate to the book list.

Book List Activity (activity_book_list.xml): Displays all books in a ListView with delete and detail options.

Details Activity (activity_detalis.xml): Shows detailed information about a selected book.

Custom Dialog (custom_dialog.xml): Provides an input field for searching books.

ListView with a custom adapter
