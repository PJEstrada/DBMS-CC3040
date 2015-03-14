package proyecto1basesdatos;

import java.util.ArrayList;
import javax.swing.JTextArea;
import org.antlr.v4.runtime.tree.ParseTree;

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
    
        DBMS  dbms;
        ArrayList<Columna> colsCreate; // Almacena las columnas que se crean en CREATE TABLE para poder verificarlas en los metodos de constraints
        Tabla tableCreate; 
        public Loader(DBMS dbms){
            this.dbms = dbms;
        
        }
        
        public void error(String s){
            Frame.jTextArea2.setText(s);
        }
        //Metodo para encontrar una columna dado un string y una arreglo de columnas. Se utiliza para verificar el primary key de una tabla.
        public Columna findCol(String name, ArrayList<Columna> cols){
            for(Columna c: cols){
                if(c.nombre.equals(name)){
                    return c;
                
                }
                
            }
            return null;
        }

	@Override
	public Object visitExpression(SQLParser.ExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExpression(ctx);
	}


	@Override
	public Object visitAlterDbStmt(SQLParser.AlterDbStmtContext ctx) {
            
            boolean result = DB.renameDB(ctx.dbName().getText(), ctx.newDbName().getText());
            if(result){
              return ctx.newDbName().getText();  
            
            }
            else{
                return "ERROR";
            }
            
	}

	@Override
	public Object visitAccionAlter(SQLParser.AccionAlterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAccionAlter(ctx);
	}
	@Override
	public Object visitDropDbStmt(SQLParser.DropDbStmtContext ctx) {
		
		String name = ctx.ID().getText();
                boolean fueDestruida = DB.destroyDb(name);
                if(!fueDestruida){
                    Frame.jTextArea2.setText("ERROR: no se encuentra la base de datos: "+name);
                    return "ERROR";
                }
                else{
                    return name;
                
                }
                  
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
                    e.printStackTrace();
                    String s = e.getMessage();
                    Frame.jTextArea2.setText(s);
                }
                return name;
	}
	@Override
	public Object visitCreateTableStmt(SQLParser.CreateTableStmtContext ctx) {
            DBMS.currentDB="test";
            Tabla t1= new Tabla(); //Utilizamos el constructor vacio para dejar inicializada la variable
            this.tableCreate = t1;
            String name = ctx.tableName().getText();
            //Verificamos si hay una DB en uso
            if(DBMS.currentDB==null){
                Frame.jTextArea2.setText("ERROR: No existe ninguna base de datos en uso. Utilice USE DB para utilizar una base de datos existente.");
                return "ERROR";
            
            }
            else{
                //Buscamos si la tabla ya existe en la metaData     
                DBMetaData d = DBMS.metaData.findDB(DBMS.currentDB);
                for(TablaMetaData t:d.tablas){
                    if(t.nombre.equals(name)){
                       Frame.jTextArea2.setText("ERROR: Ya existe la tabla: "+name);
                       return "ERROR";                       
                    
                    }
                }
                //Guardamos las columnas
                ArrayList<Columna> cols = new ArrayList<Columna>();
                for(ParseTree n: ctx.columnDecl()){
                    Columna c = (Columna) visit(n);
                    cols.add(c);
                }
                //Guardamos las columnas para constraints
                this.colsCreate=cols;
                // Si hay constraints las agregamos
                int test = ctx.colConstraint().size();
                ArrayList<Constraint> cons = new ArrayList<Constraint>();
                if(test!=0){
                   for(ParseTree n: ctx.colConstraint()){
                       Object c = visit(n);
                       if(!(c instanceof Constraint)){
                           return "ERROR";
                       
                       }
                       else{
                           Constraint con =(Constraint)c;
                           cons.add(con);
                       }
                       
                   } 
                    //Creamos la tabla y la serializamos 
                    t1 = new Tabla(name,cols,cons);
                    Frame.jTextArea2.setText("Tabla '"+name+ "' Creada existosamente.");
                    return t1;                    

                }
                else{
                    //Creamos la tabla y la serializamos 
                    t1 = new Tabla(name,cols);
                    Frame.jTextArea2.setText("Tabla '"+name+ "' Creada existosamente.");
                    return t1;


                } 
                
              
            }
	}

	@Override
	public Object visitColConstraint(SQLParser.ColConstraintContext ctx) {
            
            //Revisamos el tipo de constraint
            if(ctx.PRIMARY()!=null){ //Si es Primary key
                String name = ctx.pkNombre().getText();
                //Revisando que existan los nombre de las columnas
                ArrayList<Columna> pkCols = new ArrayList<Columna>();
                for(ParseTree n:ctx.ID()){
                    String text = n.getText();
                    Columna encontrada = findCol(text,colsCreate);
                    
                    if(encontrada==null){
                        Frame.jTextArea2.setText("ERROR: No se encuentra la columna: "+text+" En la tabla"+tableCreate.name);
                        return "ERROR";
                    }
                    else{
                        pkCols.add(encontrada);
                    
                    }
                }
                //Creamos constraint
                Constraint c = new Constraint(name,Constraint.PK,pkCols,this.tableCreate);
                return c;
                
            }
            else if(ctx.FOREIGN()!=null){
            
            
            }
            
            else if(ctx.CHECK()!=null){
            
            
            }
            return "ERROR";
	}        
	@Override
	public Object visitColumnDecl(SQLParser.ColumnDeclContext ctx) {
            //Creamos la columan dependiendo del tipo
            String name = ctx.colName().getText();
            int colType = 0;
            Columna c = new Columna(null,0,0);
            if(ctx.tipo().CHAR()!=null){
                colType = Columna.CHAR_TYPE;
                int size = Integer.parseInt(ctx.tipo().NUM().getText());
                c = new Columna(name,colType,size);
            }
            else if(ctx.tipo().INT()!=null){
                colType = Columna.INT_TYPE;
                c = new Columna(name,colType);
            
            }
            else if(ctx.tipo().FLOAT()!=null){
                colType =Columna.FLOAT_TYPE;
                c = new Columna(name,colType);
            }
            else if(ctx.tipo().DATE()!=null){
                colType = Columna.DATE_TYPE;
                c = new Columna(name,colType);
            
            }
            return c;
            
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
