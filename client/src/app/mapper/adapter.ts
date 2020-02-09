export interface Adapter<From, To> {
  map(array: From): To;
}
