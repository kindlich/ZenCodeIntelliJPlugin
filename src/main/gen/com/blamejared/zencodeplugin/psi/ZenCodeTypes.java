// This is a generated file. Not intended for manual editing.
package com.blamejared.zencodeplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.blamejared.zencodeplugin.psi.impl.*;

public interface ZenCodeTypes {

  IElementType DECLARE_VARIABLE_NAME = new ZenCodeElementType("DECLARE_VARIABLE_NAME");
  IElementType EXPRESSION = new ZenCodeElementType("EXPRESSION");
  IElementType EXPRESSION_BEP = new ZenCodeElementType("EXPRESSION_BEP");
  IElementType IMPORT = new ZenCodeElementType("IMPORT");
  IElementType STATEMENT_BLOCK = new ZenCodeElementType("STATEMENT_BLOCK");
  IElementType STATEMENT_BREAK = new ZenCodeElementType("STATEMENT_BREAK");
  IElementType STATEMENT_CONTINUE = new ZenCodeElementType("STATEMENT_CONTINUE");
  IElementType STATEMENT_DO_WHILE = new ZenCodeElementType("STATEMENT_DO_WHILE");
  IElementType STATEMENT_EXPRESSION = new ZenCodeElementType("STATEMENT_EXPRESSION");
  IElementType STATEMENT_FOR_EACH = new ZenCodeElementType("STATEMENT_FOR_EACH");
  IElementType STATEMENT_IF = new ZenCodeElementType("STATEMENT_IF");
  IElementType STATEMENT_LOCK = new ZenCodeElementType("STATEMENT_LOCK");
  IElementType STATEMENT_RETURN = new ZenCodeElementType("STATEMENT_RETURN");
  IElementType STATEMENT_SWITCH = new ZenCodeElementType("STATEMENT_SWITCH");
  IElementType STATEMENT_TRY_CATCH = new ZenCodeElementType("STATEMENT_TRY_CATCH");
  IElementType STATEMENT_VAR = new ZenCodeElementType("STATEMENT_VAR");
  IElementType STATEMENT_WHILE_DO = new ZenCodeElementType("STATEMENT_WHILE_DO");
  IElementType TYPE = new ZenCodeElementType("TYPE");
  IElementType VARIABLE_NAME = new ZenCodeElementType("VARIABLE_NAME");
  IElementType ZC_STRING_LITERAL = new ZenCodeElementType("ZC_STRING_LITERAL");

