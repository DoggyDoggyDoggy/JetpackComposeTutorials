# Bottom Navigation Demo in Jetpack Compose

This project demonstrates how to implement bottom navigation in Jetpack Compose. It showcases how to use the `NavigationBar`, `NavigationBarItem`, and `NavController` components to navigate between screens with a bottom navigation bar.

## Description

The project includes three main screens:
1. **Home** — the home screen that displays a home icon.
2. **Contacts** — a screen showing a contacts icon.
3. **Favorites** — a screen with a favorites icon.

The app uses a bottom navigation bar to switch between these screens, with the current screen being highlighted.

## Key Technologies

- **Jetpack Compose** — a modern UI framework for Android.
- **NavigationBar and NavigationBarItem** — components for bottom navigation.
- **NavController and NavHost** — used for managing navigation and the back stack.

## Project Structure

1. **MainActivity** — the main activity of the app, which contains the `NavHost` and manages the navigation.
2. **NavRoutes** — a `sealed class` that holds the routes for each screen.
3. **NavBarItems** — a list of `BarItem` objects representing each navigation item.
4. **MainScreen** — the main screen containing a `Scaffold` layout with a bottom navigation bar.
5. **Home**, **Contacts**, and **Favorites** — screens that display respective icons.
6. **BottomNavigationBar** — a custom bottom navigation bar component that handles navigation between screens.

## Navigation

Navigation is managed using a `NavController`. The app features the following navigation flows:
- From **Home** to **Contacts** and **Favorites** through the bottom navigation bar.
- The selected item in the bottom navigation bar is highlighted based on the current route.

### Bottom Navigation Bar

The bottom navigation bar dynamically switches between three screens: **Home**, **Contacts**, and **Favorites**. Each screen is represented by an icon and a title. When a user clicks an item, the `NavController` navigates to the corresponding screen.
