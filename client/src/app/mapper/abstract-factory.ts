export interface AbstractFactory<ConsumeType, ProductType> {
  create(parameter: ConsumeType): ProductType;
}