  IElementType K_ABSTRACT = new ZenCodeTokenType("abstract");
  IElementType K_ALIAS = new ZenCodeTokenType("alias");
  IElementType K_AS = new ZenCodeTokenType("as");
  IElementType K_BOOL = new ZenCodeTokenType("bool");
  IElementType K_BREAK = new ZenCodeTokenType("break");
  IElementType K_BYTE = new ZenCodeTokenType("byte");
  IElementType K_CASE = new ZenCodeTokenType("case");
  IElementType K_CATCH = new ZenCodeTokenType("catch");
  IElementType K_CHAR = new ZenCodeTokenType("char");
  IElementType K_CLASS = new ZenCodeTokenType("class");
  IElementType K_CONST = new ZenCodeTokenType("const");
  IElementType K_CONTINUE = new ZenCodeTokenType("continue");
  IElementType K_DEFAULT = new ZenCodeTokenType("default");
  IElementType K_DO = new ZenCodeTokenType("do");
  IElementType K_DOUBLE = new ZenCodeTokenType("double");
  IElementType K_ELSE = new ZenCodeTokenType("else");
  IElementType K_ENUM = new ZenCodeTokenType("enum");
  IElementType K_EXPAND = new ZenCodeTokenType("expand");
  IElementType K_EXPANSION = new ZenCodeTokenType("K_EXPANSION");
  IElementType K_EXPORT = new ZenCodeTokenType("export");
  IElementType K_EXTERN = new ZenCodeTokenType("extern");
  IElementType K_FALSE = new ZenCodeTokenType("false");
  IElementType K_FINAL = new ZenCodeTokenType("final");
  IElementType K_FINALLY = new ZenCodeTokenType("finally");
  IElementType K_FLOAT = new ZenCodeTokenType("float");
  IElementType K_FOR = new ZenCodeTokenType("for");
  IElementType K_FUNCTION = new ZenCodeTokenType("function");
  IElementType K_GET = new ZenCodeTokenType("get");
  IElementType K_IF = new ZenCodeTokenType("if");
  IElementType K_IMMUTABLE = new ZenCodeTokenType("immutable");
  IElementType K_IMPLEMENTS = new ZenCodeTokenType("implements");
  IElementType K_IMPLICIT = new ZenCodeTokenType("implicit");
  IElementType K_IMPORT = new ZenCodeTokenType("import");
  IElementType K_IN = new ZenCodeTokenType("in");
  IElementType K_INT = new ZenCodeTokenType("int");
  IElementType K_INTERFACE = new ZenCodeTokenType("interface");
  IElementType K_INTERNAL = new ZenCodeTokenType("internal");
  IElementType K_IS = new ZenCodeTokenType("is");
  IElementType K_LOCK = new ZenCodeTokenType("lock");
  IElementType K_LONG = new ZenCodeTokenType("long");
  IElementType K_MATCH = new ZenCodeTokenType("match");
  IElementType K_NEW = new ZenCodeTokenType("new");
  IElementType K_NULL = new ZenCodeTokenType("null");
  IElementType K_OVERRIDE = new ZenCodeTokenType("override");
  IElementType K_PANIC = new ZenCodeTokenType("panic");
  IElementType K_PRIVATE = new ZenCodeTokenType("private");
  IElementType K_PROTECTED = new ZenCodeTokenType("protected");
  IElementType K_PUBLIC = new ZenCodeTokenType("public");
  IElementType K_RETURN = new ZenCodeTokenType("return");
  IElementType K_SBYTE = new ZenCodeTokenType("sbyte");
  IElementType K_SET = new ZenCodeTokenType("set");
  IElementType K_SHORT = new ZenCodeTokenType("short");
  IElementType K_STATIC = new ZenCodeTokenType("static");
  IElementType K_STRING = new ZenCodeTokenType("string");
  IElementType K_STRUCT = new ZenCodeTokenType("struct");
  IElementType K_SUPER = new ZenCodeTokenType("super");
  IElementType K_SWITCH = new ZenCodeTokenType("switch");
  IElementType K_THIS = new ZenCodeTokenType("this");
  IElementType K_THROW = new ZenCodeTokenType("throw");
  IElementType K_THROWS = new ZenCodeTokenType("throws");
  IElementType K_TRUE = new ZenCodeTokenType("true");
  IElementType K_TRY = new ZenCodeTokenType("try");
  IElementType K_UINT = new ZenCodeTokenType("uint");
  IElementType K_ULONG = new ZenCodeTokenType("ulong");
  IElementType K_USHORT = new ZenCodeTokenType("ushort");
  IElementType K_USIZE = new ZenCodeTokenType("usize");
  IElementType K_VAL = new ZenCodeTokenType("val");
  IElementType K_VAR = new ZenCodeTokenType("var");
  IElementType K_VARIANT = new ZenCodeTokenType("variant");
  IElementType K_VIRTUAL = new ZenCodeTokenType("virtual");
  IElementType K_VOID = new ZenCodeTokenType("void");
  IElementType K_WHILE = new ZenCodeTokenType("while");
  IElementType T_ACLOSE = new ZenCodeTokenType("}");
  IElementType T_ADD = new ZenCodeTokenType("+");
  IElementType T_ADDASSIGN = new ZenCodeTokenType("+=");
  IElementType T_AND = new ZenCodeTokenType("&");
  IElementType T_ANDAND = new ZenCodeTokenType("&&");
  IElementType T_ANDASSIGN = new ZenCodeTokenType("&=");
  IElementType T_AOPEN = new ZenCodeTokenType("{");
  IElementType T_ASSIGN = new ZenCodeTokenType("=");
  IElementType T_BACKTICK = new ZenCodeTokenType("`");
  IElementType T_BRCLOSE = new ZenCodeTokenType(")");
  IElementType T_BROPEN = new ZenCodeTokenType("(");
  IElementType T_CAT = new ZenCodeTokenType("~");
  IElementType T_CATASSIGN = new ZenCodeTokenType("~=");
  IElementType T_COALESCE = new ZenCodeTokenType("??");
  IElementType T_COLON = new ZenCodeTokenType(":");
  IElementType T_COMMA = new ZenCodeTokenType(",");
  IElementType T_COMMENT_MULTILINE = new ZenCodeTokenType("T_COMMENT_MULTILINE");
  IElementType T_COMMENT_SCRIPT = new ZenCodeTokenType("T_COMMENT_SCRIPT");
  IElementType T_COMMENT_SINGLELINE = new ZenCodeTokenType("T_COMMENT_SINGLELINE");
  IElementType T_DECREMENT = new ZenCodeTokenType("--");
  IElementType T_DIV = new ZenCodeTokenType("/");
  IElementType T_DIVASSIGN = new ZenCodeTokenType("/=");
  IElementType T_DOLLAR = new ZenCodeTokenType("$");
  IElementType T_DOT = new ZenCodeTokenType(".");
  IElementType T_DOT2 = new ZenCodeTokenType("..");
  IElementType T_DOT3 = new ZenCodeTokenType("...");
  IElementType T_EQUAL2 = new ZenCodeTokenType("==");
  IElementType T_EQUAL3 = new ZenCodeTokenType("===");
  IElementType T_FLOAT = new ZenCodeTokenType("T_FLOAT");
  IElementType T_GREATER = new ZenCodeTokenType(">");
  IElementType T_GREATEREQ = new ZenCodeTokenType(">=");
  IElementType T_IDENTIFIER = new ZenCodeTokenType("T_IDENTIFIER");
  IElementType T_INCREMENT = new ZenCodeTokenType("++");
  IElementType T_INT = new ZenCodeTokenType("T_INT");
  IElementType T_LAMBDA = new ZenCodeTokenType("=>");
  IElementType T_LESS = new ZenCodeTokenType("<");
  IElementType T_LESSEQ = new ZenCodeTokenType("<=");
  IElementType T_LOCAL_IDENTIFIER = new ZenCodeTokenType("T_LOCAL_IDENTIFIER");
  IElementType T_MOD = new ZenCodeTokenType("%");
  IElementType T_MODASSIGN = new ZenCodeTokenType("%=");
  IElementType T_MUL = new ZenCodeTokenType("*");
  IElementType T_MULASSIGN = new ZenCodeTokenType("*=");
  IElementType T_NOT = new ZenCodeTokenType("!");
  IElementType T_NOTEQUAL = new ZenCodeTokenType("!=");
  IElementType T_NOTEQUAL2 = new ZenCodeTokenType("!==");
  IElementType T_OPTCALL = new ZenCodeTokenType("?.");
  IElementType T_OR = new ZenCodeTokenType("|");
  IElementType T_ORASSIGN = new ZenCodeTokenType("|=");
  IElementType T_OROR = new ZenCodeTokenType("||");
  IElementType T_PREFIXED_INT = new ZenCodeTokenType("T_PREFIXED_INT");
  IElementType T_QUEST = new ZenCodeTokenType("?");
  IElementType T_SEMICOLON = new ZenCodeTokenType(";");
  IElementType T_SHL = new ZenCodeTokenType("<<");
  IElementType T_SHLASSIGN = new ZenCodeTokenType("<<=");
  IElementType T_SHR = new ZenCodeTokenType(">>");
  IElementType T_SHRASSIGN = new ZenCodeTokenType(">>=");
  IElementType T_SQCLOSE = new ZenCodeTokenType("]");
  IElementType T_SQOPEN = new ZenCodeTokenType("[");
  IElementType T_STRING_DQ = new ZenCodeTokenType("T_STRING_DQ");
  IElementType T_STRING_DQ_WYSIWYG = new ZenCodeTokenType("T_STRING_DQ_WYSIWYG");
  IElementType T_STRING_SQ = new ZenCodeTokenType("T_STRING_SQ");
  IElementType T_STRING_SQ_WYSIWYG = new ZenCodeTokenType("T_STRING_SQ_WYSIWYG");
  IElementType T_SUB = new ZenCodeTokenType("-");
  IElementType T_SUBASSIGN = new ZenCodeTokenType("-=");
  IElementType T_USHR = new ZenCodeTokenType(">>>");
  IElementType T_USHRASSIGN = new ZenCodeTokenType(">>>=");
  IElementType T_WHITESPACE_CARRIAGE_RETURN = new ZenCodeTokenType("\\r");
  IElementType T_WHITESPACE_NEWLINE = new ZenCodeTokenType("\\n");
  IElementType T_WHITESPACE_SPACE = new ZenCodeTokenType(" ");
  IElementType T_WHITESPACE_TAB = new ZenCodeTokenType("\\t");
  IElementType T_XOR = new ZenCodeTokenType("^");
  IElementType T_XORASSIGN = new ZenCodeTokenType("^=");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == DECLARE_VARIABLE_NAME) {
        return new ZenCodeDeclareVariableNameImpl(node);
      }
      else if (type == EXPRESSION) {
        return new ZenCodeExpressionImpl(node);
      }
      else if (type == EXPRESSION_BEP) {
        return new ZenCodeExpressionBEPImpl(node);
      }
      else if (type == IMPORT) {
        return new ZenCodeImportImpl(node);
      }
      else if (type == STATEMENT_BLOCK) {
        return new ZenCodeStatementBlockImpl(node);
      }
      else if (type == STATEMENT_BREAK) {
        return new ZenCodeStatementBreakImpl(node);
      }
      else if (type == STATEMENT_CONTINUE) {
        return new ZenCodeStatementContinueImpl(node);
      }
      else if (type == STATEMENT_DO_WHILE) {
        return new ZenCodeStatementDoWhileImpl(node);
      }
      else if (type == STATEMENT_EXPRESSION) {
        return new ZenCodeStatementExpressionImpl(node);
      }
      else if (type == STATEMENT_FOR_EACH) {
        return new ZenCodeStatementForEachImpl(node);
      }
      else if (type == STATEMENT_IF) {
        return new ZenCodeStatementIfImpl(node);
      }
      else if (type == STATEMENT_LOCK) {
        return new ZenCodeStatementLockImpl(node);
      }
      else if (type == STATEMENT_RETURN) {
        return new ZenCodeStatementReturnImpl(node);
      }
      else if (type == STATEMENT_SWITCH) {
        return new ZenCodeStatementSwitchImpl(node);
      }
      else if (type == STATEMENT_TRY_CATCH) {
        return new ZenCodeStatementTryCatchImpl(node);
      }
      else if (type == STATEMENT_VAR) {
        return new ZenCodeStatementVarImpl(node);
      }
      else if (type == STATEMENT_WHILE_DO) {
        return new ZenCodeStatementWhileDoImpl(node);
      }
      else if (type == TYPE) {
        return new ZenCodeTypeImpl(node);
      }
      else if (type == VARIABLE_NAME) {
        return new ZenCodeVariableNameImpl(node);
      }
      else if (type == ZC_STRING_LITERAL) {
        return new ZenCodeZCStringLiteralImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
