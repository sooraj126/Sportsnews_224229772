# Sports News App

## Overview

This is a Sports News Feed Android app developed using Java and Android Studio as part of Task 5. 1C.
The app allows users to view sports news, open detailed stories, search and filter news and bookmark their favourite items.

The app is built using a single activity architecture with fragments, which helps in managing different screens efficiently.

---

## Features

* View sports news in a clean UI
* Featured Matches section (horizontal list)
* Latest Sports News section (grid layout)
* Search and filter news by category
* Open detailed view of each news item
* Related stories section in detail screen
* Bookmark favourite news items
* View bookmarked items in a separate screen
* Prevent duplicate bookmarks

---

## Technologies Used

* Java
* Android Studio
* RecyclerView
* Fragments
* GridLayoutManager & LinearLayoutManager
* TextWatcher

---

## App Structure

### MainActivity

* Acts as the main container for the app
* Loads and switches between fragments

### HomeFragment

* Displays featured matches and latest news
* Implements search functionality
* Handles item click and navigation to detail screen

### DetailFragment

* Displays selected news details
* Shows related stories
* Allows bookmarking

### BookmarksFragment

* Displays all bookmarked news items
* Shows message if no bookmarks are available

### Newsadapter

* Connects data with RecyclerView UI
* Handles item layout and click events

### Newsitem

* Data model class for each news item
* Stores title, description, category, image, and bookmark status

### NewsStorage

* Shared data class
* Stores all news items and bookmarked items
* Avoids duplication of data across fragments

---

## How It Works

1. News data is stored in NewsStorage
2. HomeFragment loads the data and displays it using RecyclerView
3. Newsadapter binds data to item layout
4. When an item is clicked, DetailFragment opens with selected data
5. User can bookmark stories
6. BookmarksFragment displays saved stories

