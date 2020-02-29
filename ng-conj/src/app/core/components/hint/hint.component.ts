import { Component, Input } from '@angular/core';
import { AbstractControl } from '@angular/forms';
import { ValidationService } from '@app/services/validation.service';

@Component({
  selector: 'app-hint',
  templateUrl: './hint.component.html',
  styleUrls: ['./hint.component.scss'],
})
export class HintComponent {

  @Input()
  public control: any;

  get errorMessage(): boolean {
    for (const propertyName in this.control.errors) {

      if (this.control.errors.hasOwnProperty(propertyName)
        && this.control.touched) {

        return ValidationService.getValidationErrorMessage(
          propertyName,
          this.control.errors[propertyName],
        );
      }
    }

    return undefined;
  }
}
