package proyecto1basesdatos;

import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Al
 */
public class Loader extends SQLBaseVisitor<Object>{
    
        JTextArea  console;
        public Loader(JTextArea s){
            console = s;
        
        }
        
        public void error(String s){
            console.setText(s);
        }

	@Override
	public Object visitExpression(SQLParser.ExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExpression(ctx);
	}

	@Override
	public Object visitAlterDbStmt(SQLParser.AlterDbStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAlterDbStmt(ctx);
	}

	@Override
	public Object visitAccionAlter(SQLParser.AccionAlterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAccionAlter(ctx);
	}

	@Override
	public Object visitExpConstraint(SQLParser.ExpConstraintContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExpConstraint(ctx);
	}

	@Override
	public Object visitCreateDbStmt(SQLParser.CreateDbStmtContext ctx) {
                //Tomamos el nombre
                String name = ctx.ID().getText();
                //Intentamos crear la base de datos, si ya existe capturamos la excepcion y mostramos error
                try{
                    DB database = new DB(name);
                    return database;
                }
                catch(Exception e){
                    error(e.getMessage());
                }
                return name;
	}

	@Override
	public Object visitDmlQuery(SQLParser.DmlQueryContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDmlQuery(ctx);
	}

	@Override
	public Object visitShowTableStmt(SQLParser.ShowTableStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitShowTableStmt(ctx);
	}

	@Override
	public Object visitShowColumnsStmt(SQLParser.ShowColumnsStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitShowColumnsStmt(ctx);
	}

	@Override
	public Object visitRel_op(SQLParser.Rel_opContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRel_op(ctx);
	}

	@Override
	public Object visitRenameAlter(SQLParser.RenameAlterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRenameAlter(ctx);
	}

	@Override
	public Object visitFkNombre(SQLParser.FkNombreContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFkNombre(ctx);
	}

	@Override
	public Object visitDbName(SQLParser.DbNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDbName(ctx);
	}

	@Override
	public Object visitPrimary(SQLParser.PrimaryContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPrimary(ctx);
	}

	@Override
	public Object visitInsertStmt(SQLParser.InsertStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitInsertStmt(ctx);
	}

	@Override
	public Object visitDeleteStmt(SQLParser.DeleteStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDeleteStmt(ctx);
	}

	@Override
	public Object visitUpdateStmt(SQLParser.UpdateStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitUpdateStmt(ctx);
	}

	@Override
	public Object visitShowDbStmt(SQLParser.ShowDbStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitShowDbStmt(ctx);
	}

	@Override
	public Object visitDropTableStmt(SQLParser.DropTableStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDropTableStmt(ctx);
	}

	@Override
	public Object visitAndexpr(SQLParser.AndexprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAndexpr(ctx);
	}

	@Override
	public Object visitValueList(SQLParser.ValueListContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueList(ctx);
	}

	@Override
	public Object visitNewName(SQLParser.NewNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNewName(ctx);
	}

	@Override
	public Object visitTable(SQLParser.TableContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTable(ctx);
	}

	@Override
	public Object visitAlterName(SQLParser.AlterNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAlterName(ctx);
	}

	@Override
	public Object visitColumnList(SQLParser.ColumnListContext ctx) {
		// TODO Auto-generated method stub
		return super.visitColumnList(ctx);
	}

	@Override
	public Object visitUseDbStmt(SQLParser.UseDbStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitUseDbStmt(ctx);
	}

	@Override
	public Object visitColumn(SQLParser.ColumnContext ctx) {
		// TODO Auto-generated method stub
		return super.visitColumn(ctx);
	}

	@Override
	public Object visitVal(SQLParser.ValContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVal(ctx);
	}

	@Override
	public Object visitDdlQuery(SQLParser.DdlQueryContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDdlQuery(ctx);
	}

	@Override
	public Object visitQuery(SQLParser.QueryContext ctx) {
		// TODO Auto-generated method stub
		return super.visitQuery(ctx);
	}

	@Override
	public Object visitOrderTerm(SQLParser.OrderTermContext ctx) {
		// TODO Auto-generated method stub
		return super.visitOrderTerm(ctx);
	}

	@Override
	public Object visitColConstraint(SQLParser.ColConstraintContext ctx) {
		// TODO Auto-generated method stub
		return super.visitColConstraint(ctx);
	}

	@Override
	public Object visitSelectList(SQLParser.SelectListContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSelectList(ctx);
	}

	@Override
	public Object visitChNombre(SQLParser.ChNombreContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChNombre(ctx);
	}

	@Override
	public Object visitCompareExpr(SQLParser.CompareExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCompareExpr(ctx);
	}

	@Override
	public Object visitOrderExpr(SQLParser.OrderExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitOrderExpr(ctx);
	}

	@Override
	public Object visitTableName(SQLParser.TableNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTableName(ctx);
	}

	@Override
	public Object visitColumnName(SQLParser.ColumnNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitColumnName(ctx);
	}

	@Override
	public Object visitIdTabla(SQLParser.IdTablaContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIdTabla(ctx);
	}

	@Override
	public Object visitPkNombre(SQLParser.PkNombreContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPkNombre(ctx);
	}

	@Override
	public Object visitCreateTableStmt(SQLParser.CreateTableStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCreateTableStmt(ctx);
	}

	@Override
	public Object visitSelectStmt(SQLParser.SelectStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSelectStmt(ctx);
	}

	@Override
	public Object visitFactor(SQLParser.FactorContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFactor(ctx);
	}

	@Override
	public Object visitDropDbStmt(SQLParser.DropDbStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDropDbStmt(ctx);
	}

	@Override
	public Object visitAccion(SQLParser.AccionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAccion(ctx);
	}

	@Override
	public Object visitColumnsUpdate(SQLParser.ColumnsUpdateContext ctx) {
		// TODO Auto-generated method stub
		return super.visitColumnsUpdate(ctx);
	}

	@Override
	public Object visitTerm(SQLParser.TermContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTerm(ctx);
	}

	@Override
	public Object visitTipo(SQLParser.TipoContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTipo(ctx);
	}

	@Override
	public Object visitColumnDecl(SQLParser.ColumnDeclContext ctx) {
		// TODO Auto-generated method stub
		return super.visitColumnDecl(ctx);
	}

	@Override
	public Object visitNewDbName(SQLParser.NewDbNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNewDbName(ctx);
	}

	@Override
	public Object visitColName(SQLParser.ColNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitColName(ctx);
	}
    
    
}
