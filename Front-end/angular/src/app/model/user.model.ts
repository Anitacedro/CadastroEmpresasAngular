export class User {

    constructor( public id: number,
      public cnpj: string,
      public nome: string,
      public razaoSocial: string,
      public contato: string,
      public email: string,
      public logradouro: string,
      public cep: string,
      public cidade: string,
      public estado: string,
      public bairro: string,
      public complemento: string){}
  }