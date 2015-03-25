
grammar SQL;
/*---------------TERMINALES Y PALABRAS RESERVADAS-------------------------- */
CREATE: 'CREATE';
DATABASE: 'DATABASE';
DATABASES: 'DATABASES';
ALTER: 'ALTER';
RENAMETO: 'RENAME TO';
DROP: 'DROP';
SHOW: 'SHOW';
USE:'USE';
TABLE: 'TABLE';
INT:'INT';
FLOAT:'FLOAT';
DATE:'DATE';
CHAR:'CHAR';
CONSTRAINT: 'CONSTRAINT';
PRIMARY: 'PRIMARY';
KEY: 'KEY';
FOREIGN: 'FOREIGN';
CHECK:'CHECK';
REFERENCES:'REFERENCES';
TABLES:'TABLES';
COLUMN:'COLUMN';
COLUMNS: 'COLUMNS';
FROM:'FROM';
ADD:'ADD';
AND: 'AND';
OR: 'OR';
NOT: 'NOT';
INSERT:'INSERT';
INTO:'INTO';
WHERE:'WHERE';
UPDATE:'UPDATE';
SET:'SET';
DELETE:'DELETE';
SELECT: 'SELECT';
ORDER:'ORDER';
BY: 'BY';
ASC: 'ASC';
DESC: 'DESC';
VALUES: 'VALUES';
fragment LETTER: ('a'..'z'|'A'..'Z') ;
fragment DIGIT : '0'..'9' ;

WS : [ \t\r\n\f]+  ->channel(HIDDEN);
DATE_VAL: '\''DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT'\'' ;
NUM: DIGIT(DIGIT)* ;
ID : LETTER( LETTER | DIGIT | '_' | '-') * ;
CHAR_VAL: '\'' ~('\r' | '\n' | '\'')* '\'' ;
FLOAT_VAL: NUM'.'NUM;
/*---------------------------------------------------------- */

/* ----------------------GRAMATICA------------------------- */
query: ddlQuery | dmlQuery ;
/*-----DDL QUERIES---- */
ddlQuery:   createDbStmt|
			alterDbStmt|
			dropDbStmt|
			showDbStmt|
			useDbStmt|
			createTableStmt|
			alterTableStmt|
			dropTableStmt|
			showTableStmt|
			showColumnsStmt;
			
createDbStmt: CREATE DATABASE ID; 

alterDbStmt: ALTER DATABASE dbName RENAMETO newDbName;
	dbName: ID;
	newDbName:ID;
	
dropDbStmt: DROP DATABASE ID;
showDbStmt: SHOW DATABASES;
useDbStmt: USE DATABASE ID;

createTableStmt: CREATE TABLE tableName '('    (columnDecl (','columnDecl)* ) (   (',' CONSTRAINT colConstraint)*)?   ')';  //Revisar Constraints: por tabla
	tableName: ID;
	
	columnDecl: colName tipo  ;
		tipo: INT|FLOAT|DATE|CHAR'('NUM')'; //Formato DATE: ‘AAAA-MM-DD’
		colName: ID;
		
		colConstraint:  (pkNombre PRIMARY KEY '(' (localids(','localids)*)')'
						|fkNombre FOREIGN KEY '(' (localids (','localids)* ) ')' REFERENCES idTabla '('(refids(','refids)*)')' 
						|chNombre CHECK '(' expression ')' );
			localids: ID;
			refids:ID;
			chNombre: ID;				
			idTabla: ID ;
			fkNombre:ID;
			pkNombre: ID;
			 //PENDIENTE

alterTableStmt: ALTER TABLE alterName RENAMETO newName #renameAlter | ALTER TABLE alterName accion (','accion)*     #accionAlter ;
	alterName: ID;
	newName: ID;
	accion: ADD COLUMN columnName tipo  (singleColConstraint)* |
			ADD CONSTRAINT colConstraint| /* constraint de tabla  */
			DROP COLUMN columnName|
			DROP CONSTRAINT ID;
		columnName: ID;
	
	singleColConstraint: CONSTRAINT pkNombre PRIMARY KEY|
						 CONSTRAINT fkNombre REFERENCES idTabla '(' refids ')' |
						 CONSTRAINT chNombre CHECK '(' expression ')';

					  
dropTableStmt: DROP TABLE ID;
showTableStmt: SHOW TABLES;
showColumnsStmt: SHOW COLUMNS FROM ID;

expression: andexpr | expression OR andexpr;
	andexpr: factor | andexpr AND factor;
	factor: primary | NOT primary;
	primary: compareExpr | '(' expression ')';
	compareExpr : term  rel_op term;
	term: column | NUM | FLOAT_VAL | DATE_VAL | CHAR_VAL;

column: ID| table'.'ID;
table: ID;
rel_op : '<' | '>' | '<=' | '>=' | '=' | '<>' ;


/* END ----- DDL QUERIES----- */

dmlQuery: multiInsert | updateStmt | deleteStmt| selectStmt; 

multiInsert: (insertStmt)(';' insertStmt)* ;
insertStmt: INSERT INTO table (columnList)? VALUES valueList ;
	columnList:  '('  colName (','colName)* ')';
	valueList: '(' val(',' val)* ')' ;
	val: NUM | FLOAT_VAL | DATE_VAL | CHAR_VAL ;

updateStmt: UPDATE table SET columnsUpdate '=' val (',' columnsUpdate '=' val)* (WHERE expression)? ;
	columnsUpdate:ID ;
	

deleteStmt: DELETE FROM table (WHERE expression)?;

selectStmt: SELECT ('*'| selectList) FROM table(','table)* (WHERE expression)? (orderExpr)? ;
	selectList: ID(','ID);
	orderExpr: ORDER BY (orderTerm(','orderTerm)*);
	orderTerm: colName(ASC|DESC)? ;
	
	