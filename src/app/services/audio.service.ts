import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Station } from '../models/station';

@Injectable({
  providedIn: 'root'
})
export class AudioService {

  private currentPlaying = new BehaviorSubject<Station | null>(null);

  private audio = new Audio()

  constructor() {
   }

  getCurrentPlaying(): Observable<Station | null> {
    return this.currentPlaying
  }

  updateCurrentPlaying(newStation: Station) {
    this.currentPlaying.next(newStation)
    this.play(newStation.url)
  }

  play(url: string) {
    this.audio.pause()
    this.audio.src = url
    this.audio.load()
    this.audio.play()
  }
}
