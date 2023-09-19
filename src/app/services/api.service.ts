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

  getPopularStations(): Observable<Station[]> {
    return this.httpClient.get<any>('https://de1.api.radio-browser.info/json/stations?limit=30&order=votes&reverse=true').pipe(
      map((data: any) => data.map((item: any) => this.stationAdapter.adapt(item)))
    );
  }

  getStationsByCountry(countryCode: string): Observable<Station[]> {
    return this.httpClient.get<any>(`https://de1.api.radio-browser.info/json/stations/bycountrycodeexact/${countryCode}?limit=30&order=votes&reverse=true`).pipe(
      map((data: any) => data.map((item: any) => this.stationAdapter.adapt(item)))
    );
  }

  getStationsOfGenre(genre: string): Observable<Station[]> {
    return this.httpClient.get<any>(`https://de1.api.radio-browser.info/json/stations/bytagexact/${genre}?limit=20&order=votes&reverse=true`).pipe(
      map((data: any) => data.map((item: any) => this.stationAdapter.adapt(item)))
    );
  }

  getMostPopularTags(): Observable<any> {
    return this.httpClient.get<any>(`https://de1.api.radio-browser.info/json/tags?limit=20&order=stationcount&reverse=true`);
  }
}
