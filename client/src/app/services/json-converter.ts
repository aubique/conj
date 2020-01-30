import {Injectable} from '@angular/core';
import {Verb} from "../models/verb";

@Injectable()
export class JsonConverter implements ObjectConverter<Array<any>, Array<Verb>> {

  constructor() {
  }

  public map(jsonArray: Array<any>): Array<Verb> {
    let itemList: Array<Verb> = new Array<Verb>();

    for (let item of jsonArray) {
      item.presentPerfectTense.forEach(e => console.log(e));

      // It instantiates <Verb> objects and add it to the list
      itemList.push(new Verb(
        item.infinitive,
        item.presentTense,
        item.presentPerfectTense,
        item.imperfectTense,
        item.futureTense
      ));
    }

    return itemList;
  }
}

interface ObjectConverter<From, To> {
  map(array: From): To;
}
