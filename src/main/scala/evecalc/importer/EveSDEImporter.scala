package evecalc.importer

import evecalc.util.{ItemStore, BlueprintLoader, YAMLToJava}
import scala.collection.JavaConverters._

object EveSDEImporter {
  def main(args: Array[String]): Unit = {
    val blueprintMap =
      Map.empty ++ YAMLToJava.idToPropertiesYAMLToJava("C:\\EveData\\Oceanus_1.0_105658_db\\blueprints.yaml").asScala
    val blueprints = BlueprintLoader.createBlueprintsFromJavaYAMLMap(blueprintMap)
    println("Loaded " + blueprints.size + " blueprints")
    println("Loaded " + ItemStore.loadedItems.size + " other items")
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