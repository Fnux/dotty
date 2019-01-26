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

/*
 * Copyright (C) 2012-2014 Typesafe Inc. <http://www.typesafe.com>
 */

package scala.compat.java8;

import scala.runtime.BoxedUnit;

@FunctionalInterface
public interface JProcedure7<T1, T2, T3, T4, T5, T6, T7> extends JFunction7<T1, T2, T3, T4, T5, T6, T7, BoxedUnit> {
    default void $init$() {
    }

    void applyVoid(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7);

    default BoxedUnit apply(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        applyVoid(t1, t2, t3, t4, t5, t6, t7);
        return BoxedUnit.UNIT;
    }
}
