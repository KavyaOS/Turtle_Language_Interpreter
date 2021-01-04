package sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern;

import sdsu.cs635.TurtleOperations.Turtle;
import sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern.*;

public interface CommandVisitor {

    void visit(Assignment assignment, Turtle turtle);

    void visit(Move move, Turtle turtle);

    void visit(Repeat repeat, Turtle turtle);

    void visit(Turn turn, Turtle turtle);

    void visit(End end, Turtle turtle);

    void visit(DistanceTo distanceTo, Turtle turtle);

    void visit(BearingTo bearingTo, Turtle turtle);
}
