package sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern;

import sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern.*;
import sdsu.cs635.TurtleOperations.Turtle;

public class CalculateTotalDistanceTraveledVisitor implements CommandVisitor{
    double totalDistanceTravelled=0;
    @Override
    public void visit(Assignment assignment, Turtle turtle) {
        assignment.execute(turtle);
    }

    @Override
    public void visit(Move move, Turtle turtle) {
        totalDistanceTravelled+=move.getDistance();
        move.execute(turtle);
    }

    @Override
    public void visit(Repeat repeat, Turtle turtle) {
        repeat.execute(turtle);
    }

    @Override
    public void visit(Turn turn, Turtle turtle) {
        turn.execute(turtle);
    }

    @Override
    public void visit(End end, Turtle turtle) {
        end.execute(turtle);
    }

    @Override
    public void visit(DistanceTo distanceTo, Turtle turtle) {
        distanceTo.execute(turtle);
    }

    @Override
    public void visit(BearingTo bearingTo, Turtle turtle) {
        bearingTo.execute(turtle);
    }

    public double getResult()
    {
        return Math.round(totalDistanceTravelled);
    }
}
