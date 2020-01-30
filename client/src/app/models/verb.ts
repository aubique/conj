import {TenseObj} from "./baseTense";

export class Verb {

  // infinitive: string;
  // presentTense: string[];
  // presentPerfectTense: string[];
  tenseArray: Array<TenseObj>;
  presentName = "present-tense";
  presentPerfectName = "present-perfect-tense";

  constructor(
    infinitive: string,
    presentTense: string[],
    presentPerfectTense: string[],
    imperfectTense: string[],
    futureTense: string[]
  ) {
    console.log(infinitive);
    console.log(presentTense);
    this.tenseArray = new Array<TenseObj>();

    for (let index in presentTense) {
      this.tenseArray.push({
        present: presentTense[index],
        presentPerfect: presentPerfectTense[index],
        imperfect: imperfectTense[index],
        future: futureTense[index]
      });

      console.log(this.tenseArray[index]);
    }
  }
}
