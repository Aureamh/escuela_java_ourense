import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CuentaBanc } from './modelo/CuentaBanc';

// Objeto que Angular se encarga de instaciar como un Singleton
@Injectable({
  providedIn: 'root'
})
export class CuentasRestService {

  // Infiere / deduce a partir del valor ("" es String)
  urlApiRest = "http://127.0.0.1:8080/cuentas";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  alCambiar: any;

  constructor(private httpCli: HttpClient) { }

  public add(nuevaCuenta: CuentaBanc, lambda: any): Observable<CuentaBanc> {
    let observable: Observable<CuentaBanc> = this.httpCli.post<CuentaBanc>(this.urlApiRest,
      nuevaCuenta, this.httpOptions);
    observable.subscribe((datos) => {
      this.alCambiar(datos);
      lambda(datos);
    });
    return observable;
  }
  public traerTodos(): Observable<CuentaBanc[]> {
    return this.httpCli.get<CuentaBanc[]>(this.urlApiRest);
  }
  public eliminar(id: Number) {
    let urlPeticionDelete = `${this.urlApiRest}/${id}`;
    console.log("Eliminado " + id);
    this.httpCli.delete(urlPeticionDelete, this.httpOptions)
      .subscribe((datos) => {
        this.alCambiar(datos);
        console.log("Eliminado " + id);
      });
  }
}
