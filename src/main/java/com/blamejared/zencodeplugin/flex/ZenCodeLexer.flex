package com.blamejared.zencodeplugin.flex;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.blamejared.zencodeplugin.psi.ZenCodeTypes.*;

%%

%{
  public _ZenCodeLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _ZenCodeLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R

T_COMMENT_SCRIPT=#[^\n]*[\n\\e]
T_COMMENT_SINGLELINE="//"[^\n]*
T_COMMENT_MULTILINE="/"\\*([^\\*]|(\\*+([^\\*/])))*\\*+"/"
T_IDENTIFIER=@?[a-zA-Z_][a-zA-Z_0-9]*
T_LOCAL_IDENTIFIER=\$[a-zA-Z_][a-zA-Z_0-9]*
T_FLOAT=-?(0|[1-9][0-9]*)\.[0-9]+([eE][+\-]?[0-9]+)?[a-zA-Z_]*
T_INT=-?(0|[1-9][0-9_]*)[a-zA-Z_]*
T_PREFIXED_INT=-?(0b|0x|0o|0B|0X|0O)(0|[1-9a-fA-F][0-9a-fA-F_]*)[a-zA-Z_]*
T_STRING_DQ=\"([^\"\\\n]|\\(\['\\\"\\\/bfnrt&]|u[0-9a-fA-F]{4}))*\"
T_STRING_DQ_WYSIWYG=\"[^\"]\"
T_STRING_SQ='([^'\\\n]|\\(['\"\\/bfnrt&]|u[0-9a-fA-F]{4}))*'
T_STRING_SQ_WYSIWYG=@'[^']'
T_WHITESPACE_TAB=\t
T_WHITESPACE_CARRIAGE_RETURN=\r

%%
<YYINITIAL> {
  " "                             { return T_WHITESPACE_SPACE; }
  {T_WHITESPACE_TAB}              { return T_WHITESPACE_TAB; }
  {T_WHITESPACE_CARRIAGE_RETURN}  { return T_WHITESPACE_CARRIAGE_RETURN; }

  "{"                         { return T_AOPEN; }
  "}"                         { return T_ACLOSE; }
  "["                         { return T_SQOPEN; }
  "]"                         { return T_SQCLOSE; }
  "..."                       { return T_DOT3; }
  ".."                        { return T_DOT2; }
  "."                         { return T_DOT; }
  ","                         { return T_COMMA; }
  "++"                        { return T_INCREMENT; }
  "+="                        { return T_ADDASSIGN; }
  "+"                         { return T_ADD; }
  "--"                        { return T_DECREMENT; }
  "-="                        { return T_SUBASSIGN; }
  "-"                         { return T_SUB; }
  "~="                        { return T_CATASSIGN; }
  "~"                         { return T_CAT; }
  "*="                        { return T_MULASSIGN; }
  "*"                         { return T_MUL; }
  "/="                        { return T_DIVASSIGN; }
  "/"                         { return T_DIV; }
  "%="                        { return T_MODASSIGN; }
  "%"                         { return T_MOD; }
  "|="                        { return T_ORASSIGN; }
  "||"                        { return T_OROR; }
  "|"                         { return T_OR; }
  "&="                        { return T_ANDASSIGN; }
  "&&"                        { return T_ANDAND; }
  "&"                         { return T_AND; }
  "^="                        { return T_XORASSIGN; }
  "^"                         { return T_XOR; }
  "??"                        { return T_COALESCE; }
  "?."                        { return T_OPTCALL; }
  "?"                         { return T_QUEST; }
  ":"                         { return T_COLON; }
  "("                         { return T_BROPEN; }
  ")"                         { return T_BRCLOSE; }
  ";"                         { return T_SEMICOLON; }
  "<="                        { return T_LESSEQ; }
  "<<="                       { return T_SHLASSIGN; }
  "<<"                        { return T_SHL; }
  "<"                         { return T_LESS; }
  "="                         { return T_GREATEREQ; }
  ">>>"                       { return T_USHR; }
  ">>>="                      { return T_USHRASSIGN; }
  ">>="                       { return T_SHRASSIGN; }
  ">>"                        { return T_SHR; }
  ">"                         { return T_GREATER; }
  "=>"                        { return T_LAMBDA; }
  "==="                       { return T_EQUAL3; }
  "=="                        { return T_EQUAL2; }
  "="                         { return T_ASSIGN; }
  "!=="                       { return T_NOTEQUAL2; }
  "!="                        { return T_NOTEQUAL; }
  "!"                         { return T_NOT; }
  "$"                         { return T_DOLLAR; }
  "`"                         { return T_BACKTICK; }
  "import"                    { return K_IMPORT; }
  "alias"                     { return K_ALIAS; }
  "class"                     { return K_CLASS; }
  "function"                  { return K_FUNCTION; }
  "interface"                 { return K_INTERFACE; }
  "enum"                      { return K_ENUM; }
  "struct"                    { return K_STRUCT; }
  "expand"                    { return K_EXPAND; }
  "variant"                   { return K_VARIANT; }
  "abstract"                  { return K_ABSTRACT; }
  "final"                     { return K_FINAL; }
  "override"                  { return K_OVERRIDE; }
  "const"                     { return K_CONST; }
  "private"                   { return K_PRIVATE; }
  "public"                    { return K_PUBLIC; }
  "export"                    { return K_EXPORT; }
  "internal"                  { return K_INTERNAL; }
  "static"                    { return K_STATIC; }
  "protected"                 { return K_PROTECTED; }
  "implicit"                  { return K_IMPLICIT; }
  "virtual"                   { return K_VIRTUAL; }
  "extern"                    { return K_EXTERN; }
  "immutable"                 { return K_IMMUTABLE; }
  "val"                       { return K_VAL; }
  "var"                       { return K_VAR; }
  "get"                       { return K_GET; }
  "implements"                { return K_IMPLEMENTS; }
  "set"                       { return K_SET; }
  "void"                      { return K_VOID; }
  "bool"                      { return K_BOOL; }
  "byte"                      { return K_BYTE; }
  "sbyte"                     { return K_SBYTE; }
  "short"                     { return K_SHORT; }
  "ushort"                    { return K_USHORT; }
  "int"                       { return K_INT; }
  "uint"                      { return K_UINT; }
  "long"                      { return K_LONG; }
  "ulong"                     { return K_ULONG; }
  "usize"                     { return K_USIZE; }
  "float"                     { return K_FLOAT; }
  "double"                    { return K_DOUBLE; }
  "char"                      { return K_CHAR; }
  "string"                    { return K_STRING; }
  "if"                        { return K_IF; }
  "else"                      { return K_ELSE; }
  "do"                        { return K_DO; }
  "while"                     { return K_WHILE; }
  "for"                       { return K_FOR; }
  "throw"                     { return K_THROW; }
  "panic"                     { return K_PANIC; }
  "lock"                      { return K_LOCK; }
  "try"                       { return K_TRY; }
  "catch"                     { return K_CATCH; }
  "finally"                   { return K_FINALLY; }
  "return"                    { return K_RETURN; }
  "break"                     { return K_BREAK; }
  "continue"                  { return K_CONTINUE; }
  "switch"                    { return K_SWITCH; }
  "case"                      { return K_CASE; }
  "default"                   { return K_DEFAULT; }
  "in"                        { return K_IN; }
  "is"                        { return K_IS; }
  "as"                        { return K_AS; }
  "match"                     { return K_MATCH; }
  "throws"                    { return K_THROWS; }
  "super"                     { return K_SUPER; }
  "this"                      { return K_THIS; }
  "null"                      { return K_NULL; }
  "true"                      { return K_TRUE; }
  "false"                     { return K_FALSE; }
  "new"                       { return K_NEW; }
  "K_EXPANSION"               { return K_EXPANSION; }
  "K_AOPEN"                   { return K_AOPEN; }

  {T_COMMENT_SCRIPT}          { return T_COMMENT_SCRIPT; }
  {T_COMMENT_SINGLELINE}      { return T_COMMENT_SINGLELINE; }
  {T_COMMENT_MULTILINE}       { return T_COMMENT_MULTILINE; }
  {T_IDENTIFIER}              { return T_IDENTIFIER; }
  {T_LOCAL_IDENTIFIER}        { return T_LOCAL_IDENTIFIER; }
  {T_FLOAT}                   { return T_FLOAT; }
  {T_INT}                     { return T_INT; }
  {T_PREFIXED_INT}            { return T_PREFIXED_INT; }
  {T_STRING_DQ}               { return T_STRING_DQ; }
  {T_STRING_DQ_WYSIWYG}       { return T_STRING_DQ_WYSIWYG; }
  {T_STRING_SQ}               { return T_STRING_SQ; }
  {T_STRING_SQ_WYSIWYG}       { return T_STRING_SQ_WYSIWYG; }

}

[^] { return BAD_CHARACTER; }
