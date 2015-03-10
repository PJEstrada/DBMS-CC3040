// Generated from SQL.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLParser}.
 */
public interface SQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull SQLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull SQLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#alterDbStmt}.
	 * @param ctx the parse tree
	 */
	void enterAlterDbStmt(@NotNull SQLParser.AlterDbStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#alterDbStmt}.
	 * @param ctx the parse tree
	 */
	void exitAlterDbStmt(@NotNull SQLParser.AlterDbStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code accionAlter}
	 * labeled alternative in {@link SQLParser#alterTableStmt}.
	 * @param ctx the parse tree
	 */
	void enterAccionAlter(@NotNull SQLParser.AccionAlterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code accionAlter}
	 * labeled alternative in {@link SQLParser#alterTableStmt}.
	 * @param ctx the parse tree
	 */
	void exitAccionAlter(@NotNull SQLParser.AccionAlterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#expConstraint}.
	 * @param ctx the parse tree
	 */
	void enterExpConstraint(@NotNull SQLParser.ExpConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#expConstraint}.
	 * @param ctx the parse tree
	 */
	void exitExpConstraint(@NotNull SQLParser.ExpConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#createDbStmt}.
	 * @param ctx the parse tree
	 */
	void enterCreateDbStmt(@NotNull SQLParser.CreateDbStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#createDbStmt}.
	 * @param ctx the parse tree
	 */
	void exitCreateDbStmt(@NotNull SQLParser.CreateDbStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#dmlQuery}.
	 * @param ctx the parse tree
	 */
	void enterDmlQuery(@NotNull SQLParser.DmlQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#dmlQuery}.
	 * @param ctx the parse tree
	 */
	void exitDmlQuery(@NotNull SQLParser.DmlQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#showTableStmt}.
	 * @param ctx the parse tree
	 */
	void enterShowTableStmt(@NotNull SQLParser.ShowTableStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#showTableStmt}.
	 * @param ctx the parse tree
	 */
	void exitShowTableStmt(@NotNull SQLParser.ShowTableStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#showColumnsStmt}.
	 * @param ctx the parse tree
	 */
	void enterShowColumnsStmt(@NotNull SQLParser.ShowColumnsStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#showColumnsStmt}.
	 * @param ctx the parse tree
	 */
	void exitShowColumnsStmt(@NotNull SQLParser.ShowColumnsStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRel_op(@NotNull SQLParser.Rel_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRel_op(@NotNull SQLParser.Rel_opContext ctx);
	/**
	 * Enter a parse tree produced by the {@code renameAlter}
	 * labeled alternative in {@link SQLParser#alterTableStmt}.
	 * @param ctx the parse tree
	 */
	void enterRenameAlter(@NotNull SQLParser.RenameAlterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code renameAlter}
	 * labeled alternative in {@link SQLParser#alterTableStmt}.
	 * @param ctx the parse tree
	 */
	void exitRenameAlter(@NotNull SQLParser.RenameAlterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#fkNombre}.
	 * @param ctx the parse tree
	 */
	void enterFkNombre(@NotNull SQLParser.FkNombreContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#fkNombre}.
	 * @param ctx the parse tree
	 */
	void exitFkNombre(@NotNull SQLParser.FkNombreContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#dbName}.
	 * @param ctx the parse tree
	 */
	void enterDbName(@NotNull SQLParser.DbNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#dbName}.
	 * @param ctx the parse tree
	 */
	void exitDbName(@NotNull SQLParser.DbNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(@NotNull SQLParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(@NotNull SQLParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#insertStmt}.
	 * @param ctx the parse tree
	 */
	void enterInsertStmt(@NotNull SQLParser.InsertStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#insertStmt}.
	 * @param ctx the parse tree
	 */
	void exitInsertStmt(@NotNull SQLParser.InsertStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#deleteStmt}.
	 * @param ctx the parse tree
	 */
	void enterDeleteStmt(@NotNull SQLParser.DeleteStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#deleteStmt}.
	 * @param ctx the parse tree
	 */
	void exitDeleteStmt(@NotNull SQLParser.DeleteStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#updateStmt}.
	 * @param ctx the parse tree
	 */
	void enterUpdateStmt(@NotNull SQLParser.UpdateStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#updateStmt}.
	 * @param ctx the parse tree
	 */
	void exitUpdateStmt(@NotNull SQLParser.UpdateStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#showDbStmt}.
	 * @param ctx the parse tree
	 */
	void enterShowDbStmt(@NotNull SQLParser.ShowDbStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#showDbStmt}.
	 * @param ctx the parse tree
	 */
	void exitShowDbStmt(@NotNull SQLParser.ShowDbStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#dropTableStmt}.
	 * @param ctx the parse tree
	 */
	void enterDropTableStmt(@NotNull SQLParser.DropTableStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#dropTableStmt}.
	 * @param ctx the parse tree
	 */
	void exitDropTableStmt(@NotNull SQLParser.DropTableStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#andexpr}.
	 * @param ctx the parse tree
	 */
	void enterAndexpr(@NotNull SQLParser.AndexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#andexpr}.
	 * @param ctx the parse tree
	 */
	void exitAndexpr(@NotNull SQLParser.AndexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#valueList}.
	 * @param ctx the parse tree
	 */
	void enterValueList(@NotNull SQLParser.ValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#valueList}.
	 * @param ctx the parse tree
	 */
	void exitValueList(@NotNull SQLParser.ValueListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#newName}.
	 * @param ctx the parse tree
	 */
	void enterNewName(@NotNull SQLParser.NewNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#newName}.
	 * @param ctx the parse tree
	 */
	void exitNewName(@NotNull SQLParser.NewNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(@NotNull SQLParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(@NotNull SQLParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#alterName}.
	 * @param ctx the parse tree
	 */
	void enterAlterName(@NotNull SQLParser.AlterNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#alterName}.
	 * @param ctx the parse tree
	 */
	void exitAlterName(@NotNull SQLParser.AlterNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#columnList}.
	 * @param ctx the parse tree
	 */
	void enterColumnList(@NotNull SQLParser.ColumnListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#columnList}.
	 * @param ctx the parse tree
	 */
	void exitColumnList(@NotNull SQLParser.ColumnListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#useDbStmt}.
	 * @param ctx the parse tree
	 */
	void enterUseDbStmt(@NotNull SQLParser.UseDbStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#useDbStmt}.
	 * @param ctx the parse tree
	 */
	void exitUseDbStmt(@NotNull SQLParser.UseDbStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(@NotNull SQLParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(@NotNull SQLParser.ColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#val}.
	 * @param ctx the parse tree
	 */
	void enterVal(@NotNull SQLParser.ValContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#val}.
	 * @param ctx the parse tree
	 */
	void exitVal(@NotNull SQLParser.ValContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#ddlQuery}.
	 * @param ctx the parse tree
	 */
	void enterDdlQuery(@NotNull SQLParser.DdlQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#ddlQuery}.
	 * @param ctx the parse tree
	 */
	void exitDdlQuery(@NotNull SQLParser.DdlQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(@NotNull SQLParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(@NotNull SQLParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#orderTerm}.
	 * @param ctx the parse tree
	 */
	void enterOrderTerm(@NotNull SQLParser.OrderTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#orderTerm}.
	 * @param ctx the parse tree
	 */
	void exitOrderTerm(@NotNull SQLParser.OrderTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#colConstraint}.
	 * @param ctx the parse tree
	 */
	void enterColConstraint(@NotNull SQLParser.ColConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#colConstraint}.
	 * @param ctx the parse tree
	 */
	void exitColConstraint(@NotNull SQLParser.ColConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#selectList}.
	 * @param ctx the parse tree
	 */
	void enterSelectList(@NotNull SQLParser.SelectListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#selectList}.
	 * @param ctx the parse tree
	 */
	void exitSelectList(@NotNull SQLParser.SelectListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#chNombre}.
	 * @param ctx the parse tree
	 */
	void enterChNombre(@NotNull SQLParser.ChNombreContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#chNombre}.
	 * @param ctx the parse tree
	 */
	void exitChNombre(@NotNull SQLParser.ChNombreContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#compareExpr}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpr(@NotNull SQLParser.CompareExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#compareExpr}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpr(@NotNull SQLParser.CompareExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#orderExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrderExpr(@NotNull SQLParser.OrderExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#orderExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrderExpr(@NotNull SQLParser.OrderExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(@NotNull SQLParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(@NotNull SQLParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(@NotNull SQLParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(@NotNull SQLParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#idTabla}.
	 * @param ctx the parse tree
	 */
	void enterIdTabla(@NotNull SQLParser.IdTablaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#idTabla}.
	 * @param ctx the parse tree
	 */
	void exitIdTabla(@NotNull SQLParser.IdTablaContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#pkNombre}.
	 * @param ctx the parse tree
	 */
	void enterPkNombre(@NotNull SQLParser.PkNombreContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#pkNombre}.
	 * @param ctx the parse tree
	 */
	void exitPkNombre(@NotNull SQLParser.PkNombreContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#createTableStmt}.
	 * @param ctx the parse tree
	 */
	void enterCreateTableStmt(@NotNull SQLParser.CreateTableStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#createTableStmt}.
	 * @param ctx the parse tree
	 */
	void exitCreateTableStmt(@NotNull SQLParser.CreateTableStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#selectStmt}.
	 * @param ctx the parse tree
	 */
	void enterSelectStmt(@NotNull SQLParser.SelectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#selectStmt}.
	 * @param ctx the parse tree
	 */
	void exitSelectStmt(@NotNull SQLParser.SelectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(@NotNull SQLParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(@NotNull SQLParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#dropDbStmt}.
	 * @param ctx the parse tree
	 */
	void enterDropDbStmt(@NotNull SQLParser.DropDbStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#dropDbStmt}.
	 * @param ctx the parse tree
	 */
	void exitDropDbStmt(@NotNull SQLParser.DropDbStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#accion}.
	 * @param ctx the parse tree
	 */
	void enterAccion(@NotNull SQLParser.AccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#accion}.
	 * @param ctx the parse tree
	 */
	void exitAccion(@NotNull SQLParser.AccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#columnsUpdate}.
	 * @param ctx the parse tree
	 */
	void enterColumnsUpdate(@NotNull SQLParser.ColumnsUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#columnsUpdate}.
	 * @param ctx the parse tree
	 */
	void exitColumnsUpdate(@NotNull SQLParser.ColumnsUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull SQLParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull SQLParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(@NotNull SQLParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(@NotNull SQLParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#columnDecl}.
	 * @param ctx the parse tree
	 */
	void enterColumnDecl(@NotNull SQLParser.ColumnDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#columnDecl}.
	 * @param ctx the parse tree
	 */
	void exitColumnDecl(@NotNull SQLParser.ColumnDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#newDbName}.
	 * @param ctx the parse tree
	 */
	void enterNewDbName(@NotNull SQLParser.NewDbNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#newDbName}.
	 * @param ctx the parse tree
	 */
	void exitNewDbName(@NotNull SQLParser.NewDbNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#colName}.
	 * @param ctx the parse tree
	 */
	void enterColName(@NotNull SQLParser.ColNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#colName}.
	 * @param ctx the parse tree
	 */
	void exitColName(@NotNull SQLParser.ColNameContext ctx);
}