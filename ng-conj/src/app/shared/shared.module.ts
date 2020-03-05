import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HintComponent } from '@shared/components/hint/hint.component';
import { SearchComponent } from '@shared/components/search/search.component';
import { MaterialModule } from './material.module';


@NgModule({
  declarations: [
    SearchComponent,
    HintComponent,
  ],
  imports: [
    CommonModule,
    MaterialModule,
    FlexLayoutModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  exports: [
    SearchComponent,
    HintComponent,
    MaterialModule,
    FlexLayoutModule,
    ReactiveFormsModule,
    FormsModule,
  ],
})
export class SharedModule {
}
