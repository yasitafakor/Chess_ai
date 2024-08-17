# Chess Game

Welcome to the **Chess Game** project, a fully interactive chess application built in Java. The game supports both two-player mode and a challenging AI opponent. With a graphical interface and smooth gameplay, it’s designed for both casual players and chess enthusiasts.

## Features

- **Two-Player Mode**: Play against a friend in a local multiplayer setting.
- **AI Mode**: Challenge yourself against an AI opponent with strategic moves powered by the MiniMax algorithm.
- **Graphical Interface**: A visually appealing chessboard with responsive piece movements.
- **Save and Continue**: Save your game progress at any point and resume later from where you left off.
- **Dynamic Piece Interaction**: Pieces move according to chess rules, capturing opponents and checking for victory conditions.

## Project Structure

### Piece Classes

- **Piece**: The abstract base class for all chess pieces. It defines the core structure and behaviors of a piece.
  - **Pawn, Rook, Knight, Bishop, Queen, King**: Specific implementations of each chess piece, inheriting from `Piece`. Each class includes a `canMove` method that determines valid moves based on the current position and state of the board.

### Cell Class

- **Cell**: Represents each square on the chessboard. It initializes the board by placing pieces in their standard starting positions. White pieces are represented by values from `1 to 6`, and black pieces by `-1 to -6`. The pieces are arranged in a two-dimensional array that mirrors the standard chess setup.

### NewGame Class

- **NewGame**: Extends `JFrame` and implements `MouseListener` and `MouseMotionListener` to handle user interactions. This class is responsible for:
  - Rendering the chessboard and placing piece images on their corresponding cells.
  - Detecting and processing mouse clicks (`mousePressed`): Identifies which piece the player intends to move.
  - Handling the piece movement (`mouseReleased`): Determines the validity of the move based on the rules defined in the piece classes. If the move is valid, it updates the board, captures opponent pieces if necessary, and checks for game-ending conditions (checkmate, stalemate).

### AI Implementation

- **MiniMax Class**: Implements the MiniMax algorithm, which evaluates the possible moves and selects the best one to maximize the AI's chances of winning.
- **AIPlayer Class**: Contains the `nextMove` method, which takes the current state of the board and returns the AI's next move.
- **AI Class**: Similar to `NewGame`, but facilitates gameplay between a human player and the AI.

### Continue Class

- **Continue**: Allows the game to be saved at any point, so players can resume from the exact state where they left off.

### Main Class

- **Main**: Displays the main graphical interface, where players can choose to start a new game, continue a saved game, or play against another player or the AI.

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Make sure you have JDK 8 or higher installed.




