import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Station } from '../models/station';

@Injectable({
  providedIn: 'root'
})
export class AudioService {

  private currentPlaying = new BehaviorSubject<Station | null>(null);

  constructor() { }

  getCurrentPlaying(): Observable<Station | null> {
    return this.currentPlaying
  }

  updateCurrentPlaying(newStation: Station) {
    this.currentPlaying.next(newStation)
  }
}
