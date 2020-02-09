import {Adapter} from "./adapter";
import {Verb} from "../models/verb";

export class MapperFromDictToVerbs implements Adapter<Map<string, Map<string, Array<string>>>,Array<Verb>> {

  map(array: Map<string, Map<string, Array<string>>>): Array<Verb> {
    return null;
  }
}
