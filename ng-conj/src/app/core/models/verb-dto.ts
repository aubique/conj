import { TenseDto } from '@app/models/tense-dto';

export interface VerbDto {

  name: string;
  description: string;
  tenses: Array<TenseDto>;
}
