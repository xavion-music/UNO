# UNO
UNO Game Java - A class project demonstrating basic UNO mechanics using OOP in Java. Includes player, card, and game classes.

Latest Change:
Fix handling of Wild cards and implement color selection logic
1. Modify UNOGame logic to correctly handle Wild Color Changer and Wild Draw Four cards. Allow any card to be played following a Wild Color Changer, and add functionality for players to choose the next color after playing any wild card.
2. Implement chooseColor method in UNOGame to handle color selection after a wild card is played, ensuring the game flow correctly continues with the chosen color.
3. Adjust takeTurn method in UNOGame to prevent NoSuchElementException by not closing the scanner prematurely and fixing the logic to validate the player's chosen card properly.
4. Add currentColor field in UNOGame to track the current color in play, updated either when normal or wild cards are played.
5. Update UNOPlayer class to include getCard method for checking card playability without removing it from the hand and correct playCard logic to remove the card from the hand if it's played.
6. Remove premature `scanner.close()` calls in UNO.java to avoid closing `System.in` prematurely, which was causing input issues in subsequent turns.
7. Ensure that game logic aligns with UNO rules, especially regarding wild cards where players can choose the next color and force actions like drawing cards.

These changes ensure the game adheres to the standard UNO rules, particularly handling wild cards and color changes, thus improving the overall gameplay and user experience.
