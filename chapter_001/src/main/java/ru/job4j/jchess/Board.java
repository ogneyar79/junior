package ru.job4j.jchess;

/**public class Board {
    public Cell getCell(final int cellCoordinate) {

        return gameBoard.get(cellCoordinate);
    }

    private final List<Cell> gameBoard;
    private final Collection<Piece> whitePieces;
    private final Collection<Piece>blackPieces;

    private Board(Builder builder) {
          this.gameBoard = createGameBoard(builder);
          this.whitePieces = calculateActivePieces(this.gameBoard, Alliance.WHITE);
          this.blackPieces = calculateActivePieces(this.gameBoard, Alliance.BLACK);
    }

    private Collection<Piece> calculateActivePieces(final List<Cell> gameBoard, final Alliance alliance) {
        final List<Piece> activePieces = new ArrayList<>();
        for (final Cell cell : gameBoard) {
            if (cell.isCellOccupied()) {
                final Piece piece = cell.getPiece();
                if (piece.getPieceAlliance() == alliance) {
                    activePieces.add(piece);
                }
            }
        }
        return ImmutableList.copyOf(activePieces);
    }

    private static List<Cell>createGameBoard(final Builder builder) {
        final Cell[]cells = new Cell[BoardUtils.NUM_CELL];
        for (int i = 0; i < BoardUtils.NUM_CELL; i++) {
            cells[i] = Cell.createCell(i, builder.boardConfig.get(i));
        }
        return ImmutableList.copyOf(cells);
    }
    public static Board creatStandartBoard() {
        final Builder builder = new Builder();
        // Black Layout
        builder.setPiece(new Rook(Alliance.BLACK,0));
        builder.setPiece(new Knight(Alliance.BLACK,1));
        builder.setPiece(new Bishop(Alliance.BLACK,2));
        builder.setPiece(new Queen(Alliance.BLACK,3));
        builder.setPiece(new King(Alliance.BLACK,4));
        builder.setPiece(new Bishop(Alliance.BLACK,5));
        builder.setPiece(new Knight(Alliance.BLACK,6));
        builder.setPiece(new Rook(Alliance.BLACK,7));
        builder.setPiece(new Pawn(Alliance.BLACK,8));
        builder.setPiece(new Pawn (Alliance.BLACK,9));
        builder.setPiece(new Pawn(Alliance.BLACK,10));
        builder.setPiece(new Pawn(Alliance.BLACK,11));
        builder.setPiece(new Pawn(Alliance.BLACK,12));
        builder.setPiece(new Pawn(Alliance.BLACK,13));
        builder.setPiece(new Pawn(Alliance.BLACK,14));
        builder.setPiece(new Pawn(Alliance.BLACK,15));

        // White Layout
        builder.setPiece(new Pawn(Alliance.WHITE,48));
        builder.setPiece(new Pawn(Alliance.WHITE,49));
        builder.setPiece(new Pawn(Alliance.WHITE,50));
        builder.setPiece(new Pawn(Alliance.WHITE,51));
        builder.setPiece(new Pawn(Alliance.WHITE,52));
        builder.setPiece(new Pawn(Alliance.WHITE,53));
        builder.setPiece(new Pawn(Alliance.WHITE,54));
        builder.setPiece(new Pawn(Alliance.WHITE,55));
        builder.setPiece(new Rook(Alliance.WHITE,56));
        builder.setPiece(new Knight(Alliance.WHITE,57));
        builder.setPiece(new Bishop(Alliance.WHITE,58));
        builder.setPiece(new Queen(Alliance.WHITE,59));
        builder.setPiece(new King(Alliance.WHITE,60));
        builder.setPiece(new Bishop(Alliance.WHITE,61));
        builder.setPiece(new Knight(Alliance.WHITE,62));
        builder.setPiece(new Rook(Alliance.WHITE,63));
        // White to move
        builder.setMoveMaker(Alliance.WHITE);
        return builder.build();
    }

    public static class Builder {
        map<Integer, Piece> boardConfig;
    Alliance nextMoveMaker;

    public Builder() {
    }

    public Builder setPiece(final Piece piece) {
        this.boardConfig.put(piece.getPiecePosition(), piece);
          return this;
    }
    public Builder setMoveMaker(final Alliance nextMoveMaker) {
        this.nextMoveMaker = nextMoveMaker;
        return this;
    }
        public Board build() {
            return new Board(this);
        }
    }
}*/
