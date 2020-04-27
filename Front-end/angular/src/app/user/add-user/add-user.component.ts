import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ApiService} from "../../service/api.service";
import { User } from 'src/app/model/user.model';

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
      cnpj: ['', Validators.pattern("/^\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}$/")],
      nome: ['', Validators.required],
      razaoSocial: ['', Validators.required],
      contato: ['',[ Validators.pattern("^[0-9]*$"),
      Validators.minLength(8),
      Validators.maxLength(11)
    ]],
      email: ['', [Validators.email]],
      cep: ['', [Validators.required]],
      cidade: ['', Validators.required],
      estado: ['', Validators.required],
      bairro: ['', Validators.required],
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

  consultarCep(){
    this.apiService.consultCep(this.addForm.value.cep).subscribe( data => {this.addForm.setValue(data);});
  }

  cancelar(){
    this.router.navigate(['list-user']);
  }
 validarCNPJ(cnpj) {
 
    cnpj = cnpj.replace(/[^\d]+/g,'');
 
    if(cnpj == '') return false;
     
    if (cnpj.length != 14)
        return false;
 
    // Elimina CNPJs invalidos conhecidos
    if (cnpj == "00000000000000" || 
        cnpj == "11111111111111" || 
        cnpj == "22222222222222" || 
        cnpj == "33333333333333" || 
        cnpj == "44444444444444" || 
        cnpj == "55555555555555" || 
        cnpj == "66666666666666" || 
        cnpj == "77777777777777" || 
        cnpj == "88888888888888" || 
        cnpj == "99999999999999")
        return false;
         
    // Valida DVs
     var tamanho = cnpj.length - 2;
     var numeros = cnpj.substring(0,tamanho);
     var digitos = cnpj.substring(tamanho);
     var soma = 0;
     var i = 0;
     var pos = tamanho - 7;
    for (i = tamanho; i >= 1; i--) {
      soma += numeros.charAt(tamanho - i) * pos--;
      if (pos < 2)
            pos = 9;
    }
    var resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
    if (resultado != digitos.charAt(0))
        return false;
         
    tamanho = tamanho + 1;
    numeros = cnpj.substring(0,tamanho);
    soma = 0;
    pos = tamanho - 7;
    for (i = tamanho; i >= 1; i--) {
      soma += numeros.charAt(tamanho - i) * pos--;
      if (pos < 2)
            pos = 9;
    }
    resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
    if (resultado != digitos.charAt(1))
          return false;
           
    return true;
    
  }

}
