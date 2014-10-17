package evecalc.util

import evecalc.common.items._

import scala.collection.JavaConverters._

object BlueprintLoader {
  private[this] def usefulActivities =
    Set(
      BlueprintActivityType.Invention,
      BlueprintActivityType.Manufacturing,
      BlueprintActivityType.MaterialEfficiencyResearch,
      BlueprintActivityType.TimeEfficiencyResearch,
      BlueprintActivityType.Copying
    ).map(_.activityId)

  private[this] def convertMaterialsFromJavaYAMLMap(yamlMap: Map[java.lang.Integer, Object]) = {
    yamlMap map {
      case (materialTypeID, materialPropertyJavaYAMLMap) =>
        val materialItem = ItemStore.get(materialTypeID) match {
          case Some(item) => item
          case _ => throw new IllegalArgumentException
        }
        val materialPropertyMap =
          materialPropertyJavaYAMLMap.asInstanceOf[java.util.Map[java.lang.String, Object]].asScala
        (
          materialPropertyMap.get("quantity").map(_.asInstanceOf[java.lang.Integer].toInt),
          materialPropertyMap.get("consume")
          ) match {
          case (Some(quantity), Some("false")) => InputItem(materialItem, quantity, false)
          case (Some(quantity), _) => InputItem(materialItem, quantity, true)
          case (_, _) => throw new IllegalArgumentException
        }
    }
  }

  private[this] def convertSkillsFromJavaYAMLMap(yamlMap: Map[java.lang.Integer, Object]) = {
    yamlMap flatMap {
      case (skillID, skillPropertyJavaYAMLMap) =>
        val scalaSkillPropertyMap =
          skillPropertyJavaYAMLMap.asInstanceOf[java.util.Map[java.lang.String, Object]].asScala
        for {
          level <- scalaSkillPropertyMap.get("level").map(_.asInstanceOf[java.lang.Integer].toInt)
          skill <- ItemStore.get(skillID)
        } yield {
          RequiredSkill(skill, level)
        }
    }
  }

  private[this] def convertProductsFromJavaYAMLMap(yamlMap: Map[java.lang.Integer, Object]) = {
    yamlMap flatMap {
      case (itemID, itemPropertyJavaYAMLMap) =>
        val scalaItemPropertyMap =
          itemPropertyJavaYAMLMap.asInstanceOf[java.util.Map[java.lang.String, Object]].asScala
        for {
          quantity <- scalaItemPropertyMap.get("quantity").map(_.asInstanceOf[java.lang.Integer].toInt)
          probability = scalaItemPropertyMap.get("probability").map(_.asInstanceOf[java.lang.Double].toDouble)
          item <- ItemStore.get(itemID)
        } yield {
          OutputProduct(item, quantity, probability.getOrElse(1.0))
        }
    }
  }

  private[this] def extractManufacturingPropertiesFromJavaYAMLMap(yamlMap: Map[java.lang.String, Object]) = {
    for {
      materialsJavaYAMLMap <- yamlMap.get("materials").map(_.asInstanceOf[java.util.Map[java.lang.Integer, Object]])
      productsJavaYAMLMap <- yamlMap.get("products").map(_.asInstanceOf[java.util.Map[java.lang.Integer, Object]])
      skillsJavaYAMLMap <- yamlMap.get("skills").map(_.asInstanceOf[java.util.Map[java.lang.Integer, Object]])
      time <- yamlMap.get("time").map(_.asInstanceOf[java.lang.Integer].toInt)
    } yield  {
      ManufacturingBlueprintActivity(
        inputs = convertMaterialsFromJavaYAMLMap(Map.empty ++ materialsJavaYAMLMap.asScala).toSeq,
        requiredSkills = convertSkillsFromJavaYAMLMap(Map.empty ++ skillsJavaYAMLMap.asScala).toSeq,
        products = convertProductsFromJavaYAMLMap(Map.empty ++ productsJavaYAMLMap.asScala).toSeq,
        baseDurationInSeconds = time
      )
    }
  }

  private[this] def extractInventionPropertiesFromJavaYAMLMap(yamlMap: Map[java.lang.String, Object]) = {
    for {
      materialsJavaYAMLMap <- yamlMap.get("materials").map(_.asInstanceOf[java.util.Map[java.lang.Integer, Object]])
      productsJavaYAMLMap <- yamlMap.get("products").map(_.asInstanceOf[java.util.Map[java.lang.Integer, Object]])
      skillsJavaYAMLMap <- yamlMap.get("skills").map(_.asInstanceOf[java.util.Map[java.lang.Integer, Object]])
      time <- yamlMap.get("time").map(_.asInstanceOf[java.lang.Integer].toInt)
    } yield {
      InventionBlueprintActivity(
        inputs = convertMaterialsFromJavaYAMLMap(Map.empty ++ materialsJavaYAMLMap.asScala).toSeq,
        requiredSkills = convertSkillsFromJavaYAMLMap(Map.empty ++ skillsJavaYAMLMap.asScala).toSeq,
        products = convertProductsFromJavaYAMLMap(Map.empty ++ productsJavaYAMLMap.asScala).toSeq,
        baseDurationInSeconds = time
      )
    }
  }

