package models

sealed abstract class BlueprintActivityType(val activityId: Int)
object BlueprintActivityType {
  case object Manufacturing extends BlueprintActivityType(1)
  case object TimeEfficiencyResearch extends BlueprintActivityType(3)
  case object MaterialEfficiencyResearch extends BlueprintActivityType(4)
  case object Copying extends BlueprintActivityType(5)
  case object Invention extends BlueprintActivityType(8)
}

case class InputItem(item: Item, quantity: Int, isConsumed: Boolean = true)

case class RequiredSkill(skill: Item, requiredLevel: Int)

case class OutputProduct(item: Item, quantity: Int, baseProbability: Double)

case class ManufacturingBlueprintActivity(
    inputs: Seq[InputItem],
    requiredSkills: Seq[RequiredSkill],
    baseDurationInSeconds: Int,
    products: Seq[OutputProduct])

case class TimeEfficiencyBlueprintActivity(
    inputs: Seq[InputItem],
    requiredSkills: Seq[RequiredSkill],
    baseDurationInSeconds: Int)

case class MaterialEfficiencyBlueprintActivity(
    inputs: Seq[InputItem],
    requiredSkills: Seq[RequiredSkill],
    baseDurationInSeconds: Int)

case class CopyingBlueprintActivity(
    inputs: Seq[InputItem],
    requiredSkills: Seq[RequiredSkill],
    baseDurationInSeconds: Int)

case class InventionBlueprintActivity(
    inputs: Seq[InputItem],
    requiredSkills: Seq[RequiredSkill],
    baseDurationInSeconds: Int,
    products: Seq[OutputProduct])

trait Blueprint extends Item {
  def manufacturing: Option[ManufacturingBlueprintActivity]
  def materialEfficiencyResearch: Option[MaterialEfficiencyBlueprintActivity]
  def timeEfficiencyResearch: Option[TimeEfficiencyBlueprintActivity]
  def copying: Option[CopyingBlueprintActivity]
  def invention: Option[InventionBlueprintActivity]
}



/*
   Copyright 2014 Kyle Galloway (kyle.s.galloway@gmail.com)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
