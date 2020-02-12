import {AbstractFactory} from "./abstract-factory";
import {Verb} from "../models/verb";
import {JsonVerb} from "../models/json-verb";

export class VerbFactory implements AbstractFactory<Map<string, JsonVerb>, Verb> {

  create(jsonDict: Map<string, JsonVerb>): Verb {
    // console.log(jsonDict);
    const jsonObject: JsonVerb = Object.values(jsonDict)[0];
    // console.log(jsonObject);
    const newVerb = new Verb(
      jsonObject.infinitive,
      jsonObject.presentTenseList,
      jsonObject.presentPerfectTenseList,
      jsonObject.imperfectTenseList,
      jsonObject.futureTenseList
    );
    // console.log(newVerb);
    return newVerb;
  }
}
