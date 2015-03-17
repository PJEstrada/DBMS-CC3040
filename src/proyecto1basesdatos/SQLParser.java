// Generated from SQL.g4 by ANTLR 4.4
package proyecto1basesdatos;
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
		TABLES=31, COLUMNS=32, FROM=33, ADD=34, COLUMN=35, AND=36, OR=37, NOT=38, 
		INSERT=39, INTO=40, WHERE=41, UPDATE=42, SET=43, DELETE=44, SELECT=45, 
		ORDER=46, BY=47, ASC=48, DESC=49, WS=50, DATE_VAL=51, NUM=52, ID=53, CHAR_VAL=54, 
		FLOAT_VAL=55;
	public static final String[] tokenNames = {
		"<INVALID>", "'<='", "'<>'", "'('", "')'", "'*'", "'>='", "'<'", "','", 
		"'='", "'>'", "'.'", "'CREATE'", "'DATABASE'", "'DATABASES'", "'ALTER'", 
		"'RENAME TO'", "'DROP'", "'SHOW'", "'USE'", "'TABLE'", "'INT'", "'FLOAT'", 
		"'DATE'", "'CHAR'", "'CONSTRAINT'", "'PRIMARY'", "'KEY'", "'FOREIGN'", 
		"'CHECK'", "'REFERENCES'", "'TABLES'", "COLUMNS", "'FROM'", "'ADD'", "COLUMN", 
		"'AND'", "'OR'", "'NOT'", "'INSERT'", "'INTO'", "'WHERE'", "'UPDATE'", 
		"'SET'", "'DELETE'", "'SELECT'", "'ORDER'", "'BY'", "'ASC'", "'DESC'", 
		"WS", "DATE_VAL", "NUM", "ID", "CHAR_VAL", "FLOAT_VAL"
	};
	public static final int
		RULE_query = 0, RULE_ddlQuery = 1, RULE_createDbStmt = 2, RULE_alterDbStmt = 3, 
		RULE_dbName = 4, RULE_newDbName = 5, RULE_dropDbStmt = 6, RULE_showDbStmt = 7, 
		RULE_useDbStmt = 8, RULE_createTableStmt = 9, RULE_tableName = 10, RULE_columnDecl = 11, 
		RULE_tipo = 12, RULE_colName = 13, RULE_colConstraint = 14, RULE_localids = 15, 
		RULE_refids = 16, RULE_chNombre = 17, RULE_idTabla = 18, RULE_fkNombre = 19, 
		RULE_pkNombre = 20, RULE_alterTableStmt = 21, RULE_alterName = 22, RULE_newName = 23, 
		RULE_accion = 24, RULE_columnName = 25, RULE_dropTableStmt = 26, RULE_showTableStmt = 27, 
		RULE_showColumnsStmt = 28, RULE_expression = 29, RULE_andexpr = 30, RULE_factor = 31, 
		RULE_primary = 32, RULE_compareExpr = 33, RULE_term = 34, RULE_column = 35, 
		RULE_table = 36, RULE_rel_op = 37, RULE_dmlQuery = 38, RULE_insertStmt = 39, 
		RULE_columnList = 40, RULE_valueList = 41, RULE_val = 42, RULE_updateStmt = 43, 
		RULE_columnsUpdate = 44, RULE_deleteStmt = 45, RULE_selectStmt = 46, RULE_selectList = 47, 
		RULE_orderExpr = 48, RULE_orderTerm = 49;
	public static final String[] ruleNames = {
		"query", "ddlQuery", "createDbStmt", "alterDbStmt", "dbName", "newDbName", 
		"dropDbStmt", "showDbStmt", "useDbStmt", "createTableStmt", "tableName", 
		"columnDecl", "tipo", "colName", "colConstraint", "localids", "refids", 
		"chNombre", "idTabla", "fkNombre", "pkNombre", "alterTableStmt", "alterName", 
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
			setState(102);
			switch (_input.LA(1)) {
			case CREATE:
			case ALTER:
			case DROP:
			case SHOW:
			case USE:
				enterOuterAlt(_localctx, 1);
				{
				setState(100); ddlQuery();
				}
				break;
			case INSERT:
			case UPDATE:
			case DELETE:
			case SELECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(101); dmlQuery();
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
		public ShowColumnsStmtContext showColumnsStmt() {
			return getRuleContext(ShowColumnsStmtContext.class,0);
		}
		public ShowTableStmtContext showTableStmt() {
			return getRuleContext(ShowTableStmtContext.class,0);
		}
		public DropDbStmtContext dropDbStmt() {
			return getRuleContext(DropDbStmtContext.class,0);
		}
		public DropTableStmtContext dropTableStmt() {
			return getRuleContext(DropTableStmtContext.class,0);
		}
		public AlterDbStmtContext alterDbStmt() {
			return getRuleContext(AlterDbStmtContext.class,0);
		}
		public ShowDbStmtContext showDbStmt() {
			return getRuleContext(ShowDbStmtContext.class,0);
		}
		public CreateTableStmtContext createTableStmt() {
			return getRuleContext(CreateTableStmtContext.class,0);
		}
		public CreateDbStmtContext createDbStmt() {
			return getRuleContext(CreateDbStmtContext.class,0);
		}
		public UseDbStmtContext useDbStmt() {
			return getRuleContext(UseDbStmtContext.class,0);
		}
		public AlterTableStmtContext alterTableStmt() {
			return getRuleContext(AlterTableStmtContext.class,0);
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
			setState(114);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104); createDbStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105); alterDbStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(106); dropDbStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(107); showDbStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(108); useDbStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(109); createTableStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(110); alterTableStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(111); dropTableStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(112); showTableStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(113); showColumnsStmt();
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
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
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
			setState(116); match(CREATE);
			setState(117); match(DATABASE);
			setState(118); match(ID);
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
		public NewDbNameContext newDbName() {
			return getRuleContext(NewDbNameContext.class,0);
		}
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public DbNameContext dbName() {
			return getRuleContext(DbNameContext.class,0);
		}
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
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
			setState(120); match(ALTER);
			setState(121); match(DATABASE);
			setState(122); dbName();
			setState(123); match(RENAMETO);
			setState(124); newDbName();
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
			setState(128); match(ID);
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
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
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
			setState(130); match(DROP);
			setState(131); match(DATABASE);
			setState(132); match(ID);
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
		public TerminalNode SHOW() { return getToken(SQLParser.SHOW, 0); }
		public TerminalNode DATABASES() { return getToken(SQLParser.DATABASES, 0); }
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
			setState(134); match(SHOW);
			setState(135); match(DATABASES);
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
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public TerminalNode USE() { return getToken(SQLParser.USE, 0); }
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
			setState(137); match(USE);
			setState(138); match(DATABASE);
			setState(139); match(ID);
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
		public ColumnDeclContext columnDecl(int i) {
			return getRuleContext(ColumnDeclContext.class,i);
		}
		public List<ColumnDeclContext> columnDecl() {
			return getRuleContexts(ColumnDeclContext.class);
		}
		public List<ColConstraintContext> colConstraint() {
			return getRuleContexts(ColConstraintContext.class);
		}
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ColConstraintContext colConstraint(int i) {
			return getRuleContext(ColConstraintContext.class,i);
		}
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(141); match(CREATE);
			setState(142); match(TABLE);
			setState(143); tableName();
			setState(144); match(T__8);
			{
			setState(145); columnDecl();
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(146); match(T__3);
					setState(147); columnDecl();
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
			setState(160);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(153); match(T__3);
					setState(154); colConstraint();
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(162); match(T__7);
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
			setState(164); match(ID);
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
			setState(166); colName();
			setState(167); tipo();
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
		public TerminalNode NUM() { return getToken(SQLParser.NUM, 0); }
		public TerminalNode DATE() { return getToken(SQLParser.DATE, 0); }
		public TerminalNode CHAR() { return getToken(SQLParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(SQLParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(SQLParser.FLOAT, 0); }
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
		try {
			setState(176);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(169); match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(170); match(FLOAT);
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(171); match(DATE);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(172); match(CHAR);
				setState(173); match(T__8);
				setState(174); match(NUM);
				setState(175); match(T__7);
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
			setState(178); match(ID);
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
		public TerminalNode PRIMARY() { return getToken(SQLParser.PRIMARY, 0); }
		public TerminalNode CHECK() { return getToken(SQLParser.CHECK, 0); }
		public RefidsContext refids(int i) {
			return getRuleContext(RefidsContext.class,i);
		}
		public ChNombreContext chNombre() {
			return getRuleContext(ChNombreContext.class,0);
		}
		public IdTablaContext idTabla() {
			return getRuleContext(IdTablaContext.class,0);
		}
		public List<LocalidsContext> localids() {
			return getRuleContexts(LocalidsContext.class);
		}
		public LocalidsContext localids(int i) {
			return getRuleContext(LocalidsContext.class,i);
		}
		public List<RefidsContext> refids() {
			return getRuleContexts(RefidsContext.class);
		}
		public TerminalNode KEY() { return getToken(SQLParser.KEY, 0); }
		public FkNombreContext fkNombre() {
			return getRuleContext(FkNombreContext.class,0);
		}
		public PkNombreContext pkNombre() {
			return getRuleContext(PkNombreContext.class,0);
		}
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public TerminalNode REFERENCES() { return getToken(SQLParser.REFERENCES, 0); }
		public TerminalNode FOREIGN() { return getToken(SQLParser.FOREIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(180); match(CONSTRAINT);
			setState(227);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(181); pkNombre();
				setState(182); match(PRIMARY);
				setState(183); match(KEY);
				setState(184); match(T__8);
				{
				setState(185); localids();
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(186); match(T__3);
					setState(187); localids();
					}
					}
					setState(192);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(193); match(T__7);
				}
				break;
			case 2:
				{
				setState(195); fkNombre();
				setState(196); match(FOREIGN);
				setState(197); match(KEY);
				setState(198); match(T__8);
				{
				setState(199); localids();
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(200); match(T__3);
					setState(201); localids();
					}
					}
					setState(206);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(207); match(T__7);
				setState(208); match(REFERENCES);
				setState(209); idTabla();
				setState(210); match(T__8);
				{
				setState(211); refids();
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(212); match(T__3);
					setState(213); refids();
					}
					}
					setState(218);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(219); match(T__7);
				}
				break;
			case 3:
				{
				setState(221); chNombre();
				setState(222); match(CHECK);
				setState(223); match(T__8);
				setState(224); expression(0);
				setState(225); match(T__7);
				}
				break;
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

	public static class LocalidsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public LocalidsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localids; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterLocalids(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitLocalids(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitLocalids(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalidsContext localids() throws RecognitionException {
		LocalidsContext _localctx = new LocalidsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_localids);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229); match(ID);
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

	public static class RefidsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public RefidsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refids; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterRefids(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitRefids(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLVisitor ) return ((SQLVisitor<? extends T>)visitor).visitRefids(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefidsContext refids() throws RecognitionException {
		RefidsContext _localctx = new RefidsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_refids);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231); match(ID);
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
		enterRule(_localctx, 34, RULE_chNombre);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233); match(ID);
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
		enterRule(_localctx, 36, RULE_idTabla);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235); match(ID);
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
		enterRule(_localctx, 38, RULE_fkNombre);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); match(ID);
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
		enterRule(_localctx, 40, RULE_pkNombre);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239); match(ID);
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
		public TerminalNode RENAMETO() { return getToken(SQLParser.RENAMETO, 0); }
		public NewNameContext newName() {
			return getRuleContext(NewNameContext.class,0);
		}
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public AlterNameContext alterName() {
			return getRuleContext(AlterNameContext.class,0);
		}
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
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
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public List<AccionContext> accion() {
			return getRuleContexts(AccionContext.class);
		}
		public AccionContext accion(int i) {
			return getRuleContext(AccionContext.class,i);
		}
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
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
		enterRule(_localctx, 42, RULE_alterTableStmt);
		int _la;
		try {
			setState(260);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new RenameAlterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(241); match(ALTER);
				setState(242); match(TABLE);
				setState(243); alterName();
				setState(244); match(RENAMETO);
				setState(245); newName();
				}
				break;
			case 2:
				_localctx = new AccionAlterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(247); match(ALTER);
				setState(248); match(TABLE);
				setState(249); match(ID);
				setState(258);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(250); accion();
					}
					break;
				case 2:
					{
					setState(251); accion();
					setState(254); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(252); match(T__3);
						setState(253); accion();
						}
						}
						setState(256); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==T__3 );
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
		enterRule(_localctx, 44, RULE_alterName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262); match(ID);
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
		enterRule(_localctx, 46, RULE_newName);
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

	public static class AccionContext extends ParserRuleContext {
		public ColConstraintContext colConstraint() {
			return getRuleContext(ColConstraintContext.class,0);
		}
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ADD() { return getToken(SQLParser.ADD, 0); }
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
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
		enterRule(_localctx, 48, RULE_accion);
		try {
			setState(282);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(266); match(ADD);
				setState(267); match(COLUMN);
				setState(268); columnName();
				setState(269); tipo();
				setState(270); match(CONSTRAINT);
				setState(271); colConstraint();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(273); match(ADD);
				setState(274); match(CONSTRAINT);
				setState(275); colConstraint();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(276); match(DROP);
				setState(277); match(COLUMN);
				setState(278); columnName();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(279); match(DROP);
				setState(280); match(CONSTRAINT);
				setState(281); match(ID);
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
		enterRule(_localctx, 50, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284); match(ID);
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
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
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
		enterRule(_localctx, 52, RULE_dropTableStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286); match(DROP);
			setState(287); match(TABLE);
			setState(288); match(ID);
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
		public TerminalNode SHOW() { return getToken(SQLParser.SHOW, 0); }
		public TerminalNode TABLES() { return getToken(SQLParser.TABLES, 0); }
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
		enterRule(_localctx, 54, RULE_showTableStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290); match(SHOW);
			setState(291); match(TABLES);
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
		public TerminalNode SHOW() { return getToken(SQLParser.SHOW, 0); }
		public TerminalNode ID() { return getToken(SQLParser.ID, 0); }
		public TerminalNode COLUMNS() { return getToken(SQLParser.COLUMNS, 0); }
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
		enterRule(_localctx, 56, RULE_showColumnsStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293); match(SHOW);
			setState(294); match(COLUMNS);
			setState(295); match(FROM);
			setState(296); match(ID);
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
		public TerminalNode OR() { return getToken(SQLParser.OR, 0); }
		public AndexprContext andexpr() {
			return getRuleContext(AndexprContext.class,0);
		}
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
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(299); andexpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(306);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(301);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(302); match(OR);
					setState(303); andexpr(0);
					}
					} 
				}
				setState(308);
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

	public static class AndexprContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode AND() { return getToken(SQLParser.AND, 0); }
		public AndexprContext andexpr() {
			return getRuleContext(AndexprContext.class,0);
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
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_andexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(310); factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(317);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndexprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andexpr);
					setState(312);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(313); match(AND);
					setState(314); factor();
					}
					} 
				}
				setState(319);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
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
		enterRule(_localctx, 62, RULE_factor);
		try {
			setState(323);
			switch (_input.LA(1)) {
			case T__8:
			case DATE_VAL:
			case NUM:
			case ID:
			case CHAR_VAL:
			case FLOAT_VAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(320); primary();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(321); match(NOT);
				setState(322); primary();
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
		public CompareExprContext compareExpr() {
			return getRuleContext(CompareExprContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 64, RULE_primary);
		try {
			setState(330);
			switch (_input.LA(1)) {
			case DATE_VAL:
			case NUM:
			case ID:
			case CHAR_VAL:
			case FLOAT_VAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(325); compareExpr();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(326); match(T__8);
				setState(327); expression(0);
				setState(328); match(T__7);
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
		public Rel_opContext rel_op() {
			return getRuleContext(Rel_opContext.class,0);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
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
		enterRule(_localctx, 66, RULE_compareExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332); term();
			setState(333); rel_op();
			setState(334); term();
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
		public TerminalNode DATE_VAL() { return getToken(SQLParser.DATE_VAL, 0); }
		public TerminalNode CHAR_VAL() { return getToken(SQLParser.CHAR_VAL, 0); }
		public ColumnContext column() {
			return getRuleContext(ColumnContext.class,0);
		}
		public TerminalNode NUM() { return getToken(SQLParser.NUM, 0); }
		public TerminalNode FLOAT_VAL() { return getToken(SQLParser.FLOAT_VAL, 0); }
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
		enterRule(_localctx, 68, RULE_term);
		try {
			setState(341);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(336); column();
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(337); match(NUM);
				}
				break;
			case FLOAT_VAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(338); match(FLOAT_VAL);
				}
				break;
			case DATE_VAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(339); match(DATE_VAL);
				}
				break;
			case CHAR_VAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(340); match(CHAR_VAL);
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
		enterRule(_localctx, 70, RULE_column);
		try {
			setState(348);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(343); match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(344); table();
				setState(345); match(T__0);
				setState(346); match(ID);
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
		enterRule(_localctx, 72, RULE_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350); match(ID);
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
		enterRule(_localctx, 74, RULE_rel_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__9) | (1L << T__5) | (1L << T__4) | (1L << T__2) | (1L << T__1))) != 0)) ) {
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
		public DeleteStmtContext deleteStmt() {
			return getRuleContext(DeleteStmtContext.class,0);
		}
		public InsertStmtContext insertStmt() {
			return getRuleContext(InsertStmtContext.class,0);
		}
		public SelectStmtContext selectStmt() {
			return getRuleContext(SelectStmtContext.class,0);
		}
		public UpdateStmtContext updateStmt() {
			return getRuleContext(UpdateStmtContext.class,0);
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
		enterRule(_localctx, 76, RULE_dmlQuery);
		try {
			setState(358);
			switch (_input.LA(1)) {
			case INSERT:
				enterOuterAlt(_localctx, 1);
				{
				setState(354); insertStmt();
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(355); updateStmt();
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 3);
				{
				setState(356); deleteStmt();
				}
				break;
			case SELECT:
				enterOuterAlt(_localctx, 4);
				{
				setState(357); selectStmt();
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
		public ValueListContext valueList() {
			return getRuleContext(ValueListContext.class,0);
		}
		public ColumnListContext columnList() {
			return getRuleContext(ColumnListContext.class,0);
		}
		public TerminalNode INSERT() { return getToken(SQLParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(SQLParser.INTO, 0); }
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
		enterRule(_localctx, 78, RULE_insertStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360); match(INSERT);
			setState(361); match(INTO);
			setState(362); table();
			setState(364);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(363); columnList();
				}
			}

			setState(366); valueList();
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
		enterRule(_localctx, 80, RULE_columnList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368); match(T__8);
			setState(369); match(ID);
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(370); match(T__3);
				setState(371); match(ID);
				}
				}
				setState(376);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(377); match(T__7);
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
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
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
		enterRule(_localctx, 82, RULE_valueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379); val();
			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DATE_VAL) | (1L << NUM) | (1L << CHAR_VAL) | (1L << FLOAT_VAL))) != 0)) {
				{
				{
				setState(380); val();
				}
				}
				setState(385);
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
		public TerminalNode DATE_VAL() { return getToken(SQLParser.DATE_VAL, 0); }
		public TerminalNode CHAR_VAL() { return getToken(SQLParser.CHAR_VAL, 0); }
		public TerminalNode NUM() { return getToken(SQLParser.NUM, 0); }
		public TerminalNode FLOAT_VAL() { return getToken(SQLParser.FLOAT_VAL, 0); }
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
		enterRule(_localctx, 84, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
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
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public ColumnsUpdateContext columnsUpdate(int i) {
			return getRuleContext(ColumnsUpdateContext.class,i);
		}
		public List<ColumnsUpdateContext> columnsUpdate() {
			return getRuleContexts(ColumnsUpdateContext.class);
		}
		public TerminalNode UPDATE() { return getToken(SQLParser.UPDATE, 0); }
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
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
		enterRule(_localctx, 86, RULE_updateStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388); match(UPDATE);
			setState(389); table();
			setState(390); match(SET);
			setState(391); columnsUpdate();
			setState(392); match(T__2);
			setState(393); val();
			setState(401);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(394); match(T__3);
				setState(395); columnsUpdate();
				setState(396); match(T__2);
				setState(397); val();
				}
				}
				setState(403);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(406);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(404); match(WHERE);
				setState(405); expression(0);
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
		enterRule(_localctx, 88, RULE_columnsUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408); match(ID);
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
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public TerminalNode DELETE() { return getToken(SQLParser.DELETE, 0); }
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		enterRule(_localctx, 90, RULE_deleteStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410); match(DELETE);
			setState(411); match(FROM);
			setState(412); table();
			setState(415);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(413); match(WHERE);
				setState(414); expression(0);
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
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public OrderExprContext orderExpr() {
			return getRuleContext(OrderExprContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public TerminalNode SELECT() { return getToken(SQLParser.SELECT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SelectListContext selectList() {
			return getRuleContext(SelectListContext.class,0);
		}
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
		enterRule(_localctx, 92, RULE_selectStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417); match(SELECT);
			setState(420);
			switch (_input.LA(1)) {
			case T__6:
				{
				setState(418); match(T__6);
				}
				break;
			case ID:
				{
				setState(419); selectList();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(422); match(FROM);
			setState(423); table();
			setState(424); match(WHERE);
			setState(425); expression(0);
			setState(427);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(426); orderExpr();
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
		enterRule(_localctx, 94, RULE_selectList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429); match(ID);
			{
			setState(430); match(T__3);
			setState(431); match(ID);
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
		public TerminalNode ORDER() { return getToken(SQLParser.ORDER, 0); }
		public List<OrderExprContext> orderExpr() {
			return getRuleContexts(OrderExprContext.class);
		}
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public OrderExprContext orderExpr(int i) {
			return getRuleContext(OrderExprContext.class,i);
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
		enterRule(_localctx, 96, RULE_orderExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(433); match(ORDER);
			setState(434); match(BY);
			{
			setState(435); orderExpr();
			setState(440);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(436); match(T__3);
					setState(437); orderExpr();
					}
					} 
				}
				setState(442);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		public TerminalNode ASC() { return getToken(SQLParser.ASC, 0); }
		public ColNameContext colName() {
			return getRuleContext(ColNameContext.class,0);
		}
		public TerminalNode DESC() { return getToken(SQLParser.DESC, 0); }
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
		enterRule(_localctx, 98, RULE_orderTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443); colName();
			setState(445);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(444);
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
		case 29: return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 30: return andexpr_sempred((AndexprContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\39\u01c2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2\3\2"+
		"\5\2i\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3u\n\3\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0097\n\13"+
		"\f\13\16\13\u009a\13\13\3\13\3\13\7\13\u009e\n\13\f\13\16\13\u00a1\13"+
		"\13\5\13\u00a3\n\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u00b3\n\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\7\20\u00bf\n\20\f\20\16\20\u00c2\13\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\7\20\u00cd\n\20\f\20\16\20\u00d0\13\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00d9\n\20\f\20\16\20\u00dc\13\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00e6\n\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\6\27\u0101\n\27\r\27\16\27\u0102"+
		"\5\27\u0105\n\27\5\27\u0107\n\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u011d"+
		"\n\32\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0133\n\37\f\37\16\37\u0136\13"+
		"\37\3 \3 \3 \3 \3 \3 \7 \u013e\n \f \16 \u0141\13 \3!\3!\3!\5!\u0146\n"+
		"!\3\"\3\"\3\"\3\"\3\"\5\"\u014d\n\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\5$\u0158"+
		"\n$\3%\3%\3%\3%\3%\5%\u015f\n%\3&\3&\3\'\3\'\3(\3(\3(\3(\5(\u0169\n(\3"+
		")\3)\3)\3)\5)\u016f\n)\3)\3)\3*\3*\3*\3*\7*\u0177\n*\f*\16*\u017a\13*"+
		"\3*\3*\3+\3+\7+\u0180\n+\f+\16+\u0183\13+\3,\3,\3-\3-\3-\3-\3-\3-\3-\3"+
		"-\3-\3-\3-\7-\u0192\n-\f-\16-\u0195\13-\3-\3-\5-\u0199\n-\3.\3.\3/\3/"+
		"\3/\3/\3/\5/\u01a2\n/\3\60\3\60\3\60\5\60\u01a7\n\60\3\60\3\60\3\60\3"+
		"\60\3\60\5\60\u01ae\n\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62"+
		"\7\62\u01b9\n\62\f\62\16\62\u01bc\13\62\3\63\3\63\5\63\u01c0\n\63\3\63"+
		"\2\4<>\64\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BDFHJLNPRTVXZ\\^`bd\2\5\5\2\3\4\b\t\13\f\4\2\65\6689\3\2\62\63\u01c0"+
		"\2h\3\2\2\2\4t\3\2\2\2\6v\3\2\2\2\bz\3\2\2\2\n\u0080\3\2\2\2\f\u0082\3"+
		"\2\2\2\16\u0084\3\2\2\2\20\u0088\3\2\2\2\22\u008b\3\2\2\2\24\u008f\3\2"+
		"\2\2\26\u00a6\3\2\2\2\30\u00a8\3\2\2\2\32\u00b2\3\2\2\2\34\u00b4\3\2\2"+
		"\2\36\u00b6\3\2\2\2 \u00e7\3\2\2\2\"\u00e9\3\2\2\2$\u00eb\3\2\2\2&\u00ed"+
		"\3\2\2\2(\u00ef\3\2\2\2*\u00f1\3\2\2\2,\u0106\3\2\2\2.\u0108\3\2\2\2\60"+
		"\u010a\3\2\2\2\62\u011c\3\2\2\2\64\u011e\3\2\2\2\66\u0120\3\2\2\28\u0124"+
		"\3\2\2\2:\u0127\3\2\2\2<\u012c\3\2\2\2>\u0137\3\2\2\2@\u0145\3\2\2\2B"+
		"\u014c\3\2\2\2D\u014e\3\2\2\2F\u0157\3\2\2\2H\u015e\3\2\2\2J\u0160\3\2"+
		"\2\2L\u0162\3\2\2\2N\u0168\3\2\2\2P\u016a\3\2\2\2R\u0172\3\2\2\2T\u017d"+
		"\3\2\2\2V\u0184\3\2\2\2X\u0186\3\2\2\2Z\u019a\3\2\2\2\\\u019c\3\2\2\2"+
		"^\u01a3\3\2\2\2`\u01af\3\2\2\2b\u01b3\3\2\2\2d\u01bd\3\2\2\2fi\5\4\3\2"+
		"gi\5N(\2hf\3\2\2\2hg\3\2\2\2i\3\3\2\2\2ju\5\6\4\2ku\5\b\5\2lu\5\16\b\2"+
		"mu\5\20\t\2nu\5\22\n\2ou\5\24\13\2pu\5,\27\2qu\5\66\34\2ru\58\35\2su\5"+
		":\36\2tj\3\2\2\2tk\3\2\2\2tl\3\2\2\2tm\3\2\2\2tn\3\2\2\2to\3\2\2\2tp\3"+
		"\2\2\2tq\3\2\2\2tr\3\2\2\2ts\3\2\2\2u\5\3\2\2\2vw\7\16\2\2wx\7\17\2\2"+
		"xy\7\67\2\2y\7\3\2\2\2z{\7\21\2\2{|\7\17\2\2|}\5\n\6\2}~\7\22\2\2~\177"+
		"\5\f\7\2\177\t\3\2\2\2\u0080\u0081\7\67\2\2\u0081\13\3\2\2\2\u0082\u0083"+
		"\7\67\2\2\u0083\r\3\2\2\2\u0084\u0085\7\23\2\2\u0085\u0086\7\17\2\2\u0086"+
		"\u0087\7\67\2\2\u0087\17\3\2\2\2\u0088\u0089\7\24\2\2\u0089\u008a\7\20"+
		"\2\2\u008a\21\3\2\2\2\u008b\u008c\7\25\2\2\u008c\u008d\7\17\2\2\u008d"+
		"\u008e\7\67\2\2\u008e\23\3\2\2\2\u008f\u0090\7\16\2\2\u0090\u0091\7\26"+
		"\2\2\u0091\u0092\5\26\f\2\u0092\u0093\7\5\2\2\u0093\u0098\5\30\r\2\u0094"+
		"\u0095\7\n\2\2\u0095\u0097\5\30\r\2\u0096\u0094\3\2\2\2\u0097\u009a\3"+
		"\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u00a2\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009b\u009c\7\n\2\2\u009c\u009e\5\36\20\2\u009d\u009b\3"+
		"\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u009f\3\2\2\2\u00a2\u00a3\3\2"+
		"\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\7\6\2\2\u00a5\25\3\2\2\2\u00a6\u00a7"+
		"\7\67\2\2\u00a7\27\3\2\2\2\u00a8\u00a9\5\34\17\2\u00a9\u00aa\5\32\16\2"+
		"\u00aa\31\3\2\2\2\u00ab\u00b3\7\27\2\2\u00ac\u00b3\7\30\2\2\u00ad\u00b3"+
		"\7\31\2\2\u00ae\u00af\7\32\2\2\u00af\u00b0\7\5\2\2\u00b0\u00b1\7\66\2"+
		"\2\u00b1\u00b3\7\6\2\2\u00b2\u00ab\3\2\2\2\u00b2\u00ac\3\2\2\2\u00b2\u00ad"+
		"\3\2\2\2\u00b2\u00ae\3\2\2\2\u00b3\33\3\2\2\2\u00b4\u00b5\7\67\2\2\u00b5"+
		"\35\3\2\2\2\u00b6\u00e5\7\33\2\2\u00b7\u00b8\5*\26\2\u00b8\u00b9\7\34"+
		"\2\2\u00b9\u00ba\7\35\2\2\u00ba\u00bb\7\5\2\2\u00bb\u00c0\5 \21\2\u00bc"+
		"\u00bd\7\n\2\2\u00bd\u00bf\5 \21\2\u00be\u00bc\3\2\2\2\u00bf\u00c2\3\2"+
		"\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c3\u00c4\7\6\2\2\u00c4\u00e6\3\2\2\2\u00c5\u00c6\5("+
		"\25\2\u00c6\u00c7\7\36\2\2\u00c7\u00c8\7\35\2\2\u00c8\u00c9\7\5\2\2\u00c9"+
		"\u00ce\5 \21\2\u00ca\u00cb\7\n\2\2\u00cb\u00cd\5 \21\2\u00cc\u00ca\3\2"+
		"\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\7\6\2\2\u00d2\u00d3\7 "+
		"\2\2\u00d3\u00d4\5&\24\2\u00d4\u00d5\7\5\2\2\u00d5\u00da\5\"\22\2\u00d6"+
		"\u00d7\7\n\2\2\u00d7\u00d9\5\"\22\2\u00d8\u00d6\3\2\2\2\u00d9\u00dc\3"+
		"\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dd\u00de\7\6\2\2\u00de\u00e6\3\2\2\2\u00df\u00e0\5$"+
		"\23\2\u00e0\u00e1\7\37\2\2\u00e1\u00e2\7\5\2\2\u00e2\u00e3\5<\37\2\u00e3"+
		"\u00e4\7\6\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00b7\3\2\2\2\u00e5\u00c5\3\2"+
		"\2\2\u00e5\u00df\3\2\2\2\u00e6\37\3\2\2\2\u00e7\u00e8\7\67\2\2\u00e8!"+
		"\3\2\2\2\u00e9\u00ea\7\67\2\2\u00ea#\3\2\2\2\u00eb\u00ec\7\67\2\2\u00ec"+
		"%\3\2\2\2\u00ed\u00ee\7\67\2\2\u00ee\'\3\2\2\2\u00ef\u00f0\7\67\2\2\u00f0"+
		")\3\2\2\2\u00f1\u00f2\7\67\2\2\u00f2+\3\2\2\2\u00f3\u00f4\7\21\2\2\u00f4"+
		"\u00f5\7\26\2\2\u00f5\u00f6\5.\30\2\u00f6\u00f7\7\22\2\2\u00f7\u00f8\5"+
		"\60\31\2\u00f8\u0107\3\2\2\2\u00f9\u00fa\7\21\2\2\u00fa\u00fb\7\26\2\2"+
		"\u00fb\u0104\7\67\2\2\u00fc\u0105\5\62\32\2\u00fd\u0100\5\62\32\2\u00fe"+
		"\u00ff\7\n\2\2\u00ff\u0101\5\62\32\2\u0100\u00fe\3\2\2\2\u0101\u0102\3"+
		"\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0105\3\2\2\2\u0104"+
		"\u00fc\3\2\2\2\u0104\u00fd\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u00f3\3\2"+
		"\2\2\u0106\u00f9\3\2\2\2\u0107-\3\2\2\2\u0108\u0109\7\67\2\2\u0109/\3"+
		"\2\2\2\u010a\u010b\7\67\2\2\u010b\61\3\2\2\2\u010c\u010d\7$\2\2\u010d"+
		"\u010e\7%\2\2\u010e\u010f\5\64\33\2\u010f\u0110\5\32\16\2\u0110\u0111"+
		"\7\33\2\2\u0111\u0112\5\36\20\2\u0112\u011d\3\2\2\2\u0113\u0114\7$\2\2"+
		"\u0114\u0115\7\33\2\2\u0115\u011d\5\36\20\2\u0116\u0117\7\23\2\2\u0117"+
		"\u0118\7%\2\2\u0118\u011d\5\64\33\2\u0119\u011a\7\23\2\2\u011a\u011b\7"+
		"\33\2\2\u011b\u011d\7\67\2\2\u011c\u010c\3\2\2\2\u011c\u0113\3\2\2\2\u011c"+
		"\u0116\3\2\2\2\u011c\u0119\3\2\2\2\u011d\63\3\2\2\2\u011e\u011f\7\67\2"+
		"\2\u011f\65\3\2\2\2\u0120\u0121\7\23\2\2\u0121\u0122\7\26\2\2\u0122\u0123"+
		"\7\67\2\2\u0123\67\3\2\2\2\u0124\u0125\7\24\2\2\u0125\u0126\7!\2\2\u0126"+
		"9\3\2\2\2\u0127\u0128\7\24\2\2\u0128\u0129\7\"\2\2\u0129\u012a\7#\2\2"+
		"\u012a\u012b\7\67\2\2\u012b;\3\2\2\2\u012c\u012d\b\37\1\2\u012d\u012e"+
		"\5> \2\u012e\u0134\3\2\2\2\u012f\u0130\f\3\2\2\u0130\u0131\7\'\2\2\u0131"+
		"\u0133\5> \2\u0132\u012f\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2\2"+
		"\2\u0134\u0135\3\2\2\2\u0135=\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u0138"+
		"\b \1\2\u0138\u0139\5@!\2\u0139\u013f\3\2\2\2\u013a\u013b\f\3\2\2\u013b"+
		"\u013c\7&\2\2\u013c\u013e\5@!\2\u013d\u013a\3\2\2\2\u013e\u0141\3\2\2"+
		"\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140?\3\2\2\2\u0141\u013f"+
		"\3\2\2\2\u0142\u0146\5B\"\2\u0143\u0144\7(\2\2\u0144\u0146\5B\"\2\u0145"+
		"\u0142\3\2\2\2\u0145\u0143\3\2\2\2\u0146A\3\2\2\2\u0147\u014d\5D#\2\u0148"+
		"\u0149\7\5\2\2\u0149\u014a\5<\37\2\u014a\u014b\7\6\2\2\u014b\u014d\3\2"+
		"\2\2\u014c\u0147\3\2\2\2\u014c\u0148\3\2\2\2\u014dC\3\2\2\2\u014e\u014f"+
		"\5F$\2\u014f\u0150\5L\'\2\u0150\u0151\5F$\2\u0151E\3\2\2\2\u0152\u0158"+
		"\5H%\2\u0153\u0158\7\66\2\2\u0154\u0158\79\2\2\u0155\u0158\7\65\2\2\u0156"+
		"\u0158\78\2\2\u0157\u0152\3\2\2\2\u0157\u0153\3\2\2\2\u0157\u0154\3\2"+
		"\2\2\u0157\u0155\3\2\2\2\u0157\u0156\3\2\2\2\u0158G\3\2\2\2\u0159\u015f"+
		"\7\67\2\2\u015a\u015b\5J&\2\u015b\u015c\7\r\2\2\u015c\u015d\7\67\2\2\u015d"+
		"\u015f\3\2\2\2\u015e\u0159\3\2\2\2\u015e\u015a\3\2\2\2\u015fI\3\2\2\2"+
		"\u0160\u0161\7\67\2\2\u0161K\3\2\2\2\u0162\u0163\t\2\2\2\u0163M\3\2\2"+
		"\2\u0164\u0169\5P)\2\u0165\u0169\5X-\2\u0166\u0169\5\\/\2\u0167\u0169"+
		"\5^\60\2\u0168\u0164\3\2\2\2\u0168\u0165\3\2\2\2\u0168\u0166\3\2\2\2\u0168"+
		"\u0167\3\2\2\2\u0169O\3\2\2\2\u016a\u016b\7)\2\2\u016b\u016c\7*\2\2\u016c"+
		"\u016e\5J&\2\u016d\u016f\5R*\2\u016e\u016d\3\2\2\2\u016e\u016f\3\2\2\2"+
		"\u016f\u0170\3\2\2\2\u0170\u0171\5T+\2\u0171Q\3\2\2\2\u0172\u0173\7\5"+
		"\2\2\u0173\u0178\7\67\2\2\u0174\u0175\7\n\2\2\u0175\u0177\7\67\2\2\u0176"+
		"\u0174\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2"+
		"\2\2\u0179\u017b\3\2\2\2\u017a\u0178\3\2\2\2\u017b\u017c\7\6\2\2\u017c"+
		"S\3\2\2\2\u017d\u0181\5V,\2\u017e\u0180\5V,\2\u017f\u017e\3\2\2\2\u0180"+
		"\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182U\3\2\2\2"+
		"\u0183\u0181\3\2\2\2\u0184\u0185\t\3\2\2\u0185W\3\2\2\2\u0186\u0187\7"+
		",\2\2\u0187\u0188\5J&\2\u0188\u0189\7-\2\2\u0189\u018a\5Z.\2\u018a\u018b"+
		"\7\13\2\2\u018b\u0193\5V,\2\u018c\u018d\7\n\2\2\u018d\u018e\5Z.\2\u018e"+
		"\u018f\7\13\2\2\u018f\u0190\5V,\2\u0190\u0192\3\2\2\2\u0191\u018c\3\2"+
		"\2\2\u0192\u0195\3\2\2\2\u0193\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194"+
		"\u0198\3\2\2\2\u0195\u0193\3\2\2\2\u0196\u0197\7+\2\2\u0197\u0199\5<\37"+
		"\2\u0198\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199Y\3\2\2\2\u019a\u019b"+
		"\7\67\2\2\u019b[\3\2\2\2\u019c\u019d\7.\2\2\u019d\u019e\7#\2\2\u019e\u01a1"+
		"\5J&\2\u019f\u01a0\7+\2\2\u01a0\u01a2\5<\37\2\u01a1\u019f\3\2\2\2\u01a1"+
		"\u01a2\3\2\2\2\u01a2]\3\2\2\2\u01a3\u01a6\7/\2\2\u01a4\u01a7\7\7\2\2\u01a5"+
		"\u01a7\5`\61\2\u01a6\u01a4\3\2\2\2\u01a6\u01a5\3\2\2\2\u01a7\u01a8\3\2"+
		"\2\2\u01a8\u01a9\7#\2\2\u01a9\u01aa\5J&\2\u01aa\u01ab\7+\2\2\u01ab\u01ad"+
		"\5<\37\2\u01ac\u01ae\5b\62\2\u01ad\u01ac\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae"+
		"_\3\2\2\2\u01af\u01b0\7\67\2\2\u01b0\u01b1\7\n\2\2\u01b1\u01b2\7\67\2"+
		"\2\u01b2a\3\2\2\2\u01b3\u01b4\7\60\2\2\u01b4\u01b5\7\61\2\2\u01b5\u01ba"+
		"\5b\62\2\u01b6\u01b7\7\n\2\2\u01b7\u01b9\5b\62\2\u01b8\u01b6\3\2\2\2\u01b9"+
		"\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bbc\3\2\2\2"+
		"\u01bc\u01ba\3\2\2\2\u01bd\u01bf\5\34\17\2\u01be\u01c0\t\4\2\2\u01bf\u01be"+
		"\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0e\3\2\2\2!ht\u0098\u009f\u00a2\u00b2"+
		"\u00c0\u00ce\u00da\u00e5\u0102\u0104\u0106\u011c\u0134\u013f\u0145\u014c"+
		"\u0157\u015e\u0168\u016e\u0178\u0181\u0193\u0198\u01a1\u01a6\u01ad\u01ba"+
		"\u01bf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}