package ru.job4j.jchess;

/**public class Knight extends Piece {

    private final static int[] CANDIDATE_MOVE_COORDINATE = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Knight( final Alliance pieceAlliance,final int piecePosition) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public List<Move> calculateLegalMoves(final Board board) {
        final List<Move>legalMoves = new ArrayList<>();
        for  (final int currentCandiadateOffset : CANDIDATE_MOVE_COORDINATE) {
           final int candidateDestinationCoordinate = this.piecePosition + currentCandiadateOffset;
            if (BoardUtils.isValidCellCoordinate(candidateDestinationCoordinate)) {
                    if (isFirstColumnExclusion(this.piecePosition, currentCandiadateOffset) || isSecondColumnExclusion(this.piecePosition, currentCandiadateOffset) ||
                            isSeventhColumnExclusion(this.piecePosition, currentCandiadateOffset) || isEigthColumnExclusion(this.piecePosition, currentCandiadateOffset)){
                        continue;
                    }

                final Cell candidateDestinationCell = board.getCell(candidateDestinationCoordinate);

                  if (!candidateDestinationCell.isCellOccupied()) {
                      legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
                  } else {
                      final Piece pieceAtDestination = candidateDestinationCell.getPiece();
                      final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();
                      if (this.pieceAlliance != pieceAlliance) {
                           legalMoves.add(new Move.AttackMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
                      }
                  }
            }
        }

        return ImmutableList.copyOf(legalMoves);

    }
    private static boolean isFirstColumnExclusion(final int carrentPosition, final int candidateOffset) {
       return BoardUtils.FIRST_COLUMN[carrentPosition] && (candidateOffset == -17 || candidateOffset == -10 || candidateOffset == 6 || candidateOffset == 15);
    }
    private static boolean isSecondColumnExclusion(final int carrentPosition, final int candidateOffset) {
        return BoardUtils.SECOND_COLUMN[carrentPosition] && (candidateOffset == -10 || candidateOffset == 6); }

    private static boolean isSeventhColumnExclusion(final int carrentPosition, final int candidateOffset) {
        return BoardUtils.SEVENTH_COLUMN[carrentPosition] && (candidateOffset == -6 || candidateOffset == 10); }

    private static boolean isEigthColumnExclusion(final int carrentPosition, final int candidateOffset) {
        return BoardUtils.EIGTH_COLUMN[carrentPosition] && (candidateOffset == -15 || candidateOffset == -6 || candidateOffset == 10 || candidateOffset == 17);

    }
}*/
