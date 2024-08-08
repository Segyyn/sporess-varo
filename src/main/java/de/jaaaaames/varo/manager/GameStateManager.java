package de.jaaaaames.varo.manager;

public class GameStateManager {

    private static GameState currentGameState = GameState.LOBBY;

    public static GameState getCurrentGameState() {
        return currentGameState;
    }

    public static void setCurrentGameState(GameState currentGameState) {
        GameStateManager.currentGameState = currentGameState;
    }

    public static boolean isGameState(GameState gameState) {
        return currentGameState == gameState;
    }
}
