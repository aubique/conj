import { DefaultDto } from '@app/models/default-dto';
import { TenseDto } from '@app/models/tense-dto';

export interface GroupDto extends DefaultDto<TenseDto> {
  // level: string;
  // name: string;
  // list: Array<TenseDto>;
}
