package sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern;

import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CommandVisitor;
import sdsu.cs635.TurtleOperations.Point;
import sdsu.cs635.TurtleOperations.Turtle;

public class BearingTo implements CommandElement{
    Point point;
    Character variable;

    public BearingTo(Character variable,Point point)
    {
        this.variable=variable;
        this.point=point;
    }

    @Override
    public void accept(CommandVisitor commandVisitor, Turtle turtle) {
        commandVisitor.visit(this,turtle);
    }

    @Override
    public String expressionType() {
        return "bearingTo";
    }

    @Override
    public void execute(Turtle turtle) {
        turtle.addVariable(variable,turtle.bearingTo(point));
    }

    @Override
    public void undo(Turtle turtle) {
        turtle.removeVariable(variable);
    }

    @Override
    public void redo(Turtle turtle) {
        execute(turtle);
    }
}
