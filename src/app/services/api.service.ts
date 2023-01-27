import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getRequests(): Observable<any> {
    return this.httpClient.get<any>('https://de1.api.radio-browser.info/json/stations/bycountrycodeexact/AT?limit=20&order=votes&reverse=true');
  }
}
