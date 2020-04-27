import { Component, OnInit , Inject} from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {first} from "rxjs/operators";
import {User} from "../../model/user.model";
import {ApiService} from "../../service/api.service";

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.scss']
})
export class EditUserComponent implements OnInit {

  user: User;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private router: Router, private apiService: ApiService) { }
  
  ngOnInit() {
    let userId = window.localStorage.getItem("editUserId");
    if(!userId) {
      alert("Erro")
      this.router.navigate(['list-user']);
      return;
    }
    this.editForm = this.formBuilder.group({
      id: [0],
      cnpj: [''],
      nome: ['', Validators.required],
      razaoSocial: [''],
      contato: ['',[ Validators.pattern("^[0-9]*$"),
      Validators.minLength(8),
      Validators.maxLength(11)]],
      email: ['', [Validators.email]],
      cep: [''],
      cidade: [''],
      estado: [''],
      bairro: [''],
      complemento: [''],
    });
    this.apiService.getUserById(+userId).subscribe( data => {this.editForm.setValue(data);});
  }

  onSubmit() {
    this.apiService.updateUser(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          alert('Empresa alterada com sucesso');
          this.router.navigate(['list-user']);
          return;
        },
        error => {
          alert(error);
        });
  }

  cancelar(){
    this.router.navigate(['list-user']);
}

}
