package uk.co.directline.mathcompiler.operations;

import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;

/**
 * Created by pawel on 30/03/15.
 */
public class LoadValueOperaiton extends BaseOperation {

    private int value;

    public LoadValueOperaiton(int value) {
        this.value = value;
    }

    @Override
    public void execute(InstructionList il, InstructionFactory factory) {
        il.append(factory.createConstant(this.value));
    }
}
