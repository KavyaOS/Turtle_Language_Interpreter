package sdsu.cs635.TurtleOperations.InterpreterPattern.CommandPattern;

import sdsu.cs635.TurtleOperations.InterpreterPattern.VisitorPattern.CommandVisitor;
import sdsu.cs635.TurtleOperations.Turtle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class CommandProcessor {
    ArrayList<CommandElement> commands;
    Stack<CommandElement> undoStack= new Stack<>();
    Stack<CommandElement> redoStack= new Stack<>();

    public CommandProcessor(ArrayList<CommandElement> commands)
    {
        this.commands=commands;
    }

    public void processCommands(CommandVisitor commandVisitor, Turtle turtle)
    {
        Iterator<CommandElement> CommandsIterator= commands.iterator();
        while(CommandsIterator.hasNext())
        {
            CommandElement command=CommandsIterator.next();

            if(command.expressionType().equals("repeat"))
            {
                int repeatCount=((Repeat)command).getCount();
                ArrayList<CommandElement> repeatList= new ArrayList<>();
                while(CommandsIterator.hasNext()) {
                    command = CommandsIterator.next();
                    if (!command.expressionType().equals("end"))
                        repeatList.add(command);
                }
                while (repeatCount>0)
                {
                    for(CommandElement commandElement:repeatList)
                    {
                        commandElement.accept(commandVisitor,turtle);
                        undoStack.push(commandElement);
                        redoStack.push(commandElement);
                    }
                    repeatCount--;
                }
            }
            else
            {
                command.accept(commandVisitor,turtle);
                undoStack.push(command);
                redoStack.push(command);
            }
        }
    }

    public void undo(Turtle turtle)
    {
        CommandElement commandElement=undoStack.pop();
        redoStack.push(commandElement);
        commandElement.undo(turtle);
    }

    public void redo(Turtle turtle)
    {
        CommandElement commandElement= redoStack.pop();
        undoStack.push(commandElement);
        commandElement.redo(turtle);
    }
}