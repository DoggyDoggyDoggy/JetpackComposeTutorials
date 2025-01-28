# Gesture Demo App

This project demonstrates various ways to handle user gestures in Jetpack Compose. It includes examples of common gestures such as drag, scroll, tap, click, and multi-touch (zoom, rotate, pan) interactions. Each demo is implemented in a separate composable function.

## Features

- **Multi-Touch Gesture Handling:** Demonstrates scaling, rotating, and panning using `rememberTransformableState`.
- **Scroll Modifiers:** Shows vertical and horizontal scroll using `verticalScroll` and `horizontalScroll`.
- **Scrollable Modifier:** Implements scrolling with a custom offset using the `scrollable` modifier.
- **Pointer Input Drag:** Enables dragging functionality with `detectDragGestures`.
- **Drag Gesture with Draggable:** Demonstrates horizontal dragging using the `draggable` modifier.
- **Tap and Press Gestures:** Detects tap, double-tap, long-press, and press gestures using `detectTapGestures`.
- **Click Interaction:** Toggles the background color of a box on click using the `clickable` modifier.

### Gesture Demos

1. **MultiTouchDemo:**
   - Demonstrates scaling, rotation, and panning using `rememberTransformableState`.
   - Key modifiers: `graphicsLayer`, `transformable`.

2. **ScrollModifiers:**
   - Combines vertical and horizontal scrolling.
   - Key modifiers: `verticalScroll`, `horizontalScroll`.

3. **ScrollableModifier:**
   - Implements custom vertical scrolling using `scrollable`.
   - Key modifiers: `scrollable`, `offset`.

4. **PointerInputDrag:**
   - Enables freeform dragging using `detectDragGestures`.
   - Key function: `pointerInput`.

5. **DragDemo:**
   - Implements horizontal dragging using `draggable`.
   - Key modifiers: `draggable`, `offset`.

6. **TapPressDemo:**
   - Detects different tap and press gestures (tap, double-tap, long-press, press).
   - Key function: `detectTapGestures`.

7. **ClickDemo:**
   - Toggles background color on click using `clickable`.
