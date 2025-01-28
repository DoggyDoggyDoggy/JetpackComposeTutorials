# Glance Widget Example

This is a sample project demonstrating how to create a simple Glance widget in an Android application using the **Glance** library. The widget displays stock price data and updates periodically.

## Project Overview

The project includes:

- **Glance AppWidget**: Displays stock price data in a widget.
- **Stock Data**: Simulated stock price data is updated every 20 seconds.
- **Responsive Widget**: The widget is responsive, adjusting its size based on the available space.

## Features

- **Small Mode**: Displays stock price with a simple layout.
- **Medium Mode**: Displays stock price with an arrow indicating whether the stock price is going up or down.
- **Auto Update**: The widget automatically updates every 20 seconds using a background job.
- **Click Action**: The widget is clickable and triggers a refresh of the stock price when tapped.

## Technologies Used

- **Glance**: Used to create the widget layout and manage widget updates.
- **Jetpack Compose**: Used to build UI components for the widget.
- **Kotlin Coroutines**: Used to manage background tasks for updating the stock data.
- **StateFlow**: Used to hold and manage the state of the stock price.
