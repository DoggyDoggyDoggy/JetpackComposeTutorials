# Navigation in Jetpack Compose

This project is an educational example of how to use navigation in Jetpack Compose on Android. It demonstrates the basics of navigation using `NavController`, `NavHost`, and other components to create screens with navigation between them.

## Description

The project includes several screens:
1. **Home** — a screen for entering the user's name.
2. **Welcome** — a greeting screen that displays the user's name.
3. **Profile** — a profile screen where the user can go after registration.

## Key Technologies

- **Jetpack Compose** — a modern UI framework for building Android apps.
- **NavController and NavHost** — components for navigating between screens.
- **Composable functions** — for building screen layouts.

## Project Structure

1. **MainActivity** — the main activity of the app, which contains the `NavHost` and manages navigation.
2. **NavRoutes** — a `sealed class` that holds the routes for each screen.
3. **MainScreen** — the main screen where navigation between screens is defined.
4. **Home** — a screen where the user enters their name and navigates to the welcome screen.
5. **Welcome** — a screen that displays a greeting with the user's name and a button to navigate to the profile screen.
6. **Profile** — a profile screen for the user.

## Navigation

Navigation between screens is managed using `NavController`. The project implements the following transitions:
- From the **Home** screen to the **Welcome** screen with the user’s name passed in the URL.
- From the **Welcome** screen to the **Profile** screen.
