import { AlunoModel } from './../componentes/aluno/aluno.model';
import { AlunoFiltro } from './../componentes/aluno/aluno-filtro.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  token: string = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1Mzk4ODA4NDcsInVzZXJfbmFtZSI6ImFkbUBhZG0uY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9ERUxFVEFSX1BST0ZFU1NPUiIsIlJPTEVfREVMRVRBUl9OT1RBIiwiUk9MRV9MSVNUQVJfQUxVTk8iLCJST0xFX0xJU1RBUl9BTFVOT1MiLCJST0xFX0xJU1RBUl9QUk9GRVNTT1JFUyIsIlJPTEVfRURJVEFSX0FMVU5PIiwiUk9MRV9MSVNUQVJfUFJPRkVTU09SIiwiUk9MRV9MSVNUQVJfRkFMVEFTIiwiUk9MRV9TQUxWQVJfUFJPRkVTU09SIiwiUk9MRV9TQUxWQVJfQUxVTk8iLCJST0xFX0RFTEVUQVJfQUxVTk8iLCJST0xFX0xJU1RBUl9OT1RBUyIsIlJPTEVfREVMRVRBUl9GQUxUQSIsIlJPTEVfRURJVEFSX05PVEEiLCJST0xFX0VESVRBUl9QUk9GRVNTT1IiLCJST0xFX1NBTFZBUl9OT1RBIiwiUk9MRV9TQUxWQVJfRkFMVEEiXSwianRpIjoiZDliYzZiZTMtOTQwZS00YTE1LTg0YTItNDUyNGJhYjcxMzg4IiwiY2xpZW50X2lkIjoiYW5ndWxhciIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.froDypbs2uCqS7W_WOrZzlmIMCWQiGRKz9YMCjn0B0U";

  constructor(private http: HttpClient ) {}


  pesquisarAlunos(filtro: AlunoFiltro): Promise<any>{

    if(filtro.nome == null){
      filtro.nome = "";
    }if(filtro.sobrenome == null){
        filtro.sobrenome = "";
    }if(filtro.email == null){
      filtro.email = "";
    }if(filtro.telefone == null){
      filtro.telefone = "";
    }

    return this.http.get("http://localhost:8080/aluno", {
      headers: { "Authorization": this.token}, 
      params: {"nome": filtro.nome, "sobrenome": filtro.sobrenome, "email": filtro.email, "telefone": filtro.telefone},
    })
          .toPromise()
          .then(response => response );
  }

  pesquisarAlunoPorId(matricula: number): Promise<any>{

    return this.http.get(`http://localhost:8080/aluno/${matricula}`, { headers: { "Authorization": this.token} } )
          .toPromise()
          .then(response =>response  );
  }

  deletarAluno(matricula: number): Promise<void>{

    return this.http.delete(`http://localhost:8080/aluno/${matricula}`,{ headers: { "Authorization":  this.token}})
      .toPromise()
      .then(() => null);
  }

  atualizarAluno(matricula: number, aluno: AlunoModel): Promise<any>{

    return this.http.put(`http://localhost:8080/aluno/${matricula}`,aluno,{ headers: { "Authorization":  this.token}} )
      .toPromise()
      .then(()=> null);
  }

  adicionarAluno(aluno: AlunoModel): Promise<any>{
    return this.http.post("http://localhost:8080/aluno", { headers: { "Authorization": this.token } } )
      .toPromise()
      .then(al => al)
  }
}
