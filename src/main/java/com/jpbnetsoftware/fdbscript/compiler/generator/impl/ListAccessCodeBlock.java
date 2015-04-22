package com.jpbnetsoftware.fdbscript.compiler.generator.impl;

import com.jpbnetsoftware.fdbscript.compiler.generator.ICodeBlock;
import com.jpbnetsoftware.fdbscript.compiler.generator.IEmitter;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionList;

import java.util.List;

/**
 * Created by pawel on 22/04/15.
 */
public class ListAccessCodeBlock extends JvmCodeBlock {

    private ICodeBlock listSource;

    private List<ICodeBlock> indexExpressions;

    public ListAccessCodeBlock(ICodeBlock listSource, List<ICodeBlock> indexExpressions) {
        this.listSource = listSource;
        this.indexExpressions = indexExpressions;
    }

    @Override
    protected void emitInternal(IEmitter emitter, InstructionList il, InstructionFactory factory) {

        this.listSource.emit(emitter);

        for (ICodeBlock i : this.indexExpressions) {
            i.emit(emitter);
        }
    }
}
