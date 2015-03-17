package proyecto1basesdatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
        String createTableName;
        ArrayList<Columna> availableCols;
        ArrayList<Constraint> availableCons;
        public Loader(DBMS dbms){
            this.dbms = dbms;
        
        }
        
        public void error(String s){
            Frame.jTextArea2.setText(s);
        }
        //Metodo para encontrar una columna dado un string y una arreglo de columnas. Se utiliza para verificar el primary key de una tabla.
        public Columna findCol(String name, ArrayList<Columna> cols){
            for(Columna c: cols){
                if(c.nombre.equalsIgnoreCase(name)){
                    return c;
                
                }
                
            }
            return null;
        }
        //Metodo para encontrar primary key de una lista de constraints
        public boolean findPk(ArrayList<Constraint> cons){
            for(Constraint c:cons){
                if(c.tipo==Constraint.PK){
                    return true;
                }
            
            }
            return false;
        
        }
	@Override
	public Object visitExpression(SQLParser.ExpressionContext ctx) {
            if(ctx.children.size()==1){
                return visit(ctx.andexpr());
            
            }
            else{
                Object l =  visit(ctx.expression());
                Object r=  visit(ctx.andexpr());
                if((l instanceof Expression)&&(r instanceof Expression)){
                    Expression l1 = (Expression)l;
                    Expression r1 = (Expression) r;
                    OrExpression e = new OrExpression(l1,r1);
                    return e;
                }
                else{
                    return "ERROR";
                }
            
            }
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
            this.availableCols = new ArrayList<Columna>();
            this.availableCons = new ArrayList<Constraint>();
            Tabla t1= new Tabla(); //Utilizamos el constructor vacio para dejar inicializada la variable
            this.tableCreate = t1;
            String name = ctx.tableName().getText();
            t1.name=name;
            //Verificamos si hay una DB en uso
            if(DBMS.currentDB==null){
                Frame.jTextArea2.setText("ERROR: No existe ninguna base de datos en uso. Utilice USE DATABASE <nombre> para utilizar una base de datos existente.");
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
                    availableCols.add(c);
                }
                //Guardamos las columnas para constraints
                this.colsCreate=cols;
                // Si hay constraints las agregamos
                int test = ctx.colConstraint().size();
                ArrayList<Constraint> cons = new ArrayList<Constraint>();
                availableCons = cons;
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
                //Revisamos que no exista una primary key en las constraints declaradas antes
                boolean hay_pk = findPk(availableCons);
                if(hay_pk){
                        Frame.jTextArea2.setText("ERROR: No es posible declarar dos primary keys. En la tabla: "+tableCreate.name);
                        return "ERROR";                    
                }
                //Revisando que existan los nombre de las columnas
                ArrayList<Columna> pkCols = new ArrayList<Columna>();
                
                
                for(ParseTree n:ctx.localids()){
                    String text = n.getText();
                    Columna encontrada = findCol(text,colsCreate);
                    
                    if(encontrada==null){
                        Frame.jTextArea2.setText("ERROR: No se encuentra la columna: "+text+" En la tabla: "+tableCreate.name);
                        return "ERROR";
                    }
                    else{
                        pkCols.add(encontrada);
                    
                    }
                }
                //Creamos constraint
                Constraint c = new Constraint(name,Constraint.PK,pkCols,tableCreate.name);
                return c;
                
            }
            else if(ctx.FOREIGN()!=null){ // Si es foreign key
                String name = ctx.fkNombre().getText();
                //Revisando que existan los nombre de las columnas en la tabla local
                ArrayList<Columna> localCols = new ArrayList<Columna>();
                for(ParseTree n:ctx.localids()){
                    String text = n.getText();
                    Columna encontrada = findCol(text,colsCreate);
                    
                    if(encontrada==null){
                        Frame.jTextArea2.setText("ERROR: No se encuentra la columna: "+text+" En la tabla: "+tableCreate.name);
                        return "ERROR";
                    }
                    else{
                        localCols.add(encontrada);
                    
                    }
                }
                //Obteniendo la tabla que referencia
                String refTable = ctx.idTabla().getText();
                DBMetaData bd = DBMS.metaData.findDB(DBMS.currentDB);
                TablaMetaData t = bd.findTable(refTable);
                if(t==null){
                        Frame.jTextArea2.setText("ERROR: No se encuentra la tabla de referencia: "+refTable);
                        return "ERROR";                   
                }
                //Si encontramos la tabla procedemos a buscar las columnas
                else{
                    ArrayList<Columna> fkCols = new ArrayList<Columna>();
                    ArrayList<Columna> cols = Tabla.loadColums(refTable);
                    for(ParseTree n:ctx.refids()){
                        String text = n.getText();
                        //Buscamos las columnas de la tabla
                        
                        if(cols==null){
                            Frame.jTextArea2.setText("ERROR: No se encuentra archivo de columnas para la tabla: "+refTable);
                            return "ERROR";                            
                        }
                        Columna encontrada = findCol(text,cols);

                        if(encontrada==null){
                            Frame.jTextArea2.setText("ERROR: No se encuentra la columna: "+text+" En la tabla: "+tableCreate.name);
                            return "ERROR";
                        }
                        else{
                            fkCols.add(encontrada);

                        }
                    }
                    
                    //Una vez obtenidos los dos arreglos de columnas verificamos que tengan el mismo tamaño
                    if(fkCols.size()!=localCols.size()){
                        Frame.jTextArea2.setText("ERROR: El numero de columnas locales y remotas en la foregin key debe ser el mismo");
                        return "ERROR";
                    }
                    //Si los arreglos son iguales verificamos que tengan los mismos tipo
                    for(int i =0;i<localCols.size();i++){
                        Columna local = localCols.get(i);
                        Columna foreign = fkCols.get(i);
                        if(local.tipo!=foreign.tipo){
                            Frame.jTextArea2.setText("ERROR: las columnas: '"+local.nombre+", "+foreign.nombre+"' Deben tener el mismo tipo");
                            return "ERROR";                       
                        
                        }
                    }
                    //Si todas las columnas tienen los mismo tipos, procedemos a crear la constraint
                    Constraint c = new Constraint(name,Constraint.FK,localCols,fkCols,refTable,this.tableCreate.name);
                    return c;
                
                }
                
            
            }
            
            else if(ctx.CHECK()!=null){
                String name= ctx.chNombre().getText();
                //Obtenemos la expresion del CHECK
                Object e = visit(ctx.expression());
                String expr = ctx.expression().getText();
                //Verificamos que no existan errores en la expresion para poder castear
                if(! (e instanceof Expression)){
                    return "ERROR";
                
                }
                Expression e1 = (Expression)e;
                Constraint c = new Constraint(name,Constraint.CHECK,e1,tableCreate.name,expr);
                return c;
                
            
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
            //Verificamos si hay una DB en uso
            if(DBMS.currentDB==null){
                Frame.jTextArea2.setText("ERROR: No existe ninguna base de datos en uso. Utilice USE DATABASE <nombre> para utilizar una base de datos existente.");
                return "ERROR";
            
            }            
            String oldName = ctx.alterName().getText();
            String newName= ctx.newName().getText();
            Tabla t = Tabla.loadTable(oldName);
            if(t==null){
                Frame.jTextArea2.setText("ERROR: No se encuentra la tabla: "+oldName);
                return "ERROR";           
            
            }
            DBMetaData d = DBMS.metaData.findDB(DBMS.currentDB);
            TablaMetaData tm=d.findTable(oldName);
            tm.nombre=newName;
            t.renameTo(newName);
            DBMS.metaData.writeMetadata();
            Frame.jTextArea2.setText("Tabla: "+oldName+" renombrada a : '"+newName);
            return t;
            
            
	}
	@Override
	public Object visitAccionAlter(SQLParser.AccionAlterContext ctx) {
            return super.visitAccionAlter(ctx);
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
            if(ctx.children.size()==1){
                return visit(ctx.compareExpr());
            
            }
            else{
                return visit(ctx.expression());
            }
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
            //1. Especificar el directorio donde se debe ir a buscar el archivo de metadata
            String currentDir = System.getProperty("user.dir");
            System.out.println(currentDir);
            //2. Abrir el archivo de metadata
            File directorio  = new File(currentDir+"/DBMS/master.dat");
            BufferedReader reader = null;
            String [] nombres = null;
            int indiceDosPuntos = 0;
            ArrayList<String> nombresDB = new ArrayList<String>();
            //3. Leer el archivo de metadata 
            try{
                reader = new BufferedReader(new FileReader(directorio));
                String text = null;
                while ((text = reader.readLine()) != null) {
                    nombres = text.split(" ");
                    indiceDosPuntos = java.util.Arrays.asList(nombres).indexOf("Datos:");
                    if(indiceDosPuntos>0)
                    {
                        //4. Pasar cada dato referente al nombre de las bases de datos creadas
                        nombresDB.add(nombres[indiceDosPuntos+1]);
                    }
                    indiceDosPuntos = 0;
                    
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            //5. Mostrar el string creado
            for(int i = 0; i< nombresDB.size(); i++)
            {
                System.out.println(nombresDB.get(i));
            }
            /*Prueba para mostrar las bases de datos*/
            ArrayList<String> tituloColumnas = new ArrayList<String>();
            tituloColumnas.add("Databases: ");
            ArrayList<ArrayList<String>> filas = new ArrayList<ArrayList<String>>();
            for(int i = 0; i< nombresDB.size(); i++)
            {
                ArrayList<String> tempFila = new ArrayList<String>();
                tempFila.add(nombresDB.get(i));
                filas.add(tempFila);
            }
           Resultados results = new Resultados(tituloColumnas, filas);
            return super.visitShowDbStmt(ctx);
	}

	@Override
	public Object visitDropTableStmt(SQLParser.DropTableStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDropTableStmt(ctx);
	}

	@Override
	public Object visitAndexpr(SQLParser.AndexprContext ctx) {
            if(ctx.children.size()==1){
                return visit(ctx.factor());
            
            }
            else{
                Object l =  visit(ctx.andexpr());
                Object r=  visit(ctx.factor());
                if((l instanceof Expression)&&(r instanceof Expression)){
                    Expression l1 = (Expression)l;
                    Expression r1 = (Expression) r;
                    AndExpression e = new AndExpression(l1,r1);
                    return e;
                }
                else{
                    return "ERROR";
                }
            }
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
            //1. Especificar el directorio donde se debe ir a buscar el archivo de metadata
            String currentDir = System.getProperty("user.dir");
            System.out.println(currentDir);
            //2. Abrir el archivo de metadata
            File directorio  = new File(currentDir+"/DBMS/master.dat");
            BufferedReader reader = null;
            String [] nombres = null;
            int indiceDosPuntos = 0;
            ArrayList<String> nombresDB = new ArrayList<String>();
            //3. Leer el archivo de metadata 
            try{
                reader = new BufferedReader(new FileReader(directorio));
                String text = null;
                while ((text = reader.readLine()) != null) {
                    nombres = text.split(" ");
                    indiceDosPuntos = java.util.Arrays.asList(nombres).indexOf("Datos:");
                    if(indiceDosPuntos>0)
                    {
                        //4. Pasar cada dato referente al nombre de las bases de datos creadas
                        nombresDB.add(nombres[indiceDosPuntos+1]);
                    }
                    indiceDosPuntos = 0;
                    
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            //5. Mostrar el string creado
            String dbname = ctx.ID().getText();
            boolean existsDb = false;
            for(int i = 0; i< nombresDB.size(); i++)
            {
               if(dbname.equals(nombresDB.get(i)))
               {
                   existsDb = true;
                   break;
               }
            }
            if(existsDb)
            {
                DBMS.currentDB = dbname;
                System.out.println("Si existe la base de datos");
            }
            else
            {
                Frame.jTextArea2.setText("ERROR: No existe la base de datos: "+dbname);
                return "ERROR";
            }
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
            String op = ctx.rel_op().getText();
            if(!op.equals("=")&&!op.equals("<>")&&!op.equals(">")&&!op.equals("<")&&!op.equals(">=")&&!op.equals("<=")){
                Frame.jTextArea2.setText("Error, operando invalido en expresion: "+op);
                return "ERROR";
            }
            else{
                Object l = visit(ctx.term(0));
                Object r = visit(ctx.term(1));
                if((l instanceof Term)&& (r instanceof Term)){
                    Term l1 = (Term) l;
                    Term r1 = (Term)r;
                
                

                    //Verificamos los tipos
                    if(l1.type == Term.INT_TYPE && r1.type== Term.CHAR_TYPE ){
                        Frame.jTextArea2.setText("Error, Tipos invalidos en comparacion: 'INT' , 'CHAR'");
                        return "ERROR";                   
                    }
                    if(l1.type == Term.INT_TYPE && r1.type == Term.DATE_TYPE ){
                        Frame.jTextArea2.setText("Error, Tipos invalidos en comparacion: 'INT' , 'Date'");
                        return "ERROR";                   
                    }                
                    if(l1.type == Term.CHAR_TYPE && r1.type == Term.INT_TYPE ){
                        Frame.jTextArea2.setText("Error, Tipos invalidos en comparacion: 'CHAR' , 'INT'");
                        return "ERROR";                   
                    }
                    if(l1.type == Term.DATE_TYPE && r1.type == Term.INT_TYPE ){
                        Frame.jTextArea2.setText("Error, Tipos invalidos en comparacion: 'Date' , 'INT'");
                        return "ERROR";                   
                    }                 
                    if(l1.type == Term.FLOAT_TYPE && r1.type == Term.CHAR_TYPE ){
                        Frame.jTextArea2.setText("Error, Tipos invalidos en comparacion: 'INT' , 'CHAR'");
                        return "ERROR";                   
                    }
                    if(l1.type == Term.FLOAT_TYPE && r1.type== Term.DATE_TYPE ){
                        Frame.jTextArea2.setText("Error, Tipos invalidos en comparacion: 'INT' , 'Date'");
                        return "ERROR";                   
                    }                
                    if(l1.type == Term.CHAR_TYPE && r1.type == Term.FLOAT_TYPE ){
                        Frame.jTextArea2.setText("Error, Tipos invalidos en comparacion: 'CHAR' , 'INT'");
                        return "ERROR";                   
                    }
                    if(l1.type == Term.DATE_TYPE && r1.type == Term.FLOAT_TYPE ){
                        Frame.jTextArea2.setText("Error, Tipos invalidos en comparacion: 'Date' , 'INT'");
                        return "ERROR";                   
                    }               

                    CompareExpression e = new CompareExpression(l1,r1,op);
                    return e;
                    
                }
                 else{
                    return "ERROR";
                }
            }

            
            
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
            if(ctx.children.size()== 1){
                return visit(ctx.primary());
            
            }
            else{
                Object l =  visit(ctx.primary());
                if((l instanceof Expression)){
                    Expression l1 = (Expression)l;
                    NotExpression e = new NotExpression(l1);
                    return e;
                }
                else{
                    return "ERROR";
                }
            }
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
            //Si es un int
            if(ctx.NUM()!=null){
                int a = Integer.parseInt(ctx.NUM().getText());
                Term t = new Term(a);
                return t;
            }
            else if(ctx.CHAR_VAL()!=null){
                String s = ctx.CHAR_VAL().getText();
                Term t = new Term(s);
                return t;
            }
            else if(ctx.FLOAT_VAL()!=null){
                float f = Float.parseFloat(ctx.FLOAT_VAL().getText());
                Term t = new Term(f);
                return t;
            }
            else if(ctx.DATE_VAL()!=null){
                String date = ctx.DATE_VAL().getText();
                date= date.substring(1);
                date = date.substring(0,date.length()-1);
                try{
                    LocalDate d = LocalDate.parse(date);
                    Term t = new Term(d);
                    return t;
                }
                catch(Exception e){
                     Frame.jTextArea2.setText("Error: Tipo Invalido de Fecha: "+ctx.DATE_VAL().getText());
                    return "ERROR";                      
                }
            }
            //Si es columna
            else{
                String colName = ctx.column().getText();
                //Buscamos la columna
                Columna c = this.findCol(colName, this.availableCols);
                if(c==null){
                    Frame.jTextArea2.setText("Error: No se encuentra la columna: "+colName);
                    return "ERROR";                     
                }
                Term t = new Term(c);
                return t;
            }
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
