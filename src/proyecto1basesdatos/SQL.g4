
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
COLUMNS: 'COLUMNS';
FROM:'FROM';
ADD:'ADD';
COLUMN:'COLUMNS';
RENAME:'RENAME';
TO:'TO';
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
fragment LETTER: ('a'..'z'|'A'..'Z') ;
fragment DIGIT : '0'..'9' ;

WS : [ \t\r\n\f]+  ->channel(HIDDEN);
DATE_VAL: DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ;
NUM: DIGIT(DIGIT)* ;
ID : LETTER( LETTER | DIGIT)* ;
CHAR_VAL: '\'' ~('\r' | '\n' | '"')* '\'' ;
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

createTableStmt: CREATE TABLE tableName '('    (columnDecl (','columnDecl)* ) (   (','colConstraint)*)?   ')';  //Revisar Constraints: por tabla
	tableName: ID;
	
	columnDecl: colName tipo  ;
		tipo: INT|FLOAT|DATE|CHAR'('NUM')'; //Formato DATE: ‘AAAA-MM-DD’
		colName: ID;
		
		colConstraint: CONSTRAINT (pkNombre PRIMARY KEY '(' (localids(','localids)*)')'
						|fkNombre FOREIGN KEY '(' (localids (','localids)* ) ')' REFERENCES idTabla '('(refids(','refids)*)')' 
						|chNombre CHECK '(' expression ')' );
			localids: ID;
			refids:ID;
			chNombre: ID;				
			idTabla: ID ;
			fkNombre:ID;
			pkNombre: ID;
			 //PENDIENTE

alterTableStmt: ALTER TABLE alterName RENAME TO newName #renameAlter | ALTER TABLE ID (accion | accion(','accion)+  ) #accionAlter ;
	alterName: ID;
	newName: ID;
	accion: ADD COLUMN columnName tipo CONSTRAINT colConstraint|
			ADD CONSTRAINT colConstraint| /* constraint de tabla  */
			DROP COLUMN columnName|
			DROP CONSTRAINT ID;
		columnName: ID;
	
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

dmlQuery: insertStmt | updateStmt | deleteStmt| selectStmt; 

insertStmt: INSERT INTO table (columnList)? valueList ;
	columnList:  '('  ID (','ID)* ')';
	valueList: val(val)* ;
	val: NUM | FLOAT_VAL | DATE_VAL | CHAR_VAL ;

updateStmt: UPDATE table SET columnsUpdate '=' val (',' columnsUpdate '=' val)* (WHERE expression)? ;
	columnsUpdate:ID ;
	

deleteStmt: DELETE FROM table (WHERE expression)?;

selectStmt: SELECT ('*'| selectList) FROM table WHERE expression (orderExpr)? ;
	selectList: ID(','ID);
	orderExpr: ORDER BY (orderExpr(','orderExpr)*);
	orderTerm: colName(ASC|DESC)? ;
	
	