import {TenseObj} from "./baseTense";

export class Verb {

  // infinitive: string;
  // presentTense: string[];
  // presentPerfectTense: string[];
  tenseArray: Array<TenseObj>;
  presentName = "present-tense";
  presentPerfectName = "present-perfect-tense";

  constructor(infinitive: string, presentTense: string[], presentPerfectTense: string[]) {
    // this.infinitive = infinitive;
    // this.presentTense = presentTense;
    // this.presentPerfectTense = presentPerfectTense;
    this.tenseArray = new Array<TenseObj>();
    for (let index in presentTense) {
      this.tenseArray.push({present: presentTense[index], presentPerfect: presentPerfectTense[index]});
      console.log(this.tenseArray[index]);
    }
  }
}
