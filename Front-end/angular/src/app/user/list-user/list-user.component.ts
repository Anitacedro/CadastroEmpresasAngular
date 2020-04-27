import { Component, OnInit , Inject} from '@angular/core';
import {Router} from "@angular/router";
import {User} from "../../model/user.model";
import {ApiService} from "../../service/api.service";
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.scss']
})
export class ListUserComponent implements OnInit {

  public paginaAtual = 1;
  public users: User[] = [];
  public consulta: FormGroup;
  searchText;
  formBuilder: any;
  constructor(private router: Router, private apiService: ApiService) { }
  
  ngOnInit() {
    this.apiService.getUsers().subscribe( data => this.users = data);
  }

  buscar(texto: string){
    
    this.apiService.findUsers(texto).subscribe( data => this.users = data);
  }

  deleteUser(user: User): void {
    this.apiService.deleteUser(user.id)
      .subscribe( data => {
        this.users = this.users.filter(u => u !== user);
        alert('Empresa removida com sucesso');
      })
  };

  editUser(user: User): void {
    window.localStorage.removeItem("editUserId");
    window.localStorage.setItem("editUserId", user.id.toString());
    this.router.navigate(['edit-user']);
  };
}
