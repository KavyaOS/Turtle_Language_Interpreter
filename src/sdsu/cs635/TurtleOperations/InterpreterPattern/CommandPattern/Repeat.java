package sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern;

import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CommandVisitor;
import sdsu.cs635.TurtleOperations.Turtle;

public class Repeat implements CommandElement{
    int count;

    public Repeat(int count)
    {
        this.count=count;
    }

    public int getCount()
    {
        return count;
    }

    @Override
    public void accept(CommandVisitor commandVisitor, Turtle turtle) {
        commandVisitor.visit(this,turtle);
    }

    @Override
    public String expressionType() {
        return "repeat";
    }

    @Override
    public void execute(Turtle turtle) {
        //CommandProcessor has already handled the execution of repeat command
    }

    @Override
    public void undo(Turtle turtle) {
        //CommandProcessor has already handled the undo request of commands inside the repeatList
    }

    @Override
    public void redo(Turtle turtle) {
        //CommandProcessor has already handled the redo request of commands inside the repeatList
    }
}