  private[this] def extractTEPropertiesFromJavaYAMLMap(yamlMap: Map[java.lang.String, Object]) = {
    for {
      time <- yamlMap.get("time").map(_.asInstanceOf[java.lang.Integer].toInt)
    } yield {
      TimeEfficiencyBlueprintActivity(
        inputs = Seq.empty,
        requiredSkills = Seq.empty,
        baseDurationInSeconds = time
      )
    }
  }

  private[this] def extractMEPropertiesFromJavaYAMLMap(yamlMap: Map[java.lang.String, Object]) = {
    for {
      time <- yamlMap.get("time").map(_.asInstanceOf[java.lang.Integer].toInt)
    } yield {
      MaterialEfficiencyBlueprintActivity(
        inputs = Seq.empty,
        requiredSkills = Seq.empty,
        baseDurationInSeconds = time
      )
    }
  }

  private[this] def extractCopyingPropertiesFromJavaYAMLMap(yamlMap: Map[java.lang.String, Object]) = {
    for {
      time <- yamlMap.get("time").map(_.asInstanceOf[java.lang.Integer].toInt)
    } yield {
      CopyingBlueprintActivity(
        inputs = Seq.empty,
        requiredSkills = Seq.empty,
        baseDurationInSeconds = time
      )
    }
  }

  def createBlueprintsFromJavaYAMLMap(yamlMap: Map[java.lang.Long, Object]) = {
    yamlMap flatMap {
      case (_, properties) =>
        val propertiesAsScalaMap = properties.asInstanceOf[java.util.Map[Object, Object]].asScala
        for {
          blueprintTypeID <- propertiesAsScalaMap.get("blueprintTypeID").map(_.asInstanceOf[java.lang.Integer].toInt)
          maxProductionLimit <- propertiesAsScalaMap.get("maxProductionLimit")
          activities <- propertiesAsScalaMap.get("activities")
          activitiesAsScalaMap = Map.empty ++ activities.asInstanceOf[java.util.Map[java.lang.Integer, Object]].asScala
          manufacturingActivity = activitiesAsScalaMap.get(BlueprintActivityType.Manufacturing.activityId) flatMap {
            properties =>
              extractManufacturingPropertiesFromJavaYAMLMap(
                Map.empty ++ properties.asInstanceOf[java.util.Map[java.lang.String, Object]].asScala)
          }
          inventionActivity = activitiesAsScalaMap.get(BlueprintActivityType.Invention.activityId) flatMap {
            properties =>
              extractInventionPropertiesFromJavaYAMLMap(
                Map.empty ++ properties.asInstanceOf[java.util.Map[java.lang.String, Object]].asScala)
          }
          copyingActivity = activitiesAsScalaMap.get(BlueprintActivityType.Copying.activityId) flatMap { properties =>
            extractCopyingPropertiesFromJavaYAMLMap(
              Map.empty ++ properties.asInstanceOf[java.util.Map[java.lang.String, Object]].asScala)
          }
          meResearch = activitiesAsScalaMap.get(BlueprintActivityType.MaterialEfficiencyResearch.activityId) flatMap {
            properties =>
              extractMEPropertiesFromJavaYAMLMap(
                Map.empty ++ properties.asInstanceOf[java.util.Map[java.lang.String, Object]].asScala)
          }
          teResearch = activitiesAsScalaMap.get(BlueprintActivityType.TimeEfficiencyResearch.activityId) flatMap {
            properties =>
              extractTEPropertiesFromJavaYAMLMap(
                Map.empty ++ properties.asInstanceOf[java.util.Map[java.lang.String, Object]].asScala)
          }
          basicItem <- EveDB.getBasicItem(blueprintTypeID)
        } yield {
          new Blueprint {
            override val typeID: TypeID = blueprintTypeID

            override val typeName: String = basicItem.typeName

            override val category: ItemCategory = basicItem.category

            override val marketGroupID: Option[Int] = basicItem.marketGroupID

            override val manufacturing: Option[ManufacturingBlueprintActivity] = manufacturingActivity
            override val invention: Option[InventionBlueprintActivity] = inventionActivity
            override val materialEfficiencyResearch: Option[MaterialEfficiencyBlueprintActivity] = meResearch
            override val timeEfficiencyResearch: Option[TimeEfficiencyBlueprintActivity] = teResearch
            override val copying: Option[CopyingBlueprintActivity] = copyingActivity
          }
        }
    }
  }
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