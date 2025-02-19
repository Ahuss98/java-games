# 🕹️ Java Games: Hangman  & Snap

Welcome to my **first Java project**, where I built **two classic games: Hangman & Snap**, along with a **functional user menu** that allows navigation between both games in **single-player and multiplayer modes**.

This project helped me **improve my Java skills**, including:
- **Object-Oriented Programming (OOP)**
- **Exception Handling**
- **Loops & Conditional Logic**
- **User Input Handling**
- **Game Mechanics & Design**

---

## 📌 Features
✅ **Two Classic Games:** Hangman & Snap  
✅ **Functional User Menu:** Choose and switch between games  
✅ **Single & Multiplayer Modes:** Play solo or with a friend  
✅ **Error Handling & Input Validation:** Handles invalid inputs gracefully  
✅ **Interactive ASCII-Based UI:** Displays Hangman & Snap reactions visually  
✅ **Replay & Game Selection Options:** Play again or switch games dynamically


<details>
  <summary>Click to Expand</summary>

## 📌 Features
- [x] **Two Classic Games:** Hangman & Snap
- [x] **User-Friendly Menu:** Select and switch between games
- [x] **Single & Multiplayer Modes:** Play solo or with a friend
- [x] **Input Validation & Error Handling:** Prevents crashes from invalid input
- [x] **Dynamic Gameplay:** Replay rounds and switch games seamlessly
- [x] **Interactive Console UI:** Uses ASCII art for an engaging experience

---

## 🛠️ Project Breakdown

### **📌 Game Menu System**
- [x] Implement a **main menu system** that allows users to:
    - [x] Choose **Single-Player or Multiplayer Mode**
    - [x] Select **Hangman** or **Snap**
    - [x] Exit the game
- [x] Handle **invalid inputs** to prevent crashes.
- [x] Ensure smooth **user input handling** and **error prevention**.
- [x] Add replay and game-switching functionality.

---

### **📌 Hangman Game (Single Player)**
- [x] Implement **random word selection** from a predefined list.
- [x] Allow the player to **guess letters** until:
    - [x] The word is completed (**Win**)
    - [x] The player reaches **5 incorrect guesses** (**Lose**).
- [x] Display a **dynamic Hangman ASCII drawing** that updates after incorrect guesses.
- [x] **Class Design:**
    - [x] `Words.java` → Stores a list of words & selects a random word.
    - [x] `DisplayGuess.java` → Manages letter guessing logic & word display.
    - [x] `HangmanMenu.java` → Handles game flow.
- [x] **Game Logic:**
    - [x] `selectRandomWord()` → Picks a word from an array.
    - [x] `guessLetterCheck()` → Validates player input and updates game state.
    - [x] `displayWordLength()` → Shows guessed letters and underscores (`_`).
    - [x] `displayHangman()` → Displays ASCII representation of the Hangman.

---

### **📌 Snap Game (Single & Multiplayer)**
- [x] Implement **card-based gameplay** where players **take turns drawing a card**.
- [x] If two consecutive cards **match in rank**, player types `"SNAP!"` to wins.
- [x] **Single-Player Mode:** The player plays until they type 'snap' to win'.
- [x] **Multiplayer Mode:** Two players take turns, reacting quickly.
- [x] **Class Design:**
    - [x] `Card.java` → Defines the suit, rank, and value of a card.
    - [x] `CardGame.java` → Manages shuffling and dealing cards.
    - [x] `Snap.java` → Handles game logic and timing for SNAP reactions.
    - [x] `Player.java` → Stores player names and tracks scores.
- [x] **Game Logic:**
    - [x] `dealCard()` → Each player draws a card from the deck.
    - [x] `winChecker()` → Checks if the last two cards match & if a player doesn’t type `"SNAP!"` within **2 seconds**, they lose.
    - [x] `playAgain()` → Allows replay or switching to another game.

---

### **📌 Error Handling & Input Validation**
- [x] Ensure **invalid input (letters instead of numbers, empty input, etc.) does not crash the game**.
- [x] Add **input loops** to keep asking the user until they provide a valid response.
- [x] **Use try-catch blocks** to prevent crashes.
---
</details>

## 📥 Installation & How to Run

### **1️⃣ Prerequisites**
- Install **Java JDK 8+**
- Use an IDE (**IntelliJ**)

### **2️⃣ Clone the Repository**
- for SSH
```sh
git clone git@github.com:Ahuss98/java-games.git
cd java-games 
``` 
- OR for HTTPS
```sh
git clone https://github.com/Ahuss98/java-games.git
cd java-games 
``` 
### **3️⃣ Compile & Run**
Run `Main.java` in your Java IDE.

---
## 🎮 How to Play

### 🧩 **Hangman** 🧩 
- The game picks a **random word** and displays underscores (`_`).
- **Guess a letter** by typing it in the console.
- If correct → The letter is revealed.
- If incorrect → The Hangman drawing updates.
- **Win:** Guess all letters before **5 incorrect guesses**.
- **Lose:** The full Hangman is drawn.

#### **Example:**
```sh
🔥 Welcome to Hangman! Guess the word!

_ _ _ _ _ _
❌ Incorrect guesses: 2 / 5

  _______
  |/     |
  |
  |
  |
  |
 ___|___
```
### ♠️ ♦️ **Snap** ♣️ ♥️
- Players take turns drawing cards.
- If two consecutive cards match in rank, type "SNAP!" as fast as possible.
- Win: First to get Snap on their turn and type it.
- Lose: If you mistype or react too slowly, you lose.

---

This project has been a rewarding journey, blending creativity and technical knowledge. I’m excited to apply these lessons in the future!

## 🤝 Contribution & Feedback

Feel free to explore the project and provide feedback!

---

Thank you for visiting! 😊 
