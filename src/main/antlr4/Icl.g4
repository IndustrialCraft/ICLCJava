grammar Icl;
@header {
package com.github.industrialcraft.ICLCJava.antlr;
}

/*
 * Parser Rules
 */
package_: KW_PACKAGE name_dcol SEMI;
import_: KW_IMPORT name_dcol SEMI;
name_dcol: NAME (DCOLON NAME)*;
name_dot: NAME (DOT NAME)*;
modificatorClass_: HASH NOT NAME nameArgs?;
modificatorMember_: HASH NAME nameArgs?;
nameArgs: OPARAN (NAME (COMMA NAME)*)? CPARAN;
typeNameArgs: OPARAN (type NAME (COMMA type NAME)*)? CPARAN;
type: NAME NULL? (AND HASH?)?;
visibility: KW_PUBLIC | KW_PROTECTED | KW_PRIVATE;
method_:
	modificatorMember_* visibility? KW_STATIC? type NAME HASH? typeNameArgs (frame | SEMI);
variable_:
	modificatorMember_* visibility? KW_STATIC? type NAME HASH? SEMI;
literal:
	INTEGER_LITERAL
	| FLOAT_LITERAL
	| BOOL_LITERAL
	| STRING_LITERAL;
operator:
	PLUS
	| MINUS
	| MULT
	| DIV
	| MOD
	| ORD
	| ANDD
	| OR
	| AND
	| XOR;
assigns: EQ | PLUSQ | MINUSQ | MULTQ | DIVQ | MODQ | ORQ | ANDQ;
compare: EQEQ | NE | LT | LE | GT | GE;
frame: OBRACE instruction* CBRACE;
frameOrInst: frame | instruction;
exprInstruction: expr SEMI;
assignExprInstruction: type? NAME assigns expr SEMI;
returnInstruction: KW_RETURN expr? SEMI;
continueInstruction: KW_CONTINUE SEMI;
breakInstruction: KW_BREAK expr? SEMI;
ifInstruction: KW_IF OPARAN expr CPARAN frameOrInst (KW_ELSE frameOrInst)?;
forInstruction: KW_FOR OPARAN expr CPARAN frameOrInst (KW_ELSE frameOrInst)?;
whileInstruction: KW_WHILE OPARAN expr CPARAN frameOrInst (KW_ELSE frameOrInst)?;
instruction: exprInstruction | assignExprInstruction | returnInstruction | continueInstruction | breakInstruction | ifInstruction | forInstruction | whileInstruction;
nullcheck: (NULL (OPARAN expr CPARAN)?);

expr:
    OPARAN expr CPARAN #ParanExpr
	| literal #LiteralExpr
	| (NAME | KW_THIS) #NameExpr
	| NOT expr #NotExpr
	| expr operator expr #OperatorExpr
	| expr compare expr #CompareExpr
	| expr nullcheck #NullcheckExpr
	| HASH HASH? expr #CopyExpr
	| NAME OPARAN (expr (COMMA expr)*)? CPARAN #MethodCall
	| expr (CAST | DYNCAST) NAME (OPARAN NAME CPARAN)? #Cast
	| expr (DOT | ARROW) NAME #AccessVar
	| expr (DOT | ARROW) HASH? nullcheck? NAME OPARAN (expr (COMMA expr)*)? CPARAN #AccessMethod
	| expr OSQBRACK expr CSQBRACK #AccessArray;
sourceFile: package_ (import_ | modificatorClass_ | method_ | variable_)*;
//operation: LITERAL '+' LITERAL ;
/*
 * Lexer Rules
 */
INTEGER_LITERAL:
	DEC_DIGIT+
	| '0' [Xx] HEX_DIGIT+
	| '0' [Bb] BIN_DIGIT+;
fragment DEC_DIGIT: [0-9];
fragment HEX_DIGIT: [0-9A-Fa-f];
fragment BIN_DIGIT: [01];

FLOAT_LITERAL:
	DEC_DIGIT+ '.' DEC_DIGIT*
	| DEC_DIGIT* '.' DEC_DIGIT+;
BOOL_LITERAL: 'true' | 'false';
KW_IF: 'if';
KW_ELSE: 'else';
KW_WHILE: 'while';
KW_FOR: 'for';
KW_BREAK: 'break';
KW_CONTINUE: 'continue';
KW_IMPORT: 'import';
KW_RETURN: 'return';
KW_STATIC: 'static';
KW_ABSTRACT: 'abstract';
KW_OVERRIDE: 'override';
KW_DO: 'do';
KW_PUBLIC: 'public';
KW_PRIVATE: 'private';
KW_PROTECTED: 'protected';
KW_TRY: 'try';
KW_CATCH: 'catch';
KW_PACKAGE: 'package';
KW_THIS: 'this';


OBRACE: '{';
CBRACE: '}';
OSQBRACK: '[';
CSQBRACK: ']';
OPARAN: '(';
CPARAN: ')';

ARROW: '->';
CAST: '=>';
DYNCAST: '=?>';

PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
MOD: '%';
NOT: '!';
ORD: '||';
ANDD: '&&';
OR: '|';
AND: '&';
XOR: '^';

PLUSQ: '+=';
MINUSQ: '-=';
MULTQ: '*=';
DIVQ: '/=';
MODQ: '%=';
ORQ: '|=';
ANDQ: '&=';

EQ: '=';
EQEQ: '==';
NE: '!=';
GT: '>';
LT: '<';
GE: '>=';
LE: '<=';

UNDERSCORE: '_';
DOT: '.';
COMMA: ',';
SEMI: ';';
COLON: ':';
DCOLON: '::';
NULL: '?';
HASH: '#';

fragment QUOTE_ESCAPE: '\\' ["];
STRING_LITERAL: '"' ( ~["] | QUOTE_ESCAPE)* '"';

NAME: [a-zA-Z_] [a-zA-Z_0-9]*;

BCOMMENT: '/*' .*? '*/' -> skip;
LCOMMENT: '//' ~[\r\n]* -> skip;

WS: [ \t\r\n]+ -> skip;
