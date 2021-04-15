package com.designPatterns.a17Command;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令模式
 */
public class CommandmMain {

    public static void main(String[] args) {
        Context context = new Context("sdjfksdfofkskgksdfj");
        //插入
        InsertCommand insertCommand = new InsertCommand(context, "wetew");
        //删除
        DelteCommand delteCommand = new DelteCommand(context, 3);

        // insertCommand.execute();
        // System.out.println(insertCommand.context.str);
        // insertCommand.undo();
        // delteCommand.execute();
        // System.out.println(delteCommand.deleteStr);
        // delteCommand.undo();

        //引入责任链模式（自己理解写的，仅供参考）
        CommandChain commandChain = new CommandChain().add(insertCommand).add(delteCommand);
        commandChain.execute();
        commandChain.undo();
    }
}

//文本类
class Context {
    String str;

    public Context(String str) {
        this.str = str;
    }
}

//命令抽象类
abstract class Command {
    Context context;

    abstract void execute();//执行
    abstract void undo();//回滚
}
//插入命令
class InsertCommand extends Command {

    String insertStr;

    public InsertCommand(Context c, String insertStr) {
        this.context = c;
        this.insertStr = insertStr;
    }

    @Override
    void execute() {
        context.str = context.str + insertStr;
    }

    @Override
    void undo() {
        context.str = context.str.substring(0, context.str.length() - insertStr.length());
    }
}
//删除命令
class DelteCommand extends Command {

    int len;
    String deleteStr;

    public DelteCommand(Context c, int len) {
        this.context = c;
        this.len = len;
    }

    @Override
    void execute() {
        deleteStr = context.str.substring(0,len);
        context.str = context.str.substring(len, context.str.length());
    }

    @Override
    void undo() {
        context.str = deleteStr + context.str;
    }
}
//继续扩展其他命令

//命令责任链
class CommandChain extends Command{

    int index;
    List<Command> commands = new ArrayList();

    public CommandChain add(Command c){
        commands.add(c);
        return this;
    }

    @Override
    void execute() {
        for(Command c : commands){
            c.execute();
            System.out.println(c.context.str);
        }
    }

    @Override
    void undo() {
        try {
            for (int i = commands.size() -1; i >= 0; i--) {
                commands.get(i).undo();
                index = i;
                System.out.println(commands.get(i).context.str);
            }
        } catch (Exception e) {
            e.printStackTrace();
            for (int i = index; i < commands.size() -1; i++) {
                commands.get(i).execute();
            }
            index = 0;
        }
    }
}