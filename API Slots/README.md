# API Slots in Jetpack Compose
This project demonstrates the use of the API Slots concept in Jetpack Compose, which allows passing functions (or "slots") to other components for dynamic content configuration.

## Description
In this example, a screen is created with two different progress bars: LinearProgressIndicator and CircularProgressIndicator, which can be toggled using checkboxes. There is also the option to change the header content: an image or text. This is achieved through API Slots, where the content is passed as composable functions.

## Features
- State management to control the UI state.
- Dynamic content modification using passed functions (API Slots).
- Ability to switch between different types of progress indicators and header content.
