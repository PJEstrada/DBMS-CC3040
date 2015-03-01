
grammar SQL;

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
fragment LETTER: ('a'..'z'|'A'..'Z') ;
fragment DIGIT : '0'..'9' ;
ID : LETTER( LETTER | DIGIT)* ;


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

createTableStmt: CREATE TABLE tableName '('    (columnDecl | columnDecl(','columnDecl)+ )    ')';  //Revisar Constraints: son por columna o por tabla?
	tableName: ID;
	
	columnDecl: colName tipo (CONSTRAINT colConstraint)? ;
		tipo: INT|FLOAT|DATE|CHAR; //Formato DATE: ‘AAAA-MM-DD’
		colName: ID;
		
		colConstraint:  pkNombre PRIMARY KEY '(' (ID)+')'
						|fkNombre FOREIGN KEY '(' (ID)+ ')' REFERENCES idTabla '('(ID)+')' 
						|chNombre CHECK '(' expConstraint ')' ;
			chNombre: ID;				
			idTabla: ID ;
			fkNombre:ID;
			pkNombre: ID;
			expConstraint: ; //PENDIENTE

alterTableStmt: ALTER TABLE alterName RENAME TO newName #renameAlter | ALTER TABLE ID (accion | accion(','accion)+  ) #accionAlter ;
	alterName: ID;
	newName: ID;
	accion: ADD COLUMN columnName tipo CONSTRAINT colConstraint|
			ADD CONSTRAINT colConstraint| /* constraint de tabla o de columna?? */
			DROP COLUMN columnName|
			DROP CONSTRAINT ID;
		columnName: ID;
	
dropTableStmt: DROP TABLE ID;
showTableStmt: SHOW TABLES;
showColumnsStmt: SHOW COLUMNS FROM ID;


/* END ----- DDL QUERIES----- */

dmlQuery: ; 