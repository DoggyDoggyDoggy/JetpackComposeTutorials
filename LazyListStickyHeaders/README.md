# StickyHeaders with LazyColumn and Scroll to Top Example

This is a simple educational project demonstrating the use of `LazyColumn` with `StickyHeaders` and manual scrolling to the top in Jetpack Compose. 

## Features

- **Sticky Headers**: Grouped items in the list are displayed with sticky headers that remain at the top while scrolling through their group.
- **Manual Scroll to Top**: A button appears when the user scrolls past a certain point in the list, allowing them to quickly return to the top of the list.
- **Dynamic Toast Messages**: Clicking on any item in the list displays a `Toast` message with the item's text.
- **Lazy Loading with `LazyColumn`**: Efficiently renders a large list of items with smooth scrolling.
- **Image Loading**: Dynamically loads car manufacturer logos using their names in URLs.

## How It Works

1. **Data Grouping**: 
   - The data is grouped by the manufacturer name, with each group represented by a sticky header.

2. **Scroll State Handling**: 
   - A `LazyListState` is used to track the current scroll position.
   - A derived state is used to determine whether the "Scroll to Top" button should be displayed.

3. **Sticky Headers**:
   - Each manufacturer's name is displayed as a sticky header using the `stickyHeader` function.

4. **Manual Scroll**:
   - Clicking the "Scroll to Top" button triggers a coroutine to scroll the list back to the top.
