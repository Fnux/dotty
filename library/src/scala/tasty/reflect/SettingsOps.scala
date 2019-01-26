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

package scala.tasty.reflect

trait SettingsOps extends Core {

  /** Compiler settings */
  def settings: Settings

  trait SettingsAPI {
    /** Can print output using colors? */
    def color: Boolean
  }
  implicit def SettingsDeco(settings: Settings): SettingsAPI

}
