package sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern;

import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CommandVisitor;
import sdsu.cs635.TurtleOperations.Turtle;

public class Move implements CommandElement{
    double distance;

    public Move(double distance)
    {
        this.distance=distance;
    }

    public double getDistance()
    {
        return this.distance;
    }

    @Override
    public void accept(CommandVisitor commandVisitor, Turtle turtle) {
        commandVisitor.visit(this,turtle);
    }

    @Override
    public String expressionType() {
        return "move";
    }

    @Override
    public void execute(Turtle turtle) {
        turtle.move(distance);
    }

    @Override
    public void undo(Turtle turtle) {
        turtle.move(-distance);
    }

    @Override
    public void redo(Turtle turtle) {
        execute(turtle);
    }

}
