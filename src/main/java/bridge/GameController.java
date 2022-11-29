package bridge;

import java.util.List;

public class GameController {

    public static final String RETRY = "R";
    public static final String QUIT = "Q";

    private final InputView inputView;
    private final OutputView outputView;

    private BridgeGame bridgeGame;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();

        initGame();
    }

    private void initGame(){
        outputView.printGameStartMessage();
        bridgeGame = generateRandomBridgeGame();
        outputView.prinEmptyLine();
    }

    private BridgeGame generateRandomBridgeGame(){
        return RepeatValidator.readUntilValidate(() -> {
            int bridgeSize = inputView.readBridgeSize();
            BridgeMaker randomBridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridgeDirections = randomBridgeMaker.makeBridge(bridgeSize);
            return BridgeGame.from(bridgeDirections);
        });
    }

    public void startGame() {
        Player player = new Player();

        playUntilEnd(player);
        showResult(player);
    }

    private void playUntilEnd(Player player) {
        while (isContinueGame(player)) {
            playOneTurn(player);
            outputView.printMap(bridgeGame, player);
        }
    }

    private void playOneTurn(Player player) {
        Tile movingTargetTile = RepeatValidator.readUntilValidate(() ->
                Tile.findByDirectionSign(inputView.readMoving()));

        bridgeGame.move(player, movingTargetTile);
    }

    private boolean isContinueGame(Player player) {
        if (player.isAlive()) {
            return !bridgeGame.isWin(player);
        }
        return decideTryAgainOrNot(player);
    }

    private boolean decideTryAgainOrNot(Player player) {
        String input = RepeatValidator.readUntilValidate(() ->
                inputView.readGameCommand(GAME_RETRY_INPUT, GAME_QUIT_INPUT));

        if (input.equals(GAME_RETRY_INPUT)) {
            bridgeGame.retry(player);
            return true;
        }
        return false;
    }

    private void showResult(Player player) {
        outputView.printFinishGameInfoMessage();
        outputView.printMap(bridgeGame, player);
        outputView.printResult(bridgeGame.isWin(player), player.getTryCount());
    }


}
