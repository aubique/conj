import {BaseTense} from "./base-tense";

export class Verb {

  // infinitive: string;
  // presentTense: string[];
  // presentPerfectTense: string[];
  tenseArray: Array<BaseTense>;
  presentName = "present-tense";
  presentPerfectName = "present-perfect-tense";

  constructor(
    infinitive: string,
    presentTenseList: string[],
    presentPerfectTenseList: string[],
    imperfectTenseList: string[],
    futureTenseList: string[]
  ) {
    console.log(infinitive);
    console.log(presentTenseList);
    this.tenseArray = new Array<BaseTense>();

    for (let index in presentTenseList) {
      this.tenseArray.push({
        present: presentTenseList[index],
        presentPerfect: presentPerfectTenseList[index],
        imperfect: imperfectTenseList[index],
        future: futureTenseList[index]
      });

      console.log(this.tenseArray[index]);
    }
  }
}
