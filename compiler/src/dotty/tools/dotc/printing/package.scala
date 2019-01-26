/*
 * Dotty (https://dotty.epfl.ch/)
 *
 * Copyright EPFL and Lightbend, Inc.
 *
 * Licensed under Apache License 2.0
 * (https://www.apache.org/licenses/LICENSE-2.0).
 *
 * See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 */

package dotty.tools.dotc

import core.StdNames.{nme,tpnme}
import util.Property.Key

package object printing {

  type Precedence = Int

  val DotPrec: Int       = parsing.maxPrec
  val AndTypePrec: Int   = parsing.precedence(tpnme.raw.AMP)
  val OrTypePrec: Int    = parsing.precedence(tpnme.raw.BAR)
  val OrPrec: Int        = parsing.precedence(nme.raw.BAR)
  val InfixPrec: Int     = parsing.minInfixPrec
  val GlobalPrec: Int    = parsing.minPrec
  val TopLevelPrec: Int  = parsing.minPrec - 1

  /** A property to indicate whether the compiler is currently doing -Xprint
   *
   *  -Xprint will print `sym.name` instead of `sym.originalName`
   */
  val XprintMode: Key[Unit] = new Key

  /** @pre `nel` is non-empty list */
  private[printing] implicit class ListOps[A](val nel: List[A]) extends AnyVal {
    def intersperse(a: A): List[A] =
      nel.flatMap(a :: _ :: Nil).tail
  }
}
