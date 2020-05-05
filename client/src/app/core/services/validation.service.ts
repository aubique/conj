import { Injectable } from '@angular/core';
import { AbstractControl } from '@angular/forms';

@Injectable({
  providedIn: 'root',
})
export class ValidationService {

  public static getValidationErrorMessage(
    validatorName: string,
    validatorError?: any,
  ): any {
    const config = {
      required: 'Ce champ ne peut pas être vide.',
      minlength: `Le verbe doit contenir au moins ${validatorError.requiredLength} lettres.`,
      maxlength: `Le verbe ne doit pas excéder ${validatorError.requiredLength} caractères.`,
      pattern: 'Ce champ ne doit pas contenir de caractère spéciaux, ni plus que 2 mots.',
    };

    return config[validatorName];
  }

  public static twoWordsPattern(control: AbstractControl): { pattern: boolean } {
    if (!control.value)
      return;

    return (control.value.match(/^[a-zA-Z]+\s*[a-zA-Z]*$/))
      ? null : {pattern: true};
  }
}
