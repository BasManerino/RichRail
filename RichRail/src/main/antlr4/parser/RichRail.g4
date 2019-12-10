grammar RichRail;

// Rules
command         : newcommand | addcommand | getcommand | delcommand | remcommand;
newcommand      : 'new' type ID ('numseats' NUMBER)? ('maxweight' NUMBER)?;
addcommand      : 'add' ID 'to' ID;
getcommand      : 'get' option type ID;
delcommand      : 'delete' type ID;
remcommand      : 'remove' ID 'from' ID;

option			: 'numseats' | 'maxweight';
type            : 'train' | 'wagon';

// Tokens
ID          : ('a'..'z')('a'..'z'|'0'..'9')*;
NUMBER      : ('0'..'9')+;
WHITESPACE  : [ \t\r\n\u000C] -> skip;