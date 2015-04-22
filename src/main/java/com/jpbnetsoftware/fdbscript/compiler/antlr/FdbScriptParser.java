// Generated from /Users/pawel/work/java/FdbScriptCompiler/src/main/antlr/FdbScript.g4 by ANTLR 4.5
package com.jpbnetsoftware.fdbscript.compiler.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FdbScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, EQ=11, GT=12, LT=13, GE=14, LE=15, NEQ=16, AND=17, OR=18, NOT=19, 
		PLUS=20, MINUS=21, DIV=22, MUL=23, TRUE=24, FALSE=25, INDEXSEPARATOR=26, 
		STRING=27, NUMBER=28, ID=29, MODULEID=30, WS=31;
	public static final int
		RULE_programDeclaration = 0, RULE_definitionExpression = 1, RULE_functionDeclaration = 2, 
		RULE_invokeExpression = 3, RULE_ifExpression = 4, RULE_conditionClause = 5, 
		RULE_elseClause = 6, RULE_listExpression = 7, RULE_indexExpression = 8, 
		RULE_listAccessArgExpression = 9, RULE_listAccessExpression = 10, RULE_expression = 11, 
		RULE_valueExpression = 12, RULE_mathExpression = 13, RULE_additiveExpression = 14, 
		RULE_multiplicativeExpression = 15, RULE_compareExpression = 16, RULE_logicalExpression = 17;
	public static final String[] ruleNames = {
		"programDeclaration", "definitionExpression", "functionDeclaration", "invokeExpression", 
		"ifExpression", "conditionClause", "elseClause", "listExpression", "indexExpression", 
		"listAccessArgExpression", "listAccessExpression", "expression", "valueExpression", 
		"mathExpression", "additiveExpression", "multiplicativeExpression", "compareExpression", 
		"logicalExpression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'module'", "'='", "'f'", "'('", "','", "')'", "'->'", "'_'", "'['", 
		"']'", "'=='", "'>'", "'<'", "'>='", "'<='", "'!='", "'and'", "'or'", 
		"'!'", "'+'", "'-'", "'/'", "'*'", "'true'", "'false'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "EQ", 
		"GT", "LT", "GE", "LE", "NEQ", "AND", "OR", "NOT", "PLUS", "MINUS", "DIV", 
		"MUL", "TRUE", "FALSE", "INDEXSEPARATOR", "STRING", "NUMBER", "ID", "MODULEID", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FdbScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FdbScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramDeclarationContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MODULEID() { return getToken(FdbScriptParser.MODULEID, 0); }
		public List<DefinitionExpressionContext> definitionExpression() {
			return getRuleContexts(DefinitionExpressionContext.class);
		}
		public DefinitionExpressionContext definitionExpression(int i) {
			return getRuleContext(DefinitionExpressionContext.class,i);
		}
		public ProgramDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterProgramDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitProgramDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitProgramDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramDeclarationContext programDeclaration() throws RecognitionException {
		ProgramDeclarationContext _localctx = new ProgramDeclarationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(36); 
				match(T__0);
				setState(37); 
				match(MODULEID);
				}
			}

			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(40); 
					definitionExpression();
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(46); 
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionExpressionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(FdbScriptParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DefinitionExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitionExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterDefinitionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitDefinitionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitDefinitionExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionExpressionContext definitionExpression() throws RecognitionException {
		DefinitionExpressionContext _localctx = new DefinitionExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definitionExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); 
			match(ID);
			setState(49); 
			match(T__1);
			setState(50); 
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(FdbScriptParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FdbScriptParser.ID, i);
		}
		public List<DefinitionExpressionContext> definitionExpression() {
			return getRuleContexts(DefinitionExpressionContext.class);
		}
		public DefinitionExpressionContext definitionExpression(int i) {
			return getRuleContext(DefinitionExpressionContext.class,i);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(52); 
			match(T__2);
			setState(53); 
			match(T__3);
			setState(62);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(54); 
				match(ID);
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(55); 
					match(T__4);
					setState(56); 
					match(ID);
					}
					}
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(64); 
			match(T__5);
			setState(65); 
			match(INDEXSEPARATOR);
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(66); 
					definitionExpression();
					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(72); 
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InvokeExpressionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(FdbScriptParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public InvokeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invokeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterInvokeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitInvokeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitInvokeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvokeExpressionContext invokeExpression() throws RecognitionException {
		InvokeExpressionContext _localctx = new InvokeExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_invokeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); 
			match(ID);
			setState(75); 
			match(T__3);
			setState(84);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__8) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << STRING) | (1L << NUMBER) | (1L << ID))) != 0)) {
				{
				setState(76); 
				expression();
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(77); 
					match(T__4);
					setState(78); 
					expression();
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(86); 
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfExpressionContext extends ParserRuleContext {
		public ElseClauseContext elseClause() {
			return getRuleContext(ElseClauseContext.class,0);
		}
		public List<ConditionClauseContext> conditionClause() {
			return getRuleContexts(ConditionClauseContext.class);
		}
		public ConditionClauseContext conditionClause(int i) {
			return getRuleContext(ConditionClauseContext.class,i);
		}
		public IfExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterIfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitIfExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitIfExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfExpressionContext ifExpression() throws RecognitionException {
		IfExpressionContext _localctx = new IfExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(88); 
				conditionClause();
				}
				}
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			{
			setState(93); 
			elseClause();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionClauseContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ConditionClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterConditionClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitConditionClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitConditionClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionClauseContext conditionClause() throws RecognitionException {
		ConditionClauseContext _localctx = new ConditionClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_conditionClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); 
			match(T__3);
			setState(96); 
			expression();
			setState(97); 
			match(T__5);
			setState(98); 
			match(T__6);
			setState(99); 
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseClauseContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ElseClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterElseClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitElseClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitElseClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseClauseContext elseClause() throws RecognitionException {
		ElseClauseContext _localctx = new ElseClauseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_elseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); 
			match(T__7);
			setState(102); 
			match(T__6);
			setState(103); 
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListExpressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ListExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterListExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitListExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitListExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListExpressionContext listExpression() throws RecognitionException {
		ListExpressionContext _localctx = new ListExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_listExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105); 
			match(T__8);
			setState(114);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__8) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << STRING) | (1L << NUMBER) | (1L << ID))) != 0)) {
				{
				setState(106); 
				expression();
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(107); 
					match(T__4);
					setState(108); 
					expression();
					}
					}
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(116); 
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexExpressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode INDEXSEPARATOR() { return getToken(FdbScriptParser.INDEXSEPARATOR, 0); }
		public IndexExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterIndexExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitIndexExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitIndexExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexExpressionContext indexExpression() throws RecognitionException {
		IndexExpressionContext _localctx = new IndexExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_indexExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118); 
			match(T__8);
			setState(120);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__8) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << STRING) | (1L << NUMBER) | (1L << ID))) != 0)) {
				{
				setState(119); 
				expression();
				}
			}

			setState(126);
			_la = _input.LA(1);
			if (_la==INDEXSEPARATOR) {
				{
				setState(122); 
				match(INDEXSEPARATOR);
				setState(124);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__8) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << STRING) | (1L << NUMBER) | (1L << ID))) != 0)) {
					{
					setState(123); 
					expression();
					}
				}

				}
			}

			setState(128); 
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListAccessArgExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ID() { return getToken(FdbScriptParser.ID, 0); }
		public InvokeExpressionContext invokeExpression() {
			return getRuleContext(InvokeExpressionContext.class,0);
		}
		public ListExpressionContext listExpression() {
			return getRuleContext(ListExpressionContext.class,0);
		}
		public ListAccessArgExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listAccessArgExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterListAccessArgExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitListAccessArgExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitListAccessArgExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListAccessArgExpressionContext listAccessArgExpression() throws RecognitionException {
		ListAccessArgExpressionContext _localctx = new ListAccessArgExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_listAccessArgExpression);
		try {
			setState(137);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130); 
				match(T__3);
				setState(131); 
				expression();
				setState(132); 
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134); 
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(135); 
				invokeExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(136); 
				listExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListAccessExpressionContext extends ParserRuleContext {
		public ListAccessArgExpressionContext listAccessArgExpression() {
			return getRuleContext(ListAccessArgExpressionContext.class,0);
		}
		public List<IndexExpressionContext> indexExpression() {
			return getRuleContexts(IndexExpressionContext.class);
		}
		public IndexExpressionContext indexExpression(int i) {
			return getRuleContext(IndexExpressionContext.class,i);
		}
		public ListAccessExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listAccessExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterListAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitListAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitListAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListAccessExpressionContext listAccessExpression() throws RecognitionException {
		ListAccessExpressionContext _localctx = new ListAccessExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_listAccessExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(139); 
			listAccessArgExpression();
			setState(141); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(140); 
					indexExpression();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(143); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public CompareExpressionContext compareExpression() {
			return getRuleContext(CompareExpressionContext.class,0);
		}
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public ListExpressionContext listExpression() {
			return getRuleContext(ListExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		try {
			setState(150);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145); 
				valueExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146); 
				mathExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147); 
				compareExpression(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(148); 
				logicalExpression(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(149); 
				listExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueExpressionContext extends ParserRuleContext {
		public IfExpressionContext ifExpression() {
			return getRuleContext(IfExpressionContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public InvokeExpressionContext invokeExpression() {
			return getRuleContext(InvokeExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ListExpressionContext listExpression() {
			return getRuleContext(ListExpressionContext.class,0);
		}
		public ListAccessExpressionContext listAccessExpression() {
			return getRuleContext(ListAccessExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(FdbScriptParser.NOT, 0); }
		public TerminalNode ID() { return getToken(FdbScriptParser.ID, 0); }
		public TerminalNode TRUE() { return getToken(FdbScriptParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FdbScriptParser.FALSE, 0); }
		public TerminalNode NUMBER() { return getToken(FdbScriptParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(FdbScriptParser.STRING, 0); }
		public ValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterValueExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitValueExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueExpressionContext valueExpression() throws RecognitionException {
		ValueExpressionContext _localctx = new ValueExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_valueExpression);
		try {
			setState(168);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152); 
				ifExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(153); 
				functionDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(154); 
				invokeExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(155); 
				match(T__3);
				setState(156); 
				expression();
				setState(157); 
				match(T__5);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(159); 
				listExpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(160); 
				listAccessExpression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(161); 
				match(NOT);
				setState(162); 
				expression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(163); 
				match(ID);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(164); 
				match(TRUE);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(165); 
				match(FALSE);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(166); 
				match(NUMBER);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(167); 
				match(STRING);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MathExpressionContext extends ParserRuleContext {
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public MathExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterMathExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitMathExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitMathExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathExpressionContext mathExpression() throws RecognitionException {
		MathExpressionContext _localctx = new MathExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_mathExpression);
		try {
			setState(172);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170); 
				multiplicativeExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171); 
				additiveExpression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(FdbScriptParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(FdbScriptParser.MINUS, 0); }
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		return additiveExpression(0);
	}

	private AdditiveExpressionContext additiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, _parentState);
		AdditiveExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_additiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(175); 
			multiplicativeExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(183);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(177);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(178); 
						match(PLUS);
						setState(179); 
						multiplicativeExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(180);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(181); 
						match(MINUS);
						setState(182); 
						multiplicativeExpression(0);
						}
						break;
					}
					} 
				}
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public TerminalNode MUL() { return getToken(FdbScriptParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(FdbScriptParser.DIV, 0); }
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		return multiplicativeExpression(0);
	}

	private MultiplicativeExpressionContext multiplicativeExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, _parentState);
		MultiplicativeExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_multiplicativeExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(189); 
			valueExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(197);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(191);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(192); 
						match(MUL);
						setState(193); 
						valueExpression();
						}
						break;
					case 2:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(194);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(195); 
						match(DIV);
						setState(196); 
						valueExpression();
						}
						break;
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CompareExpressionContext extends ParserRuleContext {
		public MathExpressionContext mathExpression() {
			return getRuleContext(MathExpressionContext.class,0);
		}
		public CompareExpressionContext compareExpression() {
			return getRuleContext(CompareExpressionContext.class,0);
		}
		public TerminalNode EQ() { return getToken(FdbScriptParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(FdbScriptParser.NEQ, 0); }
		public TerminalNode GT() { return getToken(FdbScriptParser.GT, 0); }
		public TerminalNode LT() { return getToken(FdbScriptParser.LT, 0); }
		public TerminalNode GE() { return getToken(FdbScriptParser.GE, 0); }
		public TerminalNode LE() { return getToken(FdbScriptParser.LE, 0); }
		public CompareExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterCompareExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitCompareExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitCompareExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompareExpressionContext compareExpression() throws RecognitionException {
		return compareExpression(0);
	}

	private CompareExpressionContext compareExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CompareExpressionContext _localctx = new CompareExpressionContext(_ctx, _parentState);
		CompareExpressionContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_compareExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(203); 
			mathExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(223);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new CompareExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_compareExpression);
						setState(205);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(206); 
						match(EQ);
						setState(207); 
						mathExpression();
						}
						break;
					case 2:
						{
						_localctx = new CompareExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_compareExpression);
						setState(208);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(209); 
						match(NEQ);
						setState(210); 
						mathExpression();
						}
						break;
					case 3:
						{
						_localctx = new CompareExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_compareExpression);
						setState(211);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(212); 
						match(GT);
						setState(213); 
						mathExpression();
						}
						break;
					case 4:
						{
						_localctx = new CompareExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_compareExpression);
						setState(214);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(215); 
						match(LT);
						setState(216); 
						mathExpression();
						}
						break;
					case 5:
						{
						_localctx = new CompareExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_compareExpression);
						setState(217);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(218); 
						match(GE);
						setState(219); 
						mathExpression();
						}
						break;
					case 6:
						{
						_localctx = new CompareExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_compareExpression);
						setState(220);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(221); 
						match(LE);
						setState(222); 
						mathExpression();
						}
						break;
					}
					} 
				}
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LogicalExpressionContext extends ParserRuleContext {
		public CompareExpressionContext compareExpression() {
			return getRuleContext(CompareExpressionContext.class,0);
		}
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public TerminalNode AND() { return getToken(FdbScriptParser.AND, 0); }
		public TerminalNode OR() { return getToken(FdbScriptParser.OR, 0); }
		public LogicalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).enterLogicalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FdbScriptListener ) ((FdbScriptListener)listener).exitLogicalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FdbScriptVisitor ) return ((FdbScriptVisitor<? extends T>)visitor).visitLogicalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalExpressionContext logicalExpression() throws RecognitionException {
		return logicalExpression(0);
	}

	private LogicalExpressionContext logicalExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalExpressionContext _localctx = new LogicalExpressionContext(_ctx, _parentState);
		LogicalExpressionContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_logicalExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(229); 
			compareExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(237);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(231);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(232); 
						match(AND);
						setState(233); 
						compareExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(234);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(235); 
						match(OR);
						setState(236); 
						compareExpression(0);
						}
						break;
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14: 
			return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);
		case 15: 
			return multiplicativeExpression_sempred((MultiplicativeExpressionContext)_localctx, predIndex);
		case 16: 
			return compareExpression_sempred((CompareExpressionContext)_localctx, predIndex);
		case 17: 
			return logicalExpression_sempred((LogicalExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean additiveExpression_sempred(AdditiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return precpred(_ctx, 3);
		case 1: 
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multiplicativeExpression_sempred(MultiplicativeExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: 
			return precpred(_ctx, 3);
		case 3: 
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean compareExpression_sempred(CompareExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: 
			return precpred(_ctx, 7);
		case 5: 
			return precpred(_ctx, 6);
		case 6: 
			return precpred(_ctx, 5);
		case 7: 
			return precpred(_ctx, 4);
		case 8: 
			return precpred(_ctx, 3);
		case 9: 
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean logicalExpression_sempred(LogicalExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10: 
			return precpred(_ctx, 3);
		case 11: 
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!\u00f5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\5\2)\n\2\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\5\4A\n\4\3\4\3"+
		"\4\3\4\7\4F\n\4\f\4\16\4I\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\7\5R\n\5\f"+
		"\5\16\5U\13\5\5\5W\n\5\3\5\3\5\3\6\6\6\\\n\6\r\6\16\6]\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\7\tp\n\t\f\t\16\ts\13"+
		"\t\5\tu\n\t\3\t\3\t\3\n\3\n\5\n{\n\n\3\n\3\n\5\n\177\n\n\5\n\u0081\n\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u008c\n\13\3\f\3\f\6"+
		"\f\u0090\n\f\r\f\16\f\u0091\3\r\3\r\3\r\3\r\3\r\5\r\u0099\n\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u00ab\n\16\3\17\3\17\5\17\u00af\n\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\7\20\u00ba\n\20\f\20\16\20\u00bd\13\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00c8\n\21\f\21\16\21\u00cb\13"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00e2\n\22\f\22\16\22\u00e5"+
		"\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00f0\n\23\f"+
		"\23\16\23\u00f3\13\23\3\23\2\6\36 \"$\24\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$\2\2\u010f\2(\3\2\2\2\4\62\3\2\2\2\6\66\3\2\2\2\bL\3\2\2"+
		"\2\n[\3\2\2\2\fa\3\2\2\2\16g\3\2\2\2\20k\3\2\2\2\22x\3\2\2\2\24\u008b"+
		"\3\2\2\2\26\u008d\3\2\2\2\30\u0098\3\2\2\2\32\u00aa\3\2\2\2\34\u00ae\3"+
		"\2\2\2\36\u00b0\3\2\2\2 \u00be\3\2\2\2\"\u00cc\3\2\2\2$\u00e6\3\2\2\2"+
		"&\'\7\3\2\2\')\7 \2\2(&\3\2\2\2()\3\2\2\2)-\3\2\2\2*,\5\4\3\2+*\3\2\2"+
		"\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60\61\5\30\r\2"+
		"\61\3\3\2\2\2\62\63\7\37\2\2\63\64\7\4\2\2\64\65\5\30\r\2\65\5\3\2\2\2"+
		"\66\67\7\5\2\2\67@\7\6\2\28=\7\37\2\29:\7\7\2\2:<\7\37\2\2;9\3\2\2\2<"+
		"?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>A\3\2\2\2?=\3\2\2\2@8\3\2\2\2@A\3\2\2\2"+
		"AB\3\2\2\2BC\7\b\2\2CG\7\34\2\2DF\5\4\3\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2"+
		"\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\5\30\r\2K\7\3\2\2\2LM\7\37\2\2MV\7"+
		"\6\2\2NS\5\30\r\2OP\7\7\2\2PR\5\30\r\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2S"+
		"T\3\2\2\2TW\3\2\2\2US\3\2\2\2VN\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\7\b\2\2"+
		"Y\t\3\2\2\2Z\\\5\f\7\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2\2]^\3\2\2\2^_\3\2"+
		"\2\2_`\5\16\b\2`\13\3\2\2\2ab\7\6\2\2bc\5\30\r\2cd\7\b\2\2de\7\t\2\2e"+
		"f\5\30\r\2f\r\3\2\2\2gh\7\n\2\2hi\7\t\2\2ij\5\30\r\2j\17\3\2\2\2kt\7\13"+
		"\2\2lq\5\30\r\2mn\7\7\2\2np\5\30\r\2om\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3"+
		"\2\2\2ru\3\2\2\2sq\3\2\2\2tl\3\2\2\2tu\3\2\2\2uv\3\2\2\2vw\7\f\2\2w\21"+
		"\3\2\2\2xz\7\13\2\2y{\5\30\r\2zy\3\2\2\2z{\3\2\2\2{\u0080\3\2\2\2|~\7"+
		"\34\2\2}\177\5\30\r\2~}\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080|"+
		"\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\7\f\2\2\u0083"+
		"\23\3\2\2\2\u0084\u0085\7\6\2\2\u0085\u0086\5\30\r\2\u0086\u0087\7\b\2"+
		"\2\u0087\u008c\3\2\2\2\u0088\u008c\7\37\2\2\u0089\u008c\5\b\5\2\u008a"+
		"\u008c\5\20\t\2\u008b\u0084\3\2\2\2\u008b\u0088\3\2\2\2\u008b\u0089\3"+
		"\2\2\2\u008b\u008a\3\2\2\2\u008c\25\3\2\2\2\u008d\u008f\5\24\13\2\u008e"+
		"\u0090\5\22\n\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f\3"+
		"\2\2\2\u0091\u0092\3\2\2\2\u0092\27\3\2\2\2\u0093\u0099\5\32\16\2\u0094"+
		"\u0099\5\34\17\2\u0095\u0099\5\"\22\2\u0096\u0099\5$\23\2\u0097\u0099"+
		"\5\20\t\2\u0098\u0093\3\2\2\2\u0098\u0094\3\2\2\2\u0098\u0095\3\2\2\2"+
		"\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\31\3\2\2\2\u009a\u00ab"+
		"\5\n\6\2\u009b\u00ab\5\6\4\2\u009c\u00ab\5\b\5\2\u009d\u009e\7\6\2\2\u009e"+
		"\u009f\5\30\r\2\u009f\u00a0\7\b\2\2\u00a0\u00ab\3\2\2\2\u00a1\u00ab\5"+
		"\20\t\2\u00a2\u00ab\5\26\f\2\u00a3\u00a4\7\25\2\2\u00a4\u00ab\5\30\r\2"+
		"\u00a5\u00ab\7\37\2\2\u00a6\u00ab\7\32\2\2\u00a7\u00ab\7\33\2\2\u00a8"+
		"\u00ab\7\36\2\2\u00a9\u00ab\7\35\2\2\u00aa\u009a\3\2\2\2\u00aa\u009b\3"+
		"\2\2\2\u00aa\u009c\3\2\2\2\u00aa\u009d\3\2\2\2\u00aa\u00a1\3\2\2\2\u00aa"+
		"\u00a2\3\2\2\2\u00aa\u00a3\3\2\2\2\u00aa\u00a5\3\2\2\2\u00aa\u00a6\3\2"+
		"\2\2\u00aa\u00a7\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab"+
		"\33\3\2\2\2\u00ac\u00af\5 \21\2\u00ad\u00af\5\36\20\2\u00ae\u00ac\3\2"+
		"\2\2\u00ae\u00ad\3\2\2\2\u00af\35\3\2\2\2\u00b0\u00b1\b\20\1\2\u00b1\u00b2"+
		"\5 \21\2\u00b2\u00bb\3\2\2\2\u00b3\u00b4\f\5\2\2\u00b4\u00b5\7\26\2\2"+
		"\u00b5\u00ba\5 \21\2\u00b6\u00b7\f\4\2\2\u00b7\u00b8\7\27\2\2\u00b8\u00ba"+
		"\5 \21\2\u00b9\u00b3\3\2\2\2\u00b9\u00b6\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb"+
		"\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\37\3\2\2\2\u00bd\u00bb\3\2\2"+
		"\2\u00be\u00bf\b\21\1\2\u00bf\u00c0\5\32\16\2\u00c0\u00c9\3\2\2\2\u00c1"+
		"\u00c2\f\5\2\2\u00c2\u00c3\7\31\2\2\u00c3\u00c8\5\32\16\2\u00c4\u00c5"+
		"\f\4\2\2\u00c5\u00c6\7\30\2\2\u00c6\u00c8\5\32\16\2\u00c7\u00c1\3\2\2"+
		"\2\u00c7\u00c4\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca!\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\b\22\1\2\u00cd"+
		"\u00ce\5\34\17\2\u00ce\u00e3\3\2\2\2\u00cf\u00d0\f\t\2\2\u00d0\u00d1\7"+
		"\r\2\2\u00d1\u00e2\5\34\17\2\u00d2\u00d3\f\b\2\2\u00d3\u00d4\7\22\2\2"+
		"\u00d4\u00e2\5\34\17\2\u00d5\u00d6\f\7\2\2\u00d6\u00d7\7\16\2\2\u00d7"+
		"\u00e2\5\34\17\2\u00d8\u00d9\f\6\2\2\u00d9\u00da\7\17\2\2\u00da\u00e2"+
		"\5\34\17\2\u00db\u00dc\f\5\2\2\u00dc\u00dd\7\20\2\2\u00dd\u00e2\5\34\17"+
		"\2\u00de\u00df\f\4\2\2\u00df\u00e0\7\21\2\2\u00e0\u00e2\5\34\17\2\u00e1"+
		"\u00cf\3\2\2\2\u00e1\u00d2\3\2\2\2\u00e1\u00d5\3\2\2\2\u00e1\u00d8\3\2"+
		"\2\2\u00e1\u00db\3\2\2\2\u00e1\u00de\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4#\3\2\2\2\u00e5\u00e3\3\2\2\2"+
		"\u00e6\u00e7\b\23\1\2\u00e7\u00e8\5\"\22\2\u00e8\u00f1\3\2\2\2\u00e9\u00ea"+
		"\f\5\2\2\u00ea\u00eb\7\23\2\2\u00eb\u00f0\5\"\22\2\u00ec\u00ed\f\4\2\2"+
		"\u00ed\u00ee\7\24\2\2\u00ee\u00f0\5\"\22\2\u00ef\u00e9\3\2\2\2\u00ef\u00ec"+
		"\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"%\3\2\2\2\u00f3\u00f1\3\2\2\2\34(-=@GSV]qtz~\u0080\u008b\u0091\u0098\u00aa"+
		"\u00ae\u00b9\u00bb\u00c7\u00c9\u00e1\u00e3\u00ef\u00f1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}