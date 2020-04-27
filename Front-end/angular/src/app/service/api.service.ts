import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {User} from "../model/user.model";
import {Observable} from "rxjs/index";


@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:8080/api/empresas/';

  findUsers(texto: string) :Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl+'texto?texto' +texto);
  }

  getUsers() : Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl+'listarEmpresas');
  }

  getUserById(id: number): Observable<any> {
    return this.http.get<any>(this.baseUrl + 'empresa/'+id);
  }

  createUser(user: User): Observable<any[]> {
    return this.http.post<any>(this.baseUrl + 'salvaEmpresa', user);
  }

  updateUser(user: User): Observable<any[]> {
    return this.http.put<any>(this.baseUrl + 'atualizaEmpresa/' + user.id, user);
  }

  deleteUser(id: number): Observable<any[]> {
    return this.http.delete<any>(this.baseUrl + 'deletarEmpresa/'+ id);
  }

  consultCep(user: User): Observable<any[]> {
    return this.http.get<any>("https://viacep.com.br/ws/" + Number(user.cep) + '/json');
  }
}