import {Injectable} from '@angular/core';
import {BaseVerb} from "../models/baseVerb";
import {Verb} from "../models/verb";

@Injectable()
export class VerbFactoryService {

  constructor() {
  }

  public parseVerbObj(object: BaseVerb): Verb {
    return new Verb(
      object.infinitive,
      object.presentTense,
      object.presentPerfectTense
    );
  }
}
