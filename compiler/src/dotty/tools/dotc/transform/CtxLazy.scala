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
package transform

import core.Contexts.Context

/** Utility class for lazy values whose evaluation depends on a context.
 *  This should be used whenever the evaluation of a lazy expression
 *  depends on some context, but the value can be re-used afterwards
 *  with a different context.
 *
 *  A typical use case is a lazy val in a phase object which exists once per root context where
 *  the expression intiializing the lazy val depends only on the root context, but not any changes afterwards.
 */
class CtxLazy[T](expr: Context => T) {
  private[this] var myValue: T = _
  private[this] var forced = false
  def apply()(implicit ctx: Context): T = {
    if (!forced) {
      myValue = expr(ctx)
      forced = true
    }
    myValue
  }
}
