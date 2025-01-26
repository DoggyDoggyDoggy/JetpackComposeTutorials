# Jetpack Compose State Animation Examples

This project demonstrates different animation techniques in Jetpack Compose using `animate*AsState` and `Transition` APIs. Below are the examples of the animations included in the project:

## Overview

The project showcases the following types of animations:

1. **Rotation Animation**: Animates the rotation of an image.
2. **Color Change Animation**: Transitions between two colors using an animated background.
3. **Motion Animation**: Moves a box horizontally across the screen.
4. **Transition Animation**: Combines both color change and motion animation using a transition state.

## Features

- **Rotation Animation**: The propeller image rotates when the button is pressed, using `animateFloatAsState` with a linear easing curve.
- **Color Change Animation**: A box's color transitions between red and magenta with a smooth animation using `animateColorAsState`.
- **Motion Animation**: A box moves between two positions based on a state toggle, using `animateDpAsState` with keyframes and various easing functions.
- **Transition Animation**: A combined animation for both color and position change using `updateTransition`, making the box move horizontally and change color simultaneously.
