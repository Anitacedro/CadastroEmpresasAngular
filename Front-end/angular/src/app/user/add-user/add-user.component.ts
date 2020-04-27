import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ApiService} from "../../service/api.service";

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,private router: Router, private apiService: ApiService) { }

  addForm: FormGroup;

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      id: [0],
      cnpj: [''],
      nome: ['', Validators.required],
      razaoSocial: [''],
      contato: ['',[ Validators.pattern("^[0-9]*$"),
      Validators.minLength(8),
      Validators.maxLength(11)
    ]],
      email: ['', [Validators.email]],
      cep: [''],
      cidade: [''],
      estado: [''],
      bairro: [''],
      complemento: [''],
    });
  }

  onSubmit() {
    this.apiService.createUser(this.addForm.value)
      .subscribe( data => {
        alert('Empresa cadastrada com sucesso');
        this.router.navigate(['list-user']);
        return;
      });
  }

  cancelar(){
    this.router.navigate(['list-user']);
}

}
