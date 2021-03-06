package evecalc.dbimporter.util;

import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;

import org.yaml.snakeyaml.Yaml;

/**
 * Created by Kyle on 10/12/2014.
 */
public class YAMLToJava {
    public static java.util.Map<Long, Object> idToPropertiesYAMLToJava(String filename) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        @SuppressWarnings("unchecked")
        java.util.Map<Long, Object> yamlMap =
          (java.util.Map<Long, Object>)yaml.load(
            new FileInputStream(new File(filename)));
        return yamlMap;
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

