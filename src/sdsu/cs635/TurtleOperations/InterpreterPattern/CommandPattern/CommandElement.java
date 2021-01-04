package sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern;

import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CommandVisitor;
import sdsu.cs635.TurtleOperations.Turtle;

public interface CommandElement {
    void accept(CommandVisitor commandVisitor, Turtle turtle);

    String expressionType();

    void execute(Turtle turtle);

    void undo(Turtle turtle);

    void redo(Turtle turtle);
}
