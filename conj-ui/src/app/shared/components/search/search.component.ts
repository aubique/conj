import { Component, ElementRef, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { FacadeService } from '@app/services/facade.service';
import { ValidationService } from '@app/services/validation.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss'],
})
export class SearchComponent implements OnInit, OnDestroy {

  isLoading: boolean;
  inputForm: FormGroup;
  @ViewChild('inputElement') inputElement: ElementRef<HTMLElement>;
  @ViewChild('formDirective') formDirective: NgForm;
  private loadingSubscription: Subscription;

  constructor(
    private fb: FormBuilder,
    private facade: FacadeService,
  ) {
    this.buildForm();
  }

  get ctrl(): { [p: string]: AbstractControl } {
    return this.inputForm.controls;
  }

  ngOnInit(): void {
    this.loadingSubscription = this.facade.loadingState
      .subscribe((state) => this.isLoading = state);
  }

  ngOnDestroy(): void {
    if (this.loadingSubscription)
      this.loadingSubscription.unsubscribe();
  }

  onSubmit(): void {
    this.facade.loadingState.next(true);
    const userInput = (this.inputForm.value.verb as string).toLowerCase();

    console.log(`User Input = ${userInput}`);
    console.log('Submit form values:', {...this.inputForm.value});

    this.facade.navigateTo(userInput);
    this.inputElement.nativeElement.blur();
    this.inputForm.reset();
    this.formDirective.resetForm();
  }

  private buildForm(): void {
    this.inputForm = this.fb.group({
      verb: ['',
        [
          Validators.required,
          Validators.minLength(4),
          Validators.maxLength(24),
          ValidationService.twoWordsPattern,
        ]],
    });
  }
}
