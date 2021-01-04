package sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern;

import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CommandVisitor;
import sdsu.cs635.TurtleOperations.Turtle;

public class Turn implements CommandElement{

    double direction;

    public Turn(double direction)
    {
        this.direction=direction;
    }

    @Override
    public void accept(CommandVisitor commandVisitor, Turtle turtle) {
        commandVisitor.visit(this,turtle);
    }

    @Override
    public String expressionType() {
        return "turn";
    }

    @Override
    public void execute(Turtle turtle) {
        turtle.turn(this.direction);
    }

    @Override
    public void undo(Turtle turtle) {
        turtle.turn(-direction);
    }

    @Override
    public void redo(Turtle turtle) {
        execute(turtle);
    }
}
