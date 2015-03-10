// Generated from SQL.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__10=1, T__9=2, T__8=3, T__7=4, T__6=5, T__5=6, T__4=7, T__3=8, T__2=9, 
		T__1=10, T__0=11, CREATE=12, DATABASE=13, DATABASES=14, ALTER=15, RENAMETO=16, 
		DROP=17, SHOW=18, USE=19, TABLE=20, INT=21, FLOAT=22, DATE=23, CHAR=24, 
		CONSTRAINT=25, PRIMARY=26, KEY=27, FOREIGN=28, CHECK=29, REFERENCES=30, 
		TABLES=31, COLUMNS=32, FROM=33, ADD=34, COLUMN=35, RENAME=36, TO=37, AND=38, 
		OR=39, NOT=40, INSERT=41, INTO=42, WHERE=43, UPDATE=44, SET=45, DELETE=46, 
		SELECT=47, ORDER=48, BY=49, ASC=50, DESC=51, DATE_VAL=52, NUM=53, ID=54, 
		CHAR_VAL=55, FLOAT_VAL=56;
	public static final String[] tokenNames = {
		"<INVALID>", "'>'", "')'", "'.'", "','", "'*'", "'('", "'<>'", "'<'", 
		"'='", "'>='", "'<='", "'CREATE'", "'DATABASE'", "'DATABASES'", "'ALTER'", 
		"'RENAME TO'", "'DROP'", "'SHOW'", "'USE'", "'TABLE'", "'INT'", "'FLOAT'", 
		"'DATE'", "'CHAR'", "'CONSTRAINT'", "'PRIMARY'", "'KEY'", "'FOREIGN'", 
		"'CHECK'", "'REFERENCES'", "'TABLES'", "COLUMNS", "'FROM'", "'ADD'", "COLUMN", 
		"'RENAME'", "'TO'", "'AND'", "'OR'", "'NOT'", "'INSERT'", "'INTO'", "'WHERE'", 
		"'UPDATE'", "'SET'", "'DELETE'", "'SELECT'", "'ORDER'", "'BY'", "'ASC'", 
		"'DESC'", "DATE_VAL", "NUM", "ID", "CHAR_VAL", "FLOAT_VAL"
	};
	public static final int
		RULE_query = 0, RULE_ddlQuery = 1, RULE_createDbStmt = 2, RULE_alterDbStmt = 3, 
		RULE_dbName = 4, RULE_newDbName = 5, RULE_dropDbStmt = 6, RULE_showDbStmt = 7, 
		RULE_useDbStmt = 8, RULE_createTableStmt = 9, RULE_tableName = 10, RULE_columnDecl = 11, 
		RULE_tipo = 12, RULE_colName = 13, RULE_colConstraint = 14, RULE_chNombre = 15, 
		RULE_idTabla = 16, RULE_fkNombre = 17, RULE_pkNombre = 18, RULE_expConstraint = 19, 
		RULE_alterTableStmt = 20, RULE_alterName = 21, RULE_newName = 22, RULE_accion = 23, 
		RULE_columnName = 24, RULE_dropTableStmt = 25, RULE_showTableStmt = 26, 
		RULE_showColumnsStmt = 27, RULE_expression = 28, RULE_andexpr = 29, RULE_factor = 30, 
		RULE_primary = 31, RULE_compareExpr = 32, RULE_term = 33, RULE_column = 34, 
		RULE_table = 35, RULE_rel_op = 36, RULE_dmlQuery = 37, RULE_insertStmt = 38, 
		RULE_columnList = 39, RULE_valueList = 40, RULE_val = 41, RULE_updateStmt = 42, 
		RULE_columnsUpdate = 43, RULE_deleteStmt = 44, RULE_selectStmt = 45, RULE_selectList = 46, 
		RULE_orderExpr = 47, RULE_orderTerm = 48;
	public static final String[] ruleNames = {
		"query", "ddlQuery", "createDbStmt", "alterDbStmt", "dbName", "newDbName", 
		"dropDbStmt", "showDbStmt", "useDbStmt", "createTableStmt", "tableName", 
		"columnDecl", "tipo", "colName", "colConstraint", "chNombre", "idTabla", 
		"fkNombre", "pkNombre", "expConstraint", "alterTableStmt", "alterName", 
		"newName", "accion", "columnName", "dropTableStmt", "showTableStmt", "showColumnsStmt", 
		"expression", "andexpr", "factor", "primary", "compareExpr", "term", "column", 
		"table", "rel_op", "dmlQuery", "insertStmt", "columnList", "valueList", 
		"val", "updateStmt", "columnsUpdate", "deleteStmt", "selectStmt", "selectList", 
		"orderExpr", "orderTerm"
	};

	@Override
	public String getGrammarFileName() { return "SQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QueryContext extends ParserRuleContext {
		public DdlQueryContext ddlQuery() {
			return getRuleContext(DdlQueryContext.class,0);
		}
		public DmlQueryContext dmlQuery() {
			return getRuleContext(DmlQueryContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		try {
			setState(100);
			switch (_input.LA(1)) {
			case CREATE:
			case ALTER:
			case DROP:
			case SHOW:
			case USE:
				enterOuterAlt(_localctx, 1);
				{
				setState(98); ddlQuery();
				}
				break;
			case INSERT:
			case UPDATE:
			case DELETE:
			case SELECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(99); dmlQuery();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class DdlQueryContext extends ParserRuleContext {
		public DropDbStmtContext dropDbStmt() {
			return getRuleContext(DropDbStmtContext.class,0);
		}
		public ShowDbStmtContext showDbStmt() {
			return getRuleContext(ShowDbStmtContext.class,0);
		}
		public UseDbStmtContext useDbStmt() {
			return getRuleContext(UseDbStmtContext.class,0);
		}
		public CreateDbStmtContext createDbStmt() {
			return getRuleContext(CreateDbStmtContext.class,0);
		}
		public ShowColumnsStmtContext showColumnsStmt() {
			return getRuleContext(ShowColumnsStmtContext.class,0);
		}
		public DropTableStmtContext dropTableStmt() {
			return getRuleContext(DropTableStmtContext.class,0);
		}
		public AlterTableStmtContext alterTableStmt() {
			return getRuleContext(AlterTableStmtContext.class,0);
		}
		public CreateTableStmtContext createTableStmt() {
			return getRuleContext(CreateTableStmtContext.class,0);
		}
		public AlterDbStmtContext alterDbStmt() {
			return getRuleContext(AlterDbStmtContext.class,0);
		}
		public ShowTableStmtContext showTableStmt() {
			return getRuleContext(ShowTableStmtContext.class,0);
		}
		public DdlQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ddlQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterDdlQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitDdlQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitDdlQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DdlQueryContext ddlQuery() throws RecognitionException {
		DdlQueryContext _localctx = new DdlQueryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ddlQuery);
		try {
			setState(112);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102); createDbStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103); alterDbStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(104); dropDbStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(105); showDbStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(106); useDbStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(107); createTableStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(108); alterTableStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(109); dropTableStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(110); showTableStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(111); showColumnsStmt();
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

	public static class CreateDbStmtContext extends ParserRuleContext {
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public CreateDbStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createDbStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterCreateDbStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitCreateDbStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitCreateDbStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateDbStmtContext createDbStmt() throws RecognitionException {
		CreateDbStmtContext _localctx = new CreateDbStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_createDbStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114); match(CREATE);
			setState(115); match(DATABASE);
			setState(116); match(ID);
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

	public static class AlterDbStmtContext extends ParserRuleContext {
		public TerminalNode RENAMETO() { return getToken(SQLParser.RENAMETO, 0); }
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public DbNameContext dbName() {
			return getRuleContext(DbNameContext.class,0);
		}
		public NewDbNameContext newDbName() {
			return getRuleContext(NewDbNameContext.class,0);
		}
		public AlterDbStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alterDbStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterAlterDbStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitAlterDbStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitAlterDbStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlterDbStmtContext alterDbStmt() throws RecognitionException {
		AlterDbStmtContext _localctx = new AlterDbStmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_alterDbStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118); match(ALTER);
			setState(119); match(DATABASE);
			setState(120); dbName();
			setState(121); match(RENAMETO);
			setState(122); newDbName();
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

	public static class DbNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public DbNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dbName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterDbName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitDbName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitDbName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DbNameContext dbName() throws RecognitionException {
		DbNameContext _localctx = new DbNameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dbName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124); match(ID);
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

	public static class NewDbNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public NewDbNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newDbName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterNewDbName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitNewDbName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitNewDbName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewDbNameContext newDbName() throws RecognitionException {
		NewDbNameContext _localctx = new NewDbNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_newDbName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); match(ID);
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

	public static class DropDbStmtContext extends ParserRuleContext {
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public DropDbStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropDbStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterDropDbStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitDropDbStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitDropDbStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DropDbStmtContext dropDbStmt() throws RecognitionException {
		DropDbStmtContext _localctx = new DropDbStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dropDbStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); match(DROP);
			setState(129); match(DATABASE);
			setState(130); match(ID);
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

	public static class ShowDbStmtContext extends ParserRuleContext {
		public TerminalNode DATABASES() { return getToken(SQLParser.DATABASES, 0); }
		public TerminalNode SHOW() { return getToken(SQLParser.SHOW, 0); }
		public ShowDbStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showDbStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterShowDbStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitShowDbStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitShowDbStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowDbStmtContext showDbStmt() throws RecognitionException {
		ShowDbStmtContext _localctx = new ShowDbStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_showDbStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132); match(SHOW);
			setState(133); match(DATABASES);
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

	public static class UseDbStmtContext extends ParserRuleContext {
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public TerminalNode USE() { return getToken(SQLParser.USE, 0); }
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public UseDbStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_useDbStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterUseDbStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitUseDbStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitUseDbStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UseDbStmtContext useDbStmt() throws RecognitionException {
		UseDbStmtContext _localctx = new UseDbStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_useDbStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135); match(USE);
			setState(136); match(DATABASE);
			setState(137); match(ID);
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

	public static class CreateTableStmtContext extends ParserRuleContext {
		public List<ColConstraintContext> colConstraint() {
			return getRuleContexts(ColConstraintContext.class);
		}
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ColConstraintContext colConstraint(int i) {
			return getRuleContext(ColConstraintContext.class,i);
		}
		public List<ColumnDeclContext> columnDecl() {
			return getRuleContexts(ColumnDeclContext.class);
		}
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public ColumnDeclContext columnDecl(int i) {
			return getRuleContext(ColumnDeclContext.class,i);
		}
		public CreateTableStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTableStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterCreateTableStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitCreateTableStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitCreateTableStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateTableStmtContext createTableStmt() throws RecognitionException {
		CreateTableStmtContext _localctx = new CreateTableStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_createTableStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); match(CREATE);
			setState(140); match(TABLE);
			setState(141); tableName();
			setState(142); match(T__5);
			{
			setState(143); columnDecl();
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(144); match(T__7);
				setState(145); columnDecl();
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(158);
			_la = _input.LA(1);
			if (_la==CONSTRAINT) {
				{
				setState(151); match(CONSTRAINT);
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(152); colConstraint();
					}
					}
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(160); match(T__9);
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

	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(ID);
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

	public static class ColumnDeclContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public ColNameContext colName() {
			return getRuleContext(ColNameContext.class,0);
		}
		public ColumnDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterColumnDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitColumnDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitColumnDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnDeclContext columnDecl() throws RecognitionException {
		ColumnDeclContext _localctx = new ColumnDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_columnDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164); colName();
			setState(165); tipo();
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

	public static class TipoContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(SQLParser.DATE, 0); }
		public TerminalNode FLOAT() { return getToken(SQLParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(SQLParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(SQLParser.CHAR, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << DATE) | (1L << CHAR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class ColNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public ColNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterColName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitColName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitColName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColNameContext colName() throws RecognitionException {
		ColNameContext _localctx = new ColNameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_colName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); match(ID);
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

	public static class ColConstraintContext extends ParserRuleContext {
		public TerminalNode CHECK() { return getToken(SQLParser.CHECK, 0); }
		public ExpConstraintContext expConstraint() {
			return getRuleContext(ExpConstraintContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(SQLParser.ID); }
		public TerminalNode KEY() { return getToken(SQLParser.KEY, 0); }
		public PkNombreContext pkNombre() {
			return getRuleContext(PkNombreContext.class,0);
		}
		public TerminalNode PRIMARY() { return getToken(SQLParser.PRIMARY, 0); }
		public FkNombreContext fkNombre() {
			return getRuleContext(FkNombreContext.class,0);
		}
		public TerminalNode FOREIGN() { return getToken(SQLParser.FOREIGN, 0); }
		public ChNombreContext chNombre() {
			return getRuleContext(ChNombreContext.class,0);
		}
		public IdTablaContext idTabla() {
			return getRuleContext(IdTablaContext.class,0);
		}
		public TerminalNode REFERENCES() { return getToken(SQLParser.REFERENCES, 0); }
		public TerminalNode ID(int i) {
			return getToken(SQLParser.ID, i);
		}
		public ColConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterColConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitColConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitColConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColConstraintContext colConstraint() throws RecognitionException {
		ColConstraintContext _localctx = new ColConstraintContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_colConstraint);
		int _la;
		try {
			setState(208);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(171); pkNombre();
				setState(172); match(PRIMARY);
				setState(173); match(KEY);
				setState(174); match(T__5);
				setState(176); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(175); match(ID);
					}
					}
					setState(178); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(180); match(T__9);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(182); fkNombre();
				setState(183); match(FOREIGN);
				setState(184); match(KEY);
				setState(185); match(T__5);
				setState(187); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(186); match(ID);
					}
					}
					setState(189); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(191); match(T__9);
				setState(192); match(REFERENCES);
				setState(193); idTabla();
				setState(194); match(T__5);
				setState(196); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(195); match(ID);
					}
					}
					setState(198); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(200); match(T__9);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(202); chNombre();
				setState(203); match(CHECK);
				setState(204); match(T__5);
				setState(205); expConstraint();
				setState(206); match(T__9);
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

	public static class ChNombreContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public ChNombreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chNombre; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterChNombre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitChNombre(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitChNombre(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChNombreContext chNombre() throws RecognitionException {
		ChNombreContext _localctx = new ChNombreContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_chNombre);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210); match(ID);
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

	public static class IdTablaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public IdTablaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idTabla; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterIdTabla(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitIdTabla(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitIdTabla(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdTablaContext idTabla() throws RecognitionException {
		IdTablaContext _localctx = new IdTablaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_idTabla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212); match(ID);
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

	public static class FkNombreContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public FkNombreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fkNombre; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterFkNombre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitFkNombre(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitFkNombre(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FkNombreContext fkNombre() throws RecognitionException {
		FkNombreContext _localctx = new FkNombreContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_fkNombre);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214); match(ID);
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

	public static class PkNombreContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public PkNombreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pkNombre; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPkNombre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPkNombre(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitPkNombre(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PkNombreContext pkNombre() throws RecognitionException {
		PkNombreContext _localctx = new PkNombreContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_pkNombre);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216); match(ID);
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

	public static class ExpConstraintContext extends ParserRuleContext {
		public ExpConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterExpConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitExpConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitExpConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpConstraintContext expConstraint() throws RecognitionException {
		ExpConstraintContext _localctx = new ExpConstraintContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
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

	public static class AlterTableStmtContext extends ParserRuleContext {
		public AlterTableStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alterTableStmt; }
	 
		public AlterTableStmtContext() { }
		public void copyFrom(AlterTableStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RenameAlterContext extends AlterTableStmtContext {
		public NewNameContext newName() {
			return getRuleContext(NewNameContext.class,0);
		}
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public TerminalNode RENAME() { return getToken(SQLParser.RENAME, 0); }
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public AlterNameContext alterName() {
			return getRuleContext(AlterNameContext.class,0);
		}
		public RenameAlterContext(AlterTableStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterRenameAlter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitRenameAlter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitRenameAlter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AccionAlterContext extends AlterTableStmtContext {
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public AccionContext accion(int i) {
			return getRuleContext(AccionContext.class,i);
		}
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public List<AccionContext> accion() {
			return getRuleContexts(AccionContext.class);
		}
		public AccionAlterContext(AlterTableStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterAccionAlter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitAccionAlter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitAccionAlter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlterTableStmtContext alterTableStmt() throws RecognitionException {
		AlterTableStmtContext _localctx = new AlterTableStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_alterTableStmt);
		int _la;
		try {
			setState(240);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new RenameAlterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(220); match(ALTER);
				setState(221); match(TABLE);
				setState(222); alterName();
				setState(223); match(RENAME);
				setState(224); match(TO);
				setState(225); newName();
				}
				break;
			case 2:
				_localctx = new AccionAlterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(227); match(ALTER);
				setState(228); match(TABLE);
				setState(229); match(ID);
				setState(238);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(230); accion();
					}
					break;
				case 2:
					{
					setState(231); accion();
					setState(234); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(232); match(T__7);
						setState(233); accion();
						}
						}
						setState(236); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==T__7 );
					}
					break;
				}
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

	public static class AlterNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public AlterNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alterName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterAlterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitAlterName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitAlterName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlterNameContext alterName() throws RecognitionException {
		AlterNameContext _localctx = new AlterNameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_alterName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242); match(ID);
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

	public static class NewNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public NewNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterNewName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitNewName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitNewName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewNameContext newName() throws RecognitionException {
		NewNameContext _localctx = new NewNameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_newName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244); match(ID);
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

	public static class AccionContext extends ParserRuleContext {
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
		public ColConstraintContext colConstraint() {
			return getRuleContext(ColConstraintContext.class,0);
		}
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode ADD() { return getToken(SQLParser.ADD, 0); }
		public AccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterAccion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitAccion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitAccion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccionContext accion() throws RecognitionException {
		AccionContext _localctx = new AccionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_accion);
		try {
			setState(262);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(246); match(ADD);
				setState(247); match(COLUMN);
				setState(248); columnName();
				setState(249); tipo();
				setState(250); match(CONSTRAINT);
				setState(251); colConstraint();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(253); match(ADD);
				setState(254); match(CONSTRAINT);
				setState(255); colConstraint();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(256); match(DROP);
				setState(257); match(COLUMN);
				setState(258); columnName();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(259); match(DROP);
				setState(260); match(CONSTRAINT);
				setState(261); match(ID);
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

	public static class ColumnNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitColumnName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitColumnName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264); match(ID);
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

	public static class DropTableStmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public DropTableStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropTableStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterDropTableStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitDropTableStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitDropTableStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DropTableStmtContext dropTableStmt() throws RecognitionException {
		DropTableStmtContext _localctx = new DropTableStmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_dropTableStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266); match(DROP);
			setState(267); match(TABLE);
			setState(268); match(ID);
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

	public static class ShowTableStmtContext extends ParserRuleContext {
		public TerminalNode TABLES() { return getToken(SQLParser.TABLES, 0); }
		public TerminalNode SHOW() { return getToken(SQLParser.SHOW, 0); }
		public ShowTableStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showTableStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterShowTableStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitShowTableStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitShowTableStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowTableStmtContext showTableStmt() throws RecognitionException {
		ShowTableStmtContext _localctx = new ShowTableStmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_showTableStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270); match(SHOW);
			setState(271); match(TABLES);
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

	public static class ShowColumnsStmtContext extends ParserRuleContext {
		public TerminalNode COLUMNS() { return getToken(SQLParser.COLUMNS, 0); }
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public TerminalNode SHOW() { return getToken(SQLParser.SHOW, 0); }
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public ShowColumnsStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showColumnsStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterShowColumnsStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitShowColumnsStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitShowColumnsStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowColumnsStmtContext showColumnsStmt() throws RecognitionException {
		ShowColumnsStmtContext _localctx = new ShowColumnsStmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_showColumnsStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273); match(SHOW);
			setState(274); match(COLUMNS);
			setState(275); match(FROM);
			setState(276); match(ID);
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
		public AndexprContext andexpr() {
			return getRuleContext(AndexprContext.class,0);
		}
		public TerminalNode OR() { return getToken(SQLParser.OR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(279); andexpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(281);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(282); match(OR);
					setState(283); andexpr(0);
					}
					} 
				}
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class AndexprContext extends ParserRuleContext {
		public AndexprContext andexpr() {
			return getRuleContext(AndexprContext.class,0);
		}
		public TerminalNode AND() { return getToken(SQLParser.AND, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public AndexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterAndexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitAndexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitAndexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndexprContext andexpr() throws RecognitionException {
		return andexpr(0);
	}

	private AndexprContext andexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndexprContext _localctx = new AndexprContext(_ctx, _parentState);
		AndexprContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_andexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(290); factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(297);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndexprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andexpr);
					setState(292);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(293); match(AND);
					setState(294); factor();
					}
					} 
				}
				setState(299);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class FactorContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_factor);
		try {
			setState(303);
			switch (_input.LA(1)) {
			case T__5:
			case DATE_VAL:
			case NUM:
			case ID:
			case CHAR_VAL:
			case FLOAT_VAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(300); primary();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(301); match(NOT);
				setState(302); primary();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class PrimaryContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CompareExprContext compareExpr() {
			return getRuleContext(CompareExprContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_primary);
		try {
			setState(310);
			switch (_input.LA(1)) {
			case DATE_VAL:
			case NUM:
			case ID:
			case CHAR_VAL:
			case FLOAT_VAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(305); compareExpr();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(306); match(T__5);
				setState(307); expression(0);
				setState(308); match(T__9);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class CompareExprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public Rel_opContext rel_op() {
			return getRuleContext(Rel_opContext.class,0);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public CompareExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterCompareExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitCompareExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitCompareExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompareExprContext compareExpr() throws RecognitionException {
		CompareExprContext _localctx = new CompareExprContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_compareExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312); term();
			setState(313); rel_op();
			setState(314); term();
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

	public static class TermContext extends ParserRuleContext {
		public TerminalNode FLOAT_VAL() { return getToken(SQLParser.FLOAT_VAL, 0); }
		public TerminalNode CHAR_VAL() { return getToken(SQLParser.CHAR_VAL, 0); }
		public TerminalNode DATE_VAL() { return getToken(SQLParser.DATE_VAL, 0); }
		public TerminalNode NUM() { return getToken(SQLParser.NUM, 0); }
		public ColumnContext column() {
			return getRuleContext(ColumnContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_term);
		try {
			setState(321);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(316); column();
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(317); match(NUM);
				}
				break;
			case FLOAT_VAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(318); match(FLOAT_VAL);
				}
				break;
			case DATE_VAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(319); match(DATE_VAL);
				}
				break;
			case CHAR_VAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(320); match(CHAR_VAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ColumnContext extends ParserRuleContext {
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public ColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitColumn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnContext column() throws RecognitionException {
		ColumnContext _localctx = new ColumnContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_column);
		try {
			setState(328);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(323); match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(324); table();
				setState(325); match(T__8);
				setState(326); match(ID);
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

	public static class TableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330); match(ID);
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

	public static class Rel_opContext extends ParserRuleContext {
		public Rel_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterRel_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitRel_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitRel_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rel_opContext rel_op() throws RecognitionException {
		Rel_opContext _localctx = new Rel_opContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_rel_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__4) | (1L << T__3) | (1L << T__2) | (1L << T__1) | (1L << T__0))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class DmlQueryContext extends ParserRuleContext {
		public SelectStmtContext selectStmt() {
			return getRuleContext(SelectStmtContext.class,0);
		}
		public UpdateStmtContext updateStmt() {
			return getRuleContext(UpdateStmtContext.class,0);
		}
		public InsertStmtContext insertStmt() {
			return getRuleContext(InsertStmtContext.class,0);
		}
		public DeleteStmtContext deleteStmt() {
			return getRuleContext(DeleteStmtContext.class,0);
		}
		public DmlQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dmlQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterDmlQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitDmlQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitDmlQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DmlQueryContext dmlQuery() throws RecognitionException {
		DmlQueryContext _localctx = new DmlQueryContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_dmlQuery);
		try {
			setState(338);
			switch (_input.LA(1)) {
			case INSERT:
				enterOuterAlt(_localctx, 1);
				{
				setState(334); insertStmt();
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(335); updateStmt();
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 3);
				{
				setState(336); deleteStmt();
				}
				break;
			case SELECT:
				enterOuterAlt(_localctx, 4);
				{
				setState(337); selectStmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class InsertStmtContext extends ParserRuleContext {
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public ColumnListContext columnList() {
			return getRuleContext(ColumnListContext.class,0);
		}
		public TerminalNode INTO() { return getToken(SQLParser.INTO, 0); }
		public TerminalNode INSERT() { return getToken(SQLParser.INSERT, 0); }
		public ValueListContext valueList() {
			return getRuleContext(ValueListContext.class,0);
		}
		public InsertStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterInsertStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitInsertStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitInsertStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertStmtContext insertStmt() throws RecognitionException {
		InsertStmtContext _localctx = new InsertStmtContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_insertStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340); match(INSERT);
			setState(341); match(INTO);
			setState(342); table();
			setState(344);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(343); columnList();
				}
			}

			setState(346); valueList();
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

	public static class ColumnListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SQLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SQLParser.ID, i);
		}
		public ColumnListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterColumnList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitColumnList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitColumnList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnListContext columnList() throws RecognitionException {
		ColumnListContext _localctx = new ColumnListContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_columnList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348); match(T__5);
			setState(349); match(ID);
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(350); match(T__7);
				setState(351); match(ID);
				}
				}
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(357); match(T__9);
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

	public static class ValueListContext extends ParserRuleContext {
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public ValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterValueList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitValueList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitValueList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueListContext valueList() throws RecognitionException {
		ValueListContext _localctx = new ValueListContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_valueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359); val();
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DATE_VAL) | (1L << NUM) | (1L << CHAR_VAL) | (1L << FLOAT_VAL))) != 0)) {
				{
				{
				setState(360); val();
				}
				}
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ValContext extends ParserRuleContext {
		public TerminalNode FLOAT_VAL() { return getToken(SQLParser.FLOAT_VAL, 0); }
		public TerminalNode CHAR_VAL() { return getToken(SQLParser.CHAR_VAL, 0); }
		public TerminalNode DATE_VAL() { return getToken(SQLParser.DATE_VAL, 0); }
		public TerminalNode NUM() { return getToken(SQLParser.NUM, 0); }
		public ValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DATE_VAL) | (1L << NUM) | (1L << CHAR_VAL) | (1L << FLOAT_VAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class UpdateStmtContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ColumnsUpdateContext> columnsUpdate() {
			return getRuleContexts(ColumnsUpdateContext.class);
		}
		public TerminalNode UPDATE() { return getToken(SQLParser.UPDATE, 0); }
		public ColumnsUpdateContext columnsUpdate(int i) {
			return getRuleContext(ColumnsUpdateContext.class,i);
		}
		public UpdateStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterUpdateStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitUpdateStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitUpdateStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateStmtContext updateStmt() throws RecognitionException {
		UpdateStmtContext _localctx = new UpdateStmtContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_updateStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368); match(UPDATE);
			setState(369); table();
			setState(370); match(SET);
			setState(371); columnsUpdate();
			setState(372); match(T__2);
			setState(373); val();
			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(374); match(T__7);
				setState(375); columnsUpdate();
				setState(376); match(T__2);
				setState(377); val();
				}
				}
				setState(383);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(386);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(384); match(WHERE);
				setState(385); expression(0);
				}
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

	public static class ColumnsUpdateContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public ColumnsUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnsUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterColumnsUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitColumnsUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitColumnsUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnsUpdateContext columnsUpdate() throws RecognitionException {
		ColumnsUpdateContext _localctx = new ColumnsUpdateContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_columnsUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388); match(ID);
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

	public static class DeleteStmtContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DELETE() { return getToken(SQLParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public DeleteStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterDeleteStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitDeleteStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitDeleteStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeleteStmtContext deleteStmt() throws RecognitionException {
		DeleteStmtContext _localctx = new DeleteStmtContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_deleteStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390); match(DELETE);
			setState(391); match(FROM);
			setState(392); table();
			setState(395);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(393); match(WHERE);
				setState(394); expression(0);
				}
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

	public static class SelectStmtContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public SelectListContext selectList() {
			return getRuleContext(SelectListContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SELECT() { return getToken(SQLParser.SELECT, 0); }
		public OrderExprContext orderExpr() {
			return getRuleContext(OrderExprContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public SelectStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterSelectStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitSelectStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitSelectStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectStmtContext selectStmt() throws RecognitionException {
		SelectStmtContext _localctx = new SelectStmtContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_selectStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397); match(SELECT);
			setState(400);
			switch (_input.LA(1)) {
			case T__6:
				{
				setState(398); match(T__6);
				}
				break;
			case ID:
				{
				setState(399); selectList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(402); match(FROM);
			setState(403); table();
			setState(404); match(WHERE);
			setState(405); expression(0);
			setState(407);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(406); orderExpr();
				}
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

	public static class SelectListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SQLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SQLParser.ID, i);
		}
		public SelectListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterSelectList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitSelectList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitSelectList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectListContext selectList() throws RecognitionException {
		SelectListContext _localctx = new SelectListContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_selectList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409); match(ID);
			{
			setState(410); match(T__7);
			setState(411); match(ID);
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

	public static class OrderExprContext extends ParserRuleContext {
		public OrderExprContext orderExpr(int i) {
			return getRuleContext(OrderExprContext.class,i);
		}
		public TerminalNode ORDER() { return getToken(SQLParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public List<OrderExprContext> orderExpr() {
			return getRuleContexts(OrderExprContext.class);
		}
		public OrderExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterOrderExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitOrderExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitOrderExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderExprContext orderExpr() throws RecognitionException {
		OrderExprContext _localctx = new OrderExprContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_orderExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(413); match(ORDER);
			setState(414); match(BY);
			{
			setState(415); orderExpr();
			setState(420);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(416); match(T__7);
					setState(417); orderExpr();
					}
					} 
				}
				setState(422);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
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

	public static class OrderTermContext extends ParserRuleContext {
		public TerminalNode DESC() { return getToken(SQLParser.DESC, 0); }
		public TerminalNode ASC() { return getToken(SQLParser.ASC, 0); }
		public ColNameContext colName() {
			return getRuleContext(ColNameContext.class,0);
		}
		public OrderTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterOrderTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitOrderTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitOrderTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderTermContext orderTerm() throws RecognitionException {
		OrderTermContext _localctx = new OrderTermContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_orderTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423); colName();
			setState(425);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(424);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 28: return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 29: return andexpr_sempred((AndexprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean andexpr_sempred(AndexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3:\u01ae\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\5\2g\n\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3s\n\3\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0095\n\13\f\13\16"+
		"\13\u0098\13\13\3\13\3\13\7\13\u009c\n\13\f\13\16\13\u009f\13\13\5\13"+
		"\u00a1\n\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\6\20\u00b3\n\20\r\20\16\20\u00b4\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\6\20\u00be\n\20\r\20\16\20\u00bf\3\20\3\20\3\20\3\20\3\20"+
		"\6\20\u00c7\n\20\r\20\16\20\u00c8\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\5\20\u00d3\n\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\6\26\u00ed\n\26\r\26\16\26\u00ee\5\26\u00f1\n\26\5\26\u00f3\n\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\5\31\u0109\n\31\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\7\36\u011f\n\36\f\36\16\36\u0122\13\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\7\37\u012a\n\37\f\37\16\37\u012d\13\37\3 \3 \3 \5 \u0132\n \3!\3!\3!"+
		"\3!\3!\5!\u0139\n!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\5#\u0144\n#\3$\3$\3"+
		"$\3$\3$\5$\u014b\n$\3%\3%\3&\3&\3\'\3\'\3\'\3\'\5\'\u0155\n\'\3(\3(\3"+
		"(\3(\5(\u015b\n(\3(\3(\3)\3)\3)\3)\7)\u0163\n)\f)\16)\u0166\13)\3)\3)"+
		"\3*\3*\7*\u016c\n*\f*\16*\u016f\13*\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3"+
		",\3,\7,\u017e\n,\f,\16,\u0181\13,\3,\3,\5,\u0185\n,\3-\3-\3.\3.\3.\3."+
		"\3.\5.\u018e\n.\3/\3/\3/\5/\u0193\n/\3/\3/\3/\3/\3/\5/\u019a\n/\3\60\3"+
		"\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\7\61\u01a5\n\61\f\61\16\61\u01a8"+
		"\13\61\3\62\3\62\5\62\u01ac\n\62\3\62\2\4:<\63\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`b\2\6\3\2\27"+
		"\32\4\2\3\3\t\r\4\2\66\679:\3\2\64\65\u01aa\2f\3\2\2\2\4r\3\2\2\2\6t\3"+
		"\2\2\2\bx\3\2\2\2\n~\3\2\2\2\f\u0080\3\2\2\2\16\u0082\3\2\2\2\20\u0086"+
		"\3\2\2\2\22\u0089\3\2\2\2\24\u008d\3\2\2\2\26\u00a4\3\2\2\2\30\u00a6\3"+
		"\2\2\2\32\u00a9\3\2\2\2\34\u00ab\3\2\2\2\36\u00d2\3\2\2\2 \u00d4\3\2\2"+
		"\2\"\u00d6\3\2\2\2$\u00d8\3\2\2\2&\u00da\3\2\2\2(\u00dc\3\2\2\2*\u00f2"+
		"\3\2\2\2,\u00f4\3\2\2\2.\u00f6\3\2\2\2\60\u0108\3\2\2\2\62\u010a\3\2\2"+
		"\2\64\u010c\3\2\2\2\66\u0110\3\2\2\28\u0113\3\2\2\2:\u0118\3\2\2\2<\u0123"+
		"\3\2\2\2>\u0131\3\2\2\2@\u0138\3\2\2\2B\u013a\3\2\2\2D\u0143\3\2\2\2F"+
		"\u014a\3\2\2\2H\u014c\3\2\2\2J\u014e\3\2\2\2L\u0154\3\2\2\2N\u0156\3\2"+
		"\2\2P\u015e\3\2\2\2R\u0169\3\2\2\2T\u0170\3\2\2\2V\u0172\3\2\2\2X\u0186"+
		"\3\2\2\2Z\u0188\3\2\2\2\\\u018f\3\2\2\2^\u019b\3\2\2\2`\u019f\3\2\2\2"+
		"b\u01a9\3\2\2\2dg\5\4\3\2eg\5L\'\2fd\3\2\2\2fe\3\2\2\2g\3\3\2\2\2hs\5"+
		"\6\4\2is\5\b\5\2js\5\16\b\2ks\5\20\t\2ls\5\22\n\2ms\5\24\13\2ns\5*\26"+
		"\2os\5\64\33\2ps\5\66\34\2qs\58\35\2rh\3\2\2\2ri\3\2\2\2rj\3\2\2\2rk\3"+
		"\2\2\2rl\3\2\2\2rm\3\2\2\2rn\3\2\2\2ro\3\2\2\2rp\3\2\2\2rq\3\2\2\2s\5"+
		"\3\2\2\2tu\7\16\2\2uv\7\17\2\2vw\78\2\2w\7\3\2\2\2xy\7\21\2\2yz\7\17\2"+
		"\2z{\5\n\6\2{|\7\22\2\2|}\5\f\7\2}\t\3\2\2\2~\177\78\2\2\177\13\3\2\2"+
		"\2\u0080\u0081\78\2\2\u0081\r\3\2\2\2\u0082\u0083\7\23\2\2\u0083\u0084"+
		"\7\17\2\2\u0084\u0085\78\2\2\u0085\17\3\2\2\2\u0086\u0087\7\24\2\2\u0087"+
		"\u0088\7\20\2\2\u0088\21\3\2\2\2\u0089\u008a\7\25\2\2\u008a\u008b\7\17"+
		"\2\2\u008b\u008c\78\2\2\u008c\23\3\2\2\2\u008d\u008e\7\16\2\2\u008e\u008f"+
		"\7\26\2\2\u008f\u0090\5\26\f\2\u0090\u0091\7\b\2\2\u0091\u0096\5\30\r"+
		"\2\u0092\u0093\7\6\2\2\u0093\u0095\5\30\r\2\u0094\u0092\3\2\2\2\u0095"+
		"\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u00a0\3\2"+
		"\2\2\u0098\u0096\3\2\2\2\u0099\u009d\7\33\2\2\u009a\u009c\5\36\20\2\u009b"+
		"\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2"+
		"\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u0099\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\7\4\2\2\u00a3\25\3\2\2"+
		"\2\u00a4\u00a5\78\2\2\u00a5\27\3\2\2\2\u00a6\u00a7\5\34\17\2\u00a7\u00a8"+
		"\5\32\16\2\u00a8\31\3\2\2\2\u00a9\u00aa\t\2\2\2\u00aa\33\3\2\2\2\u00ab"+
		"\u00ac\78\2\2\u00ac\35\3\2\2\2\u00ad\u00ae\5&\24\2\u00ae\u00af\7\34\2"+
		"\2\u00af\u00b0\7\35\2\2\u00b0\u00b2\7\b\2\2\u00b1\u00b3\78\2\2\u00b2\u00b1"+
		"\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00b7\7\4\2\2\u00b7\u00d3\3\2\2\2\u00b8\u00b9\5$"+
		"\23\2\u00b9\u00ba\7\36\2\2\u00ba\u00bb\7\35\2\2\u00bb\u00bd\7\b\2\2\u00bc"+
		"\u00be\78\2\2\u00bd\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\7\4\2\2\u00c2"+
		"\u00c3\7 \2\2\u00c3\u00c4\5\"\22\2\u00c4\u00c6\7\b\2\2\u00c5\u00c7\78"+
		"\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\7\4\2\2\u00cb\u00d3\3\2"+
		"\2\2\u00cc\u00cd\5 \21\2\u00cd\u00ce\7\37\2\2\u00ce\u00cf\7\b\2\2\u00cf"+
		"\u00d0\5(\25\2\u00d0\u00d1\7\4\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00ad\3\2"+
		"\2\2\u00d2\u00b8\3\2\2\2\u00d2\u00cc\3\2\2\2\u00d3\37\3\2\2\2\u00d4\u00d5"+
		"\78\2\2\u00d5!\3\2\2\2\u00d6\u00d7\78\2\2\u00d7#\3\2\2\2\u00d8\u00d9\7"+
		"8\2\2\u00d9%\3\2\2\2\u00da\u00db\78\2\2\u00db\'\3\2\2\2\u00dc\u00dd\3"+
		"\2\2\2\u00dd)\3\2\2\2\u00de\u00df\7\21\2\2\u00df\u00e0\7\26\2\2\u00e0"+
		"\u00e1\5,\27\2\u00e1\u00e2\7&\2\2\u00e2\u00e3\7\'\2\2\u00e3\u00e4\5.\30"+
		"\2\u00e4\u00f3\3\2\2\2\u00e5\u00e6\7\21\2\2\u00e6\u00e7\7\26\2\2\u00e7"+
		"\u00f0\78\2\2\u00e8\u00f1\5\60\31\2\u00e9\u00ec\5\60\31\2\u00ea\u00eb"+
		"\7\6\2\2\u00eb\u00ed\5\60\31\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee\3\2\2\2"+
		"\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00e8"+
		"\3\2\2\2\u00f0\u00e9\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00de\3\2\2\2\u00f2"+
		"\u00e5\3\2\2\2\u00f3+\3\2\2\2\u00f4\u00f5\78\2\2\u00f5-\3\2\2\2\u00f6"+
		"\u00f7\78\2\2\u00f7/\3\2\2\2\u00f8\u00f9\7$\2\2\u00f9\u00fa\7%\2\2\u00fa"+
		"\u00fb\5\62\32\2\u00fb\u00fc\5\32\16\2\u00fc\u00fd\7\33\2\2\u00fd\u00fe"+
		"\5\36\20\2\u00fe\u0109\3\2\2\2\u00ff\u0100\7$\2\2\u0100\u0101\7\33\2\2"+
		"\u0101\u0109\5\36\20\2\u0102\u0103\7\23\2\2\u0103\u0104\7%\2\2\u0104\u0109"+
		"\5\62\32\2\u0105\u0106\7\23\2\2\u0106\u0107\7\33\2\2\u0107\u0109\78\2"+
		"\2\u0108\u00f8\3\2\2\2\u0108\u00ff\3\2\2\2\u0108\u0102\3\2\2\2\u0108\u0105"+
		"\3\2\2\2\u0109\61\3\2\2\2\u010a\u010b\78\2\2\u010b\63\3\2\2\2\u010c\u010d"+
		"\7\23\2\2\u010d\u010e\7\26\2\2\u010e\u010f\78\2\2\u010f\65\3\2\2\2\u0110"+
		"\u0111\7\24\2\2\u0111\u0112\7!\2\2\u0112\67\3\2\2\2\u0113\u0114\7\24\2"+
		"\2\u0114\u0115\7\"\2\2\u0115\u0116\7#\2\2\u0116\u0117\78\2\2\u01179\3"+
		"\2\2\2\u0118\u0119\b\36\1\2\u0119\u011a\5<\37\2\u011a\u0120\3\2\2\2\u011b"+
		"\u011c\f\3\2\2\u011c\u011d\7)\2\2\u011d\u011f\5<\37\2\u011e\u011b\3\2"+
		"\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121"+
		";\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0124\b\37\1\2\u0124\u0125\5> \2\u0125"+
		"\u012b\3\2\2\2\u0126\u0127\f\3\2\2\u0127\u0128\7(\2\2\u0128\u012a\5> "+
		"\2\u0129\u0126\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c"+
		"\3\2\2\2\u012c=\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u0132\5@!\2\u012f\u0130"+
		"\7*\2\2\u0130\u0132\5@!\2\u0131\u012e\3\2\2\2\u0131\u012f\3\2\2\2\u0132"+
		"?\3\2\2\2\u0133\u0139\5B\"\2\u0134\u0135\7\b\2\2\u0135\u0136\5:\36\2\u0136"+
		"\u0137\7\4\2\2\u0137\u0139\3\2\2\2\u0138\u0133\3\2\2\2\u0138\u0134\3\2"+
		"\2\2\u0139A\3\2\2\2\u013a\u013b\5D#\2\u013b\u013c\5J&\2\u013c\u013d\5"+
		"D#\2\u013dC\3\2\2\2\u013e\u0144\5F$\2\u013f\u0144\7\67\2\2\u0140\u0144"+
		"\7:\2\2\u0141\u0144\7\66\2\2\u0142\u0144\79\2\2\u0143\u013e\3\2\2\2\u0143"+
		"\u013f\3\2\2\2\u0143\u0140\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0142\3\2"+
		"\2\2\u0144E\3\2\2\2\u0145\u014b\78\2\2\u0146\u0147\5H%\2\u0147\u0148\7"+
		"\5\2\2\u0148\u0149\78\2\2\u0149\u014b\3\2\2\2\u014a\u0145\3\2\2\2\u014a"+
		"\u0146\3\2\2\2\u014bG\3\2\2\2\u014c\u014d\78\2\2\u014dI\3\2\2\2\u014e"+
		"\u014f\t\3\2\2\u014fK\3\2\2\2\u0150\u0155\5N(\2\u0151\u0155\5V,\2\u0152"+
		"\u0155\5Z.\2\u0153\u0155\5\\/\2\u0154\u0150\3\2\2\2\u0154\u0151\3\2\2"+
		"\2\u0154\u0152\3\2\2\2\u0154\u0153\3\2\2\2\u0155M\3\2\2\2\u0156\u0157"+
		"\7+\2\2\u0157\u0158\7,\2\2\u0158\u015a\5H%\2\u0159\u015b\5P)\2\u015a\u0159"+
		"\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015d\5R*\2\u015d"+
		"O\3\2\2\2\u015e\u015f\7\b\2\2\u015f\u0164\78\2\2\u0160\u0161\7\6\2\2\u0161"+
		"\u0163\78\2\2\u0162\u0160\3\2\2\2\u0163\u0166\3\2\2\2\u0164\u0162\3\2"+
		"\2\2\u0164\u0165\3\2\2\2\u0165\u0167\3\2\2\2\u0166\u0164\3\2\2\2\u0167"+
		"\u0168\7\4\2\2\u0168Q\3\2\2\2\u0169\u016d\5T+\2\u016a\u016c\5T+\2\u016b"+
		"\u016a\3\2\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2"+
		"\2\2\u016eS\3\2\2\2\u016f\u016d\3\2\2\2\u0170\u0171\t\4\2\2\u0171U\3\2"+
		"\2\2\u0172\u0173\7.\2\2\u0173\u0174\5H%\2\u0174\u0175\7/\2\2\u0175\u0176"+
		"\5X-\2\u0176\u0177\7\13\2\2\u0177\u017f\5T+\2\u0178\u0179\7\6\2\2\u0179"+
		"\u017a\5X-\2\u017a\u017b\7\13\2\2\u017b\u017c\5T+\2\u017c\u017e\3\2\2"+
		"\2\u017d\u0178\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u0180"+
		"\3\2\2\2\u0180\u0184\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0183\7-\2\2\u0183"+
		"\u0185\5:\36\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185W\3\2\2\2"+
		"\u0186\u0187\78\2\2\u0187Y\3\2\2\2\u0188\u0189\7\60\2\2\u0189\u018a\7"+
		"#\2\2\u018a\u018d\5H%\2\u018b\u018c\7-\2\2\u018c\u018e\5:\36\2\u018d\u018b"+
		"\3\2\2\2\u018d\u018e\3\2\2\2\u018e[\3\2\2\2\u018f\u0192\7\61\2\2\u0190"+
		"\u0193\7\7\2\2\u0191\u0193\5^\60\2\u0192\u0190\3\2\2\2\u0192\u0191\3\2"+
		"\2\2\u0193\u0194\3\2\2\2\u0194\u0195\7#\2\2\u0195\u0196\5H%\2\u0196\u0197"+
		"\7-\2\2\u0197\u0199\5:\36\2\u0198\u019a\5`\61\2\u0199\u0198\3\2\2\2\u0199"+
		"\u019a\3\2\2\2\u019a]\3\2\2\2\u019b\u019c\78\2\2\u019c\u019d\7\6\2\2\u019d"+
		"\u019e\78\2\2\u019e_\3\2\2\2\u019f\u01a0\7\62\2\2\u01a0\u01a1\7\63\2\2"+
		"\u01a1\u01a6\5`\61\2\u01a2\u01a3\7\6\2\2\u01a3\u01a5\5`\61\2\u01a4\u01a2"+
		"\3\2\2\2\u01a5\u01a8\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7"+
		"a\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a9\u01ab\5\34\17\2\u01aa\u01ac\t\5\2"+
		"\2\u01ab\u01aa\3\2\2\2\u01ab\u01ac\3\2\2\2\u01acc\3\2\2\2 fr\u0096\u009d"+
		"\u00a0\u00b4\u00bf\u00c8\u00d2\u00ee\u00f0\u00f2\u0108\u0120\u012b\u0131"+
		"\u0138\u0143\u014a\u0154\u015a\u0164\u016d\u017f\u0184\u018d\u0192\u0199"+
		"\u01a6\u01ab";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}