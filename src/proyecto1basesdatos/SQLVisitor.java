// Generated from SQL.g4 by ANTLR 4.4
package proyecto1basesdatos;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SQLParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(@NotNull SQLParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#pkNombre}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPkNombre(@NotNull SQLParser.PkNombreContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#alterDbStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterDbStmt(@NotNull SQLParser.AlterDbStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#showTableStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowTableStmt(@NotNull SQLParser.ShowTableStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#dbName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDbName(@NotNull SQLParser.DbNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#dropTableStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTableStmt(@NotNull SQLParser.DropTableStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#chNombre}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChNombre(@NotNull SQLParser.ChNombreContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel_op(@NotNull SQLParser.Rel_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(@NotNull SQLParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#idTabla}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdTabla(@NotNull SQLParser.IdTablaContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#useDbStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUseDbStmt(@NotNull SQLParser.UseDbStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#compareExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(@NotNull SQLParser.CompareExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(@NotNull SQLParser.ValContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#colName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColName(@NotNull SQLParser.ColNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(@NotNull SQLParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#dropDbStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropDbStmt(@NotNull SQLParser.DropDbStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#selectStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStmt(@NotNull SQLParser.SelectStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#newName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewName(@NotNull SQLParser.NewNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#fkNombre}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFkNombre(@NotNull SQLParser.FkNombreContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#insertStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStmt(@NotNull SQLParser.InsertStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#newDbName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewDbName(@NotNull SQLParser.NewDbNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#createTableStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTableStmt(@NotNull SQLParser.CreateTableStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#deleteStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteStmt(@NotNull SQLParser.DeleteStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(@NotNull SQLParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#accion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccion(@NotNull SQLParser.AccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#orderExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderExpr(@NotNull SQLParser.OrderExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#alterName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterName(@NotNull SQLParser.AlterNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#showColumnsStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowColumnsStmt(@NotNull SQLParser.ShowColumnsStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code renameAlter}
	 * labeled alternative in {@link SQLParser#alterTableStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenameAlter(@NotNull SQLParser.RenameAlterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#showDbStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowDbStmt(@NotNull SQLParser.ShowDbStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#columnDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDecl(@NotNull SQLParser.ColumnDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull SQLParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#colConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColConstraint(@NotNull SQLParser.ColConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(@NotNull SQLParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(@NotNull SQLParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accionAlter}
	 * labeled alternative in {@link SQLParser#alterTableStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccionAlter(@NotNull SQLParser.AccionAlterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#ddlQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDdlQuery(@NotNull SQLParser.DdlQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull SQLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#createDbStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDbStmt(@NotNull SQLParser.CreateDbStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn(@NotNull SQLParser.ColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#columnList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnList(@NotNull SQLParser.ColumnListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#updateStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateStmt(@NotNull SQLParser.UpdateStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#andexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndexpr(@NotNull SQLParser.AndexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#dmlQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDmlQuery(@NotNull SQLParser.DmlQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#columnsUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnsUpdate(@NotNull SQLParser.ColumnsUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#selectList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectList(@NotNull SQLParser.SelectListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#orderTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderTerm(@NotNull SQLParser.OrderTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#valueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueList(@NotNull SQLParser.ValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#columnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(@NotNull SQLParser.ColumnNameContext ctx);
}