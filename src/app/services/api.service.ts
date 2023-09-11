import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { StationAdapter } from '../adapter/station-adapter';
import { Station } from '../models/station';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    private httpClient: HttpClient,
    private stationAdapter: StationAdapter
  ) { }

  getRequests(): Observable<Station[]> {
    return this.httpClient.get<any>('https://de1.api.radio-browser.info/json/stations/bycountrycodeexact/AT?limit=20&order=votes&reverse=true').pipe(
      map((data: any) => data.map((item: any) => this.stationAdapter.adapt(item)))
    );
  }

  getStationsOfGenre(genre: string): Observable<any> {
    return this.httpClient.get<any>(`https://de1.api.radio-browser.info/json/stations/bytagexact/${genre}?limit=20&order=votes&reverse=true`);
  }
}
