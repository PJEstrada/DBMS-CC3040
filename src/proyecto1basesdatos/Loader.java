package proyecto1basesdatos;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import proyecto1basesdatos.SQLParser.OrderTermContext;

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
        Columna addedCol; //Columna que se acaba de agregar en add column
        TablaMetaData tableCreateMetaData;
        String createTableName;
        ArrayList<Columna> availableCols;
        ArrayList<Constraint> availableCons;
        static IteradorTabla iterador;
        ArrayList<Tabla> tablesInsert;
        ArrayList<Integer> regsInsert;
        public Loader(DBMS dbms){
            ArrayList<Tabla> tablesInsert = new ArrayList<Tabla>();
            this.dbms = dbms;
        
        }
        
        public void error(String s){
            Frame.jTextArea2.setText(s);
        }
        
        public Tabla productoCartesiano(ArrayList<Tabla> tablas){
            Tabla res = new Tabla();
            res.name = "temp";
            // Si solo hay una tabla devolvemos la nueva tabla temporal con las mismas tuplas y columnas
            if(tablas.size()==1){
                res.tuplas.addAll(tablas.get(0).tuplas);
                res.columnas.addAll(tablas.get(0).columnas);
                return res;
            }
            else if(tablas.size()==2){
                //Agregamos todas las columnas de la primera y segunda tabla
                res.columnas.addAll(tablas.get(0).columnas);
                res.columnas.addAll(tablas.get(1).columnas);
                // Combinamos todas las tuplas
                for(Tupla t1 :tablas.get(0).tuplas){
                    for(Tupla t2: tablas.get(1).tuplas){
                        Tupla nuevaTupla = new Tupla(res);
                        nuevaTupla.valores.addAll(t1.valores);
                        nuevaTupla.valores.addAll(t2.valores);
                        res.tuplas.add(nuevaTupla);
                    }
                }
                return res;
            }
            else if(tablas.size()>2){
                //Agregamos las columnas de las n tablas
                for(Tabla t:tablas){
                    res.columnas.addAll(t.columnas);
                }
                ArrayList<Tupla> tuplasResultantes = new ArrayList<Tupla>();
                // Combinamos todas las tuplas de las primeras dos tablas
                for(Tupla t1 :tablas.get(0).tuplas){
                    for(Tupla t2: tablas.get(1).tuplas){
                        Tupla nuevaTupla = new Tupla(res);
                        nuevaTupla.valores.addAll(t1.valores);
                        nuevaTupla.valores.addAll(t2.valores);
                        tuplasResultantes.add(nuevaTupla);
                    }
                }
                //Continuamos combinando con el resto de tablas
                for(int i =2; i<tablas.size();i++){
                    ArrayList<Tupla> tuplasActuales = new ArrayList<Tupla>();
                    tuplasActuales.addAll(tablas.get(i).tuplas);
                    ArrayList<Tupla> tuplasAnteriores = new ArrayList<Tupla>();
                    tuplasAnteriores.addAll(tuplasResultantes);
                    tuplasResultantes.clear();
                    for(Tupla t1: tuplasAnteriores){
                        for(Tupla t2: tuplasActuales){
                            Tupla nuevaTupla = new Tupla(res);
                            nuevaTupla.valores.addAll(t1.valores);
                            nuevaTupla.valores.addAll(t2.valores);
                            tuplasResultantes.add(nuevaTupla);
                        }

                  
                    
                    }
                }
                res.tuplas.addAll(tuplasResultantes);
                return res;
                
                
                
            
            }
            else{return null;}
        
        }
        public ArrayList<Constraint> obtenerReferenciasDe(String tableName){
            ArrayList<Constraint> res = new ArrayList<Constraint>();
            ArrayList<Constraint> cons = getAllForeignConstraints();
            for(Constraint c: cons){
                if(c.foreignTable.equalsIgnoreCase(tableName)){
                    res.add(c);
                }
            }
            return res;
        
        
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
        
        //Metodo
        public boolean foreignDeleted(Tabla t){
            boolean encontrada = true;
            ArrayList<Constraint> referencias = obtenerReferenciasDe(t.name);
            for(Constraint refCons: referencias){
                //Para cada referencias primero cargamos la tabla local de la referencia
                Tabla localTable = Tabla.loadTable(refCons.tabla);
               //Luego, para cada tupla de la tabla obtenemos las columnas locales y sus valores con localfkey
                for(Tupla tupla:localTable.tuplas){
                    ArrayList<Integer> indexBuscar = new ArrayList<Integer>();
                    ArrayList<Integer> indexT = new ArrayList<Integer>();
                    ArrayList<Object> valoresActuales = new ArrayList<Object>(); 
                    for(Columna col: refCons.localFkeys){
                        int index = localTable.getIndiceColumna(localTable.name);
                        indexBuscar.add(index);
                    }
                    for(int iv: indexBuscar){
                        valoresActuales.add(tupla.valores.get(iv));
                    
                    }
                    for(Columna c2: refCons.refKeys){
                        int index2 = t.getIndiceColumna(c2.nombre);
                        indexT.add(index2);
                    
                    }
                      // Revisamos si los valores de la tupla actual existen en los valores de la tabla de referencia (i.e la mencionada en UPDATE tableName) 
                    encontrada = t.contieneValor(valoresActuales, indexT);
                    if(!encontrada)
                        return encontrada;
                }
            } 
            return encontrada;
        }
        
        //Metodo que regresa todas las constraints de las tablas en la base de datos actual
        public ArrayList<Constraint> getAllForeignConstraints(){
             ArrayList<Constraint> result = new ArrayList<Constraint>();
             DBMetaData d = DBMS.metaData.findDB(DBMS.currentDB);
             for(TablaMetaData t: d.tablas){
                ArrayList<Constraint> c = Tabla.loadConstraints(t.nombre);
                for(Constraint c1: c){
                    if(c1.tipo==Constraint.FK){
                        result.add(c1);
                    }
                }
             }
             return result;
        }
        public Constraint hayReferencia(String colName, String tableName, ArrayList<Constraint> cons){
            for(Constraint c: cons){
                if(c.foreignTable.equalsIgnoreCase(tableName)){
                    for(Columna col: c.refKeys){
                        if(col.nombre.equalsIgnoreCase(colName)){
                            return c;
                        }
                    }
                
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
        public Constraint findConstraint(String c, ArrayList<Constraint> cons){
            for(Constraint c1: cons){
                if(c.equalsIgnoreCase(c1.nombre)/*&& c.tipo==c1.tipo*/){
                    return c1;
                }
            }
            return null;
        
        }        
        public boolean findConstraint(Constraint c, ArrayList<Constraint> cons){
            for(Constraint c1: cons){
                if(c.nombre.equalsIgnoreCase(c1.nombre)/*&& c.tipo==c1.tipo*/){
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
                    Debug.agregar("ERROR: no se encuentra la base de datos: "+name);
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("ERROR: no se encuentra la base de datos: "+name);
                    }

                    
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
                    Debug.agregar("\n Base de datos "+name+" creada exitosamente." );
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("\n Base de datos "+name+" creada exitosamente.");
                    }                    
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
                Debug.agregar("ERROR: No existe ninguna base de datos en uso. Utilice USE DATABASE <nombre> para utilizar una base de datos existente.");
                if(!Frame.useVerbose){
                    Frame.jTextArea2.setText("ERROR: No existe ninguna base de datos en uso. Utilice USE DATABASE <nombre> para utilizar una base de datos existente.");
                }                    
                return "ERROR";
            
            }
            else{         
                //Buscamos si la tabla ya existe en la metaData     
                DBMetaData d = DBMS.metaData.findDB(DBMS.currentDB);
           
                Debug.agregar("Revisando existencia de la tabla...");
                
                for(TablaMetaData t:d.tablas){
                    if(t.nombre.equalsIgnoreCase(name)){
                       Frame.jTextArea2.setText("ERROR: Ya existe la tabla: "+name);
                       return "ERROR";                       
              
                    }
                }
                //Guardamos las columnas
                Debug.agregar("Verificando Columnas Declaradas...");
                ArrayList<Columna> cols = new ArrayList<Columna>();
                for(ParseTree n: ctx.columnDecl()){
                    Columna c = (Columna) visit(n);
                    Columna yaExiste = findCol(c.nombre,cols);
                    if(yaExiste == null){
                        cols.add(c);
                        availableCols.add(c);
                    }
                    else{
                        Debug.agregar("ERROR: La columna: <<"+c.nombre+">> Fue especificada mas de una vez");
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: La columna: <<"+c.nombre+">> Fue especificada mas de una vez");
                        }                           

                        
                       return "ERROR";                         
                    }

                }
                //Guardamos las columnas para constraints
                this.colsCreate=cols;
                // Si hay constraints las agregamos
                int test = ctx.colConstraint().size();
                ArrayList<Constraint> cons = new ArrayList<Constraint>();
                availableCons = cons;
                if(test!=0){
               
                  Debug.agregar("Agregando Restricciones...");
                
                   for(ParseTree n: ctx.colConstraint()){
                       Object c = visit(n);
                       if(!(c instanceof Constraint)){
                           return "ERROR"; 
                       }
                       else{
                           Constraint con =(Constraint)c;
                           //Revisamos que las no existan dos primary keys en la creacion
                           
                           
                           cons.add(con);
                       }
                   } 
                    //Creamos la tabla y la serializamos 
                    t1 = new Tabla(name,cols,cons);
                    Debug.agregar("Tabla '"+name+ "' Creada existosamente.");
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("Tabla '"+name+ "' Creada existosamente.");
                    }                      

                    
                    return t1;                    
                }
                else{
                    //Creamos la tabla y la serializamos 
                    t1 = new Tabla(name,cols);
                    Debug.agregar("Tabla '"+name+ "' Creada existosamente.");
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("Tabla '"+name+ "' Creada existosamente.");
                    }   
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
                        Debug.agregar("ERROR: No es posible declarar dos primary keys. En la tabla: "+tableCreate.name);
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: No es posible declarar dos primary keys. En la tabla: "+tableCreate.name);
                        }                                           
                        return "ERROR";                    
                }
                
                
                //Revisando que existan los nombre de las columnas
                ArrayList<Columna> pkCols = new ArrayList<Columna>();
                
                ArrayList<Integer> colIndices = new ArrayList<Integer>();
                for(ParseTree n:ctx.localids()){
                    String text = n.getText();
                    Columna encontrada = findCol(text,colsCreate);
                    
                    if(encontrada==null){
                        Debug.agregar("ERROR: No se encuentra la columna: "+text+" En la tabla: "+tableCreate.name);
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: No se encuentra la columna: "+text+" En la tabla: "+tableCreate.name);
                        }                          
                        return "ERROR";
                    }
                    else{
                        int ind = tableCreate.getIndiceColumna(encontrada.nombre);
                        colIndices.add(ind);
                        pkCols.add(encontrada);
                    
                    }
                }
                boolean hayNulos = tableCreate.hasNullValues(colIndices);
                if(hayNulos){
                    Debug.agregar("ERROR: La constraint: <<"+name+">> no puede agregarse porque existen tuplas nulas para la llave primaria.");
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("ERROR: La constraint: <<"+name+">> no puede agregarse porque existen tuplas nulas para la llave primaria.");
                    }                        
                    return "ERROR";
                }                
                // Verificamos que no existan valores duplicados o nulos para las tuplas actuales
                boolean duplicados = tableCreate.revisarDuplicados(colIndices);
                if(duplicados){
                    Debug.agregar("ERROR: La constraint: <<"+name+">> no puede agregarse porque existen tuplas duplicadas para la llave primaria.");
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("ERROR: La constraint: <<"+name+">> no puede agregarse porque existen tuplas duplicadas para la llave primaria.");
                    }      
                    return "ERROR";
                }

                //Creamos constraint
                Constraint c = new Constraint(name,Constraint.PK,pkCols,tableCreate.name);
                //Verificamos que no exista una constraint del mismo tipo con el mismo nombre
                boolean existeConstraint = findConstraint(c,this.availableCons);
                if(existeConstraint){
                    Debug.agregar("ERROR: La constraint  "+c.nombre+" Ya fue declarada "+tableCreate.name);
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("ERROR: La constraint  "+c.nombre+" Ya fue declarada "+tableCreate.name);
                    }                     
                        return "ERROR";               
                }
                return c;
                
            }
            else if(ctx.FOREIGN()!=null){ // Si es foreign key
                String name = ctx.fkNombre().getText();
                //Revisando que existan los nombre de las columnas en la tabla local
                ArrayList<Columna> localCols = new ArrayList<Columna>();
                ArrayList<Integer> localIndexes = new ArrayList<Integer>();
                for(ParseTree n:ctx.localids()){
                    String text = n.getText();
                    Columna encontrada = findCol(text,colsCreate);
                    
                    if(encontrada==null){
                        Debug.agregar("ERROR: No se encuentra la columna: "+text+" En la tabla: "+tableCreate.name);
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: No se encuentra la columna: "+text+" En la tabla: "+tableCreate.name);
                        }                                  
                       
                        return "ERROR";
                    }
                    else{
                        localCols.add(encontrada);
                        int in = tableCreate.getIndiceColumna(encontrada.nombre);
                        localIndexes.add(in);
                    }
                }
                //Obteniendo la tabla que referencia
                String refTable = ctx.idTabla().getText();

                DBMetaData bd = DBMS.metaData.findDB(DBMS.currentDB);
                TablaMetaData t = bd.findTable(refTable);

                
                if(t==null){
                        Debug.agregar("ERROR: No se encuentra la tabla de referencia: "+refTable);
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: No se encuentra la tabla de referencia: "+refTable);
                        }                           
                        return "ERROR";                   
                }
                
                
                //Si encontramos la tabla procedemos a buscar las columnas
                else{
                    Tabla tablaRef = Tabla.loadTable(refTable);
                    ArrayList<Constraint> foreignConstraints = Tabla.loadConstraints(refTable);
                    ArrayList<Columna> fkCols = new ArrayList<Columna>();
                    ArrayList<Integer> fkIndexes = new ArrayList<Integer>();
                    ArrayList<Columna> cols = Tabla.loadColums(refTable);
                    //Buscamos las columnas de la primary key de la tabla foranea
                    ArrayList<Columna> columnasPrimary = new ArrayList<Columna>();
                    for(Constraint c1: foreignConstraints){
                        if(c1.tipo == Constraint.PK){
                            columnasPrimary.addAll(c1.colsPkeys);
                        }
                    
                    }
                    if(cols==null){
                        Debug.agregar("ERROR: No se encuentra la tabla de referencia: "+refTable);
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: No se encuentra la tabla de referencia: "+refTable);
                        }                          
                        return "ERROR";                   
                    }
                    
                    for(ParseTree n:ctx.refids()){
                        String text = n.getText();
                        //Buscamos las columnas de la tabla
                        
                        if(cols==null){
                            Debug.agregar("ERROR: No se encuentra archivo de columnas para la tabla: "+refTable);
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: No se encuentra archivo de columnas para la tabla: "+refTable);
                            }                                   
                            return "ERROR";                            
                        }
                        Columna encontrada = findCol(text,cols);

                        if(encontrada==null){
                            Debug.agregar("ERROR: No se encuentra la columna: "+text+" En la tabla: "+tableCreate.name);
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: No se encuentra la columna: "+text+" En la tabla: "+tableCreate.name);
                            }                             
                            return "ERROR";
                        }
                        
                        else{
                            //Si encontramos la columna, verificamos que la columna pertenezca al primary key de la tabla externa para garantizar que la llave sea unica
                            
                            Columna encontrada2 = findCol(encontrada.nombre,columnasPrimary);
                            if(encontrada2==null){
                                Debug.agregar("ERROR: No se puede crear la llave foranea. La columna de referecia: "+encontrada.nombre+" No es unica ");
                                if(!Frame.useVerbose){
                                    Frame.jTextArea2.setText("ERROR: No se puede crear la llave foranea. La columna de referecia: "+encontrada.nombre+" No es unica ");
                                }                                    
                                return "ERROR";
                            }                           
                            //Agregamos la columna 
                            fkCols.add(encontrada);
                            int in = tablaRef.getIndiceColumna(encontrada.nombre);
                            fkIndexes.add(in);

                        }
                    }
                    
                    //Una vez obtenidos los dos arreglos de columnas verificamos que tengan el mismo tamaño
                    if(fkCols.size()!=localCols.size()){
                        Debug.agregar("ERROR: El numero de columnas locales y remotas en la foregin key debe ser el mismo");
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: El numero de columnas locales y remotas en la foregin key debe ser el mismo");
                        }                         

                        return "ERROR";
                    }
                    //Si los arreglos son iguales verificamos que tengan los mismos tipo
                    for(int i =0;i<localCols.size();i++){
                        Columna local = localCols.get(i);
                        Columna foreign = fkCols.get(i);
                        if(local.tipo!=foreign.tipo){
                            Debug.agregar("ERROR: las columnas: '"+local.nombre+", "+foreign.nombre+"' Deben tener el mismo tipo");
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: las columnas: '"+local.nombre+", "+foreign.nombre+"' Deben tener el mismo tipo");
                            }                                  
                            return "ERROR";                       
                        
                        }
                    }
                    //Para cada tupla de la tabla local verificamos que los valores existan en la tabla de referencia
                    for(Tupla tupla: tableCreate.tuplas){
                        //Obtenemos los valores de la tupla actual
                        ArrayList<Object> currValues = new ArrayList<Object>();
                        for(int i : localIndexes){
                            Object valor = tupla.valores.get(i);
                            currValues.add(valor);
                        }
                        //Revisamos si los valores actuales existen en la tabla de referencia
                        boolean existenValores = tablaRef.contieneValor(currValues, fkIndexes);
                        if(!existenValores){
                            Debug.agregar("ERROR: no se puede crear la restriccion <<"+name+">> porque los valores de las tuplas no existen en la tabla de referencia.");
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: no se puede crear la restriccion <<"+name+">> porque los valores de las tuplas no existen en la tabla de referencia.");
                            }                              
                            return "ERROR";
                        }
                    
                    }
                    //Si todas las columnas tienen los mismo tipos, procedemos a crear la constraint
                    Constraint c = new Constraint(name,Constraint.FK,localCols,fkCols,refTable,this.tableCreate.name);
                    //Verificamos que no exista una constraint del mismo tipo con el mismo nombre
                    boolean existeConstraint = findConstraint(c,this.availableCons);
                    if(existeConstraint){
                            Debug.agregar("ERROR: La constraint  "+c.nombre+" Ya fue declarada "+tableCreate.name);
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: La constraint  "+c.nombre+" Ya fue declarada "+tableCreate.name);
                            }                           

                            return "ERROR";               
                    }                   
                    
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
                //Verificamos que las tuplas actuales de la tabla cumplan con la restriccion
                Tabla temp = new Tabla();
                temp.name = tableCreate.name;
                temp.columnas.addAll(tableCreate.columnas);
                temp.tuplas.addAll(tableCreate.tuplas);
                Loader.iterador = new IteradorTabla(temp,0);
                for(int i =0; i<Loader.iterador.tabla.tuplas.size();i++){
                    try {
                    if(!e1.isTrue()){
                        Debug.agregar("ERROR: no se puede insertar constraint <<"+name+">> porque algunas tuplas no cumplen con la restriccion.");
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: no se puede insertar constraint <<"+name+">> porque algunas tuplas no cumplen con la restriccion.");
                        }                           
                        return "ERROR";                                    
                    }
                    } catch (Exception ex) {
                        Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
                    }    
                }                
                
                Constraint c = new Constraint(name,Constraint.CHECK,e1,tableCreate.name,expr);
                //Verificamos que no exista una constraint del mismo tipo con el mismo nombre
                boolean existeConstraint = findConstraint(c,this.availableCons);
                if(existeConstraint){
                        Debug.agregar("ERROR: La constraint  "+c.nombre+" Ya fue declarada "+tableCreate.name);
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: La constraint  "+c.nombre+" Ya fue declarada "+tableCreate.name);
                        }                     
                        return "ERROR";               
                }                  
                return c;
                
            
            }
            return "ERROR";
	}        
	@Override
	public Object visitColumnDecl(SQLParser.ColumnDeclContext ctx) {
            //Creamos la columan dependiendo del tipo
            String name = ctx.colName().getText();
            int colType = 0;
            Columna c = new Columna(null,0,0,tableCreate.name);
            if(ctx.tipo().CHAR()!=null){
                colType = Columna.CHAR_TYPE;
                int size = Integer.parseInt(ctx.tipo().NUM().getText());
                c = new Columna(name,colType,size,this.tableCreate.name);
            }
            else if(ctx.tipo().INT()!=null){
                colType = Columna.INT_TYPE;
                c = new Columna(name,colType,this.tableCreate.name);
            
            }
            else if(ctx.tipo().FLOAT()!=null){
                colType =Columna.FLOAT_TYPE;
                c = new Columna(name,colType,this.tableCreate.name);
            }
            else if(ctx.tipo().DATE()!=null){
                colType = Columna.DATE_TYPE;
                c = new Columna(name,colType,this.tableCreate.name);
            
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
            String dbActual = DBMS.currentDB;
            //ArraysList para crear el resultado a mostrar
            ArrayList<String> tablesHere = DBMS.metaData.allTable(dbActual);
            ArrayList<String> encabezado = new ArrayList<String>();
            ArrayList<ArrayList<String>> filas = new ArrayList<ArrayList<String>>();
            
            //Se recorre el arraylist obtenido del metodo para preparar las filas
            encabezado.add("Tables in "+dbActual);
            for(int i = 0; i<tablesHere.size(); i++){
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(tablesHere.get(i));
                filas.add(temp);
            }
            Resultados results = new Resultados(encabezado, filas);
            for(Component i: Frame.forResults.getComponents()){
                Frame.forResults.remove(i);
            }
            Frame.forResults.add(results);
            Frame.forResults.revalidate();
            Frame.forResults.repaint();
            return super.visitShowTableStmt(ctx);
	}

	@Override
	public Object visitShowColumnsStmt(SQLParser.ShowColumnsStmtContext ctx) {
            String nameTable = ctx.ID().getText();
            //Se carga la metadata de la tabla que se desea mostrar
            DBMetaData d = DBMS.metaData.findDB(DBMS.currentDB);
            TablaMetaData tm=d.findTable(nameTable);
            if(tm == null){
                Frame.jTextArea2.setText("ERROR: La tabla  "+nameTable+" no existe dentro de "+DBMS.currentDB);
                return "ERROR";   
            }
            ArrayList<String> titulos1 = new ArrayList<String>();
            ArrayList<String> titulos2 = new ArrayList<String>();
            ArrayList<ArrayList<String>> filas1 = new ArrayList();
            ArrayList<ArrayList<String>> filas2 = new ArrayList();
            //se carga los titulos para la primera tabla
            titulos1.add("Column Name");
            titulos1.add("Column Type");
            titulos2.add("Constraint Name");
            titulos2.add("Constraint Type");
            titulos2.add("Constraint Description");
            //se cargan las filas para las columnas que se desean mostrar
            for (ColumnMetaData columna : tm.columnas) {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(columna.nombre);
                temp.add(columna.tipo);
                filas1.add(temp);
            }
            //Se cargan las filas para los contraints
            for(ConstraintMetaData constraint: tm.constraints){
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(constraint.nombre);
                temp.add(constraint.tipo);
                temp.add(constraint.decripcion);
                filas2.add(temp);
            }
            Resultados result = new Resultados(titulos1,filas1,titulos2,filas2);
            for(Component i: Frame.forResults.getComponents()){
                Frame.forResults.remove(i);
            }
            
            Frame.forResults.add(result);
            Frame.forResults.revalidate();
            Frame.forResults.repaint();
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
           
            Debug.agregar("Buscando la base de datos en uso");
            
            if(DBMS.currentDB==null){
                Debug.agregar("ERROR: No existe ninguna base de datos en uso. Utilice USE DATABASE <nombre> para utilizar una base de datos existente.");
                if(!Frame.useVerbose){
                    Frame.jTextArea2.setText("ERROR: No existe ninguna base de datos en uso. Utilice USE DATABASE <nombre> para utilizar una base de datos existente.");
                }                 
                return "ERROR";
            
            }            
            String oldName = ctx.alterName().getText();
            String newName= ctx.newName().getText();

            Debug.agregar("Buscando la tabla");
            
            Tabla t = Tabla.loadTable(oldName);
            if(t==null){
                Debug.agregar("ERROR: No se encuentra la tabla: "+oldName);
                if(!Frame.useVerbose){
                    Frame.jTextArea2.setText("ERROR: No se encuentra la tabla: "+oldName);
                }                 
                return "ERROR";           
            
            }
            
            Debug.agregar("Alterando la metadata...");
                    
            DBMetaData d = DBMS.metaData.findDB(DBMS.currentDB);
            TablaMetaData tm=d.findTable(oldName);
            tm.nombre=newName;
            t.renameTo(newName);
            DBMS.metaData.writeMetadata();
            DBMS.guardar();
                Debug.agregar("Tabla: "+oldName+" renombrada a : '"+newName);
                if(!Frame.useVerbose){
                    Frame.jTextArea2.setText("Tabla: "+oldName+" renombrada a : '"+newName);
                }          
            return t;
            
            
	}
	@Override
	public Object visitAccionAlter(SQLParser.AccionAlterContext ctx) {
            
                Debug.agregar("Buscando la base de datos en uso");
                    
            if(DBMS.currentDB==null){
              Debug.agregar("ERROR: No existe ninguna base de datos en uso. Utilice USE DATABASE <nombre> para utilizar una base de datos existente.");
                if(!Frame.useVerbose){
                    Frame.jTextArea2.setText("ERROR: No existe ninguna base de datos en uso. Utilice USE DATABASE <nombre> para utilizar una base de datos existente.");
                } 
                return "ERROR";
            
            }  
            String tableName = ctx.alterName().getText();
            this.tableCreate = Tabla.loadTable(tableName);
            DBMetaData d = DBMS.metaData.findDB(DBMS.currentDB);
            TablaMetaData t = d.findTable(tableName);
            this.tableCreateMetaData =t;
            if(tableCreate == null){
                Debug.agregar("ERROR: No se encuentra la tabla: "+tableName);
                if(!Frame.useVerbose){
                    Frame.jTextArea2.setText("ERROR: No se encuentra la tabla: "+tableName);
                }            
                return "ERROR";               
            }
            for(ParseTree n: ctx.accion()){
                Object accion = visit(n);
                if(accion instanceof String){
                    return "ERROR";
                }
            }
            //Guardamos la tabla con los nuevos cambios
            
            Debug.agregar("Alterando la metadata...");
                        
            tableCreate.guardarTabla();
            DBMS.metaData.writeMetadata();
            DBMS.guardar();
              Debug.agregar("Tabla alterada correctamente. Se realizaron: "+ctx.accion().size()+" alteraciones-");
                if(!Frame.useVerbose){
                    Frame.jTextArea2.setText("Tabla alterada correctamente. Se realizaron: "+ctx.accion().size()+" alteraciones-");
                }            
            return true;
	}

 	@Override
	public Object visitAccion(SQLParser.AccionContext ctx) {
            
//Si es add Column
            this.availableCons = tableCreate.constraints;
            this.availableCols = tableCreate.columnas;
            this.colsCreate = tableCreate.columnas;            
            if(ctx.ADD()!=null && ctx.COLUMN()!=null){
                String colName = ctx.columnName().getText();
                Object tipo = visit(ctx.tipo());
                
                if(tipo instanceof String){
                    Debug.agregar("ERROR: tipo invalido al agregar columna");
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("ERROR: tipo invalido al agregar columna");
                    }                      
                    return "ERROR";
                }
                int tipo1 = (Integer) tipo;

                Debug.agregar("Verificando existencia de nueva columna");
                
                Columna yaExiste = findCol(colName,this.tableCreate.columnas);
                if(yaExiste!=null){
                    Debug.agregar("ERROR: La columna: <<"+colName+">> Fue especificada mas de una vez");
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("ERROR: La columna: <<"+colName+">> Fue especificada mas de una vez");
                    }                       

                    return "ERROR";                         
                }
                // Creando la columna
                Columna c;

                Debug.agregar("Creando la columna...");
                                 
                if(tipo1==Columna.CHAR_TYPE){
                    int size = Integer.parseInt(ctx.tipo().NUM().getText());
                     c = new Columna(colName,tipo1,size,tableCreate.name);
                     this.addedCol=c;
                }
                else{
                     c = new Columna (colName,tipo1,tableCreate.name);
                     this.addedCol=c;
                }
                
                //Verificando si existen contratins
                ArrayList<Constraint> nuevasConstraints = new ArrayList<Constraint>();
                if(ctx.singleColConstraint()!=null){
                    // Asignando las constraints creadas a las disponibles para verificar cosntraints duplicadas
                    
                    Debug.agregar("Agregando restricciones de columna...");
                      
                    this.colsCreate.add(c); //Agregamos la nueva columna
                    this.availableCols= this.colsCreate; // Agregamos a columnas disponibles para el caso en que haya un CHECK ( expression) con un term como columna
                    for(ParseTree n: ctx.singleColConstraint()){
                        Object cons = visit(n);
                        if(!(cons instanceof Constraint)){
                            return "ERROR";
                        }
                        Constraint cons1 = (Constraint)cons;
                        nuevasConstraints.add(cons1);
                        
                    
                    }
                    // Verificamos si alguna constraint es primary key y si hay alguna tupla, no permitimos agregar la columna porque habran valores nulos en una pk
                    for(Constraint cs: nuevasConstraints){
                        if(cs.tipo==Constraint.PK && this.tableCreate.tuplas.size()>0){
                            Debug.agregar("ERROR: no se puede insertar primary key : <<"+cs.nombre+">> porque se crearan valores nulos en la tabla ");
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: no se puede insertar primary key : <<"+cs.nombre+">> porque se crearan valores nulos en la tabla ");
                            }                             
                        }
                        if(cs.tipo==Constraint.CHECK){
                            Tabla temp = new Tabla();
                            temp.name = tableCreate.name;
                            temp.columnas.addAll(tableCreate.columnas);
                            temp.tuplas.addAll(tableCreate.tuplas);
                            Loader.iterador = new IteradorTabla(temp,0);
                            for(int i =0; i<Loader.iterador.tabla.tuplas.size();i++){
                                try {
                                if(cs.expr.isTrue() == null || !cs.expr.isTrue()){
                                    Debug.agregar("ERROR: no se puede insertar constraint <<"+cs.nombre+">> porque algunas tuplas no cumplen con la restriccion.");
                                    if(!Frame.useVerbose){
                                        Frame.jTextArea2.setText("ERROR: no se puede insertar constraint <<"+cs.nombre+">> porque algunas tuplas no cumplen con la restriccion.");
                                    }                                       

                                    return "ERROR";                                    
                                }
                                } catch (Exception ex) {
                                    Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
                                }    
                            }

                        }                           
                            
                    }
                    
                    
                    
                    
                    /*
                     si ya hay tuplas en la tabla y no habia PK, se agrega a cada tupla el valor nulo
                    */
                    ArrayList<Tupla> tuplas = this.tableCreate.tuplas;
                    for(Tupla fila: tuplas){
                        fila.valores.add(null);  
                    }
                    
                    // Agregamos la nueva columna a la metaData
                    ColumnMetaData cm= new ColumnMetaData(c.nombre,c.getStringType(c.tipo));
                    this.tableCreateMetaData.columnas.add(cm);
                    //Agregamos las nuevas constraints a la tabla
                    this.tableCreate.constraints.addAll(nuevasConstraints);
                    //Agregamos las nuevas constraints a la metaData
                    for(Constraint cons: nuevasConstraints){
                        ConstraintMetaData consm = new ConstraintMetaData(cons.nombre,cons.getStringType(cons.tipo),cons.toString());
                        tableCreateMetaData.constraints.add(consm);
                    }
                    return true;
                }
            }
            // Si es add constraint
            else if (ctx.ADD()!= null && ctx.CONSTRAINT()!= null){
                Object c = visit(ctx.colConstraint());
                if(!(c instanceof Constraint)){
                    return "ERROR";
                    
                }

                Debug.agregar("Agregando restricciones...");
                                  
                Constraint c1 = (Constraint)c;
                ConstraintMetaData cmt = new ConstraintMetaData(c1.nombre,c1.getStringType(c1.tipo),c1.toString());
                tableCreate.constraints.add(c1); 
                this.tableCreateMetaData.constraints.add(cmt);
                return true;
            }
            // Si es drop column
            else if(ctx.DROP()!= null && ctx.COLUMN()!= null){
                String colName = ctx.columnName().getText();
                //Verificamos que la columna exista 
                
                Debug.agregar("Buscando restriccion para eliminar...");
                               
                Columna yaExiste = findCol(colName,this.tableCreate.columnas);
                if(yaExiste==null){
                    Debug.agregar("ERROR: no se encuentra la columna <<"+colName+">> en la tabla: "+tableCreate.columnas);
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("ERROR: no se encuentra la columna <<"+colName+">> en la tabla: "+tableCreate.columnas);
                    }                      
                    return "ERROR";
                }
                
                //Revisar que no existan referencias en llaves foraneas de otras tablas
         
                Debug.agregar("Verificando referencias en otras tablas");
                                   
                ArrayList<Constraint> allForeignConstraints = getAllForeignConstraints();
                Constraint hayReferencia = hayReferencia(colName,tableCreate.name,allForeignConstraints);
                if(hayReferencia !=null){
                    Debug.agregar("ERROR: No se puede eliminar <<"+colName+">> porque existe la referencia <<"+hayReferencia.nombre+">> en la tabla: "+hayReferencia.tabla);
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("ERROR: No se puede eliminar <<"+colName+">> porque existe la referencia <<"+hayReferencia.nombre+">> en la tabla: "+hayReferencia.tabla);
                    }                      
                    return "ERROR";
                } 
                //Veriicamos si la tabla tiene un primary key con la columna especificada y si existe eliminamos la llave
                Constraint consPK = tableCreate.containsPKWithColumn(yaExiste);
                if(consPK!=null){
                    tableCreate.eliminarConstraint(consPK.nombre);
                
                }
                
                //Elimnamos la columna correspondiente a la fila en cada tupla y la columna como atributo de la tabla y del metadata
                tableCreate.eliminarColumna(yaExiste);
                return true;
            }
            // si es drop constraint
            else if(ctx.DROP()!= null && ctx.CONSTRAINT()!= null){
                String consName = ctx.ID().getText();
                Constraint yaExiste = this.findConstraint(consName, tableCreate.constraints);
                if(yaExiste==null){
                    Debug.agregar("ERROR: no se encuentra la constraint <<"+consName+">> en la tabla: "+tableCreate.columnas);
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("ERROR: no se encuentra la constraint <<"+consName+">> en la tabla: "+tableCreate.columnas);
                    }                     

                    return "ERROR";               
                }
                
                 Debug.agregar("Verificando referencias en otras tablas");
                                  
                //Si la constraint es primary key, revisamo referencias a otras tablas de las columnas de la pk
                if(yaExiste.tipo == Constraint.PK){
                    ArrayList<Columna> columnas = yaExiste.colsPkeys;
                    ArrayList<Constraint> allForeignConstraints = getAllForeignConstraints();
                    for(Columna col1: columnas){
                        Constraint hayReferencia = hayReferencia(col1.nombre,tableCreate.name,allForeignConstraints);
                        if(hayReferencia !=null){
                            Debug.agregar("ERROR: No se puede eliminar la constraint PK: <<"+col1.nombre+">> porque existe la referencia <<"+hayReferencia.nombre+">> en la tabla: "+hayReferencia.tabla);
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: No se puede eliminar la constraint PK: <<"+col1.nombre+">> porque existe la referencia <<"+hayReferencia.nombre+">> en la tabla: "+hayReferencia.tabla);
                            }                               
                            return "ERROR";
                        }                    
                    }
                
                }
                tableCreate.eliminarConstraint(consName);
                return true;
                
            
            }
            else{
                return "ERROR";
            }
            return "ERROR";
	}
        
        @Override 
        public Object visitSingleColConstraint(@NotNull SQLParser.SingleColConstraintContext ctx) {
            //Si es primary key 

            Debug.agregar("Agregando restriccion de columna...");
                       
            if(ctx.PRIMARY()!=null){
                String name = ctx.pkNombre().getText();
                //Revisamos que no exista una primary key en las constraints declaradas antes
                boolean hay_pk = findPk(availableCons);
                
                 Debug.agregar("Verificando existencia de otros primary keys...");
                
               
                if(hay_pk){
                    Debug.agregar("ERROR: No es posible declarar dos primary keys. En la tabla: "+tableCreate.name);
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("ERROR: No es posible declarar dos primary keys. En la tabla: "+tableCreate.name);
                    }                         

                    return "ERROR";                    
                }
                //No hacemos ninguna revision si la columna existe  pues esta siendo agregada en este momento.
                
                //Creamos constraint
                ArrayList<Columna> pkCols = new ArrayList<Columna>();
                pkCols.add(this.addedCol);
                
                Debug.agregar("Creando constraint...");
                
                Constraint c = new Constraint(name,Constraint.PK,pkCols,tableCreate.name);
                //Verificamos que no exista una constraint del mismo tipo con el mismo nombre

                Debug.agregar("Verificando que el nombre de la constraint no exista...");
                
                boolean existeConstraint = findConstraint(c,this.availableCons);
                if(existeConstraint){
                        Debug.agregar("ERROR: La constraint  "+c.nombre+" Ya fue declarada "+tableCreate.name);
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: La constraint  "+c.nombre+" Ya fue declarada "+tableCreate.name);
                        }                         
                        return "ERROR";               
                }
                return c;                
            }
            else if(ctx.REFERENCES()!=null){
                String name = ctx.fkNombre().getText();
                //Revisando que existan los nombre de las columnas en la tabla local
                ArrayList<Columna> localCols = new ArrayList<Columna>();
                localCols.add(addedCol);
                //Obteniendo la tabla que referencia
                String refTable = ctx.idTabla().getText();

                Debug.agregar("Buscando tabla de referencia...");
                

                DBMetaData bd = DBMS.metaData.findDB(DBMS.currentDB);
                TablaMetaData t = bd.findTable(refTable);
                if(t==null){
                        Debug.agregar("ERROR: No se encuentra la tabla de referencia: "+refTable);
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: No se encuentra la tabla de referencia: "+refTable);
                        }                      
                        return "ERROR";                   
                }
                else{
                    // Si encontramos la tabla Cargamos las constraint foraneas
                    ArrayList<Constraint> foreignConstraints = Tabla.loadConstraints(refTable);
                    ArrayList<Columna> fkCols = new ArrayList<Columna>();
                    ArrayList<Columna> cols = Tabla.loadColums(refTable);
                    //Buscamos las columnas de la primary key de la tabla foranea
                    ArrayList<Columna> columnasPrimary = new ArrayList<Columna>();
                    for(Constraint c1: foreignConstraints){
                        if(c1.tipo == Constraint.PK){
                            columnasPrimary.addAll(c1.colsPkeys);
                        }
                    }
                    if(cols==null){
                        Debug.agregar("ERROR: No se encuentra el archivo de columnas de la tabla de referencia: "+refTable);
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: No se encuentra el archivo de columnas de la tabla de referencia: "+refTable);
                        }                          
                        return "ERROR";                   
                    }
                    
                    String text = ctx.refids().getText();
                    //Buscamos las columnas de la tabla foranea
                    if(cols==null){
                        Debug.agregar("ERROR: No se encuentra el archivo de columnas de la tabla de referencia: "+refTable);
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: No se encuentra el archivo de columnas de la tabla de referencia: "+refTable);
                        }        
                        return "ERROR";                            
                    }
                    Columna encontrada = findCol(text,cols);
                    if(encontrada==null){
                        Debug.agregar("ERROR: No se encuentra la columna: "+text+" En la tabla: "+refTable);
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: No se encuentra la columna: "+text+" En la tabla: "+refTable);
                        }                                
                        
                        return "ERROR";
                    }
                    else{
                       
                        Debug.agregar("Verificando que las columnas pertenezcan a PK...");
                                               
                        //Si encontramos la columna, verificamos que la columna pertenezca al primary key de la tabla externa para garantizar que la llave sea unica
                        Columna encontrada2 = findCol(encontrada.nombre,columnasPrimary);
                        if(encontrada2==null){
                            Debug.agregar("ERROR: No se puede crear la llave foranea. La columna de referecia: "+encontrada.nombre+" No es unica ");
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: No se puede crear la llave foranea. La columna de referecia: "+encontrada.nombre+" No es unica ");
                            }                                
                            return "ERROR";
                        }                           
                        //Agregamos la columna 
                        fkCols.add(encontrada);

                    }
                   
                    Debug.agregar("Verificando columnas de la llave foranea...");
                    
                    //Una vez obtenidos los dos arreglos de columnas verificamos que tengan el mismo tamaño
                    if(fkCols.size()!=localCols.size()){
                        Debug.agregar("ERROR: El numero de columnas locales y remotas en la foregin key debe ser el mismo");
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: El numero de columnas locales y remotas en la foregin key debe ser el mismo");
                        }                         
                        return "ERROR";
                    }
                    //Si los arreglos son iguales verificamos que tengan los mismos tipo
                    for(int i =0;i<localCols.size();i++){
                        Columna local = localCols.get(i);
                        Columna foreign = fkCols.get(i);
                        if(local.tipo!=foreign.tipo){
                            Debug.agregar("ERROR: las columnas: '"+local.nombre+", "+foreign.nombre+"' Deben tener el mismo tipo");
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: las columnas: '"+local.nombre+", "+foreign.nombre+"' Deben tener el mismo tipo");
                            }                              
                            return "ERROR";                       
                        
                        }
                    }
                    
                    Debug.agregar("Creando constraint...");
                      
                    //Si todas las columnas tienen los mismo tipos, procedemos a crear la constraint
                    Constraint c = new Constraint(name,Constraint.FK,localCols,fkCols,refTable,this.tableCreate.name);
                    //Verificamos que no exista una constraint del mismo tipo con el mismo nombre
                    boolean existeConstraint = findConstraint(c,this.availableCons);
                    if(existeConstraint){
                            Debug.agregar("ERROR: La constraint  "+c.nombre+" Ya fue declarada "+tableCreate.name);
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: La constraint  "+c.nombre+" Ya fue declarada "+tableCreate.name);
                            }                         
                            return "ERROR";               
                    }                   
                    return c;
                }                
            }           
            else if(ctx.CHECK()!= null){
                String name= ctx.chNombre().getText();
                //Obtenemos la expresion del CHECK
                Object e = visit(ctx.expression());
                String expr = ctx.expression().getText();
                //Verificamos que no existan errores en la expresion para poder castear
                if(! (e instanceof Expression)){
                    return "ERROR";
                
                }

                Debug.agregar("Creando constraint...");
                Expression e1 = (Expression)e;
                //Verificamos que las tuplas actuales de la tabla cumplan con la restriccion
                Tabla temp = new Tabla();
                temp.name = tableCreate.name;
                temp.columnas.addAll(tableCreate.columnas);
                temp.tuplas.addAll(tableCreate.tuplas);
                Loader.iterador = new IteradorTabla(temp,0);
                for(int i =0; i<Loader.iterador.tabla.tuplas.size();i++){
                    try {
                    if(!e1.isTrue()){
                        Debug.agregar("ERROR: no se puede insertar constraint <<"+name+">> porque algunas tuplas no cumplen con la restriccion.");
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: no se puede insertar constraint <<"+name+">> porque algunas tuplas no cumplen con la restriccion.");
                        }                           
                        return "ERROR";                                    
                    }
                    } catch (Exception ex) {
                        Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
                    }    
                }                
                
                Constraint c = new Constraint(name,Constraint.CHECK,e1,tableCreate.name,expr);
                //Verificamos que no exista una constraint del mismo tipo con el mismo nombre

                 Debug.agregar("Buscando constraint repetida....");
                
                boolean existeConstraint = findConstraint(c,this.availableCons);
                
                if(existeConstraint){
                        Debug.agregar("ERROR: La constraint  "+c.nombre+" Ya fue declarada "+tableCreate.name);
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: La constraint  "+c.nombre+" Ya fue declarada "+tableCreate.name);
                        }                         

                        return "ERROR";               
                }                  
                return c;            
            
            }
            
            return "ERROR";
                
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
       @Override public Object visitMultiInsert(@NotNull SQLParser.MultiInsertContext ctx) {
           this.tablesInsert = new ArrayList<Tabla>();
           this.regsInsert = new ArrayList<Integer>();
            if(DBMS.currentDB==null){
                Debug.agregar("ERROR: No existe ninguna base de datos en uso. Utilice USE DATABASE <nombre> para utilizar una base de datos existente.");
                if(!Frame.useVerbose){
                    Frame.jTextArea2.setText("ERROR: No existe ninguna base de datos en uso. Utilice USE DATABASE <nombre> para utilizar una base de datos existente.");
                }                  
               
                return "ERROR";
            
            }             
           int size = ctx.insertStmt().size();
           int i =0;
           for(ParseTree n: ctx.insertStmt()){
               Debug.agregar("Insertando registro #"+i);
               
               Object x = visit(n);
               if(x instanceof String){
                    Debug.agregar("\n Error en insert no."+getTotalregs());
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("\n Error en insert no."+getTotalregs());
                    }                         

                    return "ERROR";
               }
               addRegInsert(this.tableCreate.name);
           }
           
            for(Tabla ti: this.tablesInsert){
                DBMetaData bd = DBMS.metaData.findDB(DBMS.currentDB);
                TablaMetaData tm = bd.findTable(ti.name);
                tm.cantRegistros= tm.cantRegistros+getRegNumber(ti.name);
                ti.guardarTabla();
                DBMS.metaData.writeMetadata();
                DBMS.guardar();              
            }
                Debug.agregar("Insert ("+size+") registros con exito.");
                if(!Frame.useVerbose){
                    Frame.jTextArea2.setText("Insert ("+size+") registros con exito.");
                }    

           return true;
       
       }
       public int getTotalregs(){
           int k =0;
           for(int a : this.regsInsert){
               k+=a;
           }
           return k;
       }
       public int getRegNumber(String s){
            int i =0;
             for(Tabla t: this.tablesInsert){
               if(t.name.equalsIgnoreCase(s)){
                   return this.regsInsert.get(i);
               }
               i++;
           }
             return -1;
       }
       public void addRegInsert(String s){
           int i =0;
             for(Tabla t: this.tablesInsert){
               if(t.name.equalsIgnoreCase(s)){
                   this.regsInsert.set(i, this.regsInsert.get(i)+1);
               }
               i++;
           }        
       }
       public boolean containsTableInsert(String s){
           for(Tabla t: this.tablesInsert){
               if(t.name.equalsIgnoreCase(s)){
                   return true;
               }
           }
           return false;
       }
       public Tabla getTableInsert(String s){
           for(Tabla t: this.tablesInsert){
               if(t.name.equalsIgnoreCase(s)){
                   return t;
               }
           }
           return null;
       }       
	@Override
	public Object visitInsertStmt(SQLParser.InsertStmtContext ctx) {
                 ArrayList<Object> valores = new ArrayList<Object>();
                 ArrayList<Integer> tipos = new ArrayList<Integer>();
                //Cargamos la tabla donde se insertara la tupla
                String tableName = ctx.table().getText();
                if(this.tableCreate== null){
                    this.tableCreate = Tabla.loadTable(tableName);
                    this.tablesInsert.add(tableCreate);
                    this.regsInsert.add(0);
                }
                else if (!tableName.equalsIgnoreCase(tableCreate.name) && ! containsTableInsert(tableName)){
                    
                    this.tableCreate = Tabla.loadTable(tableName);
                    this.tablesInsert.add(tableCreate);
                    this.regsInsert.add(0);
                }
                else if (tableName.equalsIgnoreCase(tableCreate.name)){

                }
                else if (!tableName.equalsIgnoreCase(tableCreate.name) &&  containsTableInsert(tableName)){
                    
                    this.tableCreate = getTableInsert(tableName);

                }     
                else{
                    this.tableCreate = null;
                }
                Tabla t = this.tableCreate;
                    if(t==null){
                    Debug.agregar("ERROR: No se encuentra la tabla: "+tableName);
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("ERROR: No se encuentra la tabla: "+tableName);
                    }                        

                    return "ERROR";
                }  
                 //Verificamos si hay columnas especificadas
                if(ctx.columnList()!=null){
                    ArrayList<Columna> columnasEspecificadas= new ArrayList<Columna>();
                    //Obtenemos las columnas que se especificaron
                    for(ParseTree n: ctx.columnList().colName()){
                        String colName = n.getText();
                        Columna existe = this.findCol(colName, t.columnas);
                        if(existe == null){
                    
                            Debug.agregar("ERROR: No se encuentra la Columna: <<"+colName+">> en la tabla: "+tableName);
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: No se encuentra la Columna: <<"+colName+">> en la tabla: "+tableName);
                            }                             
        
                            return "ERROR";                           
                        }
                        columnasEspecificadas.add(existe);
                        
                    }
                    ArrayList<Integer> indicesColumnas = new ArrayList<Integer>();
                    //Obtenemos los indices de las columnas especificadas en la tabla
                    for(int i =0;i<columnasEspecificadas.size();i++){
                        int indice = t.getIndiceColumna(columnasEspecificadas.get(i).nombre);
                        indicesColumnas.add(indice);
                    }
                    //Llenamos los valores con nulls inicialmente
                    for(int i =0;i<t.columnas.size();i++){
                        valores.add(null);
                        tipos.add(t.columnas.get(i).tipo);
                    }
                    // Verificamos que el numero de columnas y el numero de valores sean iguales 
                    if(ctx.valueList().val().size()!=columnasEspecificadas.size()){
                            Debug.agregar("ERROR: El numero de columnas y de valores especificados debe ser el mismo");
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: El numero de columnas y de valores especificados debe ser el mismo");
                            }                           

                            return "ERROR";                           
                    }
                    //Asignamos los valores ingresado a los indices correctos en el arraylist valores
                    int i =0;
                    for(ParseTree n: ctx.valueList().val()){
                        Object valueType1 = visit(n);                        
                        if(!(valueType1 instanceof Integer) ){
                            return "ERROR";
                        }
                        Object valor=null;
                        int valueType = (int) valueType1;
                        if(valueType==Columna.CHAR_TYPE){
                            String v = n.getText();
                            v= v.substring(1);
                            v = v.substring(0,v.length()-1);                            
                            valor = v;
                        }
                        else if (valueType == Columna.INT_TYPE){
                            valor = Integer.parseInt(n.getText());
                        }
                        else if(valueType == Columna.FLOAT_TYPE){
                            valor = Float.parseFloat(n.getText());
                        }
                        else if(valueType == Columna.DATE_TYPE){
                            String v = n.getText();
                            v= v.substring(1);
                            v = v.substring(0,v.length()-1);                                
                            valor = LocalDate.parse(v);
                        }
                        
                        valores.set(indicesColumnas.get(i),valor);
                        tipos.set(indicesColumnas.get(i),valueType); 
                        i++;
                    }                    
                }               
                else{
                    // Si no hay columnas especificadas tomamos cada uno de los valores y su tipo
                    for(ParseTree n: ctx.valueList().val()){
                        Object valueType1 = visit(n);
                       
                        if(!(valueType1 instanceof Integer) ){
                            return "ERROR";
                        }
                        Object valor=null;
                        int valueType = (int) valueType1;
                        if(valueType==Columna.CHAR_TYPE){
                            String v = n.getText();
                            v= v.substring(1);
                            v = v.substring(0,v.length()-1);                            
                            valor = v;
                        }
                        else if (valueType == Columna.INT_TYPE){
                            valor = Integer.parseInt(n.getText());
                        }
                        else if(valueType == Columna.FLOAT_TYPE){
                            valor = Float.parseFloat(n.getText());
                        }
                        else if(valueType == Columna.DATE_TYPE){
                            String v = n.getText();
                            v= v.substring(1);
                            v = v.substring(0,v.length()-1);                              
                            valor = LocalDate.parse(v);
                        }
                        valores.add(valor);
                        tipos.add(valueType);
                       
                    }  
                }
                    //Verificamos que el numero de valores no sea mayor al numero de columnas
                    if(valores.size()>t.columnas.size()){
                        Debug.agregar("ERROR: El numero de valores ingresados es mayor al numero de columnas en la tabla: "+tableName);
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: El numero de valores ingresados es mayor al numero de columnas en la tabla: "+tableName);
                        }                           
                        return "ERROR";                    
                    }
                    Tupla nuevaTupla = new Tupla(new ArrayList<Object>(),t);
                    //Llenamos los valores con nulls
                    for(Columna c: t.columnas){
                        nuevaTupla.valores.add(null);
                    }
                    
                    // Comprobamos los tipos de los valores con las columnas
                    for(int i =0;i<valores.size();i++){
                        int tipoValor = tipos.get(i);
                        int tipoColumna =t.columnas.get(i).tipo;
                        // Si no son iguales... intentamos hacer conversion de tipos
                        if(tipoValor != tipoColumna){                           
                            if(tipoValor == Columna.INT_TYPE){
                                if(tipoColumna== Columna.CHAR_TYPE){
                                    //Convertimos el entero a un char
                                    String v = valores.get(i).toString();
                                    //Verificamos el tamanio del string
                                    if(v.length()>t.columnas.get(i).size){
                                        Debug.agregar("ERROR: El tamaño del CHAR es mayor al definido en la columna <<"+t.columnas.get(i).nombre+">>. Se encontro: "+v.length()+", "+t.columnas.get(i).size);
                                        if(!Frame.useVerbose){
                                            Frame.jTextArea2.setText("ERROR: El tamaño del CHAR es mayor al definido en la columna <<"+t.columnas.get(i).nombre+">>. Se encontro: "+v.length()+", "+t.columnas.get(i).size);
                                        }                                                                                            
                                       
                                        return "ERRROR";                                          
                                    }                                    
                                    
                                    valores.set(i, v);
                                }
                                else if (tipoColumna == Columna.FLOAT_TYPE){
                                    float v = Float.valueOf(valores.get(i).toString());
                                    valores.set(i, v);
                                }
                                else{
                                    Debug.agregar("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                    if(!Frame.useVerbose){
                                        Frame.jTextArea2.setText("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                    }                                                                                                                                                
                                    return "ERRROR";
                                }
                            }
                            else if (tipoValor == Columna.FLOAT_TYPE){
                                if(tipoColumna==Columna.INT_TYPE){
                                    
                                    float v1 = Float.valueOf(valores.get(i).toString());
                                    int v = (int)v1;  //Convertimos el float al int trucando decimales
                                    valores.set(i, v);
                                  
                                
                                }
                                else if (tipoColumna == Columna.CHAR_TYPE){
                                    String v = valores.get(i).toString();
                                    //Verificamos el tamanio del string
                                    if(v.length()>t.columnas.get(i).size){
                                        Debug.agregar("ERROR: El tamaño del CHAR es mayor al definido en la columna <<"+t.columnas.get(i).nombre+">>. Se encontro: "+v.length()+", "+t.columnas.get(i).size);
                                        if(!Frame.useVerbose){
                                            Frame.jTextArea2.setText("ERROR: El tamaño del CHAR es mayor al definido en la columna <<"+t.columnas.get(i).nombre+">>. Se encontro: "+v.length()+", "+t.columnas.get(i).size);
                                        }                                             
                                        return "ERRROR";                                          
                                    }                                    
                                    
                                    valores.set(i, v);
                                }
                                else{
                                    Debug.agregar("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                    if(!Frame.useVerbose){
                                        Frame.jTextArea2.setText("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                    }              
                                    return "ERRROR";                                
                                }
                            
                            }
                            else if (tipoValor == Columna.DATE_TYPE){
                                if(tipoColumna == Columna.CHAR_TYPE){
                                    String v = valores.get(i).toString();
                                    //Verificamos el tamanio del string
                                    if(v.length()>t.columnas.get(i).size){
                                        Debug.agregar("ERROR: El tamaño del CHAR es mayor al definido en la columna <<"+t.columnas.get(i).nombre+">>. Se encontro: "+v.length()+", "+t.columnas.get(i).size);
                                        if(!Frame.useVerbose){
                                            Frame.jTextArea2.setText("ERROR: El tamaño del CHAR es mayor al definido en la columna <<"+t.columnas.get(i).nombre+">>. Se encontro: "+v.length()+", "+t.columnas.get(i).size);
                                        }                                             
                                                      
                                        return "ERRROR";                                          
                                    }
                                    valores.set(i, v);
                                    
                               
                                    
                                }
                                else{
                                    Debug.agregar("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                    if(!Frame.useVerbose){
                                        Frame.jTextArea2.setText("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                    }              
                                    return "ERRROR";                                      
                                }
                            }                            
                            else if (tipoValor == Columna.CHAR_TYPE){
                                 if(tipoColumna == Columna.INT_TYPE){
                                    String v = valores.get(i).toString();
                                    try{
                                        int v1 = Integer.parseInt(v);
                                        
                                        valores.set(i, v1);
                                    }
                                    
                                    catch(Exception e){
                                    Debug.agregar("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                    if(!Frame.useVerbose){
                                        Frame.jTextArea2.setText("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                    }              
                                        return "ERRROR";                                      
                                    }
                                                                   
                                 }
                                 else if(tipoColumna == Columna.FLOAT_TYPE){
                                    String v = valores.get(i).toString();
                                    try{
                                        float v1 = Float.parseFloat(v);
                                        valores.set(i, v1);
                                    }
                                    
                                    catch(Exception e){
                                    Debug.agregar("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                    if(!Frame.useVerbose){
                                        Frame.jTextArea2.setText("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                    }              
                                        return "ERRROR";                                      
                                    }                              
                                 }
                                 else if (tipoColumna == Columna.DATE_TYPE){     
                                    try{
                                        LocalDate d = LocalDate.parse(valores.get(i).toString());
                                        valores.set(i, d);
                                    }
                                    catch(Exception e){
                                    Debug.agregar("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                    if(!Frame.useVerbose){
                                        Frame.jTextArea2.setText("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                    }                                                   
                                        return "ERRROR";                                       
                                    }                             
                                 }
                                 else{
                                    Debug.agregar("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                    if(!Frame.useVerbose){
                                        Frame.jTextArea2.setText("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                    }              
                                    return "ERRROR";                                   
                                 }
                            }
                        
                        }
                        else{
                            valores.set(i, valores.get(i));
                        }
      
                        
                    }
                    // Si no hubieron errores agregamos los valores a la nueva tupla
                    for(int i =0;i<valores.size();i++){
                        nuevaTupla.valores.set(i, valores.get(i));
                    
                    }
                    
                    
                    
                    // Comprobamos las constraints de los valores 
                    Tabla tempTabla = new Tabla();
                    tempTabla.name = t.name;
                    tempTabla.columnas.addAll(t.columnas);
                    Loader.iterador = new IteradorTabla(tempTabla,0);
                    
                    Debug.agregar("Verificando restricciones en la insercion...");
                    
                    for(Constraint cons: t.constraints){
                        if(cons.tipo==Constraint.PK){
                             ArrayList<Integer> indices = new ArrayList<Integer>();
                             ArrayList<Object> pkeyValues = new ArrayList<Object>();
                            //Revisamos que las columnas de la constraint no sean nulas
                            for(Columna c:cons.colsPkeys){
                                int iValor = t.getIndiceColumna(c.nombre);
                                indices.add(iValor);
                                Object v = nuevaTupla.valores.get(iValor);
                                pkeyValues.add(v);
                                if(v==null){
                                    Debug.agregar("ERROR: la columna <<"+c.nombre+">> no puede tener valor nulo por la constraint <<"+cons.nombre+">>");
                                    if(!Frame.useVerbose){
                                        Frame.jTextArea2.setText("ERROR: la columna <<"+c.nombre+">> no puede tener valor nulo por la constraint <<"+cons.nombre+">>");
                                    }                                      

                                     return "ERRROR";                                     
                                }
                            
                            }
                            
                            
                            //Revisamos si ya existe el valor en las tuplas de la tabla
                            boolean yaExiste = t.contieneValor(pkeyValues, indices);
                            if(yaExiste){
                                Debug.agregar("ERROR: la restriccion <<"+cons.nombre+">> esta siendo violada con la insercion. Debe existir valor unico por la PK: <<"+cons.nombre+">>");
                                if(!Frame.useVerbose){
                                    Frame.jTextArea2.setText("ERROR: la restriccion <<"+cons.nombre+">> esta siendo violada con la insercion. Debe existir valor unico por la PK: <<"+cons.nombre+">>");
                                }                                                                  
                                 
                                 return "ERRROR";                                         
                            }                            
                        
                        }
                        else if (cons.tipo==Constraint.FK){
                            //Cargamos la tabla foranea 
                            Tabla foreignTable = Tabla.loadTable(cons.foreignTable);
                            // Obtenemos los valores de las columnas con la llave foranea en la tupla a insertar
                            ArrayList<Object> valoresInsert = new ArrayList<Object>();
                            for(Columna c: cons.localFkeys){
                                int indice = t.getIndiceColumna(c.nombre);
                                Object valor = nuevaTupla.valores.get(indice);
                                valoresInsert.add(valor);
                            
                            }
                            
                            //Recorremos cada columna referenciada y verificamos que el valor de la columna exista o sea nulo
                            int i =0;
                            ArrayList<Integer> indices = new ArrayList<Integer>();
                            for(Columna c:cons.refKeys){
                                //Obtenemos el indice de la columna de referencia
                                int indice = foreignTable.getIndiceColumna(c.nombre);
                                indices.add(indice);
                                Object valorBusqueda = valoresInsert.get(i);
                                if(valorBusqueda == null){ //Si es nulo reportamos CONTINUAMOS
                                    continue;} 
                                i++;
                            }
                            boolean encontrado = foreignTable.contieneValor(valoresInsert, indices);
                            if(!encontrado){
                                String s="";
                                 for(Object t2: valoresInsert){
                                     if(t2!=null){
                                         s+=t2.toString()+", ";
                                     }
                                     else{s+="null, ";}
                                 
                                 }
                                Debug.agregar("ERROR: La llave <<"+s+">> no existe en la tabla de referencia: "+foreignTable.name);
                                if(!Frame.useVerbose){
                                    Frame.jTextArea2.setText("ERROR: La llave <<"+s+">> no existe en la tabla de referencia: "+foreignTable.name);
                                }                                                                                           
                                
                                 return "ERRROR";                                       
                            }                           
                        }
                        else if(cons.tipo==Constraint.CHECK){
                            //Creamos tabla temporal con contructor que no guarda archivo serializado
                            Tabla temp = new Tabla();
                            temp.name="temp";
                            temp.columnas=t.columnas;
                            
                            temp.tuplas.add(nuevaTupla);
                            Loader.iterador = new IteradorTabla(temp,0);
                            //Obtenemos la expresion de la constraint
                            Expression e = cons.expr;
                            try {
                                //No hacemos ningun for porque solo queremos evaluar la tupla que vamos a insertar
                                if(!e.isTrue()){
                                    Debug.agregar("\n ERROR: El valor de la tupla: "+nuevaTupla.toString() +"no cumple con la restriccion '"+cons.exprText+" ' .");
                                    if(!Frame.useVerbose){
                                        Frame.jTextArea2.setText("\n ERROR: El valor de la tupla: "+nuevaTupla.toString() +"no cumple con la restriccion '"+cons.exprText+" ' .");
                                    }                                           
                                    return "ERRROR";
                                    
                                }
                            } catch (Exception ex) {
                                Debug.agregar("\n ERROR: El valor de la tupla: "+nuevaTupla.toString() +" no cumple con la restriccion ' "+cons.exprText+" ' .");
                                return "ERROR";
                            }
                            
                        
                        }
                        
                    
                    }
                //Guardamos la tabla y la metaData
                t.tuplas.add(nuevaTupla);
                return true;
	}
	@Override
	public Object visitVal(SQLParser.ValContext ctx) {
		if(ctx.CHAR_VAL()!=null){
                    return Columna.CHAR_TYPE;
                
                }
                else if(ctx.NUM()!= null){
                    return Columna.INT_TYPE;
                
                }
                else if (ctx.DATE_VAL()!=null){
                    return Columna.DATE_TYPE;
                
                }
                else if (ctx.FLOAT_VAL()!=null){
                    return Columna.FLOAT_TYPE;
                }
                else if(ctx.NULL()!=null){
                    return -1;
                }
                else{return "ERROR";}
	}


	@Override
	public Object visitUpdateStmt(SQLParser.UpdateStmtContext ctx) {
            if(DBMS.currentDB==null){
                Debug.agregar("ERROR: No existe ninguna base de datos en uso. Utilice USE DATABASE <nombre> para utilizar una base de datos existente.");
                if(!Frame.useVerbose){
                    Frame.jTextArea2.setText("ERROR: No existe ninguna base de datos en uso. Utilice USE DATABASE <nombre> para utilizar una base de datos existente.");
                }                
                return "ERROR";
            
            }              
            String tableName = ctx.table().getText();
            Tabla t = Tabla.loadTable(tableName);

            if(t==null){
                Debug.agregar("ERROR: No se encuentra la tabla: "+tableName);
                if(!Frame.useVerbose){
                    Frame.jTextArea2.setText("ERROR: No se encuentra la tabla: "+tableName);
                }                          
                return "ERROR";
            } 
            
            this.availableCols = new ArrayList<Columna>();
            this.availableCols.addAll(t.columnas);            
            ArrayList<Columna> columnasEspecificadas= new ArrayList<Columna>();
            ArrayList<Object> valores = new ArrayList<Object>();
            //Obtenemos las columnas que se especificaron
            int i =0;
                Debug.agregar("Obteniendo columnas especificadas...");
            
            for(ParseTree n: ctx.columnsUpdate()){
                String colName = n.getText();
                Columna existe = this.findCol(colName, t.columnas);
                if(existe == null){
                    Debug.agregar("ERROR: No se encuentra la Columna: <<"+colName+">> en la tabla: "+tableName);
                    if(!Frame.useVerbose){
                        Frame.jTextArea2.setText("ERROR: No se encuentra la Columna: <<"+colName+">> en la tabla: "+tableName);
                    }  
                    return "ERROR";                           
                }
                 //Verificamos los tipos del valor y la columna actual

                Object tipoValor1 = visit(ctx.val(i));
                if(tipoValor1 instanceof String){
                    return "ERROR";
                }
                Integer tipoValor2 = (Integer) tipoValor1;
                if(tipoValor2 == -1){
                    valores.add(null);
                }
                else{
                    valores.add(ctx.val(i).getText());
                }

                int tipoValor = (Integer) tipoValor1;
                int tipoColumna= existe.tipo;
                Object valor = null;
                if(tipoValor==Columna.CHAR_TYPE){
                    String v = ctx.val(i).getText();
                    v= v.substring(1);
                    v = v.substring(0,v.length()-1);                            
                    valor = v;
                }
                else if (tipoValor == Columna.INT_TYPE){
                    valor = Integer.parseInt(ctx.val(i).getText());
                }
                else if(tipoValor == Columna.FLOAT_TYPE){
                    valor = Float.parseFloat(ctx.val(i).getText());
                }
                else if(tipoValor == Columna.DATE_TYPE){
                    valor = LocalDate.parse(ctx.val(i).getText());
                }                
                valores.set(i,valor);
                // Si no son iguales... intentamos hacer conversion de tipos
              
                Debug.agregar("Verificando tipos...");
                
                if(tipoValor != tipoColumna){                           
                    if(tipoValor == Columna.INT_TYPE){
                        if(tipoColumna== Columna.CHAR_TYPE){
                            //Convertimos el entero a un char
                            String v = valores.get(i).toString();
                            //Verificamos el tamanio del string
                            if(v.length()>t.columnas.get(i).size){
                                Debug.agregar("ERROR: El tamaño del CHAR es mayor al definido en la columna <<"+t.columnas.get(i).nombre+">>. Se encontro: "+v.length()+", "+t.columnas.get(i).size);
                                if(!Frame.useVerbose){
                                    Frame.jTextArea2.setText("ERROR: El tamaño del CHAR es mayor al definido en la columna <<"+t.columnas.get(i).nombre+">>. Se encontro: "+v.length()+", "+t.columnas.get(i).size);
                                }                                             

                                return "ERRROR";                                          
                            }                                    

                            valores.set(i, v);
                        }
                        else if (tipoColumna == Columna.FLOAT_TYPE){
                            float v = Float.valueOf(valores.get(i).toString());
                            valores.set(i, v);
                        }
                        else{
                            Debug.agregar("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                            }                                                         
                            return "ERRROR";
                        }
                    }
                    else if (tipoValor == Columna.FLOAT_TYPE){
                        if(tipoColumna==Columna.INT_TYPE){
                            float v1 = Float.valueOf(valores.get(i).toString());
                            int v = (int)v1;  //Convertimos el float al int trucando decimales
                            valores.set(i, v);


                        }
                        else if (tipoColumna == Columna.CHAR_TYPE){
                            String v = valores.get(i).toString();
                            //Verificamos el tamanio del string
                            if(v.length()>t.columnas.get(i).size){
                                Debug.agregar("ERROR: El tamaño del CHAR es mayor al definido en la columna <<"+t.columnas.get(i).nombre+">>. Se encontro: "+v.length()+", "+t.columnas.get(i).size);
                                if(!Frame.useVerbose){
                                    Frame.jTextArea2.setText("ERROR: El tamaño del CHAR es mayor al definido en la columna <<"+t.columnas.get(i).nombre+">>. Se encontro: "+v.length()+", "+t.columnas.get(i).size);
                                }                                             

                                return "ERRROR";                                          
                            }                                    

                            valores.set(i, v);
                        }
                        else{
                            Debug.agregar("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                            }  
                            return "ERRROR";                                
                        }

                    }
                    else if (tipoValor == Columna.DATE_TYPE){
                        if(tipoColumna == Columna.CHAR_TYPE){
                            String v = valores.get(i).toString();
                            //Verificamos el tamanio del string
                            if(v.length()>t.columnas.get(i).size){
                                Debug.agregar("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                if(!Frame.useVerbose){
                                    Frame.jTextArea2.setText("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                }    
                                return "ERRROR";                                          
                            }
                            valores.set(i, v);



                        }
                        else{
                            Debug.agregar("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                            }    
                            return "ERRROR";                                      
                        }
                    }                            
                    else if (tipoValor == Columna.CHAR_TYPE){
                         if(tipoColumna == Columna.INT_TYPE){
                            String v = valores.get(i).toString();
                            try{
                                int v1 = Integer.parseInt(v);

                                valores.set(i, v1);
                            }

                            catch(Exception e){
                                Debug.agregar("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                if(!Frame.useVerbose){
                                    Frame.jTextArea2.setText("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                }
                                return "ERRROR";                                      
                            }

                         }
                         else if(tipoColumna == Columna.FLOAT_TYPE){
                            String v = valores.get(i).toString();
                            try{
                                float v1 = Float.parseFloat(v);
                                valores.set(i, v1);
                            }

                            catch(Exception e){
                                Debug.agregar("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                if(!Frame.useVerbose){
                                    Frame.jTextArea2.setText("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                }
                                return "ERRROR";                                      
                            }                              
                         }
                         else if (tipoColumna == Columna.DATE_TYPE){     
                            try{
                                LocalDate d = LocalDate.parse(valores.get(i).toString());
                                valores.set(i, d);
                            }
                            catch(Exception e){
                                Debug.agregar("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                if(!Frame.useVerbose){
                                    Frame.jTextArea2.setText("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                }
                                return "ERRROR";                                       
                            }                             
                         }
                         else{
                                Debug.agregar("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                if(!Frame.useVerbose){
                                    Frame.jTextArea2.setText("ERROR: Tipos invalidos en insercion de columna: <<"+t.columnas.get(i).nombre+">>. Se encontro: "+t.columnas.get(i).getStringType(tipoValor)+", "+t.columnas.get(i).getStringType(tipoColumna));
                                }
                            return "ERRROR";                                   
                         }
                    }

                }
                else{
                    valores.set(i, valores.get(i));
                }                
                
                columnasEspecificadas.add(existe);
                i++;

            }
            ArrayList<Integer> indicesColumnas = new ArrayList<Integer>();
            //Obtenemos los indices de las columnas especificadas en la tabla
            for(int j =0;j<columnasEspecificadas.size();j++){
                int indice = t.getIndiceColumna(columnasEspecificadas.get(j).nombre);
                indicesColumnas.add(indice);
            }
            
            //Obtenemos la expresion WHERE
            Object where1 = visit(ctx.expression());
            if(where1 instanceof String){
                return "ERROR";
            }
            Expression where = (Expression) where1;
            
            //Creamos el iterador para la tabla que se creo 
            Loader.iterador = new IteradorTabla(t,0);  
            //Recorremos cada una de las tuplas en el iterador y verificamos la condicion. 
            int numModificadas =0;
            ArrayList<Tupla> tuplasWhere = new ArrayList<Tupla>();
            for(int j =0;j<Loader.iterador.tabla.tuplas.size();j++){
                Tupla tuplaActual = Loader.iterador.tabla.tuplas.get(j);
                try {
                    if(where.isTrue()!= null && where.isTrue()){
                       numModificadas++;
                       t.actualizarTupla(valores, indicesColumnas, j);
                       tuplasWhere.add(tuplaActual);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
                }
                Loader.iterador.siguiente(); //Movemos el iterador a la siguiente tupla
            }
                
            Debug.agregar("Verificando restricciones en la actualizacion...");
            
            //Verificamos contraints en cada una de las tuplas de la tabla
            for(Tupla currentTupla: tuplasWhere){
                
                for(Constraint cons: t.constraints){
                    if(cons.tipo== Constraint.PK){
                        ArrayList<Object> checkValues = new ArrayList<Object>();
                        ArrayList<Integer> indexChecks = new ArrayList<Integer>();
                        for(Columna c: cons.colsPkeys){
                            int indice = t.getIndiceColumna(c.nombre);
                            Object val=currentTupla.valores.get(indice);
                            checkValues.add(val);
                            indexChecks.add(indice);
                        }
                        //Revisamo si hay valores nulos
                        boolean contieneNulls = t.hasNullValues(indexChecks,currentTupla);
                        if(contieneNulls){
                            Debug.agregar("ERROR: la actualizacion viola la restriccion <<"+cons.nombre+">> porque crea valores nulos para llave primaria");
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: la actualizacion viola la restriccion <<"+cons.nombre+">> porque crea valores nulos para llave primaria");
                            }                            
                            return "ERROR";
                        }                        
                        boolean duplicada = t.estaDuplicado(checkValues, indexChecks);
                        if(duplicada){
                            Debug.agregar("ERROR: la actualizacion viola la restriccion <<"+cons.nombre+">> porque crea valores duplicados de una llave primaria");
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: la actualizacion viola la restriccion <<"+cons.nombre+">> porque crea valores duplicados de una llave primaria");
                            }                                  
                            return "ERROR";
                        }
                    
                    }
                    else if (cons.tipo == Constraint.FK){
                        Tabla foreign = Tabla.loadTable(cons.foreignTable);
                        //Obtenemos los valores de la tupla actual 
                        ArrayList<Object> checkValues = new ArrayList<Object>();
                        ArrayList<Integer> localIndexes = new ArrayList<Integer>();
                        for(Columna local: cons.localFkeys){
                            int indice = t.getIndiceColumna(local.nombre);
                            localIndexes.add(indice);
                            Object v = currentTupla.valores.get(indice);
                            checkValues.add(v);
                        }
                        //Obtenemos los indices de la tupla foranea para buscar los valores de la tupla local
                        ArrayList<Integer> indexValues = new ArrayList<Integer>();
                        for ( Columna foreignCol: cons.refKeys){
                            int index = foreign.getIndiceColumna(foreignCol.nombre);
                            indexValues.add(index);
                        
                        }
                        
                        //Revisamos si hay valores nulos
                       /* boolean contieneNulls = t.hasNullValues(localIndexes,currentTupla);
                        if(contieneNulls){
                            Frame.jTextArea2.setText("ERROR: la actualizacion viola la restriccion <<"+cons.nombre+">> porque crea valores nulos para llave foranea");
                            return "ERROR";
                        }  */                       
                        boolean contieneValores = foreign.contieneValor(checkValues, indexValues);
                        if(!contieneValores){
                            Debug.agregar("ERROR: la actualizacion viola la restriccion <<"+cons.nombre+">> porque no se encuentra el valor de la llave foranea");
                            if(!Frame.useVerbose){
                                Frame.jTextArea2.setText("ERROR: la actualizacion viola la restriccion <<"+cons.nombre+">> porque no se encuentra el valor de la llave foranea");
                            }                                   
                            return "ERROR";                            
                        
                        }
                    }
                    else if(cons.tipo == Constraint.CHECK){
                        Tabla temp = new Tabla();
                        temp.name = t.name;
                        temp.columnas.addAll(t.columnas);
                        temp.tuplas.add(currentTupla);
                        Loader.iterador = new IteradorTabla(temp,0);
                        try {
                            if( !cons.expr.isTrue()){
                                Debug.agregar("ERROR: la actualizacion viola la restriccion <<"+cons.nombre+">>.");
                                if(!Frame.useVerbose){
                                    Frame.jTextArea2.setText("ERROR: la actualizacion viola la restriccion <<"+cons.nombre+">>.");
                                }                                     
                                return "ERROR";                                    
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                       
            }

            Debug.agregar("Verificando integridad referencial de la tabla...");
            
            //Obtenemos referencias a la tabla 
            ArrayList<Constraint> referencias = obtenerReferenciasDe(t.name);
           
            for(Constraint refCons: referencias){
                //Para cada referencias primero cargamos la tabla local de la referencia
                Tabla localTable = Tabla.loadTable(refCons.tabla);
               //Luego, para cada tupla de la tabla obtenemos las columnas locales y sus valores con localfkey
                for(Tupla tupla:localTable.tuplas){
                    ArrayList<Integer> indexBuscar = new ArrayList<Integer>();
                    ArrayList<Integer> indexT = new ArrayList<Integer>();
                    ArrayList<Object> valoresActuales = new ArrayList<Object>(); 
                    for(Columna col: refCons.localFkeys){
                        int index = localTable.getIndiceColumna(col.nombre);
                        indexBuscar.add(index);
                    }
                    for(int iv: indexBuscar){
                        valoresActuales.add(tupla.valores.get(iv));
                    
                    }
                    for(Columna c2: refCons.refKeys){
                        int index2 = t.getIndiceColumna(c2.nombre);
                        indexT.add(index2);
                    
                    }
                      // Revisamos si los valores de la tupla actual existen en los valores de la tabla de referencia (i.e la mencionada en UPDATE tableName) 
                    boolean encontrada = t.contieneValor(valoresActuales, indexT);
                    if(encontrada==false){
                        Debug.agregar("ERROR: La restriccion <<"+refCons.nombre+">> de la tabla <<"+localTable.name+">>esta siendo violdada con la actualizacion porque se cambio el valor de una tupla referenciada.");
                        if(!Frame.useVerbose){
                            Frame.jTextArea2.setText("ERROR: La restriccion <<"+refCons.nombre+">> de la tabla <<"+localTable.name+">>esta siendo violdada con la actualizacion porque se cambio el valor de una tupla referenciada.");
                        }                             
                        return "ERROR";
                    }

                }

            }
            //Guardamos la tablas
            t.guardarTabla();
            Debug.agregar("Update Finalizado. Se modificaron: "+numModificadas+" registros");
            if(!Frame.useVerbose){
                Frame.jTextArea2.setText("Update Finalizado. Se modificaron: "+numModificadas+" registros");
            }              
            return true;
            
	}
        @Override
        public Object visitDeleteStmt(SQLParser.DeleteStmtContext ctx){
            if(DBMS.currentDB==null){
                Frame.jTextArea2.setText("ERROR: No existe ninguna base de datos en uso. Utilice USE DATABASE <nombre> para utilizar una base de datos existente.");
                return "ERROR";
            
            }              
            //Para cuando no tiene where
            String tablename = ctx.table().getText();
            Tabla t = Tabla.loadTable(tablename);
            Loader.iterador = new IteradorTabla(t,0);
            int numDeleted = 0; 
            
                        
            
            if(ctx.children.get(2).getChildCount() == 3){
                for(Loader.iterador.indiceActual = 0; Loader.iterador.indiceActual< Loader.iterador.tabla.tuplas.size(); Loader.iterador.indiceActual++){
                    //Se revisa que no haya referencia a esta columna antes de eliminar
                    Loader.iterador.deleteValue();
                    numDeleted++;
                }
                boolean isOk = foreignDeleted(t);
                if(isOk){
                    t.guardarTabla();
                    DBMetaData d = DBMS.metaData.findDB(DBMS.currentDB);
                    TablaMetaData t1 = d.findTable(tablename);
                    t1.cantRegistros = 0;
                    DBMS.metaData.writeMetadata();
                    DBMS.guardar();
                }
                else{
                        Debug.agregar("\n ERROR: No se puede eliminar la fila debido a que existen referencias a una de sus columnas");
                        return "Error";
                }
                
            }
            //para cuando tiene where
            else if(ctx.children.get(2).getChildCount() == 5){
                for(Loader.iterador.indiceActual = 0; Loader.iterador.indiceActual< Loader.iterador.tabla.tuplas.size(); Loader.iterador.indiceActual++){
                    //booleana para determinar si se cumple la condicion para cada tupla
                    Object isTrueHere = ctx.expression();
                    //Si es un string es un error 
                    if(isTrueHere instanceof String){
                        return "ERROR";
                    }
                    //Si no es string se castea
                    Expression pass = (Expression)isTrueHere;
                    
                    try {
                        //Se revisa que no haya referencia a esta columna antes de eliminar
                        if(pass.isTrue() != null ||pass.isTrue()){
                            Loader.iterador.deleteValue();
                            numDeleted++;

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                boolean isOk = foreignDeleted(t);
                if(isOk){
                    t.guardarTabla();
                    DBMetaData d = DBMS.metaData.findDB(DBMS.currentDB);
                    TablaMetaData t1 = d.findTable(tablename);
                    t1.cantRegistros = 0;
                    DBMS.metaData.writeMetadata();
                    DBMS.guardar();
                }
                else{
                        Debug.agregar("\n ERROR: No se puede eliminar la fila debido a que existen referencias a una de sus columnas");
                        return "Error";
                }
            }
            Debug.agregar("\nAVISO: Se han eliminado "+numDeleted +" registros.");
            return super. visitDeleteStmt(ctx);
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
            for(Component i: Frame.forResults.getComponents()){
                Frame.forResults.remove(i);
            }
            Frame.forResults.add(results);
            Frame.forResults.revalidate();
            Frame.forResults.repaint();
            return super.visitShowDbStmt(ctx);
	}

	@Override
	public Object visitDropTableStmt(SQLParser.DropTableStmtContext ctx) {
            if(DBMS.currentDB==null){
                Frame.jTextArea2.setText("ERROR: No existe ninguna base de datos en uso. Utilice USE DATABASE <nombre> para utilizar una base de datos existente.");
                return "ERROR";
            
            }              
            /*Borrar implica: 
            1. Ver que base de datos estoy usando
            2. Buscar la tabla si existe
            3. Borrar la tabla en la metadata
            4. Borrar en el archivo serealizable - deleteAllFilesWithName*/
            String dbActual = DBMS.currentDB;
            String tablename = ctx.ID().getText();
            //Se revisa si existe una dependecia con esta tabla antes de ser eliminada
            ArrayList<Constraint> constreintsHere = getAllForeignConstraints();
            for(Constraint c: constreintsHere){
                if(c.foreignTable.equals(tablename)){
                    Frame.jTextArea2.setText("ERROR: Existe una referencia a la tabla "+tablename);
                    return "ERROR";
                }
            }
            //Verificamos si hay una DB en uso
            if(DBMS.currentDB==null){
                Frame.jTextArea2.setText("ERROR: No existe ninguna base de datos en uso. Utilice USE DATABASE <nombre> para utilizar una base de datos existente.");
                return "ERROR";
            }
            //se toma la base de datos
            DBMetaData d = DBMS.metaData.findDB(DBMS.currentDB);
            TablaMetaData t = d.findTable(tablename);
            //Se ve que existan el objeto
            if(t == null){
                Frame.jTextArea2.setText("ERROR: No existe ninguna tabla con el nombre dado.");
                return "ERROR";
            }
            //Se borra la tabla
            d.tablas.remove(t);
            d.writeMetadata();
            DBMS.metaData.writeMetadata();
            DBMS.guardar();
            //se elimnan los serealizados
            String currentDir = System.getProperty("user.dir");
            File f1  = new File(currentDir+"/DBMS/"+dbActual+"/"+tablename+"_constraints.ser");
            File f2  = new File(currentDir+"/DBMS/"+dbActual+"/"+tablename+"_cols.ser");
            File f3  = new File(currentDir+"/DBMS/"+dbActual+"/"+tablename+".ser");
            if(f1.exists() && f2.exists() && f3.exists())
            {
                System.gc();
                f1.delete();
                f2.delete();
                f3.delete();
            }
            Frame.jTextArea2.setText("Tabla '"+tablename+ "' Borrada existosamente.");
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
            Debug.agregar("Bucando Directorio de Base de Datos...");
            String currentDir = System.getProperty("user.dir");
            System.out.println(currentDir);
            //2. Abrir el archivo de metadata
            File directorio  = new File(currentDir+"/DBMS/master.dat");
            BufferedReader reader = null;
            String [] nombres = null;
            int indiceDosPuntos = 0;
            ArrayList<String> nombresDB = new ArrayList<String>();
            //3. Leer el archivo de metadata 
            Debug.agregar("Bucando Archivo de Metadata...");
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
               if(dbname.equalsIgnoreCase(nombresDB.get(i)))
               {
                   existsDb = true;
                   break;
               }
            }
            if(existsDb)
            {
                DBMS.currentDB = dbname;
                Debug.agregar("AVISO: Se esta usando la base de datos llamada: "+dbname);
                if(!Frame.useVerbose){
                    Frame.jTextArea2.setText("AVISO: Se esta usando la base de datos llamada: "+dbname);
                }                
               
                System.out.println("Si existe la base de datos");
            }
            else
            {
                Debug.agregar("ERROR: No existe la base de datos: "+dbname);
                if(!Frame.useVerbose){
                    Frame.jTextArea2.setText("ERROR: No existe la base de datos: "+dbname);
                }                  
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
             if(DBMS.currentDB==null){
                Frame.jTextArea2.setText("ERROR: No existe ninguna base de datos en uso. Utilice USE DATABASE <nombre> para utilizar una base de datos existente.");
                return "ERROR";
            
            }             
            //Primero revisamos las tablas especificadas en el from
            ArrayList<Tabla> tablasFrom = new ArrayList<Tabla>();
            for(ParseTree n: ctx.table()){
                String tableName = n.getText();
                Tabla t = Tabla.loadTable(tableName);
                if(t==null){
                    Frame.jTextArea2.setText("ERROR: No se encuentra la tabla: "+tableName);
                    return "ERRROR";
                }
                else{
                    tablasFrom.add(t);
                }  
            }
            //Una vez tenemos todas las tablas calculamos el producto cartesiano de ellas
            Tabla temp = productoCartesiano(tablasFrom);
            for(Tupla t: temp.tuplas){
                System.out.println(t.toString());
            }
            
            Loader.iterador = new IteradorTabla(temp,0);
            //Verificamos que existan las columnas del where en la tabla temporal agregandolas a las columnas disponibles
            this.availableCols = new ArrayList<Columna>();
            this.availableCols.addAll(temp.columnas);
            ArrayList<Tupla> resultSelect = new ArrayList<Tupla>(); 
            //Inicialmente agregamos al resultado toda la tabla, si hay where la vaciamos 
            resultSelect.addAll(temp.tuplas);
            if(ctx.WHERE()!=null){
                resultSelect = new ArrayList<Tupla>();
                Object where1 = visit(ctx.expression());
                if(where1 instanceof String){
                    return "ERROR";
                }
                Expression where = (Expression) where1; 
                      
                for(int j =0;j<Loader.iterador.tabla.tuplas.size();j++){
                    Tupla tuplaActual = Loader.iterador.tabla.tuplas.get(j);
                    try {
                        if(where.isTrue()!=null && where.isTrue()){
                            resultSelect.add(tuplaActual);

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Loader.iterador.siguiente(); //Movemos el iterador a la siguiente tupla
                }
            }
            
            //Verificamos que existan las columnas del select en la tabla temporal
            ArrayList<Columna> colsSelect = new ArrayList<Columna>();
            if(ctx.selectList()!=null){
                for(ParseTree n: ctx.selectList().ID()){
                    String col = n.getText();
                    Columna existe = findCol(col,temp.columnas);
                    colsSelect.add(existe);
                    if(existe == null){
                        Frame.jTextArea2.setText("ERROR: No se encuentra la columna."+col);
                        return "ERROR";
                    }

                } 
            }
            else{
                colsSelect.addAll(temp.columnas);
            }
            //Obtenemos los indices de las columnas del select
            ArrayList<Integer> indexSelect = new ArrayList<Integer>();
            for(Columna c: colsSelect){
                int indice = temp.getIndiceColumna(c.nombre);
                indexSelect.add(indice);
            
            }
            //Agregamos al resultado final solo las columnas del select
            ArrayList<Tupla> resultadoFinal = new ArrayList<Tupla>();
            for(Tupla t : resultSelect){
                Tupla tfinal = new Tupla(temp);
                for(int i:indexSelect){
                    Object valor = t.valores.get(i);
                    tfinal.valores.add(valor);
                    
                
                }
                resultadoFinal.add(tfinal);
            
            }
            ArrayList<Orders> orderBy = new ArrayList();
            if(ctx.orderExpr()!=null){
                for(OrderTermContext n: ctx.orderExpr().orderTerm()){
                    String colName = n.colName().getText();
                    String order = "";
                    if(n.ASC()==null && n.DESC()==null){
                        order = "ASC";
                    }
                    else if(n.ASC()!=null){
                        order = "ASC";
                    }
                    else if(n.DESC()!=null){
                        order = "DESC";
                    }
                    Orders oN = new Orders(colName,order);
                    orderBy.add(oN);
                }
            
            
                     
                //Se revisa si existen ORDER BY y de ser asi se toma cada uno sus datos
                ComparatorColumn com = new ComparatorColumn(temp, orderBy);
                com.order();
                System.out.println("--------------------------------");
                for(Tupla t: temp.tuplas){
                    System.out.println(t.toString());
                }
            }
            //Agregamos el resultado al JTable (pendiente)
            ArrayList<String> columnsName = new ArrayList();
            ArrayList<ArrayList<String>> dataToFill = new ArrayList();
            for(Columna c: colsSelect){
                columnsName.add(c.nombre);
            }
           
            for(Tupla tN : resultadoFinal){
                ArrayList<String> tempFill = new ArrayList();
                for(Object ob : tN.valores){
                    if(ob == null){
                        tempFill.add("");
                    }
                    else{
                        tempFill.add(((String)ob.toString()));
                    }
                    
                }
                dataToFill.add(tempFill);
            }
            Resultados newResult = new Resultados(columnsName,dataToFill);
            for(Component i: Frame.forResults.getComponents()){
                Frame.forResults.remove(i);
            }
            Frame.forResults.add(newResult);
            Frame.forResults.revalidate();
            Frame.forResults.repaint();
            return true;
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
                s= s.substring(1);
                s = s.substring(0,s.length()-1);
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
            else if (ctx.NULL()!=null){
                return new Term();
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
		if(ctx.CHAR()!= null){
                    return Columna.CHAR_TYPE;
                }
                else if (ctx.DATE()!= null){
                    return Columna.DATE_TYPE;
                }
                else if (ctx.INT()!= null){
                    return Columna.INT_TYPE;
                    
                }
                else if (ctx.FLOAT()!= null){
                    return Columna.FLOAT_TYPE;
                }
                else{
                    return "ERROR";
                }
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
