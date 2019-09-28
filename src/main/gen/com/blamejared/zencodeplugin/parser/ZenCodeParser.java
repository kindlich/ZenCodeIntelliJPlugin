// This is a generated file. Not intended for manual editing.
package com.blamejared.zencodeplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.blamejared.zencodeplugin.psi.ZenCodeTypes.*;
import static com.blamejared.zencodeplugin.parser.ZenCodeParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ZenCodeParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t instanceof IFileElementType) {
      r = parse_root_(t, b, 0);
    }
    else {
      r = false;
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return ZenCodeFile(b, l + 1);
  }

  /* ********************************************************** */
  // T_ADD | T_SUB | T_CAT
  static boolean AddOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AddOperator")) return false;
    boolean r;
    r = consumeToken(b, T_ADD);
    if (!r) r = consumeToken(b, T_SUB);
    if (!r) r = consumeToken(b, T_CAT);
    return r;
  }

  /* ********************************************************** */
  // K_ALIAS T_IDENTIFIER T_AOPEN [Member*] T_ACLOSE
  static boolean AliasDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AliasDefinition")) return false;
    if (!nextTokenIs(b, K_ALIAS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_ALIAS, T_IDENTIFIER, T_AOPEN);
    r = r && AliasDefinition_3(b, l + 1);
    r = r && consumeToken(b, T_ACLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [Member*]
  private static boolean AliasDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AliasDefinition_3")) return false;
    AliasDefinition_3_0(b, l + 1);
    return true;
  }

  // Member*
  private static boolean AliasDefinition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AliasDefinition_3_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Member(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "AliasDefinition_3_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_SQOPEN T_IDENTIFIER T_SQCLOSE
  static boolean Annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Annotation")) return false;
    if (!nextTokenIs(b, T_SQOPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_SQOPEN, T_IDENTIFIER, T_SQCLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Annotation*
  static boolean Annotations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Annotations")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Annotation(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Annotations", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_IDENTIFIER
  static boolean AnyToken(PsiBuilder b, int l) {
    return consumeToken(b, T_IDENTIFIER);
  }

  /* ********************************************************** */
  // T_ASSIGN | T_ADDASSIGN | T_SUBASSIGN | T_CATASSIGN | T_MULASSIGN | T_DIVASSIGN | T_MODASSIGN | T_ORASSIGN | T_ANDASSIGN | T_XORASSIGN | T_SHLASSIGN | T_SHRASSIGN | T_USHRASSIGN
  static boolean AssignOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignOperator")) return false;
    boolean r;
    r = consumeToken(b, T_ASSIGN);
    if (!r) r = consumeToken(b, T_ADDASSIGN);
    if (!r) r = consumeToken(b, T_SUBASSIGN);
    if (!r) r = consumeToken(b, T_CATASSIGN);
    if (!r) r = consumeToken(b, T_MULASSIGN);
    if (!r) r = consumeToken(b, T_DIVASSIGN);
    if (!r) r = consumeToken(b, T_MODASSIGN);
    if (!r) r = consumeToken(b, T_ORASSIGN);
    if (!r) r = consumeToken(b, T_ANDASSIGN);
    if (!r) r = consumeToken(b, T_XORASSIGN);
    if (!r) r = consumeToken(b, T_SHLASSIGN);
    if (!r) r = consumeToken(b, T_SHRASSIGN);
    if (!r) r = consumeToken(b, T_USHRASSIGN);
    return r;
  }

  /* ********************************************************** */
  // T_BROPEN [Expression [(T_COMMA Expression)*]] T_BRCLOSE
  static boolean CallArguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallArguments")) return false;
    if (!nextTokenIs(b, T_BROPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_BROPEN);
    r = r && CallArguments_1(b, l + 1);
    r = r && consumeToken(b, T_BRCLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [Expression [(T_COMMA Expression)*]]
  private static boolean CallArguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallArguments_1")) return false;
    CallArguments_1_0(b, l + 1);
    return true;
  }

  // Expression [(T_COMMA Expression)*]
  private static boolean CallArguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallArguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && CallArguments_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_COMMA Expression)*]
  private static boolean CallArguments_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallArguments_1_0_1")) return false;
    CallArguments_1_0_1_0(b, l + 1);
    return true;
  }

  // (T_COMMA Expression)*
  private static boolean CallArguments_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallArguments_1_0_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!CallArguments_1_0_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CallArguments_1_0_1_0", c)) break;
    }
    return true;
  }

  // T_COMMA Expression
  private static boolean CallArguments_1_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallArguments_1_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_CLASS T_IDENTIFIER T_AOPEN [Member*] T_ACLOSE
  static boolean ClassDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinition")) return false;
    if (!nextTokenIs(b, K_CLASS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_CLASS, T_IDENTIFIER, T_AOPEN);
    r = r && ClassDefinition_3(b, l + 1);
    r = r && consumeToken(b, T_ACLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [Member*]
  private static boolean ClassDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinition_3")) return false;
    ClassDefinition_3_0(b, l + 1);
    return true;
  }

  // Member*
  private static boolean ClassDefinition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinition_3_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Member(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ClassDefinition_3_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_EQUAL2 | T_EQUAL3 | T_NOTEQUAL | T_NOTEQUAL2 | T_LESS | T_LESSEQ | T_GREATER | T_GREATEREQ | K_IN | K_IS | (T_NOT (K_IN | K_IS))
  static boolean CompareOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompareOperator")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_EQUAL2);
    if (!r) r = consumeToken(b, T_EQUAL3);
    if (!r) r = consumeToken(b, T_NOTEQUAL);
    if (!r) r = consumeToken(b, T_NOTEQUAL2);
    if (!r) r = consumeToken(b, T_LESS);
    if (!r) r = consumeToken(b, T_LESSEQ);
    if (!r) r = consumeToken(b, T_GREATER);
    if (!r) r = consumeToken(b, T_GREATEREQ);
    if (!r) r = consumeToken(b, K_IN);
    if (!r) r = consumeToken(b, K_IS);
    if (!r) r = CompareOperator_10(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_NOT (K_IN | K_IS)
  private static boolean CompareOperator_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompareOperator_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_NOT);
    r = r && CompareOperator_10_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // K_IN | K_IS
  private static boolean CompareOperator_10_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompareOperator_10_1")) return false;
    boolean r;
    r = consumeToken(b, K_IN);
    if (!r) r = consumeToken(b, K_IS);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER
  public static boolean DeclareVariableName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DeclareVariableName")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    exit_section_(b, m, DECLARE_VARIABLE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // (Annotation*)? [DefinitionModifier*] (ClassDefinition|InterfaceDefinition|EnumDefinition|StructDefinition|AliasDefinition|FunctionDefinition|ExpansionDefinition|VariantDefinition)
  static boolean Definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Definition")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Definition_0(b, l + 1);
    r = r && Definition_1(b, l + 1);
    r = r && Definition_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (Annotation*)?
  private static boolean Definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Definition_0")) return false;
    Definition_0_0(b, l + 1);
    return true;
  }

  // Annotation*
  private static boolean Definition_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Definition_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Annotation(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Definition_0_0", c)) break;
    }
    return true;
  }

  // [DefinitionModifier*]
  private static boolean Definition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Definition_1")) return false;
    Definition_1_0(b, l + 1);
    return true;
  }

  // DefinitionModifier*
  private static boolean Definition_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Definition_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DefinitionModifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Definition_1_0", c)) break;
    }
    return true;
  }

  // ClassDefinition|InterfaceDefinition|EnumDefinition|StructDefinition|AliasDefinition|FunctionDefinition|ExpansionDefinition|VariantDefinition
  private static boolean Definition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Definition_2")) return false;
    boolean r;
    r = ClassDefinition(b, l + 1);
    if (!r) r = InterfaceDefinition(b, l + 1);
    if (!r) r = EnumDefinition(b, l + 1);
    if (!r) r = StructDefinition(b, l + 1);
    if (!r) r = AliasDefinition(b, l + 1);
    if (!r) r = FunctionDefinition(b, l + 1);
    if (!r) r = ExpansionDefinition(b, l + 1);
    if (!r) r = VariantDefinition(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // K_PUBLIC|K_PRIVATE|K_CONST|K_INTERNAL|K_EXTERN|K_ABSTRACT|K_FINAL|K_PROTECTED|K_IMPLICIT|K_VIRTUAL
  static boolean DefinitionModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DefinitionModifier")) return false;
    boolean r;
    r = consumeToken(b, K_PUBLIC);
    if (!r) r = consumeToken(b, K_PRIVATE);
    if (!r) r = consumeToken(b, K_CONST);
    if (!r) r = consumeToken(b, K_INTERNAL);
    if (!r) r = consumeToken(b, K_EXTERN);
    if (!r) r = consumeToken(b, K_ABSTRACT);
    if (!r) r = consumeToken(b, K_FINAL);
    if (!r) r = consumeToken(b, K_PROTECTED);
    if (!r) r = consumeToken(b, K_IMPLICIT);
    if (!r) r = consumeToken(b, K_VIRTUAL);
    return r;
  }

  /* ********************************************************** */
  // K_ENUM T_IDENTIFIER T_AOPEN [Member*] T_ACLOSE
  static boolean EnumDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDefinition")) return false;
    if (!nextTokenIs(b, K_ENUM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_ENUM, T_IDENTIFIER, T_AOPEN);
    r = r && EnumDefinition_3(b, l + 1);
    r = r && consumeToken(b, T_ACLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [Member*]
  private static boolean EnumDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDefinition_3")) return false;
    EnumDefinition_3_0(b, l + 1);
    return true;
  }

  // Member*
  private static boolean EnumDefinition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDefinition_3_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Member(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "EnumDefinition_3_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // K_EXPANSION T_IDENTIFIER T_AOPEN [Member*] T_ACLOSE
  static boolean ExpansionDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpansionDefinition")) return false;
    if (!nextTokenIs(b, K_EXPANSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_EXPANSION, T_IDENTIFIER, T_AOPEN);
    r = r && ExpansionDefinition_3(b, l + 1);
    r = r && consumeToken(b, T_ACLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [Member*]
  private static boolean ExpansionDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpansionDefinition_3")) return false;
    ExpansionDefinition_3_0(b, l + 1);
    return true;
  }

  // Member*
  private static boolean ExpansionDefinition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpansionDefinition_3_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Member(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpansionDefinition_3_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ExpressionAssign
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPRESSION, "<expression>");
    r = ExpressionAssign(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ExpressionMul [(AddOperator ExpressionMul)*]
  static boolean ExpressionAdd(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionAdd")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionMul(b, l + 1);
    r = r && ExpressionAdd_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(AddOperator ExpressionMul)*]
  private static boolean ExpressionAdd_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionAdd_1")) return false;
    ExpressionAdd_1_0(b, l + 1);
    return true;
  }

  // (AddOperator ExpressionMul)*
  private static boolean ExpressionAdd_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionAdd_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExpressionAdd_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpressionAdd_1_0", c)) break;
    }
    return true;
  }

  // AddOperator ExpressionMul
  private static boolean ExpressionAdd_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionAdd_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AddOperator(b, l + 1);
    r = r && ExpressionMul(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ExpressionCompare [(T_AND ExpressionCompare)*]
  static boolean ExpressionAnd(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionAnd")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionCompare(b, l + 1);
    r = r && ExpressionAnd_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_AND ExpressionCompare)*]
  private static boolean ExpressionAnd_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionAnd_1")) return false;
    ExpressionAnd_1_0(b, l + 1);
    return true;
  }

  // (T_AND ExpressionCompare)*
  private static boolean ExpressionAnd_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionAnd_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExpressionAnd_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpressionAnd_1_0", c)) break;
    }
    return true;
  }

  // T_AND ExpressionCompare
  private static boolean ExpressionAnd_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionAnd_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_AND);
    r = r && ExpressionCompare(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ExpressionOr [(T_ANDAND ExpressionOr)*]
  static boolean ExpressionAndAnd(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionAndAnd")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionOr(b, l + 1);
    r = r && ExpressionAndAnd_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_ANDAND ExpressionOr)*]
  private static boolean ExpressionAndAnd_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionAndAnd_1")) return false;
    ExpressionAndAnd_1_0(b, l + 1);
    return true;
  }

  // (T_ANDAND ExpressionOr)*
  private static boolean ExpressionAndAnd_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionAndAnd_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExpressionAndAnd_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpressionAndAnd_1_0", c)) break;
    }
    return true;
  }

  // T_ANDAND ExpressionOr
  private static boolean ExpressionAndAnd_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionAndAnd_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_ANDAND);
    r = r && ExpressionOr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_SQOPEN [Expression [(T_COMMA Expression)*]] T_SQCLOSE
  static boolean ExpressionArray(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionArray")) return false;
    if (!nextTokenIs(b, T_SQOPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SQOPEN);
    r = r && ExpressionArray_1(b, l + 1);
    r = r && consumeToken(b, T_SQCLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [Expression [(T_COMMA Expression)*]]
  private static boolean ExpressionArray_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionArray_1")) return false;
    ExpressionArray_1_0(b, l + 1);
    return true;
  }

  // Expression [(T_COMMA Expression)*]
  private static boolean ExpressionArray_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionArray_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && ExpressionArray_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_COMMA Expression)*]
  private static boolean ExpressionArray_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionArray_1_0_1")) return false;
    ExpressionArray_1_0_1_0(b, l + 1);
    return true;
  }

  // (T_COMMA Expression)*
  private static boolean ExpressionArray_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionArray_1_0_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExpressionArray_1_0_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpressionArray_1_0_1_0", c)) break;
    }
    return true;
  }

  // T_COMMA Expression
  private static boolean ExpressionArray_1_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionArray_1_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ExpressionConditional [AssignOperator ExpressionAssign]
  static boolean ExpressionAssign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionAssign")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionConditional(b, l + 1);
    r = r && ExpressionAssign_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [AssignOperator ExpressionAssign]
  private static boolean ExpressionAssign_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionAssign_1")) return false;
    ExpressionAssign_1_0(b, l + 1);
    return true;
  }

  // AssignOperator ExpressionAssign
  private static boolean ExpressionAssign_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionAssign_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AssignOperator(b, l + 1);
    r = r && ExpressionAssign(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_LESS T_IDENTIFIER [(T_COLON ValidBEPContent)*] T_GREATER
  public static boolean ExpressionBEP(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionBEP")) return false;
    if (!nextTokenIs(b, T_LESS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_LESS, T_IDENTIFIER);
    r = r && ExpressionBEP_2(b, l + 1);
    r = r && consumeToken(b, T_GREATER);
    exit_section_(b, m, EXPRESSION_BEP, r);
    return r;
  }

  // [(T_COLON ValidBEPContent)*]
  private static boolean ExpressionBEP_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionBEP_2")) return false;
    ExpressionBEP_2_0(b, l + 1);
    return true;
  }

  // (T_COLON ValidBEPContent)*
  private static boolean ExpressionBEP_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionBEP_2_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExpressionBEP_2_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpressionBEP_2_0", c)) break;
    }
    return true;
  }

  // T_COLON ValidBEPContent
  private static boolean ExpressionBEP_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionBEP_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COLON);
    r = r && ValidBEPContent(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_BROPEN ExpressionAssign [(T_COMMA ExpressionAssign)] T_BRCLOSE
  static boolean ExpressionBracket(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionBracket")) return false;
    if (!nextTokenIs(b, T_BROPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_BROPEN);
    r = r && ExpressionAssign(b, l + 1);
    r = r && ExpressionBracket_2(b, l + 1);
    r = r && consumeToken(b, T_BRCLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_COMMA ExpressionAssign)]
  private static boolean ExpressionBracket_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionBracket_2")) return false;
    ExpressionBracket_2_0(b, l + 1);
    return true;
  }

  // T_COMMA ExpressionAssign
  private static boolean ExpressionBracket_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionBracket_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && ExpressionAssign(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ExpressionShift [CompareOperator ExpressionShift]
  static boolean ExpressionCompare(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionCompare")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionShift(b, l + 1);
    r = r && ExpressionCompare_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [CompareOperator ExpressionShift]
  private static boolean ExpressionCompare_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionCompare_1")) return false;
    ExpressionCompare_1_0(b, l + 1);
    return true;
  }

  // CompareOperator ExpressionShift
  private static boolean ExpressionCompare_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionCompare_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CompareOperator(b, l + 1);
    r = r && ExpressionShift(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ExpressionOrOr [T_QUEST Expression T_COLON Expression]
  static boolean ExpressionConditional(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionConditional")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionOrOr(b, l + 1);
    r = r && ExpressionConditional_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [T_QUEST Expression T_COLON Expression]
  private static boolean ExpressionConditional_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionConditional_1")) return false;
    ExpressionConditional_1_0(b, l + 1);
    return true;
  }

  // T_QUEST Expression T_COLON Expression
  private static boolean ExpressionConditional_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionConditional_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_QUEST);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_INT | T_PREFIXED_INT | T_FLOAT | ZCStringLiteral | T_IDENTIFIER | T_LOCAL_IDENTIFIER | K_TRUE | K_FALSE | K_NULL
  static boolean ExpressionLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionLiteral")) return false;
    boolean r;
    r = consumeToken(b, T_INT);
    if (!r) r = consumeToken(b, T_PREFIXED_INT);
    if (!r) r = consumeToken(b, T_FLOAT);
    if (!r) r = ZCStringLiteral(b, l + 1);
    if (!r) r = consumeToken(b, T_IDENTIFIER);
    if (!r) r = consumeToken(b, T_LOCAL_IDENTIFIER);
    if (!r) r = consumeToken(b, K_TRUE);
    if (!r) r = consumeToken(b, K_FALSE);
    if (!r) r = consumeToken(b, K_NULL);
    return r;
  }

  /* ********************************************************** */
  // T_AOPEN [MapPair [(T_COMMA MapPair)*]] T_ACLOSE
  static boolean ExpressionMap(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionMap")) return false;
    if (!nextTokenIs(b, T_AOPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_AOPEN);
    r = r && ExpressionMap_1(b, l + 1);
    r = r && consumeToken(b, T_ACLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [MapPair [(T_COMMA MapPair)*]]
  private static boolean ExpressionMap_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionMap_1")) return false;
    ExpressionMap_1_0(b, l + 1);
    return true;
  }

  // MapPair [(T_COMMA MapPair)*]
  private static boolean ExpressionMap_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionMap_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MapPair(b, l + 1);
    r = r && ExpressionMap_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_COMMA MapPair)*]
  private static boolean ExpressionMap_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionMap_1_0_1")) return false;
    ExpressionMap_1_0_1_0(b, l + 1);
    return true;
  }

  // (T_COMMA MapPair)*
  private static boolean ExpressionMap_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionMap_1_0_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExpressionMap_1_0_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpressionMap_1_0_1_0", c)) break;
    }
    return true;
  }

  // T_COMMA MapPair
  private static boolean ExpressionMap_1_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionMap_1_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && MapPair(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_MATCH Expression T_AOPEN [MatchCase [(T_COMMA MatchCase)*]] T_ACLOSE
  static boolean ExpressionMatch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionMatch")) return false;
    if (!nextTokenIs(b, K_MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_MATCH);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, T_AOPEN);
    r = r && ExpressionMatch_3(b, l + 1);
    r = r && consumeToken(b, T_ACLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [MatchCase [(T_COMMA MatchCase)*]]
  private static boolean ExpressionMatch_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionMatch_3")) return false;
    ExpressionMatch_3_0(b, l + 1);
    return true;
  }

  // MatchCase [(T_COMMA MatchCase)*]
  private static boolean ExpressionMatch_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionMatch_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MatchCase(b, l + 1);
    r = r && ExpressionMatch_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_COMMA MatchCase)*]
  private static boolean ExpressionMatch_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionMatch_3_0_1")) return false;
    ExpressionMatch_3_0_1_0(b, l + 1);
    return true;
  }

  // (T_COMMA MatchCase)*
  private static boolean ExpressionMatch_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionMatch_3_0_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExpressionMatch_3_0_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpressionMatch_3_0_1_0", c)) break;
    }
    return true;
  }

  // T_COMMA MatchCase
  private static boolean ExpressionMatch_3_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionMatch_3_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && MatchCase(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ExpressionUnary [(MulOperator ExpressionUnary)*]
  static boolean ExpressionMul(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionMul")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionUnary(b, l + 1);
    r = r && ExpressionMul_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(MulOperator ExpressionUnary)*]
  private static boolean ExpressionMul_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionMul_1")) return false;
    ExpressionMul_1_0(b, l + 1);
    return true;
  }

  // (MulOperator ExpressionUnary)*
  private static boolean ExpressionMul_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionMul_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExpressionMul_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpressionMul_1_0", c)) break;
    }
    return true;
  }

  // MulOperator ExpressionUnary
  private static boolean ExpressionMul_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionMul_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MulOperator(b, l + 1);
    r = r && ExpressionUnary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_NEW Type CallArguments
  static boolean ExpressionNew(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionNew")) return false;
    if (!nextTokenIs(b, K_NEW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_NEW);
    r = r && Type(b, l + 1);
    r = r && CallArguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ExpressionXor [(T_OR ExpressionXor)*]
  static boolean ExpressionOr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionOr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionXor(b, l + 1);
    r = r && ExpressionOr_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_OR ExpressionXor)*]
  private static boolean ExpressionOr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionOr_1")) return false;
    ExpressionOr_1_0(b, l + 1);
    return true;
  }

  // (T_OR ExpressionXor)*
  private static boolean ExpressionOr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionOr_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExpressionOr_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpressionOr_1_0", c)) break;
    }
    return true;
  }

  // T_OR ExpressionXor
  private static boolean ExpressionOr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionOr_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_OR);
    r = r && ExpressionXor(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ExpressionAndAnd [(T_OROR ExpressionAndAnd)*] [(T_COALESCE ExpressionAndAnd)*]
  static boolean ExpressionOrOr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionOrOr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionAndAnd(b, l + 1);
    r = r && ExpressionOrOr_1(b, l + 1);
    r = r && ExpressionOrOr_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_OROR ExpressionAndAnd)*]
  private static boolean ExpressionOrOr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionOrOr_1")) return false;
    ExpressionOrOr_1_0(b, l + 1);
    return true;
  }

  // (T_OROR ExpressionAndAnd)*
  private static boolean ExpressionOrOr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionOrOr_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExpressionOrOr_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpressionOrOr_1_0", c)) break;
    }
    return true;
  }

  // T_OROR ExpressionAndAnd
  private static boolean ExpressionOrOr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionOrOr_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_OROR);
    r = r && ExpressionAndAnd(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_COALESCE ExpressionAndAnd)*]
  private static boolean ExpressionOrOr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionOrOr_2")) return false;
    ExpressionOrOr_2_0(b, l + 1);
    return true;
  }

  // (T_COALESCE ExpressionAndAnd)*
  private static boolean ExpressionOrOr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionOrOr_2_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExpressionOrOr_2_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpressionOrOr_2_0", c)) break;
    }
    return true;
  }

  // T_COALESCE ExpressionAndAnd
  private static boolean ExpressionOrOr_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionOrOr_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COALESCE);
    r = r && ExpressionAndAnd(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_PANIC Expression
  static boolean ExpressionPanic(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPanic")) return false;
    if (!nextTokenIs(b, K_PANIC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_PANIC);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ExpressionPrimary [(
  //                                     (T_DOT (T_IDENTIFIER TypeArguments) | T_DOLLAR | ZCStringLiteral)//Member get
  //                                      | (T_DOT2 ExpressionAssign)  //Range
  //                                      | (T_SQOPEN ExpressionAssign [(T_COMMA) ExpressionAssign] T_SQCLOSE) //Index get
  //                                      | CallArguments //Call
  //                                      | (K_AS [T_QUEST] Type) //Cast | Optional cast
  //                                      | T_INCREMENT | T_DECREMENT //Postfix
  //                                      | (T_LAMBDA LambdaBody)
  //                                )*]
  static boolean ExpressionPostFix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPostFix")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionPrimary(b, l + 1);
    r = r && ExpressionPostFix_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(
  //                                     (T_DOT (T_IDENTIFIER TypeArguments) | T_DOLLAR | ZCStringLiteral)//Member get
  //                                      | (T_DOT2 ExpressionAssign)  //Range
  //                                      | (T_SQOPEN ExpressionAssign [(T_COMMA) ExpressionAssign] T_SQCLOSE) //Index get
  //                                      | CallArguments //Call
  //                                      | (K_AS [T_QUEST] Type) //Cast | Optional cast
  //                                      | T_INCREMENT | T_DECREMENT //Postfix
  //                                      | (T_LAMBDA LambdaBody)
  //                                )*]
  private static boolean ExpressionPostFix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPostFix_1")) return false;
    ExpressionPostFix_1_0(b, l + 1);
    return true;
  }

  // (
  //                                     (T_DOT (T_IDENTIFIER TypeArguments) | T_DOLLAR | ZCStringLiteral)//Member get
  //                                      | (T_DOT2 ExpressionAssign)  //Range
  //                                      | (T_SQOPEN ExpressionAssign [(T_COMMA) ExpressionAssign] T_SQCLOSE) //Index get
  //                                      | CallArguments //Call
  //                                      | (K_AS [T_QUEST] Type) //Cast | Optional cast
  //                                      | T_INCREMENT | T_DECREMENT //Postfix
  //                                      | (T_LAMBDA LambdaBody)
  //                                )*
  private static boolean ExpressionPostFix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPostFix_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExpressionPostFix_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpressionPostFix_1_0", c)) break;
    }
    return true;
  }

  // (T_DOT (T_IDENTIFIER TypeArguments) | T_DOLLAR | ZCStringLiteral)//Member get
  //                                      | (T_DOT2 ExpressionAssign)  //Range
  //                                      | (T_SQOPEN ExpressionAssign [(T_COMMA) ExpressionAssign] T_SQCLOSE) //Index get
  //                                      | CallArguments //Call
  //                                      | (K_AS [T_QUEST] Type) //Cast | Optional cast
  //                                      | T_INCREMENT | T_DECREMENT //Postfix
  //                                      | (T_LAMBDA LambdaBody)
  private static boolean ExpressionPostFix_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPostFix_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionPostFix_1_0_0_0(b, l + 1);
    if (!r) r = ExpressionPostFix_1_0_0_1(b, l + 1);
    if (!r) r = ExpressionPostFix_1_0_0_2(b, l + 1);
    if (!r) r = CallArguments(b, l + 1);
    if (!r) r = ExpressionPostFix_1_0_0_4(b, l + 1);
    if (!r) r = consumeToken(b, T_INCREMENT);
    if (!r) r = consumeToken(b, T_DECREMENT);
    if (!r) r = ExpressionPostFix_1_0_0_7(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_DOT (T_IDENTIFIER TypeArguments) | T_DOLLAR | ZCStringLiteral
  private static boolean ExpressionPostFix_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPostFix_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionPostFix_1_0_0_0_0(b, l + 1);
    if (!r) r = consumeToken(b, T_DOLLAR);
    if (!r) r = ZCStringLiteral(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_DOT (T_IDENTIFIER TypeArguments)
  private static boolean ExpressionPostFix_1_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPostFix_1_0_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_DOT);
    r = r && ExpressionPostFix_1_0_0_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_IDENTIFIER TypeArguments
  private static boolean ExpressionPostFix_1_0_0_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPostFix_1_0_0_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    r = r && TypeArguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_DOT2 ExpressionAssign
  private static boolean ExpressionPostFix_1_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPostFix_1_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_DOT2);
    r = r && ExpressionAssign(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_SQOPEN ExpressionAssign [(T_COMMA) ExpressionAssign] T_SQCLOSE
  private static boolean ExpressionPostFix_1_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPostFix_1_0_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SQOPEN);
    r = r && ExpressionAssign(b, l + 1);
    r = r && ExpressionPostFix_1_0_0_2_2(b, l + 1);
    r = r && consumeToken(b, T_SQCLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_COMMA) ExpressionAssign]
  private static boolean ExpressionPostFix_1_0_0_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPostFix_1_0_0_2_2")) return false;
    ExpressionPostFix_1_0_0_2_2_0(b, l + 1);
    return true;
  }

  // (T_COMMA) ExpressionAssign
  private static boolean ExpressionPostFix_1_0_0_2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPostFix_1_0_0_2_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && ExpressionAssign(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // K_AS [T_QUEST] Type
  private static boolean ExpressionPostFix_1_0_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPostFix_1_0_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_AS);
    r = r && ExpressionPostFix_1_0_0_4_1(b, l + 1);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [T_QUEST]
  private static boolean ExpressionPostFix_1_0_0_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPostFix_1_0_0_4_1")) return false;
    consumeToken(b, T_QUEST);
    return true;
  }

  // T_LAMBDA LambdaBody
  private static boolean ExpressionPostFix_1_0_0_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPostFix_1_0_0_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_LAMBDA);
    r = r && LambdaBody(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ExpressionVariable | ExpressionSimple | ExpressionArray | ExpressionMap | ExpressionBracket | ExpressionNew | ExpressionThrow | ExpressionPanic | ExpressionMatch | ExpressionBEP | ExpressionType
  static boolean ExpressionPrimary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionPrimary")) return false;
    boolean r;
    r = ExpressionVariable(b, l + 1);
    if (!r) r = ExpressionSimple(b, l + 1);
    if (!r) r = ExpressionArray(b, l + 1);
    if (!r) r = ExpressionMap(b, l + 1);
    if (!r) r = ExpressionBracket(b, l + 1);
    if (!r) r = ExpressionNew(b, l + 1);
    if (!r) r = ExpressionThrow(b, l + 1);
    if (!r) r = ExpressionPanic(b, l + 1);
    if (!r) r = ExpressionMatch(b, l + 1);
    if (!r) r = ExpressionBEP(b, l + 1);
    if (!r) r = ExpressionType(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ExpressionAdd [(ShiftOperator ExpressionAdd)*]
  static boolean ExpressionShift(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionShift")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionAdd(b, l + 1);
    r = r && ExpressionShift_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(ShiftOperator ExpressionAdd)*]
  private static boolean ExpressionShift_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionShift_1")) return false;
    ExpressionShift_1_0(b, l + 1);
    return true;
  }

  // (ShiftOperator ExpressionAdd)*
  private static boolean ExpressionShift_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionShift_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExpressionShift_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpressionShift_1_0", c)) break;
    }
    return true;
  }

  // ShiftOperator ExpressionAdd
  private static boolean ExpressionShift_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionShift_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ShiftOperator(b, l + 1);
    r = r && ExpressionAdd(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ExpressionLiteral | K_THIS | K_SUPER | T_DOLLAR
  static boolean ExpressionSimple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionSimple")) return false;
    boolean r;
    r = ExpressionLiteral(b, l + 1);
    if (!r) r = consumeToken(b, K_THIS);
    if (!r) r = consumeToken(b, K_SUPER);
    if (!r) r = consumeToken(b, T_DOLLAR);
    return r;
  }

  /* ********************************************************** */
  // K_THROW Expression
  static boolean ExpressionThrow(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionThrow")) return false;
    if (!nextTokenIs(b, K_THROW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_THROW);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Type
  static boolean ExpressionType(PsiBuilder b, int l) {
    return Type(b, l + 1);
  }

  /* ********************************************************** */
  // (UnaryOperator ExpressionUnary) | ExpressionPostFix | (K_TRY ((T_QUEST | T_NOT) ExpressionUnary) | ExpressionPostFix)
  static boolean ExpressionUnary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionUnary")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionUnary_0(b, l + 1);
    if (!r) r = ExpressionPostFix(b, l + 1);
    if (!r) r = ExpressionUnary_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // UnaryOperator ExpressionUnary
  private static boolean ExpressionUnary_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionUnary_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = UnaryOperator(b, l + 1);
    r = r && ExpressionUnary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // K_TRY ((T_QUEST | T_NOT) ExpressionUnary) | ExpressionPostFix
  private static boolean ExpressionUnary_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionUnary_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionUnary_2_0(b, l + 1);
    if (!r) r = ExpressionPostFix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // K_TRY ((T_QUEST | T_NOT) ExpressionUnary)
  private static boolean ExpressionUnary_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionUnary_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_TRY);
    r = r && ExpressionUnary_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_QUEST | T_NOT) ExpressionUnary
  private static boolean ExpressionUnary_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionUnary_2_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionUnary_2_0_1_0(b, l + 1);
    r = r && ExpressionUnary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_QUEST | T_NOT
  private static boolean ExpressionUnary_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionUnary_2_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, T_QUEST);
    if (!r) r = consumeToken(b, T_NOT);
    return r;
  }

  /* ********************************************************** */
  // VariableName
  static boolean ExpressionVariable(PsiBuilder b, int l) {
    return VariableName(b, l + 1);
  }

  /* ********************************************************** */
  // ExpressionAnd [(T_XOR ExpressionAnd)*]
  static boolean ExpressionXor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionXor")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionAnd(b, l + 1);
    r = r && ExpressionXor_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_XOR ExpressionAnd)*]
  private static boolean ExpressionXor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionXor_1")) return false;
    ExpressionXor_1_0(b, l + 1);
    return true;
  }

  // (T_XOR ExpressionAnd)*
  private static boolean ExpressionXor_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionXor_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExpressionXor_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpressionXor_1_0", c)) break;
    }
    return true;
  }

  // T_XOR ExpressionAnd
  private static boolean ExpressionXor_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionXor_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_XOR);
    r = r && ExpressionAnd(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_FUNCTION T_IDENTIFIER T_BROPEN T_BRCLOSE ((T_AOPEN [Statement*] T_ACLOSE) | (T_LAMBDA Expression))
  static boolean FunctionDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition")) return false;
    if (!nextTokenIs(b, K_FUNCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_FUNCTION, T_IDENTIFIER, T_BROPEN, T_BRCLOSE);
    r = r && FunctionDefinition_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (T_AOPEN [Statement*] T_ACLOSE) | (T_LAMBDA Expression)
  private static boolean FunctionDefinition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FunctionDefinition_4_0(b, l + 1);
    if (!r) r = FunctionDefinition_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_AOPEN [Statement*] T_ACLOSE
  private static boolean FunctionDefinition_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_AOPEN);
    r = r && FunctionDefinition_4_0_1(b, l + 1);
    r = r && consumeToken(b, T_ACLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [Statement*]
  private static boolean FunctionDefinition_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_4_0_1")) return false;
    FunctionDefinition_4_0_1_0(b, l + 1);
    return true;
  }

  // Statement*
  private static boolean FunctionDefinition_4_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_4_0_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionDefinition_4_0_1_0", c)) break;
    }
    return true;
  }

  // T_LAMBDA Expression
  private static boolean FunctionDefinition_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_LAMBDA);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // StorageTag TypeParameters T_BROPEN FunctionParameters T_BRCLOSE [K_AS Type] [K_THROWS Type]
  static boolean FunctionHeader(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = StorageTag(b, l + 1);
    r = r && TypeParameters(b, l + 1);
    r = r && consumeToken(b, T_BROPEN);
    r = r && FunctionParameters(b, l + 1);
    r = r && consumeToken(b, T_BRCLOSE);
    r = r && FunctionHeader_5(b, l + 1);
    r = r && FunctionHeader_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [K_AS Type]
  private static boolean FunctionHeader_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_5")) return false;
    FunctionHeader_5_0(b, l + 1);
    return true;
  }

  // K_AS Type
  private static boolean FunctionHeader_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_AS);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [K_THROWS Type]
  private static boolean FunctionHeader_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_6")) return false;
    FunctionHeader_6_0(b, l + 1);
    return true;
  }

  // K_THROWS Type
  private static boolean FunctionHeader_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionHeader_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_THROWS);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Annotations T_IDENTIFIER [T_DOT3] [K_AS Type] [T_ASSIGN Expression]
  static boolean FunctionParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameter")) return false;
    if (!nextTokenIs(b, "", T_IDENTIFIER, T_SQOPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Annotations(b, l + 1);
    r = r && consumeToken(b, T_IDENTIFIER);
    r = r && FunctionParameter_2(b, l + 1);
    r = r && FunctionParameter_3(b, l + 1);
    r = r && FunctionParameter_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [T_DOT3]
  private static boolean FunctionParameter_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameter_2")) return false;
    consumeToken(b, T_DOT3);
    return true;
  }

  // [K_AS Type]
  private static boolean FunctionParameter_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameter_3")) return false;
    FunctionParameter_3_0(b, l + 1);
    return true;
  }

  // K_AS Type
  private static boolean FunctionParameter_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameter_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_AS);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [T_ASSIGN Expression]
  private static boolean FunctionParameter_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameter_4")) return false;
    FunctionParameter_4_0(b, l + 1);
    return true;
  }

  // T_ASSIGN Expression
  private static boolean FunctionParameter_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameter_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_ASSIGN);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FunctionParameter [(T_COMMA FunctionParameter)*]
  static boolean FunctionParameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameters")) return false;
    if (!nextTokenIs(b, "", T_IDENTIFIER, T_SQOPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FunctionParameter(b, l + 1);
    r = r && FunctionParameters_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_COMMA FunctionParameter)*]
  private static boolean FunctionParameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameters_1")) return false;
    FunctionParameters_1_0(b, l + 1);
    return true;
  }

  // (T_COMMA FunctionParameter)*
  private static boolean FunctionParameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameters_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!FunctionParameters_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionParameters_1_0", c)) break;
    }
    return true;
  }

  // T_COMMA FunctionParameter
  private static boolean FunctionParameters_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionParameters_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && FunctionParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_FUNCTION FunctionHeader
  static boolean FunctionType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType")) return false;
    if (!nextTokenIs(b, K_FUNCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_FUNCTION);
    r = r && FunctionHeader(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_IMPORT T_DOT? Type [K_AS Type] T_SEMICOLON
  public static boolean Import(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Import")) return false;
    if (!nextTokenIs(b, K_IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_IMPORT);
    r = r && Import_1(b, l + 1);
    r = r && Type(b, l + 1);
    r = r && Import_3(b, l + 1);
    r = r && consumeToken(b, T_SEMICOLON);
    exit_section_(b, m, IMPORT, r);
    return r;
  }

  // T_DOT?
  private static boolean Import_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Import_1")) return false;
    consumeToken(b, T_DOT);
    return true;
  }

  // [K_AS Type]
  private static boolean Import_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Import_3")) return false;
    Import_3_0(b, l + 1);
    return true;
  }

  // K_AS Type
  private static boolean Import_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Import_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_AS);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_INTERFACE T_IDENTIFIER T_AOPEN [Member*] T_ACLOSE
  static boolean InterfaceDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDefinition")) return false;
    if (!nextTokenIs(b, K_INTERFACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_INTERFACE, T_IDENTIFIER, T_AOPEN);
    r = r && InterfaceDefinition_3(b, l + 1);
    r = r && consumeToken(b, T_ACLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [Member*]
  private static boolean InterfaceDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDefinition_3")) return false;
    InterfaceDefinition_3_0(b, l + 1);
    return true;
  }

  // Member*
  private static boolean InterfaceDefinition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDefinition_3_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Member(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "InterfaceDefinition_3_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // StatementBlock | Expression
  static boolean LambdaBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambdaBody")) return false;
    boolean r;
    r = StatementBlock(b, l + 1);
    if (!r) r = Expression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ExpressionAssign T_COLON ExpressionAssign
  static boolean MapPair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapPair")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ExpressionAssign(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    r = r && ExpressionAssign(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (K_DEFAULT | Expression) T_LAMBDA Expression
  static boolean MatchCase(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchCase")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MatchCase_0(b, l + 1);
    r = r && consumeToken(b, T_LAMBDA);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // K_DEFAULT | Expression
  private static boolean MatchCase_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MatchCase_0")) return false;
    boolean r;
    r = consumeToken(b, K_DEFAULT);
    if (!r) r = Expression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER T_IDENTIFIER T_IDENTIFIER T_IDENTIFIER T_IDENTIFIER T_IDENTIFIER T_IDENTIFIER
  static boolean Member(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Member")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_IDENTIFIER, T_IDENTIFIER, T_IDENTIFIER, T_IDENTIFIER, T_IDENTIFIER, T_IDENTIFIER, T_IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_MUL | T_DIV | T_MOD
  static boolean MulOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MulOperator")) return false;
    boolean r;
    r = consumeToken(b, T_MUL);
    if (!r) r = consumeToken(b, T_DIV);
    if (!r) r = consumeToken(b, T_MOD);
    return r;
  }

  /* ********************************************************** */
  // (K_STRING | QualifiedType | FunctionType) [StorageTag]
  static boolean ObjectType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectType")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ObjectType_0(b, l + 1);
    r = r && ObjectType_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // K_STRING | QualifiedType | FunctionType
  private static boolean ObjectType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectType_0")) return false;
    boolean r;
    r = consumeToken(b, K_STRING);
    if (!r) r = QualifiedType(b, l + 1);
    if (!r) r = FunctionType(b, l + 1);
    return r;
  }

  // [StorageTag]
  private static boolean ObjectType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectType_1")) return false;
    StorageTag(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // K_VOID | K_BOOL | K_BYTE | K_SBYTE | K_SHORT | K_USHORT | K_INT | K_UINT | K_LONG | K_ULONG | K_USIZE | K_FLOAT | K_DOUBLE | K_CHAR
  static boolean PrimitiveType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimitiveType")) return false;
    boolean r;
    r = consumeToken(b, K_VOID);
    if (!r) r = consumeToken(b, K_BOOL);
    if (!r) r = consumeToken(b, K_BYTE);
    if (!r) r = consumeToken(b, K_SBYTE);
    if (!r) r = consumeToken(b, K_SHORT);
    if (!r) r = consumeToken(b, K_USHORT);
    if (!r) r = consumeToken(b, K_INT);
    if (!r) r = consumeToken(b, K_UINT);
    if (!r) r = consumeToken(b, K_LONG);
    if (!r) r = consumeToken(b, K_ULONG);
    if (!r) r = consumeToken(b, K_USIZE);
    if (!r) r = consumeToken(b, K_FLOAT);
    if (!r) r = consumeToken(b, K_DOUBLE);
    if (!r) r = consumeToken(b, K_CHAR);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER [(T_DOT T_IDENTIFIER)*]
  static boolean QualifiedType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "QualifiedType")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    r = r && QualifiedType_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_DOT T_IDENTIFIER)*]
  private static boolean QualifiedType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "QualifiedType_1")) return false;
    QualifiedType_1_0(b, l + 1);
    return true;
  }

  // (T_DOT T_IDENTIFIER)*
  private static boolean QualifiedType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "QualifiedType_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!QualifiedType_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "QualifiedType_1_0", c)) break;
    }
    return true;
  }

  // T_DOT T_IDENTIFIER
  private static boolean QualifiedType_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "QualifiedType_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_DOT, T_IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_SHL | T_SHR | T_USHR
  static boolean ShiftOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ShiftOperator")) return false;
    boolean r;
    r = consumeToken(b, T_SHL);
    if (!r) r = consumeToken(b, T_SHR);
    if (!r) r = consumeToken(b, T_USHR);
    return r;
  }

  /* ********************************************************** */
  // StatementBlock | StatementBreak | StatementContinue |  StatementExpression | StatementIf | StatementLock | StatementReturn | StatementSwitch | StatementTryCatch | StatementVar | StatementWhileDo | StatementDoWhile | StatementForEach
  static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    r = StatementBlock(b, l + 1);
    if (!r) r = StatementBreak(b, l + 1);
    if (!r) r = StatementContinue(b, l + 1);
    if (!r) r = StatementExpression(b, l + 1);
    if (!r) r = StatementIf(b, l + 1);
    if (!r) r = StatementLock(b, l + 1);
    if (!r) r = StatementReturn(b, l + 1);
    if (!r) r = StatementSwitch(b, l + 1);
    if (!r) r = StatementTryCatch(b, l + 1);
    if (!r) r = StatementVar(b, l + 1);
    if (!r) r = StatementWhileDo(b, l + 1);
    if (!r) r = StatementDoWhile(b, l + 1);
    if (!r) r = StatementForEach(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // T_AOPEN [Statement*] T_ACLOSE
  public static boolean StatementBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementBlock")) return false;
    if (!nextTokenIs(b, T_AOPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_AOPEN);
    r = r && StatementBlock_1(b, l + 1);
    r = r && consumeToken(b, T_ACLOSE);
    exit_section_(b, m, STATEMENT_BLOCK, r);
    return r;
  }

  // [Statement*]
  private static boolean StatementBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementBlock_1")) return false;
    StatementBlock_1_0(b, l + 1);
    return true;
  }

  // Statement*
  private static boolean StatementBlock_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementBlock_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StatementBlock_1_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // K_BREAK [T_IDENTIFIER] T_SEMICOLON
  public static boolean StatementBreak(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementBreak")) return false;
    if (!nextTokenIs(b, K_BREAK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_BREAK);
    r = r && StatementBreak_1(b, l + 1);
    r = r && consumeToken(b, T_SEMICOLON);
    exit_section_(b, m, STATEMENT_BREAK, r);
    return r;
  }

  // [T_IDENTIFIER]
  private static boolean StatementBreak_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementBreak_1")) return false;
    consumeToken(b, T_IDENTIFIER);
    return true;
  }

  /* ********************************************************** */
  // K_CONTINUE [T_IDENTIFIER] T_SEMICOLON
  public static boolean StatementContinue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementContinue")) return false;
    if (!nextTokenIs(b, K_CONTINUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_CONTINUE);
    r = r && StatementContinue_1(b, l + 1);
    r = r && consumeToken(b, T_SEMICOLON);
    exit_section_(b, m, STATEMENT_CONTINUE, r);
    return r;
  }

  // [T_IDENTIFIER]
  private static boolean StatementContinue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementContinue_1")) return false;
    consumeToken(b, T_IDENTIFIER);
    return true;
  }

  /* ********************************************************** */
  // K_DO Statement K_WHILE T_BROPEN Expression T_BRCLOSE T_SEMICOLON
  public static boolean StatementDoWhile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementDoWhile")) return false;
    if (!nextTokenIs(b, K_DO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_DO);
    r = r && Statement(b, l + 1);
    r = r && consumeTokens(b, 0, K_WHILE, T_BROPEN);
    r = r && Expression(b, l + 1);
    r = r && consumeTokens(b, 0, T_BRCLOSE, T_SEMICOLON);
    exit_section_(b, m, STATEMENT_DO_WHILE, r);
    return r;
  }

  /* ********************************************************** */
  // Expression T_SEMICOLON
  public static boolean StatementExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT_EXPRESSION, "<statement expression>");
    r = Expression(b, l + 1);
    r = r && consumeToken(b, T_SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // K_FOR DeclareVariableName ((T_COMMA DeclareVariableName)*)? K_IN Expression Statement
  public static boolean StatementForEach(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementForEach")) return false;
    if (!nextTokenIs(b, K_FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_FOR);
    r = r && DeclareVariableName(b, l + 1);
    r = r && StatementForEach_2(b, l + 1);
    r = r && consumeToken(b, K_IN);
    r = r && Expression(b, l + 1);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, STATEMENT_FOR_EACH, r);
    return r;
  }

  // ((T_COMMA DeclareVariableName)*)?
  private static boolean StatementForEach_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementForEach_2")) return false;
    StatementForEach_2_0(b, l + 1);
    return true;
  }

  // (T_COMMA DeclareVariableName)*
  private static boolean StatementForEach_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementForEach_2_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!StatementForEach_2_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StatementForEach_2_0", c)) break;
    }
    return true;
  }

  // T_COMMA DeclareVariableName
  private static boolean StatementForEach_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementForEach_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && DeclareVariableName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_IF T_BROPEN Expression T_BRCLOSE Statement [K_ELSE Statement]
  public static boolean StatementIf(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementIf")) return false;
    if (!nextTokenIs(b, K_IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_IF, T_BROPEN);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, T_BRCLOSE);
    r = r && Statement(b, l + 1);
    r = r && StatementIf_5(b, l + 1);
    exit_section_(b, m, STATEMENT_IF, r);
    return r;
  }

  // [K_ELSE Statement]
  private static boolean StatementIf_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementIf_5")) return false;
    StatementIf_5_0(b, l + 1);
    return true;
  }

  // K_ELSE Statement
  private static boolean StatementIf_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementIf_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_ELSE);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_LOCK T_BROPEN Expression T_BRCLOSE Statement
  public static boolean StatementLock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementLock")) return false;
    if (!nextTokenIs(b, K_LOCK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_LOCK, T_BROPEN);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, T_BRCLOSE);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, STATEMENT_LOCK, r);
    return r;
  }

  /* ********************************************************** */
  // K_RETURN Expression T_SEMICOLON
  public static boolean StatementReturn(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementReturn")) return false;
    if (!nextTokenIs(b, K_RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_RETURN);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, T_SEMICOLON);
    exit_section_(b, m, STATEMENT_RETURN, r);
    return r;
  }

  /* ********************************************************** */
  // K_SWITCH T_BROPEN Expression T_BRCLOSE T_AOPEN [(K_CASE (T_IDENTIFIER|K_DEFAULT) T_COLON Statement*)*] T_ACLOSE
  public static boolean StatementSwitch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementSwitch")) return false;
    if (!nextTokenIs(b, K_SWITCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_SWITCH, T_BROPEN);
    r = r && Expression(b, l + 1);
    r = r && consumeTokens(b, 0, T_BRCLOSE, T_AOPEN);
    r = r && StatementSwitch_5(b, l + 1);
    r = r && consumeToken(b, T_ACLOSE);
    exit_section_(b, m, STATEMENT_SWITCH, r);
    return r;
  }

  // [(K_CASE (T_IDENTIFIER|K_DEFAULT) T_COLON Statement*)*]
  private static boolean StatementSwitch_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementSwitch_5")) return false;
    StatementSwitch_5_0(b, l + 1);
    return true;
  }

  // (K_CASE (T_IDENTIFIER|K_DEFAULT) T_COLON Statement*)*
  private static boolean StatementSwitch_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementSwitch_5_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!StatementSwitch_5_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StatementSwitch_5_0", c)) break;
    }
    return true;
  }

  // K_CASE (T_IDENTIFIER|K_DEFAULT) T_COLON Statement*
  private static boolean StatementSwitch_5_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementSwitch_5_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_CASE);
    r = r && StatementSwitch_5_0_0_1(b, l + 1);
    r = r && consumeToken(b, T_COLON);
    r = r && StatementSwitch_5_0_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_IDENTIFIER|K_DEFAULT
  private static boolean StatementSwitch_5_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementSwitch_5_0_0_1")) return false;
    boolean r;
    r = consumeToken(b, T_IDENTIFIER);
    if (!r) r = consumeToken(b, K_DEFAULT);
    return r;
  }

  // Statement*
  private static boolean StatementSwitch_5_0_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementSwitch_5_0_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StatementSwitch_5_0_0_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // K_TRY Statement (K_CATCH T_BROPEN DeclareVariableName K_AS Type T_AOPEN Statement T_ACLOSE)* [K_FINALLY Statement]
  public static boolean StatementTryCatch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementTryCatch")) return false;
    if (!nextTokenIs(b, K_TRY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_TRY);
    r = r && Statement(b, l + 1);
    r = r && StatementTryCatch_2(b, l + 1);
    r = r && StatementTryCatch_3(b, l + 1);
    exit_section_(b, m, STATEMENT_TRY_CATCH, r);
    return r;
  }

  // (K_CATCH T_BROPEN DeclareVariableName K_AS Type T_AOPEN Statement T_ACLOSE)*
  private static boolean StatementTryCatch_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementTryCatch_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!StatementTryCatch_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StatementTryCatch_2", c)) break;
    }
    return true;
  }

  // K_CATCH T_BROPEN DeclareVariableName K_AS Type T_AOPEN Statement T_ACLOSE
  private static boolean StatementTryCatch_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementTryCatch_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_CATCH, T_BROPEN);
    r = r && DeclareVariableName(b, l + 1);
    r = r && consumeToken(b, K_AS);
    r = r && Type(b, l + 1);
    r = r && consumeToken(b, T_AOPEN);
    r = r && Statement(b, l + 1);
    r = r && consumeToken(b, T_ACLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [K_FINALLY Statement]
  private static boolean StatementTryCatch_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementTryCatch_3")) return false;
    StatementTryCatch_3_0(b, l + 1);
    return true;
  }

  // K_FINALLY Statement
  private static boolean StatementTryCatch_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementTryCatch_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_FINALLY);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (K_VAR|K_VAL) DeclareVariableName (K_AS Type)? [T_ASSIGN Expression] T_SEMICOLON
  public static boolean StatementVar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementVar")) return false;
    if (!nextTokenIs(b, "<statement var>", K_VAL, K_VAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT_VAR, "<statement var>");
    r = StatementVar_0(b, l + 1);
    r = r && DeclareVariableName(b, l + 1);
    r = r && StatementVar_2(b, l + 1);
    r = r && StatementVar_3(b, l + 1);
    r = r && consumeToken(b, T_SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // K_VAR|K_VAL
  private static boolean StatementVar_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementVar_0")) return false;
    boolean r;
    r = consumeToken(b, K_VAR);
    if (!r) r = consumeToken(b, K_VAL);
    return r;
  }

  // (K_AS Type)?
  private static boolean StatementVar_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementVar_2")) return false;
    StatementVar_2_0(b, l + 1);
    return true;
  }

  // K_AS Type
  private static boolean StatementVar_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementVar_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_AS);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [T_ASSIGN Expression]
  private static boolean StatementVar_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementVar_3")) return false;
    StatementVar_3_0(b, l + 1);
    return true;
  }

  // T_ASSIGN Expression
  private static boolean StatementVar_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementVar_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_ASSIGN);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_WHILE T_BROPEN Expression T_BRCLOSE Statement
  public static boolean StatementWhileDo(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StatementWhileDo")) return false;
    if (!nextTokenIs(b, K_WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_WHILE, T_BROPEN);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, T_BRCLOSE);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, STATEMENT_WHILE_DO, r);
    return r;
  }

  /* ********************************************************** */
  // [T_BACKTICK (K_STATIC | T_IDENTIFIER) [(T_COLON AnyToken)]]
  static boolean StorageTag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StorageTag")) return false;
    StorageTag_0(b, l + 1);
    return true;
  }

  // T_BACKTICK (K_STATIC | T_IDENTIFIER) [(T_COLON AnyToken)]
  private static boolean StorageTag_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StorageTag_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_BACKTICK);
    r = r && StorageTag_0_1(b, l + 1);
    r = r && StorageTag_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // K_STATIC | T_IDENTIFIER
  private static boolean StorageTag_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StorageTag_0_1")) return false;
    boolean r;
    r = consumeToken(b, K_STATIC);
    if (!r) r = consumeToken(b, T_IDENTIFIER);
    return r;
  }

  // [(T_COLON AnyToken)]
  private static boolean StorageTag_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StorageTag_0_2")) return false;
    StorageTag_0_2_0(b, l + 1);
    return true;
  }

  // T_COLON AnyToken
  private static boolean StorageTag_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StorageTag_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COLON);
    r = r && AnyToken(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_STRUCT T_IDENTIFIER T_AOPEN [Member*] T_ACLOSE
  static boolean StructDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDefinition")) return false;
    if (!nextTokenIs(b, K_STRUCT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_STRUCT, T_IDENTIFIER, T_AOPEN);
    r = r && StructDefinition_3(b, l + 1);
    r = r && consumeToken(b, T_ACLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [Member*]
  private static boolean StructDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDefinition_3")) return false;
    StructDefinition_3_0(b, l + 1);
    return true;
  }

  // Member*
  private static boolean StructDefinition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDefinition_3_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Member(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StructDefinition_3_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (PrimitiveType | ObjectType) [(TypeSuffix)*] [T_QUEST]
  public static boolean Type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, TYPE, "<type>");
    r = Type_0(b, l + 1);
    r = r && Type_1(b, l + 1);
    r = r && Type_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PrimitiveType | ObjectType
  private static boolean Type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_0")) return false;
    boolean r;
    r = PrimitiveType(b, l + 1);
    if (!r) r = ObjectType(b, l + 1);
    return r;
  }

  // [(TypeSuffix)*]
  private static boolean Type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_1")) return false;
    Type_1_0(b, l + 1);
    return true;
  }

  // (TypeSuffix)*
  private static boolean Type_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Type_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Type_1_0", c)) break;
    }
    return true;
  }

  // (TypeSuffix)
  private static boolean Type_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypeSuffix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [T_QUEST]
  private static boolean Type_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_2")) return false;
    consumeToken(b, T_QUEST);
    return true;
  }

  /* ********************************************************** */
  // [T_LESS Type [(T_COMMA Type)*] T_GREATER]
  static boolean TypeArguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeArguments")) return false;
    TypeArguments_0(b, l + 1);
    return true;
  }

  // T_LESS Type [(T_COMMA Type)*] T_GREATER
  private static boolean TypeArguments_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeArguments_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_LESS);
    r = r && Type(b, l + 1);
    r = r && TypeArguments_0_2(b, l + 1);
    r = r && consumeToken(b, T_GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_COMMA Type)*]
  private static boolean TypeArguments_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeArguments_0_2")) return false;
    TypeArguments_0_2_0(b, l + 1);
    return true;
  }

  // (T_COMMA Type)*
  private static boolean TypeArguments_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeArguments_0_2_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!TypeArguments_0_2_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TypeArguments_0_2_0", c)) break;
    }
    return true;
  }

  // T_COMMA Type
  private static boolean TypeArguments_0_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeArguments_0_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER StorageTag [(T_COLON [K_SUPER] Type)]
  static boolean TypeParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParameter")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    r = r && StorageTag(b, l + 1);
    r = r && TypeParameter_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_COLON [K_SUPER] Type)]
  private static boolean TypeParameter_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParameter_2")) return false;
    TypeParameter_2_0(b, l + 1);
    return true;
  }

  // T_COLON [K_SUPER] Type
  private static boolean TypeParameter_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParameter_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COLON);
    r = r && TypeParameter_2_0_1(b, l + 1);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [K_SUPER]
  private static boolean TypeParameter_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParameter_2_0_1")) return false;
    consumeToken(b, K_SUPER);
    return true;
  }

  /* ********************************************************** */
  // [T_LESS TypeParameter [(T_COMMA TypeParameter)*]]
  static boolean TypeParameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParameters")) return false;
    TypeParameters_0(b, l + 1);
    return true;
  }

  // T_LESS TypeParameter [(T_COMMA TypeParameter)*]
  private static boolean TypeParameters_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParameters_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_LESS);
    r = r && TypeParameter(b, l + 1);
    r = r && TypeParameters_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_COMMA TypeParameter)*]
  private static boolean TypeParameters_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParameters_0_2")) return false;
    TypeParameters_0_2_0(b, l + 1);
    return true;
  }

  // (T_COMMA TypeParameter)*
  private static boolean TypeParameters_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParameters_0_2_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!TypeParameters_0_2_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TypeParameters_0_2_0", c)) break;
    }
    return true;
  }

  // T_COMMA TypeParameter
  private static boolean TypeParameters_0_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParameters_0_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && TypeParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (T_DOT2 Type) | ([T_QUEST](T_SQOPEN [(T_COMMA)*] (T_SQCLOSE | (T_LESS TypeParameters T_GREATER T_SQCLOSE) | (Type T_SQCLOSE))) StorageTag)
  static boolean TypeSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeSuffix")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypeSuffix_0(b, l + 1);
    if (!r) r = TypeSuffix_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_DOT2 Type
  private static boolean TypeSuffix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeSuffix_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_DOT2);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [T_QUEST](T_SQOPEN [(T_COMMA)*] (T_SQCLOSE | (T_LESS TypeParameters T_GREATER T_SQCLOSE) | (Type T_SQCLOSE))) StorageTag
  private static boolean TypeSuffix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeSuffix_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypeSuffix_1_0(b, l + 1);
    r = r && TypeSuffix_1_1(b, l + 1);
    r = r && StorageTag(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [T_QUEST]
  private static boolean TypeSuffix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeSuffix_1_0")) return false;
    consumeToken(b, T_QUEST);
    return true;
  }

  // T_SQOPEN [(T_COMMA)*] (T_SQCLOSE | (T_LESS TypeParameters T_GREATER T_SQCLOSE) | (Type T_SQCLOSE))
  private static boolean TypeSuffix_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeSuffix_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SQOPEN);
    r = r && TypeSuffix_1_1_1(b, l + 1);
    r = r && TypeSuffix_1_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(T_COMMA)*]
  private static boolean TypeSuffix_1_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeSuffix_1_1_1")) return false;
    TypeSuffix_1_1_1_0(b, l + 1);
    return true;
  }

  // (T_COMMA)*
  private static boolean TypeSuffix_1_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeSuffix_1_1_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, T_COMMA)) break;
      if (!empty_element_parsed_guard_(b, "TypeSuffix_1_1_1_0", c)) break;
    }
    return true;
  }

  // T_SQCLOSE | (T_LESS TypeParameters T_GREATER T_SQCLOSE) | (Type T_SQCLOSE)
  private static boolean TypeSuffix_1_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeSuffix_1_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SQCLOSE);
    if (!r) r = TypeSuffix_1_1_2_1(b, l + 1);
    if (!r) r = TypeSuffix_1_1_2_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_LESS TypeParameters T_GREATER T_SQCLOSE
  private static boolean TypeSuffix_1_1_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeSuffix_1_1_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_LESS);
    r = r && TypeParameters(b, l + 1);
    r = r && consumeTokens(b, 0, T_GREATER, T_SQCLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // Type T_SQCLOSE
  private static boolean TypeSuffix_1_1_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeSuffix_1_1_2_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Type(b, l + 1);
    r = r && consumeToken(b, T_SQCLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_NOT | T_SUB | T_CAT | T_INCREMENT | T_DECREMENT
  static boolean UnaryOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryOperator")) return false;
    boolean r;
    r = consumeToken(b, T_NOT);
    if (!r) r = consumeToken(b, T_SUB);
    if (!r) r = consumeToken(b, T_CAT);
    if (!r) r = consumeToken(b, T_INCREMENT);
    if (!r) r = consumeToken(b, T_DECREMENT);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER | T_INT
  static boolean ValidBEPContent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ValidBEPContent")) return false;
    if (!nextTokenIs(b, "", T_IDENTIFIER, T_INT)) return false;
    boolean r;
    r = consumeToken(b, T_IDENTIFIER);
    if (!r) r = consumeToken(b, T_INT);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER
  public static boolean VariableName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableName")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    exit_section_(b, m, VARIABLE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // K_VARIANT T_IDENTIFIER T_AOPEN [Member*] T_ACLOSE
  static boolean VariantDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantDefinition")) return false;
    if (!nextTokenIs(b, K_VARIANT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_VARIANT, T_IDENTIFIER, T_AOPEN);
    r = r && VariantDefinition_3(b, l + 1);
    r = r && consumeToken(b, T_ACLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [Member*]
  private static boolean VariantDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantDefinition_3")) return false;
    VariantDefinition_3_0(b, l + 1);
    return true;
  }

  // Member*
  private static boolean VariantDefinition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariantDefinition_3_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Member(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VariantDefinition_3_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_STRING_DQ | T_STRING_SQ
  public static boolean ZCStringLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ZCStringLiteral")) return false;
    if (!nextTokenIs(b, "<zc string literal>", T_STRING_DQ, T_STRING_SQ)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ZC_STRING_LITERAL, "<zc string literal>");
    r = consumeToken(b, T_STRING_DQ);
    if (!r) r = consumeToken(b, T_STRING_SQ);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (Import*)? [(Definition|Statement)*]
  static boolean ZenCodeFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ZenCodeFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ZenCodeFile_0(b, l + 1);
    r = r && ZenCodeFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (Import*)?
  private static boolean ZenCodeFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ZenCodeFile_0")) return false;
    ZenCodeFile_0_0(b, l + 1);
    return true;
  }

  // Import*
  private static boolean ZenCodeFile_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ZenCodeFile_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Import(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ZenCodeFile_0_0", c)) break;
    }
    return true;
  }

  // [(Definition|Statement)*]
  private static boolean ZenCodeFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ZenCodeFile_1")) return false;
    ZenCodeFile_1_0(b, l + 1);
    return true;
  }

  // (Definition|Statement)*
  private static boolean ZenCodeFile_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ZenCodeFile_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ZenCodeFile_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ZenCodeFile_1_0", c)) break;
    }
    return true;
  }

  // Definition|Statement
  private static boolean ZenCodeFile_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ZenCodeFile_1_0_0")) return false;
    boolean r;
    r = Definition(b, l + 1);
    if (!r) r = Statement(b, l + 1);
    return r;
  }

}
